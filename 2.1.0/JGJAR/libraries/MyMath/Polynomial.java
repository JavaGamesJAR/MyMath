package JGJAR.libraries.MyMath;

import java.util.ArrayList;
import JGJAR.libraries.MyMath.calculus.*;

/**<h1>MyMath Polynomial</h1>
 * 
 * Class of Polynomials
 * @author JavaGamesJAR
 * @version 0.5
 * @since MyMath 1.8.0
 *
 */

public class Polynomial 
{
	private static ArrayList<Double> toArrayList(double[] a) 
	{
		ArrayList<Double> res = new ArrayList<Double>();
		for(int i = 0; i<a.length; i++)
			res.add(a[i]);
		return res;
		
	}
	private static double[] toArray(ArrayList<Double> a)
	{
		double[] res = new double[a.size()];
		for(int i = 0; i<a.size(); i++)
			res[i] = a.get(i);

		return res;
		
	}
	public Polynomial(double[] coef)
	{
		this.c = coef;
		this.coeffs = toArrayList(coef);
		
	}
	public Polynomial(ArrayList<Double> coef)
	{
		this.c = toArray(coef);
		this.coeffs = coef;
		
	}
	private ArrayList<Double> coeffs;
	private double[] c;
	
	/**Returns P(a)
	 * 
	 * @param a argument
	 * @return P(a)
	 * @since 0.5 (MyMath 1.8.0)
	 */
	public double apply(double a)
	{
		double res = 0;
		
		for(int i = 0; i<coeffs.size(); i++)
		{
			res+=coeffs.get(i)*MyMath.pow(a, i);
			
		}
		
		return res;
		
	}
	/**Takes the derivative of your Polynomial
	 * @since 0.5 (MyMath 1.8.0)
	 */
	public void derivative()
	{
		ArrayList<Double> a = new ArrayList<Double>();
		for(int i = 1; i<coeffs.size(); i++)
		{
			a.add(i-1, coeffs.get(i)*i);
			
		}
		this.coeffs = a;
		this.c = toArray(a);
		
	}
	/**Integrates your Polynomial adding C
	 * 
	 * @param C const
	 * @since 0.5 (MyMath 1.8.0)
	 */
	public void integrate(double C)
	{
		ArrayList<Double> a = new ArrayList<Double>();
		a.add(0, C);
		
		for(int i = 0; i<coeffs.size();i++)
		{
			a.add(i+1, coeffs.get(i)/(i+1));
			
		}
		this.coeffs = a;
		this.c = toArray(a);
		
	}
	/**Converts Polynomial to String
	 * @since 0.5 (MyMath 1.8.0)
	 */
	public String toString()
	{
		String res = "";

		for(int i = coeffs.size()-1; i>=0; i--)
		{
			if(i==0)
			{
				if(coeffs.get(i)==0)
				{
					
					
				}
				else
					res+=coeffs.get(i)+"+";
				
			}
			else
			{
				 if(i==1)
				 {
					 if(coeffs.get(i)==0)
					 {
						 
						 
					 }
					 else
					 {
						 if(coeffs.get(i)==1)
							{
								res+="x+";
								
							}
							else
							{
								res+=coeffs.get(i)+"x"+"+";
								
							}
						 
					 }
					
						
					 
				 }
				 else
				 {
					 if(coeffs.get(i)==0)
					 {
						 
						 
					 }
					 else
					 {
						 if(coeffs.get(i)==1)
							{
								res+="x^"+i+"+";
									
							}
							res+=coeffs.get(i)+"x^"+i+"+";
						 
					 }
					
						
				}
				
			}
			
			
			//System.out.println(coeffs.get(i)+"x^"+i+"+");
			
		}
		res = res.substring(0, res.length()-1);
		return res;
		
	}
	public static Polynomial TaylorSeries(DoubleFunction f, int n)
	{
		ArrayList<Double> c = new ArrayList<Double>();
		for(int i = 0; i<n; i++)
		{
			c.add(f.execute(0)/MyMath.fastFact(i));
			f = Derivative.sqrDerivative(f);
			
		}
		return new Polynomial(c);
		
	}
	public DoubleFunction toDoubleFunction()
	{
		final Polynomial p = this;
		return new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public double execute(double x) {
				// TODO Auto-generated method stub
				return p.apply(x);
			}
		};
		
	}
	public void integrate() {
		integrate(0);
		
	}

}
