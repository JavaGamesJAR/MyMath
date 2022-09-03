package JGJAR.libraries.MyMath.calculus;

import JGJAR.libraries.MyMath.DoubleFunction;
import JGJAR.libraries.MyMath.MyMath;

/**<h1>Limit class</h1><br>
 * 
 * @author JavaGamesJAR
 * @since MyMath 2.0.0
 * @version 1.0
 */
public class Limit 
{
	public Limit(DoubleFunction f, double a, double dx)
	{
		this.f = f;
		this.a = a;
		this.dx = dx;
		
	}
	DoubleFunction f;
	double dx, a;
	
	/**Calculates the limit
	 * 
	 * @return lim x->a f(x)
	 */
	public double apply()
	{
		return (f.execute(a-dx)+f.execute(a+dx))/2.0;
		
	}

}
