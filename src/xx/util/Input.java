package xx.util;

import java.util.Scanner;

public class Input {
	public static long getLong() {
		Scanner scanner = new Scanner(System.in);
		boolean b = false;
		long l = 0;
		System.out.println("input long integer");
		do {
			try {
				if (scanner.hasNextLong()) {
					l = scanner.nextLong();
					b = true;
				} else {
					if (scanner.hasNext())
						scanner.next();
					System.out.println("failed, input long integer again");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (!b);
		return l;
	}
}
