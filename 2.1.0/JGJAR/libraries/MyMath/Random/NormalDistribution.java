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
	public NormalDistribution(double sigma, double m, RandomGenerator rng)
	{
		this.sigma = sigma;
		this.mu = m;
		this.rng = rng;
		
	}
	double sigma, mu;
	RandomGenerator rng;
	
	private double normal(double x)
	{
		double C = sigma*2.50662827;
		double arg = (x-mu)*(x-mu)/(sigma*sigma);
		return MyMath.exp(-arg)/C;
		
		
	}
	//private static final double max = 5, min = -5;
	public double get()
	{
		/*else if(sigma>1000)
			return MyMath.random(-sigma*sigma/2, sigma*sigma/2);*/
		/*double x = MyMath.random(-sigma*sigma/2, sigma*sigma/2);
		double chance = 100*normal(x);
		if(SimpleChance.sampleBool(chance))
			return x;
		else
			return get();*/
		return sigma*rng.nextGaussian()+mu;
		
		
	}

}
