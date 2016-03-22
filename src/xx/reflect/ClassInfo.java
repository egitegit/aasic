package xx.reflect;

import java.awt.Color;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

public class ClassInfo {
	private Class<?> class1;

	public ClassInfo(String obj) {
		try {
			class1 = Class.forName(obj);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public java.lang.String getName() {
		return class1.getCanonicalName();
	}

	public java.lang.String getModifier() {
		return Modifier.toString(class1.getModifiers());
	}

	public java.lang.String getGenericArgs() {
		TypeVariable[] typeVariable = class1.getTypeParameters();
		StringBuilder stringBuilder = new StringBuilder();
		for (TypeVariable typeVariable2 : typeVariable) {
			stringBuilder.append(typeVariable2);
			stringBuilder.append('\n');
		}
		return stringBuilder.toString();
	}

	public java.lang.String getInterfaces() {
		Type[] classes = class1.getGenericInterfaces();
		StringBuilder stringBuilder = new StringBuilder();
		for (Type c : classes) {
			stringBuilder.append(c);
			stringBuilder.append('\n');
		}
		return stringBuilder.toString();
	}

	public java.lang.String getSuperClasses() {
		Type type = class1.getGenericSuperclass();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(type);
		return stringBuilder.toString();
	}

	public java.lang.String getAnnotations() {
		Annotation[] classes = class1.getAnnotations();
		StringBuilder stringBuilder = new StringBuilder();
		for (Annotation c : classes) {
			stringBuilder.append(c);
			stringBuilder.append('\n');
		}
		return stringBuilder.toString();
	}

	public java.lang.String getFields() {
		Field[] fields = class1.getDeclaredFields();
		StringBuilder stringBuilder = new StringBuilder();
		for (Field field : fields) {
			stringBuilder.append(field);
			stringBuilder.append('\n');
		}
		return stringBuilder.toString();
	}

	public java.lang.String getConstructors() {
		Constructor<?>[] constructors = class1.getConstructors();
		StringBuilder stringBuilder = new StringBuilder();
		for (Constructor<?> constructor : constructors) {
			stringBuilder.append(constructor);
			stringBuilder.append('\n');
		}
		return stringBuilder.toString();
	}

	public String getMethods() {
		Method[] methods = class1.getDeclaredMethods();
		StringBuilder stringBuilder = new StringBuilder();
		for (Method method : methods) {
			stringBuilder.append(method);
			stringBuilder.append('\n');
		}
		return stringBuilder.toString();
	}

	public void getInnerClasses() {
		Class<?>[] classes = class1.getDeclaredClasses();
		for (Class<?> c : classes) {
			ClassInfo classInfo = new ClassInfo(c.getName());
			System.out.println(classInfo.getName());
			System.out.println(classInfo.getFields());
			System.out.println(classInfo.getConstructors());
			System.out.println(classInfo.getMethods());
		}
	}

	public static void main(String[] args) {
		ClassInfo classInfo = new ClassInfo("java.lang.String");
		System.out.println(classInfo.getName());
		 System.out.println(classInfo.getFields());
		// System.out.println(classInfo.getConstructors());
		 System.out.println(classInfo.getMethods());
//		classInfo.getInnerClasses();
//		 System.out.println(classInfo.getSuperClasses());
//		 System.out.println(classInfo.getAnnotations());
	}
}
