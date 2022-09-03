package JGJAR.libraries.MyMath.Random;

import JGJAR.libraries.MyMath.vectors.Vector2;

/**<h1>MyMath NormalDistribution2D</h1>
 * 
 * Class for generating random numbers
 * @author JavaGamesJAR
 * @version 1.0
 * @since MyMath 2.0.0
 *
 */
public class NormalDistribution2D 
{
	public NormalDistribution2D(double[] mu, double[] sigma, RandomGenerator rng)
	{
		this.m1 = mu[0];
		this.m2 = mu[1];
		this.s1 = sigma[0];
		this.s2 = sigma[1];
		this.rng = rng;
		
	}
	RandomGenerator rng;
	double m1, m2, s1, s2;
	public Vector2 get()
	{
		NormalDistribution normX = new NormalDistribution(s1, m1, rng);
		NormalDistribution normY = new NormalDistribution(s2, m2, rng);
		
		return new Vector2(normX.get(), normY.get());
		
	}
	
}
