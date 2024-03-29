package com.wufuqiang.reflection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

	public static void main(String[] args) {
		ReflectionTest t1 = new ReflectionTest();
		try {
			t1.test2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getConstructorTest() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		final Class<Person> clazz = Person.class;
		final Constructor<Person> constructor = clazz.getConstructor();
		final Person person = constructor.newInstance();
		System.out.println("Person:"+person);
	}
	
	@Test
	public void test2() throws Exception {
		Class clazz = Person.class;

		//通过反射，创建Person类的对象
		Constructor cons = clazz.getConstructor(String.class, int.class);
		Object obj = cons.newInstance("wufuqiang", 12);
		Person p1 = (Person)obj;
		p1.show();
		//获取public修饰的属性
		//Field name = clazz.getField("name");

		//获取私有属性
		Field name = clazz.getDeclaredField("name");
		name.setAccessible(true);
		name.set(p1,"wufq");
		System.out.println(p1);
//		clazz.getDeclaredField("name");
		Method show = clazz.getDeclaredMethod("show");
		show.invoke(p1);

		Method showNation = clazz.getDeclaredMethod("showNation", String.class);
		showNation.setAccessible(true);
		String china = (String)showNation.invoke(p1, "China");
		System.out.println("nation:"+china);
	}
}
