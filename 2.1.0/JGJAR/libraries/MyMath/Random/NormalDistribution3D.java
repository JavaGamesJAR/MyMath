package JGJAR.libraries.MyMath.Random;

import JGJAR.libraries.MyMath.vectors.Vector;

public class NormalDistribution3D 
{
	public NormalDistribution3D(double s1, double s2, double s3, double m1, double m2, double m3, RandomGenerator rng)
	{
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.rng = rng;
		
	}
	public NormalDistribution3D(Vector sigma, Vector mu, RandomGenerator rng)
	{
		this(sigma.x, sigma.y, sigma.z, mu.x, mu.y, mu.z, rng);
		
	}
	double s1, s2, s3, m1, m2, m3;
	RandomGenerator rng;
	
	public Vector sample()
	{
		NormalDistribution n1 = new NormalDistribution(s1, m1, rng);
		NormalDistribution n2 = new NormalDistribution(s2, m2, rng);
		NormalDistribution n3 = new NormalDistribution(s3, m3, rng);
		
		return new Vector(n1.get(), n2.get(), n3.get());
		
	}

}
