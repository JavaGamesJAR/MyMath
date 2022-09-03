package JGJAR.libraries.MyMath.Random;

import java.util.Random;

public class DefaultRandom extends RandomGenerator
{
	public DefaultRandom(long seed) 
	{
		rnd = new Random(seed);
		
	}
	public DefaultRandom()
	{
		this(System.currentTimeMillis());
		
	}
	Random rnd;
	@Override
	public double nextGaussian() 
	{
		return rnd.nextGaussian();
		
	}

	@Override
	public long next() 
	{
		return rnd.nextLong();
		
	}

	@Override
	public int nextInt() 
	{
		return rnd.nextInt();
		
	}

	@Override
	public int nextInt(int bound) 
	{
		return rnd.nextInt(bound);
		
	}

	@Override
	public boolean nextBoolean() 
	{
		return rnd.nextBoolean();
		
	}

	@Override
	public double nextDouble() 
	{
		return rnd.nextDouble();
		
	}
	@Override
	public float nextFloat()
	{
		return rnd.nextFloat();
		
	}
	@Override
	public void nextBytes(byte[] bytes) {
		rnd.nextBytes(bytes);
		
	}
	@Override
	public int next(int bits)
	{
		return rnd.nextInt(32);
		
	}
	@Override
	public double nextDouble(double min, double max) 
	{
		return min+nextDouble()*(max-min);
		
	}
	
	
}