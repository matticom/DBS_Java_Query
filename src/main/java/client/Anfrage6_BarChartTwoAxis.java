package client;

import static jFreeChart.Anfrage6_BarChartCreator.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import model.Anfrage6;

public class Anfrage6_BarChartTwoAxis {

	public static void main(String[] args) {
		List<Anfrage6> list = readEntitiesFromAnfrage6();
		JFreeChart chart = createAnfrage6Chart(list);
		ChartPanel chartPanel = new ChartPanel(chart);
	    chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	   	ApplicationFrame appFrame = new ApplicationFrame("Anfrage6");
		appFrame.getContentPane().add(chartPanel);
		appFrame.setSize(560, 367);
		RefineryUtilities.centerFrameOnScreen(appFrame);
		appFrame.setVisible(true);
	}

	public static List<Anfrage6> readEntitiesFromAnfrage6() {
		return (List<Anfrage6>)readEntitiesFromFile(Anfrage6.class, new File("./src/test/resources/result_anfrage6.txt"));
	}
	
	public static List<?> readEntitiesFromFile(Class entityClass, File file) {
		
		try (FileReader fileReader = new FileReader(file); Scanner in = new Scanner(fileReader)) {
			String[] lines = createLinesArray(in);
			return createEntityList(lines, entityClass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected static String[] createLinesArray(Scanner in) {
		List<String> arrayList = new ArrayList<String>();
		while (in.hasNextLine()) {
			arrayList.add(in.nextLine());
		}
		return arrayList.toArray(new String[arrayList.size()]);
	}

	protected static List createEntityList(String[] lines, Class entityClass) {
		List list = new ArrayList();
		Constructor constructor = null;
		for(int i=0; i < entityClass.getConstructors().length; i++) {
			if (entityClass.getConstructors()[i].getParameterTypes().length > 0) {
				constructor = entityClass.getConstructors()[i];
				break;
			}
			
		}
		Class[] classTypeArr = constructor.getParameterTypes();
		int len = constructor.getParameterTypes().length;
		for (String line : lines) {
			try (Scanner in = new Scanner(line).useDelimiter(";")) {
				Object[] paraArray = new Object[len];
				for (int i = 0; i < len; i++) {
					paraArray[i] = toObject(classTypeArr[i], in.next());
				}
				list.add(entityClass.cast(constructor.newInstance(paraArray)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	protected static Object toObject(Class clazz, String value) {
		if (boolean.class == clazz)
			return Boolean.parseBoolean(value);
		if (byte.class == clazz)
			return Byte.parseByte(value);
		if (short.class == clazz)
			return Short.parseShort(value);
		if (int.class == clazz)
			return Integer.parseInt(value);
		if (long.class == clazz)
			return Long.parseLong(value);
		if (float.class == clazz)
			return Float.parseFloat(value);
		if (double.class == clazz)
			return Double.parseDouble(value);
		return value;
	}
}
