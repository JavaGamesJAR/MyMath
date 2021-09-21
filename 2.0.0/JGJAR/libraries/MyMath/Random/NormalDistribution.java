package JGJAR.libraries.MyMath.Random;

import JGJAR.libraries.MyMath.MyMath;

/**<h1>MyMath NormalDistribution</h1>
 * 
 * Class for generating random numbers
 * @author JavaGamesJAR
 * @version 1.0
 * @since MyMath 2.0.0
 *
 */
public class NormalDistribution 
{
	public NormalDistribution(double sigma, double m)
	{
		this.sigma = sigma;
		this.mu = m;
		
	}
	double sigma, mu;
	private double normal(double x)
	{
		double C = sigma*2.50662827;
		double arg = (x-mu)*(x-mu)/(sigma*sigma);
		return MyMath.exp(-arg)/C;
		
		
	}
	private static final double max = 50, min = -50;
	public double get()
	{
		double x = MyMath.random(min, max);
		double chance = 100*normal(x);
		if(SimpleChance.sampleBool(chance))
			return x;
		else
			return get();
		
		
	}

}
