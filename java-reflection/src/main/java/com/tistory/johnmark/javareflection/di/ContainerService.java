package com.tistory.johnmark.javareflection.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {
	public static <T> T getObject(Class<T> classType) {
		T instance = createInstance(classType);
		Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
			if (f.getAnnotation(Inject.class) != null) {
				Object fieldInInstance = createInstance(f.getType());
				f.setAccessible(true);
				try {
					f.set(instance, fieldInInstance);
				} catch (IllegalAccessException e) {
					// e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		});
		return instance;
	}

	private static <T> T createInstance(Class<T> classType) {
		try {
			return classType.getConstructor(null).newInstance();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}
}
