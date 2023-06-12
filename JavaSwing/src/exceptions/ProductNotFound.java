package exceptions;

public class ProductNotFound extends Exception{
	private static final long serialVersionUID = 1L;
	public ProductNotFound(String msg) {
		super(msg);
	}
}
