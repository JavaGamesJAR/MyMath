package JGJAR.libraries.MyMath;

/**<h1>MyMath Matrix</h1>
 * 
 * @author JavaGamesJAR
 * @since 1.9.0
 * @version 0.5
 *
 */
public class Matrix 
{
	/**Constructor
	 * 
	 * @param c coefficients of matrix
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public Matrix(double[][] c)
	{
		this.c = c;
		this.l = c.length;
		this.h = c[0].length;
	}
	private double[][] c;
	public int l, h;
	
	/**Returns coefficient in i & j position
	 * 
	 * @param i x coordinate of coefficient
	 * @param j y coordinate of coefficient
	 * @return M(i, j)
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public double get(int i, int j)
	{
		return c[i][j];
		
	}
	/**Returns square matrix with det(A)=1
	 * 
	 * @param n size of matrix
	 * @return I(n)
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static Matrix UnitMatrix(int n)
	{
		double[][] c = new double[n][n];
		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<n; j++)
			{
				if(i==j)
				{
					c[i][j]=1;
					
				}
				else c[i][j]=0;
				
			}
			
		}
		return new Matrix(c);
		
	}
	/**Returns square matrix with all coeffs = 0
	 * 
	 * @param n size of matrix
	 * @return Z(n)
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static Matrix ZeroMatrix(int n)
	{
		double[][] c = new double[n][n];
		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<n; j++)
			{
				c[i][j]=0;
				
			}
			
		}
		return new Matrix(c);
		
	}
	/**Deletes line and column in Matrix A
	 * 
	 * @param a line number
	 * @param b column number
	 * @param A Matrix
	 * @return A without a-th line and b-th column <br> <h1>STARTING FROM 0!!!</h1>
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static Matrix deleteLineAndColumn(int a, int b, Matrix A)
	{
		double c[][] = new double[A.c.length-1][A.c[0].length-1];
		
		for(int i = 0; i<A.c.length-1; i++)
		{
			for(int j = 0; j<A.c[0].length-1; j++)
			{
				int d=0, e=0;
				if(i<a)
				{
					d = i;
					
				}
				else if(i>=a)
				{
					d = i+1;
					
				}
				if(j<b)
				{
					e = j;
					
				}
				else if(j>=b)
				{
					e = j+1;
					
				}
				c[i][j] = A.get(d, e);
				
			}
			
		}
		return new Matrix(c);
		
		
	}
	/**Adds two matrices
	 * 
	 * @param a first matrix
	 * @param b second matrix
	 * @return a+b
	 * @since 0.5 (MyMath 1.9.0)
	 * @throws MatricesAreNotSameSizeException if a.h&ne;b.h or a.l&ne;b.l
	 */
	public static Matrix add(Matrix a, Matrix b)
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
			double[][] c = a.c;
			for(int i = 0; i<b.l; i++)
			{
				for(int j = 0; j<b.h; j++)
				{
					c[i][j]+=b.c[i][j];
					
				}
				
			}
			return new Matrix(c);
			
		}
		
	}
	/**Subtracts two matrices
	 * 
	 * @param a first matrix
	 * @param b second matrix
	 * @return a-b
	 * @since 0.5 (MyMath 1.9.0)
	 * @throws MatricesAreNotSameSizeException if a.h&ne;b.h or a.l&ne;b.l
	 */
	public static Matrix subtract(Matrix a, Matrix b)
	{
		return Matrix.add(a, multiply(b, -1.0));
		
	}
	/**Multiplies matrix and scalar
	 * 
	 * @param a matrix
	 * @param b scalar
	 * @return a*b
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public static Matrix multiply(Matrix a, double b)
	{
		double[][] c = a.c;
		
		for(int i = 0; i<c.length; i++)
		{
			for(int j = 0; j<c[0].length; j++)
			{
				c[i][j]*=b;
				
			}
			
		}
		return new Matrix(c);
		
	}
	/**Returns determinant of matrix
	 * 
	 * @param A Matrix
	 * @return det(A)
	 * @since 0.5 (MyMath 1.9.0)
	 * @throws MatrixIsNotSquareException if A.h&ne;A.l
	 */
	public static double det(Matrix A)
	{
		if(A.h!=A.l)
		{
			try {
				throw new MatrixIsNotSquareException();
			} catch (MatrixIsNotSquareException e) {
			}return 0.0;
			
		}
		else if(A.h==1)
			return A.get(0, 0);
		else if(A.h==2)
		{
			return A.get(0, 0)*A.get(1, 1)-A.get(1,0)*A.get(0, 1);
			
		}
		else
		{
			double res = 0.0;
			for(int i = 0; i<A.h; i++)
			{
				res+=Math.pow(-1, i)*A.get(0, i)*Matrix.det(deleteLineAndColumn(0, i, A));
				
			}
			return res;
			
		}
		
	}
	/**Returns adj(A)
	 * 
	 * @param A Matrix
	 * @return adj(A)
	 * @since 0.5 (MyMath 1.9.0)
	 * @throws MatrixIsNotSquareException if A.h&ne;A.l
	 */
	public static Matrix adj(Matrix A)
	{
		double c[][] = new double[A.l][A.h];
		
		for(int i = 0; i<A.l; i++)
		{
			for(int j = 0; j<A.h; j++)
			{
				double a = Math.pow(-1, i+j)*Matrix.det(deleteLineAndColumn(i, j, A));
				c[i][j] = a;
				
			}
			
		}
		return new Matrix(c);
		
	}
	/**Multiplies two matrices
	 * 
	 * @param a first Matrix
	 * @param b second Matrix
	 * @return a*b
	 * @since 0.5 (MyMath 1.9.0)
	 * @throws MatricesAreNotSameSizeException if a.h&ne;b.l or a.l&ne;b.h
	 */
	public static Matrix multiply(Matrix a, Matrix b)
	{
		if(a.h!=b.l && b.h!=a.l)
		{
			try {
				throw new MatricesAreNotSameSizeException();
			} catch (MatricesAreNotSameSizeException e) {}
			return null;
			
		}
		else if(a.h==b.l)
		{
			double c[][] = new double[a.h][b.l];
			
			for(int i = 0; i<a.h; i++)
			{
				for(int j = 0; j<b.l; j++)
				{
					c[i][j]=0;
					
				}
				
			}
			
			for(int i = 0; i<a.h; i++)
			{
				for(int j = 0; j<b.l; j++)
				{
					for(int k = 0; k<a.l; k++)
					{
						c[i][j]+=a.get(i, k)*b.get(k, j);
						
					}
					
				}
				
			}
			return new Matrix(c);
			
		}
		else
		{
			double c[][] = new double[a.l][b.h];
			
			for(int i = 0; i<a.l; i++)
			{
				for(int j = 0; j<b.h; j++)
				{
					c[i][j]=0;
					
				}
				
			}
			
			for(int i = 0; i<a.l; i++)
			{
				for(int j = 0; j<b.h; j++)
				{
					for(int k = 0; k<a.h; k++)
					{
						c[i][j]+=a.get(i, k)*b.get(k, j);
						
					}
					
				}
				
			}
			return new Matrix(c);
			
		}
		
	}
	/**Converts Matrix to String
	 * @since 0.5 (MyMath 1.9.0)
	 */
	public String toString()
	{
		String res = "";
		
		for(int i = 0; i<this.l; i++)
		{
			res+="[";
			for(int j = 0; j<this.h; j++)
			{
				res+=" "+this.get(i, j)+" ";
				
			}
			res+="]\n";
			
		}
		
		return res;
		
	}

}
