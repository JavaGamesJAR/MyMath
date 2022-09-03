package JGJAR.libraries.MyMath.calculus;

import JGJAR.libraries.MyMath.DoubleFunction;
import JGJAR.libraries.MyMath.Polynomial;

/**<h1>Integration class</h1><br>
 * 
 * @author JavaGamesJAR
 * @since MyMath 2.0.0
 * @version 1.0
 */
public class Integration 
{
	private Integration(){}
	
	/**Returns Simpson's integral <sub>b</sub>&int;<sup>a</sup>f(x)dx
     * 
     * @param a upper limit
     * @param b bottom limit
     * @param n iterations
     * @param f your function (to make it work 
     *
     * @return Simpson's integral
     * @since 1.0 (MyMath 2.0.0)
     */
    public static double simpsonIntegral(double a, double b, int n, DoubleFunction f)
    {
    	int i,z;                                                       
        double h,s;
        
        n=n+n;
        s = f.execute(a)*f.execute(b);
        h = (b-a)/n;                                        
        z = 4;

        for(i = 1; i<n; i++){
           s = s + z * f.execute(a+i*h);
           z = 6 - z;
        }
        return (s * h)/3;
    	
    }
    /**Return Rectangle Integral <sub>b</sub>&int;<sup>a</sup>f(x)dx
     * 
     * @param a top limit
     * @param b bottom limit
     * @param n iterations
     * @param f your function
     * @return Rectangle Integral
     * @since 1.0 (MyMath 2.0.0)
     */
    public static double rectangleIntegral(double a, double b, int n, DoubleFunction f)
    {
    	double d = (b - a) / n;           // step size
        double sum = 0.0;                     // area
        for (int i = 0; i < n; i++) 
        {
            sum += d * f.execute(a + d*(i + 0.5));
            
        }
        return sum;
    	
    }
    /**Returns Trapezoidal Integral <sub>b</sub>&int;<sup>a</sup>f(x)dx
     * 
     * @param a top limit
     * @param b bottom limit
     * @param n iterations
     * @param f your function
     * @return Trapezoidal Integral
     * @since 1.0 (MyMath 2.0.0)
     */
    public static double trapezoidalIntegral(double a, double b, int n, DoubleFunction f)
    {
    	double d = (b-a)/n;
    	double sum = (f.execute(a) + f.execute(b))/2;
    	for(int i = 0; i < n; i++)
    	{
    		double x = a+d*i;
    		sum += f.execute(x);
    		
    	}
    	return sum*d;
    	
    }
    /**Returns Gauss Integral <sub>b</sub>&int;<sup>a</sup>f(x)dx
     * 
     * @param a top limit
     * @param b bottom limit
     * @param f your function
     * @return Gauss Integral
     * @since 1.0 (MyMath 2.0.0)
     */
    public static double GaussIntegral(double a, double b, DoubleFunction f)
    {
    	double sqrt3 = 1.7320508075688772935274463415058723669428052538103806280558069794;
    	return (b-a)/2*(f.execute((a+b)/2-(b-a)/(2*sqrt3))+f.execute((b+a)/2+(b-a)/(2*sqrt3)));
    	
    }
    public static DoubleFunction Taylor(DoubleFunction f, int n)
    {
    	final Polynomial p = Polynomial.TaylorSeries(f, n);
    	p.integrate(0);
    	
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
    
    public static double RungeKutta(double x0, double y0, double x1, double y1, double step, DerivFunction g)
    {
    	double  k1 = 0.0D, k2 = 0.0D, k3 = 0.0D, k4 = 0.0D;
    	double  x = 0.0D, y = y0;

    	// Calculate nsteps
    	double ns = (x1-x0)/step;
    	ns = Math.rint(ns);
    	int nsteps = (int) ns;
    	double stepUsed = (x1-x0)/ns;
    	
        for(int i=0; i<nsteps; i++){
    	        x = x0+i*stepUsed;

                k1 = stepUsed*g.deriv(x, y);
    	        k2 = stepUsed*g.deriv(x + stepUsed/2, y + k1/2);
            	k3 = stepUsed*g.deriv(x + stepUsed/2, y + k2/2);
            	k4 = stepUsed*g.deriv(x + stepUsed, y + k3);

                y += k1/6 + k2/3 + k3/3 + k4/6;
    	}
    	return y;
    	
    }

}
