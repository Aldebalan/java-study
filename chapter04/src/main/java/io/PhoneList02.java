package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {

	private static Scanner scanner;

	public static void main(String[] args) {
		Scanner scan = scanner;

		BufferedReader br = null;
		try {
			File file = new File("phone.txt");

			if (!file.exists()) {
				System.out.println("file not found");
				return;
			}
			System.out.println("==========파일정보==========");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println(sdf.format(new Date(file.lastModified())));

			System.out.println("==========전화번호==========");
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String name = scanner.next();
				String phone1 = scanner.next();
				String phone2 = scanner.next();
				String phone3 = scanner.next();

				System.out.println(name + ":" + phone1 + "-" + phone2 + "-" + phone3);
			}

		} catch (IOException ex) {
			System.out.println("File Not Found" + " : " + ex);
		} finally {
			scanner.close();
		}

	}

}