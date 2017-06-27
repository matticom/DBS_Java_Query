package views;

import static jFreeChart.Anfrage8_JTableCreator.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import model.Anfrage8;

public class Anfrage8_JTable {

	public static void main(String[] args) {
		
		// Anfrage-Ergebnisse direkt von der Datenbank holen
//		AnfragenDBzuList db2List = new AnfragenDBzuList();
//		List<Anfrage8> list = (List<Anfrage8>)db2List.getDataFromDB(Anfragen.Anfrage8);
		
		// Anfrage-Ergebnisse von Datei lesen
		List<Anfrage8> list = readEntitiesFromAnfrage8();
				
		JTable table = createAnfrage8Chart(list);
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setPreferredSize(new Dimension(500, 270));
	   	ApplicationFrame appFrame = new ApplicationFrame("Anfrage8");
	   	JLabel question = new JLabel("Welche Ranks wurden beim Suchen nach 'american idol' am häufigsten angeklickt?");
	   	question.setHorizontalAlignment(SwingConstants.CENTER);
	   	question.setPreferredSize(new Dimension(500, 60));
		appFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		appFrame.getContentPane().add(question, BorderLayout.NORTH);
		appFrame.setSize(560, 367);
		RefineryUtilities.centerFrameOnScreen(appFrame);
		appFrame.setVisible(true);
	}

	public static List<Anfrage8> readEntitiesFromAnfrage8() {
		return (List<Anfrage8>)readEntitiesFromFile(Anfrage8.class, new File("./src/test/resources/result_anfrage8.txt"));
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
