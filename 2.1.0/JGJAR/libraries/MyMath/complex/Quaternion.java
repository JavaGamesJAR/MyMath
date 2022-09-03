package JGJAR.libraries.MyMath.complex;

import JGJAR.libraries.MyMath.MyMath;
import JGJAR.libraries.MyMath.exceptions.CanNotConvertToComplexException;
import JGJAR.libraries.MyMath.exceptions.ReturnsComplexException;

/**
 * <h1>MyMath Quaternion</h1>
 * Class of Quaternions (Hypercomplex numbers)
 * @author JavaGamesJAR, website: <a href="http://fedorx.ru/index.php?id=0">fedorx.ru</a>
 * @since 1.9.0
 * @version 0.5
 */
public class Quaternion extends Number
{
	/**Quaternion constructor
	 * 
	 * @param a real part
	 * @param b first imaginary
	 * @param c second imaginary
	 * @param d third imaginary
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public Quaternion(double a, double b, double c, double d)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		
	}
	//Components
	public double a, b, c, d;
	
	public static final Quaternion ONE = new Quaternion(1, 0, 0, 0);
	public static final Quaternion I = new Quaternion(0, 1, 0, 0);
	public static final Quaternion J = new Quaternion(0, 0, 1, 0);
	public static final Quaternion K = new Quaternion(0, 0, 0, 1);
	
	/**Adds two quaternions
	 * 
	 * @param q1 first number
	 * @param q2 second number
	 * @return q<sub>1</sub>+q<sub>2</sub>
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static Quaternion add(Quaternion q1, Quaternion q2)
	{
		return new Quaternion(q1.a+q2.a, q1.b+q2.b, q1.c+q2.c, q1.d+q2.d);
		
	}
	/**Subtracts two quaternions
	 * 
	 * @param q1 first number
	 * @param q2 second number
	 * @return q<sub>1</sub>-q<sub>2</sub>
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static Quaternion subtract(Quaternion q1, Quaternion q2)
	{
		return new Quaternion(q1.a-q2.a, q1.b-q2.b, q1.c-q2.c, q1.d-q2.d);
		
	}
	/**Multiplies two quaternions
	 * 
	 * @param q1 first number
	 * @param q2 second number
	 * @return q<sub>1</sub>*q<sub>2</sub>
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static Quaternion multiply(Quaternion q1, Quaternion q2)
	{
        final double w = q1.a*q2.a-q1.b*q2.b - q1.c * q2.c - q1.d * q2.d;
        final double x = q1.a*q2.b+q1.b*q2.a + q1.c * q2.d - q1.d * q2.c;
        final double y = q1.a*q2.c-q1.b*q2.d + q1.c * q2.a + q1.d * q2.b;
        final double z = q1.a*q2.d+q1.b*q2.c - q1.c * q2.b + q1.d * q2.a;

        return new Quaternion(w, x, y, z);
		
	}
	/**Divides two quaternions
	 * 
	 * @param q1 first number
	 * @param q2 second number
	 * @return q<sub>1</sub>/q<sub>2</sub>
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static Quaternion divide(Quaternion q1, Quaternion q2)
	{
		Quaternion q3 = q2.conjugate();
		double den = multiply(q2, q3).doubleValue();
		Quaternion q4 = multiply(q1, q3);
		return new Quaternion(q4.a/den, q4.b/den, q4.c/den, q4.d/den);
		
	}
	/** Returns e<sup>q</sup>
	 * 
	 * @param q quaternion
	 * @return e<sup>q</sup>
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static Quaternion exp(Quaternion q)
	{
		Quaternion q1 = new Quaternion(Math.exp(q.a), 0, 0, 0);
		Quaternion q2 = new Quaternion(Math.cos(q.b), Math.sin(q.b), 0, 0);
		Quaternion q3 = new Quaternion(Math.cos(q.c), 0, Math.sin(q.c), 0);
		Quaternion q4 = new Quaternion(Math.cos(q.d), 0, 0, Math.sin(q.d));
		
		Quaternion q5 = multiply(q1, q2);
		Quaternion q6 = multiply(q5, q3);
		Quaternion q7 = multiply(q6, q4);
		
		return q7;
		
	}
	/** Returns natural logarithm of q
	 * 
	 * @param q quatternion
	 * @return ln(q)
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static Quaternion ln(Quaternion q)
	{
		double abs = q.abs();
		Quaternion conj = q.conjugate();
		double q1 = MyMath.ln(abs);
		Quaternion scalar = new Quaternion(Math.acos(q.a/abs), 0, 0, 0);
		//scalar = divide(scalar, conj);
		Quaternion q2 = new Quaternion(0, q.b, q.c, q.d);
		q2 = multiply(q2, scalar);
		return new Quaternion(q1+q2.a, q2.b, q2.c, q2.d);
		
	}
	/**Conjugates quaternion
	 * 
	 * @param q quaternion
	 * @return conj(q)
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static Quaternion conjugate(Quaternion q)
	{
		return new Quaternion(q.a, -q.b, -q.c, -q.d);
		
	}
	/**Conjugates quaternion
	 *
	 * @return conj(q)
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public Quaternion conjugate()
	{
		return conjugate(this);
		
	}
	/**Absolute value of quaternion
	 * @return |q|
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public double abs()
	{
		return Math.sqrt(a*a+b*b+c*c+d*d);
		
	}
	/**Absolute value of quaternion
	 * 
	 * @param q quaternion
	 * @return |q|
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static double abs(Quaternion q)
	{
		return q.abs();
		
	}
	@Override
	public double doubleValue() {
		if(b==0 && c==0 && d==0)
			return a;
		else
		{
			try
			{
				throw new ReturnsComplexException("Your Quaternion has non-zero imaginary part", new Throwable());
				
			}
			catch(ReturnsComplexException exp){}
			return 0;
			
		}
	}

	@Override
	public float floatValue() {
		return (float)doubleValue();
	}

	@Override
	public int intValue() {
		return (int)doubleValue();
	}

	@Override
	public long longValue() {
		return (long)doubleValue();
	}
	public String toString()
	{
		return "("+a+"; "+b+"; "+c+"; "+d+")";
		
	}
	public Complex toComplex()
	{
		if(c==0 && d==0)
			return new Complex(a, b);
		else
		{
			try
			{
				throw new CanNotConvertToComplexException("Your Quaternion has non-zero coefficients either at c or d or both", new Throwable());
				
			}
			catch(CanNotConvertToComplexException exp){}
			return null;
		}
		
	}
	/**Parses quaternion
	 * 
	 * @param s String
	 * @return quaternion from string
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public Quaternion parseQuaternion(String s)
	{
		s = s.replaceAll("(", "");
		s = s.replaceAll(")", "");
		s = s.trim();
		
		String[] compsStr = s.split(";");
		
		double[] c = new double[4];
		
		for(int i = 0; i<4; i++)
			c[i] = Double.parseDouble(compsStr[i]);
		
		return new Quaternion(c[0], c[1], c[2], c[3]);
		
	}
	
}
