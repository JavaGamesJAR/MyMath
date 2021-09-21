package JGJAR.libraries.MyMath.calculus;

import JGJAR.libraries.MyMath.DoubleFunction;
import JGJAR.libraries.MyMath.Polynomial;

/**<h1>Derivative class</h1><br>
 * 
 * @author JavaGamesJAR
 * @since MyMath 2.0.0
 * @version 1.0
 */
public class Derivative 
{
	private Derivative()
	{}
	static double eps = 0.000001;
	
	/**Returns derivative of f with easy limit
	 * 
	 * @param f function derivative of you get
	 * @return f'(x)
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public static DoubleFunction easyDeriv(DoubleFunction f)
	{
		return new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return (f.execute(x+eps)-f.execute(x))/eps;
			}
		};
		
	}
	
	/**Returns derivative of f with limit, where O &Proportional; h<sup>2</sup>
	 * 
	 * @param f function derivative of you get
	 * @return f'(x)
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public static DoubleFunction sqrDerivative(DoubleFunction f)
	{
		return new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return (f.execute(x+eps)-f.execute(x-eps))/(2*eps);
			}
		};
		
	}
	/**Returns derivative using Taylor Series (derives the polynomial of f(x))
	 * 
	 * @param f function derivative of you get
	 * @return f'(x)
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public static DoubleFunction Taylor(DoubleFunction f, int n)
	{
		final Polynomial p = Polynomial.TaylorSeries(f, n);
		p.derivative();
		return new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return p.apply(x);
			}
		};
		
	}

}
