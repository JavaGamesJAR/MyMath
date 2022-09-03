package JGJAR.libraries.MyMath.Random;
public abstract class RandomGenerator
{
	public abstract double nextGaussian();
	public abstract long next();
	public abstract int nextInt();
	public abstract int nextInt(int bound);
	public abstract boolean nextBoolean();
	public abstract double nextDouble();
	public abstract float nextFloat();
	public abstract void nextBytes(byte[] bytes);
	public abstract int next(int bits);
	public abstract double nextDouble(double min, double max);
}