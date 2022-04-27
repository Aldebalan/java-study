package chapter03;

import java.util.Arrays;
import java.util.stream.Stream;

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
		int isLen = is.length;
		int isLen2 = is2.length;
		int[] result3 = new int[isLen + isLen2];
		System.arraycopy(is, 0, result3, 0, isLen);
		System.arraycopy(is2, 0, result3, isLen, isLen2);
		return result3;
	}
	
	
	

}
