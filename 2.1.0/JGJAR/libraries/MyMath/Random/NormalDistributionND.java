package JGJAR.libraries.MyMath.Random;

import JGJAR.libraries.MyMath.exceptions.ArraysAreNotSameSizeException;

public class NormalDistributionND 
{
	public NormalDistributionND(double[] sigmas, double[] mus, RandomGenerator rng)
	{
		if(sigmas.length!=mus.length)
		{
			try
			{
				throw new ArraysAreNotSameSizeException("Length of sigmas and length of mus must be same!");
				
			}
			catch(Exception exp){}
			
		}
		this.s = sigmas;
		this.m = mus;
		this.rng = rng;
		
	}
	double[] s, m;
	RandomGenerator rng;
	
	public double[] sample()
	{
		double[] res = new double[s.length];
		for(int i = 0; i<s.length; i++)
		{
			NormalDistribution nd = new NormalDistribution(s[i], m[i], rng);
			res[i] = nd.get();
			
		}
		return res;
		
	}

}
