package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Anfrage1;
import model.Anfrage10_JUR;
import model.Anfrage2;
import model.Anfrage3;
import model.Anfrage4;
import model.Anfrage5;
import model.Anfrage6;
import model.Anfrage7;
import model.Anfrage8;
import model.Anfrage9;


public class UtilMethods {

	public List<?> readEntitiesFromFile(String entityClassName, File file) {
		
		try (FileReader fileReader = new FileReader(file); Scanner in = new Scanner(fileReader)) {
			String[] lines = createLinesArray(in);
			return createEntityList(lines, entityClassName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String[] createLinesArray(Scanner in) {
		List<String> arrayList = new ArrayList<String>();
		while (in.hasNextLine()) {
			arrayList.add(in.nextLine());
		}
		return arrayList.toArray(new String[arrayList.size()]);
	}

	private List createEntityList(String[] lines, String entityClassName) {
		Class entityClass = null;
		try {
			entityClass = Class.forName(entityClassName);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

	private static Object toObject(Class clazz, String value) {
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
	
	public static List<Anfrage6> readEntitiesFromAnfrage6() {
		UtilMethods utilClass = new UtilMethods();
		return (List<Anfrage6>)utilClass.readEntitiesFromFile("model.Anfrage6", new File("./src/test/resources/result_anfrage6.txt"));
	}

	public static void main(String[] args) {
//		List<Anfrage6> list = (List<Anfrage6>)readEntitiesFromFile(Anfrage6.class, new File("./src/test/resources/result_anfrage6.txt"));
		List<Anfrage6> list = readEntitiesFromAnfrage6();
		for(Anfrage6 entity : list) {
			System.out.println(entity.toString());
		}
	}
}
