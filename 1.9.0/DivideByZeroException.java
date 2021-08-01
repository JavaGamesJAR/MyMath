package JGJAR.libraries.MyMath;

/**<h1>MyMath DivideByZeroException</h1>
 * 
 * Exception thrown when you try to divide by zero
 * @author JavaGamesJAR
 * @version 1.0
 * @since MyMath 1.8.0
 *
 */
public class DivideByZeroException extends Exception
{
	public DivideByZeroException()
	{
		super();
		
	}
	public DivideByZeroException(String message)
	{
		super(message);
		
	}
	public DivideByZeroException(Throwable cause)
	{
		super(cause);
		
	}
	public DivideByZeroException(String message, Throwable cause)
	{
		super(message, cause);
		
	}
	protected DivideByZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) 
	{
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
