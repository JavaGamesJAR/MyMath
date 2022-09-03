package JGJAR.libraries.MyMath.tensor;

import JGJAR.libraries.MyMath.MyMath;

/**<h1>MyMath NumTensor</h1>
 * 
 * @author JavaGamesJAR
 * @since 2.1.0
 * @version 0.5
 *
 */
public class NumTensor 
{
	public NumTensor(int rank, int dimension)
	{
		tensor = new double[(int)MyMath.fastpow(dimension, rank)];
		this.dim = dimension;
		this.rank = rank;
		
	}
	private int dim, rank;
	double[] tensor;

	private int getIndex(int[] comps)
	{
		int index = 0;
		
		for(int i = 0; i<rank-1; i++)
		{
			index+=comps[i]*(int)MyMath.fastpow(dim, rank-i-3);
			
		}
		return index;
		
	}
	/**Sets Tensor element to value
	 * 
	 * @param components the indices of tensor
	 * @param value what the tensor element would be set to
	 * @since 0.5 (MyMath 2.1.0)
	 * 
	 */
	public void set(int[] components, double value)
	{
		tensor[getIndex(components)] = value;
		
	}
	/**Gets tensor element by indices
	 * 
	 * @param components indices of tensor
	 * @return tensor element
	 */
	public double get(int[] components)
	{
		return tensor[getIndex(components)];
		
	}
	/**Returns rank of tensor
	 * 
	 * @return rank of tensor
	 * @since 0.5 (MyMath 2.1.0)
	 */
	public int getRank()
	{
		return rank;
		
	}
	/**Returns dimension of tensor
	 * 
	 * @return dimension of tensor
	 * @since 0.5 (MyMath 2.1.0)
	 */
	public int dim()
	{
		return dim;
		
	}
	
}
