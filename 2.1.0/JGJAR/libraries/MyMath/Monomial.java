package JGJAR.libraries.MyMath;

/**<h1>MyMath Monomial</h1>
 * 
 * Class of Monomials
 * @author JavaGamesJAR
 * @version 0.5
 * @since MyMath 1.8.0
 *
 */
public class Monomial 
{
	public Monomial(double a, double b)
	{
		this.a = a;
		this.b = b;
		
	}
	double a,b;
	
	/**
	 * Returns Monomial of argument x
	 * @param x
	 * @return double
	 * @since 0.5 (MyMath 1.8.0)
	 */
	public double apply(double x)
	{
		return a*MyMath.pow(x, b);
		
	}
	/**Takes the derivative of your monomial
	 * @since 0.5 (MyMath 1.8.0)
	 */
	public void derivative()
	{
		this.a*=b;
		this.b-=1;
		
	}
	/**Integrates your monomial with constant C
	 * 
	 * !C will apply ONLY if your monomial is zero!
	 * 
	 * @param C const
	 * @since 0.5 (MyMath 1.8.0)
	 */
	public void integrate(double C)
	{
		if(a==0.0)
		{
			this.a = C;
			this.b = 0.0;
			
		}
		else
		{
			this.a/=(b+1);
			this.b+=1;
			
		}
		
	}
	/**Integrates your monomial
	 * @since 0.5 (MyMath 1.8.0)
	 */
	public void integrate()
	{
		integrate(0.0);
		
	}
	/**Converts monomial to String
	 * @since 0.5 (MyMath 1.8.0)
	 */
	public String toString()
	{
		String res ="";
		if(b==0.0)
		{
			res = a+"";
			
		}
		else if(b==1)
		{
			if(a==1)
			{
				res = "x";
				
			}
			else
				res = a+"x";
			
		}
		else
		{
			if(a==1)
			{
				res = "x^"+b;
				
			}
			else
				res = a+"x^"+b;
			
		}
		return res;
		
	}

}
