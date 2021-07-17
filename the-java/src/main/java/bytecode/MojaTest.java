package bytecode;

import static net.bytebuddy.matcher.ElementMatchers.*;

import java.io.File;
import java.io.IOException;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

public class MojaTest {
	public static void main(String[] args) {
		// try {
		// 	new ByteBuddy().redefine(Moja.class).method(named("pullOut"))
		// 				   .intercept(FixedValue.value("Rabbit!"))
		// 				   .make().saveIn(new File(
		// 		"C:\\Users\\JohnMark\\Desktop\\johnmark\\BackToTheBasic\\the-java\\target\\classes\\"));
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// }
		System.out.println(new Moja().pullOut());
	}
}
