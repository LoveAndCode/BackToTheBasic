package classloader;

public class CheckClassLoader {
	public static void main(String[] args) {
		ClassLoader classLoader = CheckClassLoader.class.getClassLoader();
		System.out.println(classLoader);
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());
	}
}
