package JGJAR.libraries.MyMath.Random;

public class Dice
{
	public Dice(int numberOfFaces, RandomGenerator rng)
	{
		this.rng = rng;
		this.nof = numberOfFaces;
		
	}
	private int nof;
	private RandomGenerator rng;
	public int throwDice()
	{
		return rng.nextInt(nof)+1;
		
	}
	
}
