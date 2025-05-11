package generic_utility;

public class JavaUtility {
	public int generateRanNum() {
		double figure = Math.random()*999;
		int randomNum = (int) figure;
		return randomNum;
	}
}
