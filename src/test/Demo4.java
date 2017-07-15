package test;

public class Demo4 {

	public static void main(String[] args) {

		int a = 5;
		int b = 0;
		try {
			double c = a / b;
			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("e.getMessage(): " + e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e);
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace()[0]);
			System.out.println(e.getSuppressed().length);

		} finally {
			// System.out.println("finally");
		}

	}

}
