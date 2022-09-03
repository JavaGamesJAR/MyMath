package JGJAR.libraries.MyMath.Random;

import java.util.concurrent.atomic.AtomicLong;

import JGJAR.libraries.MyMath.MyMath;

/**<h1>MyMath LinearCongruentRandom</h1>
 * 
 * Class for generating random numbers
 * @author JavaGamesJAR
 * @version 1.0
 * @since MyMath 1.8.0
 *
 */
public class LinearCongruentRandom extends RandomGenerator
{
	public LinearCongruentRandom(long seed, long multiplier, long adder, long m)
	{
		this.s = seed;
		this.a = multiplier;
		this.b = adder;
		this.m = m;
		
	}
	public LinearCongruentRandom(long multiplier, long adder, long m)
	{
		this(System.currentTimeMillis(), multiplier, adder, m);
		
	}
	private long s, a, b, m;
	
	private double nextNextGaussian;
    private boolean haveNextNextGaussian = false;

	
	@Override
	public double nextGaussian() 
	{
		if (haveNextNextGaussian) {
            haveNextNextGaussian = false;
            return nextNextGaussian;
        } else {
            double v1, v2, s;
            do {
                v1 = 2 * nextDouble() - 1; // between -1 and 1
                v2 = 2 * nextDouble() - 1; // between -1 and 1
                s = v1 * v1 + v2 * v2;
            } while (s >= 1 || s == 0);
            double multiplier = MyMath.sqrt(-2 * MyMath.ln(s)/s);
            nextNextGaussian = v2 * multiplier;
            haveNextNextGaussian = true;
            return v1 * multiplier;
        }
		
	}
	@Override
	public long next() 
	{
		s = (s*a+b)%m;
		return s;
		
	}
	@Override
	public int nextInt() 
	{
		return next(32);
		
	}
	@Override
	public int nextInt(int bound) 
	{
		if (bound <= 0)
            throw new IllegalArgumentException("n must be positive");

        if ((bound & -bound) == bound)  // i.e., n is a power of 2
            return (int)((bound * (long)next(31)) >> 31);

        int bits, val;
        do {
            bits = next(31);
            val = bits % bound;
        } while (bits - val + (bound-1) < 0);
        return val;
        
	}
	@Override
	public boolean nextBoolean() 
	{
		return next(1)!=0;
		
	}
	@Override
	public double nextDouble() 
	{
		return (((long)(next(26)) << 27) + next(27)) / (double)(1L << 53);
		
	}
	@Override
	public float nextFloat() 
	{
		return next(24)/(float)(1<<24);
		
	}
	@Override
	public void nextBytes(byte[] bytes) 
	{
		for (int i = 0, len = bytes.length; i < len; )
            for (int rnd = nextInt(),
                     n = Math.min(len - i, Integer.SIZE/Byte.SIZE);
                 n-- > 0; rnd >>= Byte.SIZE)
                bytes[i++] = (byte)rnd;
		
	}
	@Override
	public int next(int bits) 
	{
		long oldseed, nextseed;
		AtomicLong seed = new AtomicLong(this.s);
		do {
            oldseed = seed.get();
            nextseed = (oldseed * a + b) & m;
        } while (!seed.compareAndSet(oldseed, nextseed));
        return (int)(nextseed >>> (48 - bits));
	}
	@Override
	public double nextDouble(double min, double max) 
	{
		return min+nextDouble()*(max-min);
		
	}

}
