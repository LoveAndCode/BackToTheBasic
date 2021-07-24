package com.tistory.johnmark.javareflection.reflection.modification;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App3 {
	public static void main(String[] args) throws
		InvocationTargetException,
		InstantiationException,
		IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
		Class<Product> productClass = Product.class;

		// Create Instance
		// productClass.newInstance(); is deprecated
		Constructor<Product> constructor = productClass.getConstructor(String.class);
		Product product = constructor.newInstance("New Product");
		System.out.println("product = " + product);

		// Get static Field
		Field a = Product.class.getDeclaredField("A");
		System.out.println("a = " + a.get(null));
		a.set(null, "Hi!");
		System.out.println("a = " + a.get(null));

		// Get Instance Field
		Field b = Product.class.getDeclaredField("B");
		b.setAccessible(true);
		System.out.println(b.get(product));
		b.set(product, "BBBBBBB");
		System.out.println(b.get(product));

		// Invoke Instance Method
		Method d = Product.class.getDeclaredMethod("sum", int.class, int.class);
		int invoke = (int)d.invoke(product, 1, 2);
		System.out.println("invoke = " + invoke);
	}
}
