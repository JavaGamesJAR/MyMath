package JGJAR.libraries.MyMath.exceptions;

/**<h1>MyMath ReturnsComplexException</h1>
 * 
 * Exception thrown if function returns Complex number, but expected to return real
 * @author JavaGamesJAR
 * @version 1.0
 * @since MyMath 1.8.0
 *
 */
public class ReturnsComplexException  extends Exception
{
	private static final long serialVersionUID = 1L;
	public ReturnsComplexException()
	{
		super();
		
	}
	public ReturnsComplexException(String message)
	{
		super(message);
		
	}
	public ReturnsComplexException(Throwable cause)
	{
		super(cause);
		
	}
	public ReturnsComplexException(String message, Throwable cause)
	{
		super(message, cause);
		
	}
	protected ReturnsComplexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) 
	{
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
