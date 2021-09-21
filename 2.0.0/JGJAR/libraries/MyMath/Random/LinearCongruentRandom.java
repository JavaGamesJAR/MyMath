package JGJAR.libraries.MyMath.Random;

/**<h1>MyMath LinearCongruentRandom</h1>
 * 
 * Class for generating random numbers
 * @author JavaGamesJAR
 * @version 1.0
 * @since MyMath 1.8.0
 *
 */
public class LinearCongruentRandom 
{
	public LinearCongruentRandom(long seed, long multiplier, long adder, long m)
	{
		this.s = seed;
		this.a = multiplier;
		this.b = adder;
		this.m = m;
		
	}
	long s, a, b, m;
	
	public long next()
	{
		long n = (a*s+b)%m;
		this.s = n;
		return n;
		
	}

}
