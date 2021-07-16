package bytecode;

import org.junit.Assert;
import org.junit.Test;

public class MoimTest {

	@Test
	public void isEnrollmentFull() {
		Moim moim = new Moim();
		moim.maxNumberOfAttendees = 100;
		moim.numberOfCurrentEnrollment = 10;
		Assert.assertFalse(moim.isEnrollmentFull());

	}
}