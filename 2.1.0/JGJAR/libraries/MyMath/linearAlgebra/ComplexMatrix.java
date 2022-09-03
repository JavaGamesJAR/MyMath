package JGJAR.libraries.MyMath.linearAlgebra;

import JGJAR.libraries.MyMath.complex.*;
import JGJAR.libraries.MyMath.exceptions.MatricesAreNotSameSizeException;
import JGJAR.libraries.MyMath.exceptions.MatrixIsNotSquareException;
import JGJAR.libraries.MyMath.tensor.Tensor;

/**<h1>ComplexMatrix class</h1>
 * 
 * @author JavaGamesJAR
 * @version 0.6
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
	public final int h, l;
	
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
	/**Returns square matrix s.t. AI=A
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
	/**Returns square matrix s.t. AZ=Z
	 * 
	 * @param n size of matrix
	 * @return Z(n)
	 * @since 0.5 (MyMath 2.0.0)
	 */
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
	/**Returns square matrix with iI
	 * 
	 * @param n size of matrix
	 * @return iI(n)
	 * @since 0.5 (MyMath 2.0.0)
	 */
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
	/**Adds 2 complex matrices
	 * 
	 * @param a first adder
	 * @param b second adder
	 * @return a+b
	 * @since 0.5 (MyMath 2.0.0)
	 */
	public static ComplexMatrix add(ComplexMatrix a, ComplexMatrix b)
	{
		if(a.l!=b.l || a.h!=b.h)
		{
			try {
				throw new MatricesAreNotSameSizeException();
			} catch (MatricesAreNotSameSizeException e) {
			}
			return null;
			
		}
		else
		{
			Complex[][] c = new Complex[a.l][a.h];
			for(int i = 0; i<b.l; i++)
			{
				for(int j = 0; j<b.h; j++)
				{
					c[i][j] = Complex.add(a.c[i][j], b.c[i][j]);
					
				}
				
			}
			return new ComplexMatrix(c);
			
		}
		
	}
	/**Subtracts 2 complex matrices
	 * 
	 * @param a matrix
	 * @param b subtractor
	 * @return a-b
	 * @since 0.5 (MyMath 2.0.0)
	 */
	public static ComplexMatrix subtract(ComplexMatrix a, ComplexMatrix b)
	{
		if(a.l!=b.l || a.h!=b.h)
		{
			try {
				throw new MatricesAreNotSameSizeException();
			} catch (MatricesAreNotSameSizeException e) {
			}
			return null;
			
		}
		else
		{
			Complex[][] c = new Complex[a.l][a.h];
			for(int i = 0; i<b.l; i++)
			{
				for(int j = 0; j<b.h; j++)
				{
					c[i][j] = Complex.subtract(a.c[i][j], b.c[i][j]);
					
				}
				
			}
			return new ComplexMatrix(c);
			
		}
		
	}
	/**Multiplies matrix by number
	 * 
	 * @param A matrix
	 * @param z subtractor
	 * @return zA
	 * @since 0.5 (MyMath 2.0.0)
	 */
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
	/**Multiplies 2 matrices
	 * 
	 * @param a mtultiplier
	 * @param b multiplier
	 * @return ab
	 * @since 0.5 (MyMath 2.0.0)
	 */
	public static ComplexMatrix mult(ComplexMatrix a, ComplexMatrix b)
	{
		int l = a.h, m = a.l, n = b.l;
		if(a.h!=b.l && b.h!=a.l)
		{
			try {
				throw new MatricesAreNotSameSizeException();
			} catch (MatricesAreNotSameSizeException e) {}
			return null;
			
		}
		else if(m==b.h)
		{
			Complex c[][] = new Complex[n][l];
			
			for(int i = 0; i<n; i++)
			{
				for(int j = 0; j<l; j++)
				{
					c[i][j]=Complex.ZERO;
					
				}
				
			}
			
			for(int i = 0; i<n; i++)
			{
				for(int j = 0; j<l; j++)
				{
					for(int k = 0; k<m; k++)
					{
						c[i][j] = Complex.add(c[i][j], Complex.multiply(a.get(k, j), 
								b.get(i, k)));
						
					}
					
				}
				
			}
			return new ComplexMatrix(c);
			
		}
		else
		{
			/*Complex c[][] = new Complex[l][n];
			
			for(int i = 0; i<n; i++)
			{
				for(int j = 0; j<l; j++)
				{
					c[j][i]=Complex.ZERO;
					
				}
				
			}
			
			for(int i = 0; i<n; i++)
			{
				for(int j = 0; j<l; j++)
				{
					for(int k = 0; k<m; k++)
					{
						c[j][i] = Complex.add(c[j][i], Complex.multiply(a.get(k, i), 
								b.get(j, k)));
						
					}
					
				}
				
			}
			return new ComplexMatrix(c);*/
			return mult(b, a);
			
		}
		
	}
	/**Transports matrix
	 * 
	 * @param A matrix
	 * @return A<sup>T</sup>
	 * @since 0.6 (MyMath 2.1.0)
	 */
	public static ComplexMatrix transport(ComplexMatrix A)
	{
		Complex[][] c = new Complex[A.h][A.l];
		
		for(int i = 0; i<A.l; i++)
		{
			for(int j = 0; j<A.h; j++)
			{
				c[j][i] = A.get(i, j);
				
			}
			
		}
		return new ComplexMatrix(c);
		
	}
	/**Conjugates matrix
	 * 
	 * @param A matrix
	 * @return A*
	 * @since 0.6 (MyMath 2.1.0)
	 */
	public static ComplexMatrix conjugate(ComplexMatrix A)
	{
		Complex c[][] = new Complex[A.l][A.h];
		for(int i = 0; i<A.l; i++)
		{
			for(int j = 0; j<A.h; j++)
			{
				c[i][j] = A.c[i][j].conjugate();
				
			}
			
		}
		return new ComplexMatrix(c);
		
	}
	/**Conjugates matrix
	 * 
	 * @param A matrix
	 * @return A*
	 * @since 0.6 (MyMath 2.1.0)
	 */
	public void conjugate()
	{
		for(int i = 0; i<this.l; i++)
		{
			for(int j = 0; j<this.h; j++)
			{
				this.c[i][j] = this.c[i][j].conjugate();
				
			}
			
		}
		
	}
	/**Converts Matrix to Tensor of rank 2 and dimension Matrix.h
	 * @throws MatrixIsNotSquareException if Matrix isn't square
	 * @return Tensor rank 2, dimension Matrix.h
	 * @since 0.8 (MyMath 2.1.0)
	 */
	public Tensor toTensor()
	{
		if(this.h!=this.l)
		{
			try {
				throw new MatrixIsNotSquareException("Matrix must be square!");
			} catch (MatrixIsNotSquareException e) {}
			
		}
		Tensor res = new Tensor(2, this.h);
		for(int i = 0; i<this.h; i++)
		{
			for(int j = 0; j<this.h; j++)
			{
				res.set(new int[]{i,j}, (Object)this.get(i, j));
				
			}
			
		}
		return res;
		
	}
	
}
