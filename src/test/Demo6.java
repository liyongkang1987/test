package test;

public class Demo6 {

	public static void main(String[] args) {

		try {
			fun();
		} catch (ExceptionA e) {
			// e.printStackTrace();
			try {
				throw new ExceptionB(e);
			} catch (ExceptionB e1) {
//				e1.initCause(e);
				e1.printStackTrace();
			}
		}

	}

	public static void fun() throws ExceptionA {
		System.out.println("fun()");
		throw new ExceptionA("ExceptionA");
	}

}


class ExceptionA extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionA(String str) {
        super();
    }

	public ExceptionA(Throwable throwObj) {
		super(throwObj);
	}
}
 
class ExceptionB extends ExceptionA {
 
	private static final long serialVersionUID = 7520105617780410479L;

	public ExceptionB(String str) {
        super(str);
    }

	public ExceptionB(Throwable throwObj) {
		super(throwObj);
	}
}
 
class ExceptionC extends ExceptionA {

	private static final long serialVersionUID = 1L;

	public ExceptionC(String str) {
        super(str);
    }
}
