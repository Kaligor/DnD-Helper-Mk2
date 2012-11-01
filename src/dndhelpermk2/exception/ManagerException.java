package dndhelpermk2.exception;

public class ManagerException extends Exception
  {

    public ManagerException(String message) {
		super(message);
	}

	public ManagerException(String message, Exception e) {
		super(message, e);
	}
  }
