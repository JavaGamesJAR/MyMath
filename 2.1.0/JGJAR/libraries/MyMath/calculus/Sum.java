package JGJAR.libraries.MyMath.calculus;

/**<h1>Sum class</h1><br>
 * 
 * @author JavaGamesJAR
 * @since MyMath 2.0.0
 * @version 1.0
 */

public class Sum 
{
	public Sum(Function2D f, int start, int end)
	{
		this.f = f;
		this.start = start;
		this.end = end;
		
	}
	Function2D f;
	int start, end;
	private static final double eps = 0.000001;
	
	/**Calculates the sum
	 * 
	 * @param x the first argument of function f(x, y)
	 * @return &sum;<sup>end</sup><sub>n=start</sub>f(x, n)
	 */
	public double apply(double x)
	{
		/*if(/*end==(int)Double.POSITIVE_INFINITY)
		{
			DoubleFunction doubf = new DoubleFunction() {
				
				@Override
				public double reversedFunction(double x) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public double execute(double y) {
					return f.apply(x, y);
				}
			};
			Limit lim = new Limit(doubf, Double.MAX_VALUE-eps, eps);
			if(lim.apply()>eps)
				return Double.POSITIVE_INFINITY;
			else
			{
				this.end = Integer.MAX_VALUE;
				return apply(x);
				
			}
			
		}
		else
		{*/
			double res = 0;
			for(int i = start; i<=end; i++)
			{
				res+=f.apply(x, i);
				
			}
			return res;
			
		//}
		
	}

}
