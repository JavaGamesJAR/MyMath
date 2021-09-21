package JGJAR.libraries.MyMath.exceptions;

/**<h1>MyMath FractionFormatException</h1>
 * 
 * Exception thrown when you try to parse non-Fraction String to Fraction
 * @author JavaGamesJAR
 * @version 1.0
 * @since MyMath 1.8.0
 *
 */
public class FractionFormatException extends Exception
{
	public FractionFormatException()
	{
		super();
		
	}
	public FractionFormatException(String message)
	{
		super(message);
		
	}
	public FractionFormatException(Throwable cause)
	{
		super(cause);
		
	}
	public FractionFormatException(String message, Throwable cause)
	{
		super(message, cause);
		
	}
	protected FractionFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) 
	{
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
