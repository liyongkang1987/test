package test;

public class Demo5 {

	public static void main(String[] args) {
		try {
			throw new Error("An error occurs here");
		} catch (Exception e) {
			System.out.println("catched as Exception");
			e.printStackTrace();
		} catch (Error e) {
			System.out.println("catched as Error");
			e.printStackTrace();
		} catch (Throwable t) {
			System.out.println("catched as Throwable");
			t.printStackTrace();
		}
		System.out.println("reach the end of the method");
	}
}

