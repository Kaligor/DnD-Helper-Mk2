package dndhelpermk2.exception;


public class CRUDException extends Exception
  {


    public CRUDException(String message) {
		super(message);
	}

	public CRUDException(String message, Exception e) {
		super(message, e);
	}
  }
