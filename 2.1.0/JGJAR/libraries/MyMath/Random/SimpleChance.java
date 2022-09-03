package JGJAR.libraries.MyMath.Random;

import JGJAR.libraries.MyMath.MyMath;

/**<h1>MyMath SimpleChance</h1>
 * 
 * Class for generating random boolean from chance
 * @author JavaGamesJAR
 * @version 1.0
 * @since MyMath 2.0.0
 *
 */
public class SimpleChance 
{
	public SimpleChance(RandomGenerator rng)
	{
		this.rng = rng;
		
	}
	RandomGenerator rng;
	public boolean sampleBool(double percentage)
	{
		double rnd = rng.nextDouble(0.0, 100.0);
		return percentage>rnd;
		
	}
	public int sampleInt(double percentage)
	{
		double rnd = rng.nextDouble(0.0, 100.0);
		return percentage>rnd ? 1 : 0;
		
	}
	public double sampleDoub(double percentage)
	{
		double rnd = rng.nextDouble(0.0, 100.0);
		return percentage>rnd ? 1.0 : 0.0;
		
	}
	/*public static boolean sampleBool(double percentage)
	{
		double rnd = MyMath.random(0.0, 100.0);
		return percentage>rnd;
		
	}
	public static int sampleInt(double percentage)
	{
		double rnd = MyMath.random(0.0, 100.0);
		return percentage>rnd ? 1 : 0;
		
	}
	public static double sampleDoub(double percentage)
	{
		double rnd = MyMath.random(0.0, 100.0);
		return percentage>rnd ? 1.0 : 0.0;
		
	}*/
	
}
