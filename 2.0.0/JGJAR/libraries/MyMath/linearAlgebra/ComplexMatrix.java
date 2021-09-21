package JGJAR.libraries.MyMath.linearAlgebra;

import JGJAR.libraries.MyMath.complex.*;

/**<h1>ComplexMatrix class</h1>
 * 
 * @author JavaGamesJAR
 * @version 0.5
 * @since 2.0.0
 *
 */
public class ComplexMatrix 
{
	public ComplexMatrix(Complex[][] c)
	{
		this.c = c;
		this.l = c.length;
		this.h = c[0].length;
		
	}
	Complex[][] c;
	int h, l;
	
	/**Returns coefficient in i & j position
	 * 
	 * @param i x coordinate of coefficient
	 * @param j y coordinate of coefficient
	 * @return M(i, j)
	 * @since 0.5 (MyMath 2.0.0)
	 */
	public Complex get(int i, int j)
	{
		return c[i][j];
		
	}
	/**Returns square matrix with det(A)=1
	 * 
	 * @param n size of matrix
	 * @return I(n)
	 * @since 0.5 (MyMath 2.0.0)
	 */
	public static ComplexMatrix UnitMatrix(int n)
	{
		Complex[][] c = new Complex[n][n];
		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<n; j++)
			{
				if(i==j)
				{
					c[i][j]=Complex.ONE;
					
				}
				else c[i][j]=Complex.ZERO;
				
			}
			
		}
		return new ComplexMatrix(c);
		
	}
	public static ComplexMatrix ZeroMatrix(int n)
	{
		Complex[][] c = new Complex[n][n];
		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<n; j++)
			{
				c[i][j]=Complex.ZERO;
				
			}
			
		}
		return new ComplexMatrix(c);
		
	}
	public static ComplexMatrix IMatrix(int n)
	{
		Complex[][] c = new Complex[n][n];
		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<n; j++)
			{
				if(i==j)
				{
					c[i][j]=Complex.I;
					
				}
				else c[i][j]=Complex.ZERO;
				
			}
			
		}
		return new ComplexMatrix(c);
		
	}
	public static ComplexMatrix mult(ComplexMatrix A, Complex z)
	{
		Complex[][] c = new Complex[A.l][A.h];
		
		for(int i = 0; i<A.l; i++)
		{
			for(int j = 0; j<A.h; j++)
			{
				c[i][j] = Complex.multiply(A.get(i, j), z);
				
			}
			
		}
		return new ComplexMatrix(c);
		
	}
	
}
