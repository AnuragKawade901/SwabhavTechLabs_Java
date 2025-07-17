package com.aurionpro.student.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.aurionpro.student.model.Student;

public class StudentTest {
public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	Student student = new Student();
	
	Class c = Student.class;
	System.out.println(c.getName());
	
//	Field fields = c.getDeclaredField("cgpa");
//	fields.setAccessible(true);
//	fields.set(student, 8);
//	System.out.println("Cgpa is: "+fields.get(student));
	
	Method m = c.getDeclaredMethod("result", double.class);
	m.setAccessible(true);
	System.out.println(m.invoke(student, 9.0));
	
	
	

	
//	Field[] fields = c.getDeclaredFields();
	
//	System.out.println("Fields are: ");
//	for(Field result : fields) {
//		System.out.println(result.getName());
//	}
//	
//	System.out.println("--------------------------");
//	System.out.println("Methods are: ");
//	
//	for(Method meth : c.getDeclaredMethods()) {
//		System.out.println("Method name: "+meth.getName());
//		System.out.println("Return type: "+meth.getReturnType());
//		System.out.println("Modifier is: "+Modifier.toString(meth.getModifiers()));
//	}
//s	Constructor[] cons
//	for(Constructor<?> cons : c.getDeclaredConstructors()) {
//		System.out.println("Constructor name: "+ cons.getName());
//	}
}
}
