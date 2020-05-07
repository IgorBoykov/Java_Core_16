package Task;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		Class ac = Animal.class;

		String nameofClass = ac.getName();
		System.out.println(nameofClass);

		String cName = ac.getCanonicalName();
		System.out.println(cName);

		String name2 = ac.getTypeName();
		System.out.println(name2);

		String sName = ac.getSimpleName();
		System.out.println(sName);
		System.out.println();

		int modifier = ac.getModifiers();
		System.out.println(modifier);
		String modifText = Modifier.toString(modifier);
		System.out.println(modifText);
		System.out.println();

		Class superClass = ac.getSuperclass();
		System.out.println(superClass);

		Class encClass = ac.getEnclosingClass();
		System.out.println(encClass);
		System.out.println();

		Package classPackage = ac.getPackage();
		System.out.println(classPackage);
		System.out.println();

		Constructor<Animal>[] anConst = ac.getConstructors();
		for (int i = 0; i < anConst.length; i++) {
			Constructor<Animal> constructor = anConst[i];
			System.out.println(constructor);
		}
		System.out.println(anConst.length);

		Constructor<Animal> singleConst = ac.getConstructor(String.class, int.class, String.class);
		System.out.println(singleConst);
		Animal newInstanceAnimal = singleConst.newInstance("Loki", 4, "Cat");
		System.out.println(newInstanceAnimal);
		System.out.println();

		Field[] fields = ac.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}

		Field[] fields2 = ac.getDeclaredFields();
		for (int i = 0; i < fields2.length; i++) {
			Field field = fields2[i];
			System.out.println(field);
		}

		Field nameField = ac.getField("name");
		nameField.set(newInstanceAnimal, "Stanley");
		System.out.println(newInstanceAnimal);
		System.out.println();

		Method[] methods = ac.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println(method);
		}

		methods[4].invoke(newInstanceAnimal, "Burbon");
		System.out.println(newInstanceAnimal);
	}

}
