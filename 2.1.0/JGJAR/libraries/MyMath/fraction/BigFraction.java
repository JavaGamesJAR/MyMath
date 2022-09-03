package JGJAR.libraries.MyMath.fraction;

import java.math.BigInteger;
import JGJAR.libraries.MyMath.exceptions.DivideByZeroException;

/**
 * ATTENTION!!!<br>
 * The class is NOT ready
 * @author JavaGamesJAR
 *
 */
public class BigFraction
{
	private static BigInteger lcm(BigInteger a, BigInteger b)
	{
		BigInteger mul = a.multiply(b);
        BigInteger gcd = a.gcd(b);
        return mul.divide(gcd);
		
	}
	public BigFraction(BigInteger num, BigInteger den)
	{
		if(den.equals(BigInteger.ZERO))
		{
			try {
				throw new DivideByZeroException("Deninator can't be 0!");
			} catch (DivideByZeroException e) {
			}
			
		}
		else if(num.equals(BigInteger.ZERO))
		{
			this.num=BigInteger.ZERO;
			this.den=BigInteger.ONE;
			
		}
		else
		{
			BigInteger gcd = num.gcd(den);
			this.num = num.divide(gcd);
			this.den = den.divide(gcd);
			
		}
		
	}
	BigInteger num, den;
	
	public static BigFraction add(BigFraction a, BigFraction b)
	{
		BigFraction res = b;
		BigInteger lcm = lcm(a.den, b.den);
		res.num = res.num.multiply(lcm);
		a.num = a.num.multiply(lcm);
		res.den = res.den.multiply(lcm);
		a.den = a.den.multiply(lcm);
		
		res.num = res.num.add(a.num);
		
		return new BigFraction(res.num, res.den);
		
	}
	public static BigFraction subtract(BigFraction a, BigFraction b)
	{
		BigFraction res = b;
		BigInteger lcm = lcm(a.den, b.den);
		res.num = res.num.multiply(lcm);
		a.num = a.num.multiply(lcm);
		res.den = res.den.multiply(lcm);
		a.den = a.den.multiply(lcm);
		
		res.num = res.num.subtract(a.num);
		
		return new BigFraction(res.num, res.den);
		
	}
	public static BigFraction multiply(BigFraction a, BigFraction b)
	{
		return new BigFraction(a.num.multiply(b.num), a.den.multiply(b.den));
		
	}
	public static BigFraction divide(BigFraction a, BigFraction b)
	{
		return new BigFraction(a.num.multiply(b.den), a.den.multiply(b.num));
		
	}
	public String toString()
	{
		return num.toString()+"/"+den.toString();
		
	}

}
