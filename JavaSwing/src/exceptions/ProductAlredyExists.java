package exceptions;

public class ProductAlredyExists extends Exception{
private static final long serialVersionUID = 1L;
	public ProductAlredyExists(String msg) {
		super(msg);
	}
}
