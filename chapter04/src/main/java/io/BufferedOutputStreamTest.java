package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
	public static void main(String[] args) {
		BufferedOutputStream bos = null;

		try {
			// 스트림 라인 or 파이프 라인
			// 기반 스트림
			FileOutputStream fos = new FileOutputStream("test.txt");
			// 보조 스트림
			bos = new BufferedOutputStream(fos);
		} catch (FileNotFoundException ex) {
			System.out.println("Can't Open : " + ex);
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				System.out.println("Error : " + e);
			}
		}

	}

}
