package synchornize;

public class SynchronizedMethod {
	private int sum = 0;

	public void calculate() {
		setSum(getSum() + 1);
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}
