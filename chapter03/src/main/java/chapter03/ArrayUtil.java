package chapter03;

public class ArrayUtil {

	public static double[] intToDouble(int[] a) {
		double[] result = new double[a.length];
		for(int i = 0; i < a.length; i++) {
			result[i] = a[i];
		}
		return result;
	}

	public static int[] doubleToInt(double[] ds) {
		int[] result2 = new int[ds.length];
		for(int j = 0; j < ds.length; j++) {
			result2[j] = (int)ds[j];
		}
		return result2;
	}

	public static int[] concat(int[] is, int[] is2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
