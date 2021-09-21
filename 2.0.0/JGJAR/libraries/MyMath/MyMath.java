package JGJAR.libraries.MyMath;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

import javax.sound.sampled.*;

import JGJAR.libraries.MyMath.calculus.Integration;
import JGJAR.libraries.MyMath.complex.Complex;
import JGJAR.libraries.MyMath.exceptions.DivideByZeroException;
import JGJAR.libraries.MyMath.exceptions.ReturnsComplexException;
import JGJAR.libraries.MyMath.fraction.Fraction;

/**<h1 class="title">MyMath library</h1>
 * 
 * @author JavaGamesJAR, website: <a href="http://fedorx.ru/index.php?id=0">fedorx.ru</a>
 * 
 * <p>Library with lots of methods for easier programming!</p>
 * 
 * @version 2.0.0
 * @see Fraction
 * @see neededMethods
 * @see Complex
 */
public class MyMath
{
	public static void credit()
	{
    	System.out.println("This program is using MyMath library by ©JavaGamesJAR"+
    			" (http://fedorx.ru and https://github.com/JavaGamesJAR) this library is protected by MIT License"+
    			"\nMyMath 2.0.0\nFraction 1.0\nComplex 1.2\n\n");
		
	}
	static
	{
		credit();
		calculatePrimes(100);
		
	}
	/**Returns f+s
	 * @since 0.5
	 * */
    public static double plus(double f, double s)
    {
    	return f+s;
    	
    }
    /**Returns f-s
     * @since 0.5
     * */
    public static double minus(double f, double s)
    {
    	return f-s;
    	
    }
    /**Returns f*s
     * @since 0.5
     * */
    public static double times(double f, double s)
    {
    	return f*s;
    	
    }
    /**Returns f/s, if both are 0 or infinity (positive or negative) returns random from min_value to max_value
     * @param f numinator
     * @param s divisor
     * @since 0.5
     * @throws DivideByZeroException if s=0 and f&NotEqual;0 
     * */
    public static double div(double f, double s)
    {
    	double result = 0;
    	
    	if(f==0 && s == 0)
    	{
    		result=random(min_value, max_value);
    		
    	}
    	else if(f!=0 && s==0)
    	{
    		try {
				throw new DivideByZeroException("Divisor equals to 0");
			} catch (DivideByZeroException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	else if(f==Double.POSITIVE_INFINITY && s==Double.POSITIVE_INFINITY)
    	{
    		result = 1.0/*random(min_value, max_value)*/;
    		
    	}
    	else if(f==Double.POSITIVE_INFINITY && s==Double.NEGATIVE_INFINITY)
    	{
    		result = -1.0/*random(min_value, max_value)*/;
    		
    	}
    	else if(f==Double.NEGATIVE_INFINITY && s==Double.POSITIVE_INFINITY)
    	{
    		result = -1.0/*random(min_value, max_value)*/;
    		
    	}
    	else if(f==Double.NEGATIVE_INFINITY && s==Double.NEGATIVE_INFINITY)
    	{
    		result = 1.0/*random(min_value, max_value)*/;
    		
    	}
    	else result = f/s;
    	
    	return result;
    	
    }
    
    /**Returns root of n power of num <sup>n</sup>&#8730;x
     * 
     * @param num - the number root of which you get
     * 
     * @param n - the power of the root
     * 
     * @return root of n power of num
     * @throws ReturnsComplexException if n is even and num is negative
     * @since 0.5
     * */
    public static double root(double num, double n)
    {
    	if(n==2.0)
    	{
    		return sqrt(num);
    		
    	}
    	else if(n==3.0)
    	{
    		return cbrt(num);
    		
    	}
    	if(isInteger(n) && isEven((int)n) && num<0.0)
    	{
    		try 
    		{
				throw new ReturnsComplexException("n is even so num MUST be positive number or 0", 
						new Throwable("n is even so num MUST be postitive number or 0"));
				
			} 
    		catch (ReturnsComplexException e) 
    		{
				e.printStackTrace();
				System.exit(1);
				
			}
    		
    	}
    	//double result = pow(num, 1/n);
    	double result = 0;
    	double x0 = (2*num)/n;
    	DoubleFunction f = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return pow(x, n)-num;
			}
		};
		DoubleFunction df = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return n*pow(x, n-1.0);
			}
		};
		
		result = NewtonNull(x0, f, df);
    	
    	
    	return result;
    	
    }
    private static int[] sectorbp(double x)
    {
    	String str = x+"";
    	int numbersbp = str.indexOf(".");
    	int[] res = new int[numbersbp];
    	for(int i=0;i<numbersbp/2;i++)
    	{
    		if(isOdd(numbersbp))
    		{
    			if(i==0)
    			{
    				res[i]=Integer.parseInt(str.substring(0, 1));
    				
    			}
    			else
    			{
    				res[i]=Integer.parseInt(str.substring(i+1, i+3));
    				
    			}
    			
    		}
    		else
    		{
    			res[i]=Integer.parseInt(str.substring(i, i+2));
    			
    		}
    		
    	}
    	return res;
    	
    }
    private static int[] sectorap(double x)
    {
    	String str = x+"";
    	int[] sbp = sectorbp(x);
    	int numberap = str.length()-1-sbp.length;
    	int[] res = new int[numberap];
    	for(int i=0;i<numberap/2;i++)
    	{
    		if(isOdd(numberap))
    		{
    			if(i==0)
    			{
    				res[i]=Integer.parseInt(str.substring(0, 1));
    				
    			}
    			else
    			{
    				res[i]=Integer.parseInt(str.substring(i+1, i+3));
    				
    			}
    			
    		}
    		else
    		{
    			res[i]=Integer.parseInt(str.substring(i, i+2));
    			
    		}
    		
    	}
    	return res;
    	
    }
    /**Returns square root calculated with tower
     * 
     * @param x number square root of you get
     * @since 1.7.0
     * @return square root of x &#8730;x
     * @throws ReturnsComplexException if x is negative
     */
    protected static double sqrtTower(int x)
    {
    	if(x<0)
    	{
    		try 
    		{
				throw new ReturnsComplexException("n is even so num MUST be positive number or 0", 
						new Throwable("n is even so num MUST be postitive number or 0"));
				
			} 
    		catch (ReturnsComplexException e) 
    		{
				e.printStackTrace();
				System.exit(1);
				
			}
    		
    	}
    	else
    	{
    		//for perfect squares
    		for(int i=0;i<x;i++)
    		{
    			if(i*i==x)
    			{
    				return i;
    				
    			}
    			
    		}
    		/*System.out.println("Init");
    		String str = x+"";
    		int befpoint = str.indexOf(".");
    		int afterpoint = str.length()-1-befpoint;
    		double bp = befpoint;
    		double ap = afterpoint;
    		int nbp = Integer.parseInt(str.substring(0, befpoint+2));
    		int nap = Integer.parseInt(str.substring(befpoint+1));
    		String sbp = nbp+"";
    		String sap = nap+"";
    		int[] sectors = new int[MyMath.ceil(bp/ap)];
    		System.out.println("Filling sector");*/
    		int[] secbp = sectorbp(x);
    		int[] secap = sectorap(x);
    		int beforep = secbp.length;
    		int afterp = secap.length;
    		int[] sectors = new int[beforep+afterp];
    		//Filling sector
    		/*for(int i=0;i<befpoint-1;i++)
    		{
    			if(isOdd(befpoint))
    			{
    				System.out.println("Itteration #"+i);
    				if(i==0)
    				{
    					sectors[i]=Integer.parseInt(sbp.substring(0, 1));
    					
    				}
    				else
    				{
    					if(i+3<sbp.length())
    					{
    						System.out.println("i+3<digits before point");
    						sectors[i]=Integer.parseInt(sbp.substring(i+1, i+3));
    						
    					}
    					else sectors[i]=Integer.parseInt(sbp.substring(i+1));
    					
    				}
    				
    			}
    			else sectors[i]=Integer.parseInt(sbp.substring(i, i+2));
    			
    		}*/
    		/*for(int i=0;i<afterpoint;i++)
    		{
    			if(isOdd(befpoint))
    			{
    				if(befpoint+i+3<sap.length())
    				{
    					sectors[i+befpoint] = Integer.parseInt(sap.substring(befpoint+i+1, befpoint+i+3));
    					
    				}
    				else sectors[i+befpoint] = Integer.parseInt(sap.substring(befpoint-2));
    				
    				
    			}
    			else sectors[i+befpoint] = Integer.parseInt(sap.substring(befpoint+i, befpoint+i+2));
    			
    		}*/
    		int notfullrt = 0;
    		for(int i = 0; i<9;i++)
    		{
    			notfullrt = i;
    			System.out.println("Not full rt = "+notfullrt);
    			if(i*i>sectors[0])
    			{
    				System.out.println("Not full rt = "+(i-1));
    				notfullrt--;
    				break;
    				
    			}
    			//For perfect squares
    			else if(i*i==x) return i;
    			
    		}
    		String result = notfullrt+"";
    		int dif = sectors[0]-(notfullrt*notfullrt);
    		for(int i=0;i<beforep/2;i++)
    		{
    			//Left part
    			int r2 = MyMath.neededMethods.fractionUp(Double.parseDouble(result))*2*10;
    			int lnum;
    			for(int j=0;j<9;j++)
    			{
    				lnum = j;
    				r2+=j;
    				if(r2*j>sectors[i])
    				{
    					r2--;
    					lnum--;
    					break;
    					
    				}
    				r2-=j;
    				
    			}
    			dif*=100;
    			dif+=sectors[i];
    			dif-=r2*r2;
    			
    			
    		}
    		result+=".0";
    		return Double.parseDouble(result);
    		
    	}
    	return NaN;
    	
    }
    /**Returns square root of x
     * 
     * @param x
     * @return &#8730;x
     * @since 0.9.9.25
     * @throws ReturnsComplexException if x is negative
     */
    public static double sqrt(double a)
    {
    	if(a<0)
    	{
    		try 
    		{
				throw new ReturnsComplexException("a is negative", new Throwable("a is negative"));
				
			} 
    		catch (ReturnsComplexException e) 
    		{
				e.printStackTrace();
				System.exit(1);
				
			}
    		
    	}
    	double x0 = (2.0*a)/2.0;
    	DoubleFunction f = new DoubleFunction() 
    	{
			@Override
			public double reversedFunction(double x) {return 0;}
			@Override
			public double execute(double x) {
				return x*x-a;
			}
		};
		DoubleFunction df = new DoubleFunction() {
				
			@Override
			public double reversedFunction(double x) {return 0;}
			@Override
			public double execute(double x) {
				return 2*x;
			}
		};
    	return abs(NewtonNull(x0, f, df));
    	
    }
    /**Returns cube root of x
     * 
     * @param x
     * @return 	&#8731;x
     * @since 0.9.9.25
     */
    public static double cbrt(double x)
    {
    	double x0 = (2.0*x)/3.0;
    	DoubleFunction f = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				
				return 0;
			}
			
			@Override
			public double execute(double a) {
				return a*a*a-x;
			}
		};
		DoubleFunction df = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				return 0;
			}
			
			@Override
			public double execute(double a) 
			{
				return 3*a*a;
				
			}
		};
		return NewtonNull(x0, f, df);
    	
    }
    /**Returns base^power
     * 
     * @param base - base of power
     * 
     * @param power - power
     * 
     * @return base^power
     * @throws ReturnsComplexException if 1/power is Even and base is negative
     * @since 0.5
     * */
    public static double pow(double base, double power)
    {
    	if(isInteger(1.0/power) && base<0.0 && isEven((int) (1.0/power)))
    	{
    		try {
				throw new ReturnsComplexException("1/power is even but base is negative", 
						new Throwable("1/power is even but base is negative"));
			} catch (ReturnsComplexException e) {
				
				e.printStackTrace();
			}
    		
    	}
    	double result = 0;
    	
    	if(power==0)
    	{
    		return 1;
    		
    	}
    	else if(power==NEGATIVE_INFINITY)
    	{
    		return 0;
    		
    	}
    	else if(power==1)
    	{
    		return base;
    		
    	}
    	else if(power>0 && isInteger(power))//round(power, 0) == power)//round(power, 0) == power
    	{
            result = base;
    		
    		for(int i=0; i<power--; i++)
    		{
    			result *= base;
    			
    		}
    		
    	}
    	else if(power<0)
    		return 1/pow(base, -power);
    	else if(power>0 && !isInteger(power))
    	{
    		Fraction pq = new Fraction(power);
    		int p = pq.num;
    		int q = pq.den;
    		
    		result=pow(root(base, q),p);
    		
    	}
    	return result;
    	/*double res = exp(power*ln(base));
    	if(isInteger(power) && isInteger(base))
    	{
    		res = round(res);
    		
    	}
    	return res;*/
    	
    }
    
    /**Returns tetration function <sup>n</sup>a or a&uarr;&uarr;n
     * 
     * @param base <sup>n</sup>base
     * @param n <sup>n</sup>a
     * @return tetration
     * @since 1.6.0
     */
    public static double tetration(double base, double n)
    {
    	if(n==0.0)
    	{
    		return 1.0;
    		
    	}
    	else if(isNatur(n))
    	{
    		double result = base;
        	for(int i = 1; i<n; i++)
        	{
        		result = Math.pow(base, result);
        		
        	}
        	return result;
    		
    	}
    	else if(n>0.0 && base>0.0)
    	{
    		
    		double res = n*ln(base);
    		res = Math.exp(res);
    		res = ln(res);
    		res = base*res;
    		res = exp(res);
    		return round(res, 7);
    	}
    	else
    	{
    		Complex r = Complex.ZERO;
    		Complex a = new Complex(base,0.0);
    		Complex b = new Complex(n,0.0);
    		r = Complex.multiply(Complex.subtract(b, Complex.ONE), Complex.ln(a));
    		r = Complex.exp(r);
    		r = Complex.ln(r);
    		r = Complex.multiply(r, a);
    		r = Complex.exp(r);
    		return r.doubleValue();
    		
    	}
    	
    	
    }
    /**Returns super-root of a and n
     * 
     * @param a <sup>n</sup>x=a
     * @param n <sup>n</sup>x=a
     * @return super-root
     * @since 1.6.0
     * @see tetration
     */
    public static double superroot(double a, double n)
    {
    	//double res = 0;
    	DoubleFunction f = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return tetration(x, n)-a;
			}
		};
		return NewtonNull(a/n, f);
    	
    }
    /**Returns square super-root of a and n
     * 
     * @param a <sup>n</sup>x=a
     * @param n <sup>n</sup>x=a
     * @return square super-root
     * @since 1.6.0
     * @see tetration
     * @see superroot
     */

    public static double ssrt(double a)
    {
    	return exp(LambertW(ln(a)));
    	
    }
    /**Returns cubic super-root of a
     * 
     * @param a number cubic super-root of you get
     * @return a&darr;&darr;3
     * @since 1.8.0
     * @see tetration
     * @see superroot
     */
    public static double csrt(double a)
    {
    	return superroot(a, 3.0);
    	
    }
    /**Returns super-logaritm in the base of a of b slog<sub>a<sub>b
     * 
     * @param a basement of super-logarithm
     * @param b slog<sub>a<sub>b
     * @return slog<sub>a<sub>b
     * @since 1.8.0
     * @see tetration
     * @see superroot
     */
    public static double superlog(double a, double b)
    {
    	if(tetration(a, ilog(b))==b)
    	{
    		return ilog(b);
    		
    	}
    	else
    	{
    		DoubleFunction f = new DoubleFunction() {
    			
    			@Override
    			public double reversedFunction(double x) {
    				return 0;
    			}
    			
    			@Override
    			public double execute(double x) {
    				return tetration(a, x)-b;
    			}
    		};
    		return round(NewtonNull(a, f), 11);
    		
    	}
    	
    }
    /**Returns iterative logaritm of n <br>
     * <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/06c83f2fc65294b18978bb05427ff02b3419f78b"></img>
     * <ul>
     * <li>if n is NaN returns NaN</li>
     * <li>if n is +&infin; returns +&infin;</li>
     * <li>if n is -&infin; returns -&infin;</li>
     * </ul>
     * @param n log*(n)
     * @return log*(n)
     * @since 1.8.0
     * @see ln
     * @see log
     * @see superlog
     * @see pow
     * @see root
     */
    public static double ilog(double n)
    {
    	if(n==NaN)
    	{
    		return NaN;
    		
    	}
    	else if(n==POSITIVE_INFINITY)
    	{
    		return POSITIVE_INFINITY;
    		
    	}
    	else if(n==NEGATIVE_INFINITY)
    	{
    		return NEGATIVE_INFINITY;
    		
    	}
    	if(n<=1)
    	{
    		return 1.0;
    		
    	}
    	else
    	{
    		return 1.0+ilog(ln(n));
    		
    	}
    	
    }
    /**Returns Lambert W-function (w(z))
     * 
     * w(z) is inversed function to xe<sup>x</sup>
     * 
     * @param z w(z)
     * @return Lambert W-function
     * @since 1.6.0
     * @see arcgd
     */
    public static double LambertW(double z)
    {
    	DoubleFunction f = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				
				return 0;
			}
			
			@Override
			public double execute(double x) {

				return x*exp(x)-z;
			}
		};
		DoubleFunction df = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				
				return 0;
			}
			
			@Override
			public double execute(double x) {

				return x*exp(x)+exp(x);
			}
		};
		return NewtonNull(z/e, f, df);
    	
    }
    /**Returns Weierstraß function
     * 
     * @param n w(n)
     * @return Weierstraß function
     * @since 1.6.0
     * @see Weierstraß
     */
    public static double Weierstrass(double n)
    {
    	int a = /*MyMath.createOdd()*/1845987571;
    	double b = /*MyMath.random(0.01, 1.0)*//*0.22491248821698417*/0.5;
    	double result = sum(1000, 0, new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				return NaN;
			}
			
			@Override
			public double execute(double x) {
				return pow(b, x)*cos(pow(a, x)*pi*n, false);
			}
		});
    	return result;
    	
    }
    
    /**Returns Weierstraß function
     * 
     * @param n w(n)
     * @param a odd number &ne;1
     * @param b 0&lt;b&lt;1
     * @return Weierstraß function
     * @since 1.6.0
     * @see Weierstraß
     */
    public static double Weierstrass(double n, int a, double b)
    {
    		double result = sum(1000, 0, new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				return NaN;
			}
			
			@Override
			public double execute(double x) {
				return pow(b, x)*cos(pow(a, x)*pi*n, false);
			}
		});
    	return result;
    	
    }
    
    /**Returns Weierstraß function
     * 
     * @param n w(n)
     * @param a odd number &ne;1
     * @param b 0&lt;b&lt;1
     * @return Weierstraß function
     * @since 1.6.0
     * @see Weierstraß
     */
    public static double Weierstraß(double n, int a, double b)
    {
    	return Weierstrass(n, a, b);
    	
    }
    
    /**Returns Weierstraß function
     * 
     * @param n w(n)
     * @return Weierstraß function
     * @since 1.6.0
     * @see Weierstrass
     */
    public static double Weierstraß(double n)
    {
    	return Weierstrass(n);
    	
    }
    
    /**Returns logarithm of f
     * 
     * @param f number logarithm of which you get
     * @return logarithm of f
     * 
     * @since 0.5
     */
    public static double log(double f)
    {
    	return ln(f);
    	
    }
    /**Returns natural logariphm of num
     * 
     * @param num - number logariphm of which you get
     * @return natural logariphm of num
     * @since 0.9.9
     * @throws ReturnsComplexException if num is negative
     */
    public static double ln(double num)
	{
    	if(num==1) return 0;
    	else if(num==e) return 1;
    	else if(num==0) return NEGATIVE_INFINITY;
    	else if(num<0)
    	{
    		try {
				throw new ReturnsComplexException("num MUSTN'T be negative", 
						new Throwable("num MUSTN'T be negative"));
			} catch (ReturnsComplexException e) {
				
				e.printStackTrace();
			}
    		
    	}
    	
    	double eps = 0.00001;
    	
    	double x0 = (num-1.0)/(num+1.0);
    	while(abs(exp(x0)-num)>eps)
    	{
    		double x1 = x0 + 2*((num-exp(x0))/(num+exp(x0)));
    		x0 = x1;
    		
    	}
    	return x0;
		
	}
    // <p><sub>0</sub>&int;<sup>x</sup><table><tr><td>dx</td></tr><tr style="border-top:5px;"><td>ln x</td></tr></table></p>
    /**Returns Sine Integral (&int;<sub>0</sub><sup>x</sup>sin(t)/t dt)
     * 
     * @param t argument
     * @return Si(t)
     * @since 1.9.0
     */
    public static double Si(double t)
    {
    	return Integration.GaussIntegral(0, t, new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return sin(x, false)/x;
			}
		});
    	
    }
    /**Returns Sine Integral (&int;<sub>0</sub><sup>x</sup>sin(t)/t dt)
     * 
     * @param t argument
     * @return si(t)
     * @since 1.9.0
     */
    public static double si(double t)
    {
    	return Si(t)-pi/2.0;
    	
    }
    /**Returns Cosine Integral (&int;<sub>0</sub><sup>x</sup>cos(t)/t dt)
     * 
     * @param t argument
     * @return Ci(t)
     * @since 1.9.0
     */
    public static double Ci(double t)
    {
    	return Integration.GaussIntegral(0, t, new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return cos(x, false)/x;
			}
		});
    	
    }
    /**Returns Cosine Integral (&int;<sub>0</sub><sup>x</sup>cos(t)/t dt)
     * 
     * @param t argument
     * @return ci(t)
     * @since 1.9.0
     */
    public static double ci(double t)
    {
    	return Ci(t)-pi/2.0;
    	
    }
    /**Returns integral logarithm 
     * 
     * <style>table tr:nth-child(1){border-bottom:5px;} table tr:nth-child(2){border-top:5px;} p{ white-space:nowrap;}</style>
     * 
     * @param x number logarithm of you get
     * @return <sub>0</sub>&int;<sup>x</sup>dx/ln(x)
     * @see Li
     * @since 1.5.0
     */
    public static double li(double t)
    {
    	return Integration.GaussIntegral(0, t, new DoubleFunction() {
			
			@Override
			public double execute(double x) {
				return 1/MyMath.ln(x);
				
			}

			@Override
			public double reversedFunction(double x) {return 0.0;}
		});
    	
    }
    /**Returns integral logarithm
     * 
     * @param x number logarithm of you get
     * @return <sub>2</sub>&int;<sup>x</sup>dx/ln(x)
     * @see li
     * @since 1.2.0
     */
    public static double Li(double t)
    {
    	return Integration.GaussIntegral(2, t, new DoubleFunction() {
			
			@Override
			public double execute(double x) {
				return 1/MyMath.ln(x);
				
			}

			@Override
			public double reversedFunction(double x) {return 0;}
		});
    	
    }
    /**Returns logariphm on base 10 of x
     * 
     * @param x number logariphm of which you get
     * x must be in format like 10^n, where n is NATURAL number or number negative to natural
     * 
     * @return logariphm on base 10 of x
     * @since 0.9.9.5
     * @throws ReturnsComplexException if x is negative
     */
    public static double lg10(double x)
    {
    	if(x<0)
    	{
    		try {
				throw new ReturnsComplexException("x is negative", 
						new Throwable("x is negative"));
			} catch (ReturnsComplexException e) {
				
				e.printStackTrace();
			}
    		
    	}
    	double result = 0;
    	int zeros = 0;
    	double resx = x;
    	
    	if(x==1)
    	{
    		result=0;
    		
    	}
    	else if(x==round(x,0))
    	{
    		while(resx!=1)
    		{
    			zeros++;
    			resx=resx/10;
    			
    		}
    		
    		result=zeros;
    		
    	}
    	else if(x!=round(x,0) && x<1)
    	{
    		while(resx!=1)
    		{
    			zeros++;
    			resx*=10;
    			
    		}
    		
    		result=zeros;
    		
    	}
    	
    	return result;
    	
    }
    /**Returns binary logarithm of a (lb(a)=log<sub>2</sub>a)
     * 
     * @param a number binary logarithm of you get
     * @return lb(a)
     * @since 1.7.0
     */
    public static double lb(double a)
    {
    	if(a==2) return 1;
    	else if(a==1) return 0;
    	else if(a==0) return NEGATIVE_INFINITY;
    	else if(a<0)
    	{
    		try {
				throw new ReturnsComplexException("argument is negative", 
						new Throwable("argument is negative"));
			} catch (ReturnsComplexException e) {
				
				e.printStackTrace();
			}
    		
    	}
    	return ln(a)/neededMethods.ln2;
    	
    }
    /**Returns power and base^power=result
     * 
     * @param base the base of the power
     * @param result result of base^power
     * 
     * @return logariphm of result/logariphm of base <br>
     * <code>power = MyMath.ln(result)/MyMath.ln(base)</code>
     * 
     * @throws ReturnsComplexException if result is negative
     * 
     * @since 0.5
     */
    public static double log(double base, double result)
    {
    	return ln(result)/ln(base);
    	
    }
    /**Returns cologarithm of x of base of a (coln x=ln 1/x)
     * 
     * @param x number cologaritm of you get
     * @return coln x
     * @since 1.7.0
     */
    public static double coln(double x)
    {
    	return ln(1.0/x);
    	
    }
    /**Returns cologarithm of x of base of a (colog<sub>a</sub>x=log<sub>a</sub>1/x)
     * 
     * @param a base of cologaritm
     * @param x number cologaritm of you get
     * @return colog<sub>a</sub>x
     * @since 1.7.0
     */
    public static double colog(double a, double x)
    {
    	return ln(a)/ln(reverse(x));
    	
    }
    /**Returns factorial of number (!number)
     * 
     * @param number - number factorial of you get
     * @return factorial of number
     * 
     * @since 0.5
     */
    public static double fact(double number)
    {
    	double result = 1;
    	if(isNatur(number))
    	{
    		/*for(int i = 1; i<number+1; i++)
    		{
    			result = result*i;
    		
    		}*/
    		if(number==0)
    		{
    			return 1.0;
    			
    		}
    		else return fact(number-1.0)*number;
    		
    	}
    	if(number==0)
    	{
    		result = 1;
    	
    	}
    	else if(!isNatur(number))
    	{
    		result = Gamma(number+1.0);
    	
    	}
    	
    	return result;
    	
    }
    public static double fastFact(int n)
    {
    	double result = 1;
    	for(int i = 1; i<n+1; i++)
		{
			result = result*i;
		
		}
    	return result;
    	
    }
    /**Returns sum of the row where row is natural line
     * 
     * @param number
     * @return
     * @since 0.5
     */
    public static double rowsum(double number)
    {
    	/*double result = 0;
    	if(number<0)
    	{
    		result=Double.NaN;
    		
    	}
    	else
    	{
    		for(int i = 1; i<number+1; i++)
    		{
    			result = result+i;
    			
    		}
    		
    	}
    	return result;*/
    	return number/2*(number+1);
    	
    }
    /**Returns sum of all numbers in massive
     * 
     * @param mass your massive
     * @return sum
     * @since 0.9.9.17
     */
    public static double masssum(double mass[])
    {
    	double result = 0;
    	
    	for(int i = 0;i<mass.length;i++)
    	{
    		result = result+mass[i];
    		
    	}
    	
    	return result;
    	
    }
    /**Returns &sum;
     * 
     * @param itter upper number to &sum;
     * @param k number in bottom of &sum;
     * @param f function
     * @return sum
     * @since 1.0.0
     */
    public static double sum(int itter, int k, DoubleFunction f)
    {
    	double result = 0;
    	for(int i=k;i<itter;i++)
    	{
    		result=result+f.execute(i);
    		
    	}
    	return result;
    	
    }
    
    /**Returns sine of angle
     * 
     * @param x  angle
     * @param deg  if true you use degrees, else radians
     * @return sine of angle
     * @since 0.5
     */
    public static double sin(double x, boolean deg)
    {
    	if(deg==true)
    	{
    		if(x>=0 && x<=45.0)
        	{
        		return QuadraticInterpolation(0.0, 30.0, 45.0, 0, 0.5, Math.sqrt(0.5)).execute(x);
        		
        	}
        	else if(x>=45.0 && x<=60.0)
        	{
        		return QuadraticInterpolation(30.0, 45.0, 60.0, 0, Math.sqrt(0.5), Math.sqrt(0.75)).execute(x);
        		
        	}
        	else if(x>=60.0 && x<=90.0)
        	{
        		return QuadraticInterpolation(45.0, 60.0, 90.0, Math.sqrt(0.5), Math.sqrt(0.75), 1).execute(x);
        		
        	}
        	else if(x>90.0 && x<=180.0)
        	{
        		return sin(180.0-x, deg);
        		
        	}
        	else if(x>180.0)
        	{
        		return -sin(x-180.0, deg);
        		
        	}
        	else if(x<0)
    		{
    			return -sin(abs(x), deg);
    			
    		}
    		
    	}
    	else
    	{
    		if(x>=0.0 && x<=(PI/4.0))
        	{
        		return QuadraticInterpolation(0.0, (PI/6.0), (PI/4.0), 0.0, 0.5, Math.sqrt(0.5)).execute(x);
        		
        	}
        	else if(x>=(PI/4.0) && x<=(PI/3.0))
        	{
        		return QuadraticInterpolation((PI/6.0), (PI/4.0), (PI/3.0), 0, Math.sqrt(0.5), Math.sqrt(0.75)).execute(x);
        		
        	}
        	else if(x>=(PI/3.0) && x<=(PI/2.0))
        	{
        		return QuadraticInterpolation((PI/4.0), (PI/3.0), (PI/2.0), Math.sqrt(0.5), Math.sqrt(0.75), 1.0).execute(x);
        		
        	}
        	else if(x>(PI/2.0) && x<=PI)
        	{
        		return sin(PI-x, deg);
        		
        	}
        	else if(x>PI)
        	{
        		return -sin(x-PI, deg);
        		
        	}
        	else if(x<0)
    		{
    			return -sin(abs(x), deg);
    			
    		}
    		
    	}
    	
    	return NaN;
    	
    }
    /**Returns sine of angle
     * 
     * @param x angle
     * @return sine of angle
     * @since 2.0.0
     */
    public static double sin(double x)
    {
    	return sin(x, false);
    	
    }
    /**Returns cosine of angle
     * 
     * @param x angle
     * @param deg if true you're using degrees, else radians
     * @return cosine of an angle
     * @since 0.5
     */
    public static double cos(double x, boolean deg)
    {
    	double result = 0;
    	double p = pi/2.0;
    	if(deg)
    		p = 90;
    	else p = PI/2.0;
    	result = sin(p-x, deg);
    	
    	return result;
    	
    }
    /**Returns cosine of angle
     * 
     * @param x angle
     * @return cosine of angle
     * @since 2.0.0
     */
    public static double cos(double x)
    {
    	return cos(x, false);
    	
    }
    /**Returns tangent of angle
     * 
     * @param f angle
     * @param deg if true you're using degrees, else radians
     * @return tangent of an angle
     * @since 0.5
     */
    public static double tan(double f, boolean deg)
    {
    	double result = sin(f, deg)/cos(f, deg);
    	
    	return result;
    	
    }
    /**Returns tangent of angle
     * 
     * @param x angle
     * @return tangent of angle
     * @since 2.0.0
     */
    public static double tan(double x)
    {
    	return tan(x, false);
    	
    }
    /**Returns cotangent of angle
     * 
     * @param f angle
     * @param deg if true you're using degrees, else radians
     * @return cotangent of an angle
     * @since 0.5
     */
    public static double cot(double f, boolean deg)
    {
    	double result = cos(f, deg)/sin(f, deg);
    	
    	return result;
    	
    }
    /**Returns cotangent of angle
     * 
     * @param x angle
     * @return cotangent of angle
     * @since 2.0.0
     */
    public static double cot(double x)
    {
    	return cot(x, false);
    	
    }
    /**Returns secant of angle, which is always in degrees
     * 
     * @param f angle
     * @return secant of angle
     * @since 0.5
     */
    public static double sec(double f, boolean deg)
    {
    	double result = 1/cos(f, deg);
    	
    	return result;
    }
    /**Returns secant of angle
     * 
     * @param x angle
     * @return secant of angle
     * @since 2.0.0
     */
    public static double sec(double x)
    {
    	return sec(x, false);
    	
    }
    /**Returns cosecant of angle, which is always in degrees
     * 
     * @param f angle
     * @return cosecant of an angle
     * @since 0.5
     */
    public static double csc(double f, boolean deg)
    {
    	double result = 1/sin(f, deg);
    	
    	return result;
    }
    /**Returns cosecant of angle
     * 
     * @param x angle
     * @return cosecant of angle
     * @since 2.0.0
     */
    public static double csc(double x)
    {
    	return csc(x, false);
    	
    }
    /**Returns hyperbolic sine
     * 
     * @param x sinh x
     * @return hyperbolic sine
     * @since 1.4.0
     */
    public static double sinh(double x)
    {
    	double exp = exp(x);
    	return (exp-1/exp)/2.0;
    	
    }
    /**Returns hyperbolic cosine
     * 
     * @param x cosh x
     * @return hyperbolic cosine
     * @since 1.4.0
     */
    public static double cosh(double x)
    {
    	double result = 0;
    	result = Math.pow(MyMath.e, x)+Math.pow(MyMath.e, -x);
    	result = result/2.0;
    	return result;
    	
    }
    /**Returns hyperbolic tangent
     * 
     * @param x tanh x
     * @return hyperbolic tangent
     * @since 1.4.0
     */
    public static double tanh(double x)
    {
    	return sinh(x)/cosh(x);
    	
    }
    /**Returns hyperbolic cotangent
     * 
     * @param x coth x
     * @return hyperbolic cotangent
     * @since 1.4.0
     */
    public static double coth(double x)
    {
    	return cosh(x)/sinh(x);
    	
    }
    /**Returns hyperbolic secant
     * 
     * @param x sech x
     * @return hyperbolic secant
     * @since 1.4.0
     */
    public static double sech(double x)
    {
    	return 1.0/cosh(x);
    	
    }
    /**Returns hyperbolic cosecant
     * 
     * @param x csch x
     * @return hyperbolic cosecant
     * @since 1.4.0
     */
    public static double csch(double x)
    {
    	return 1.0/sinh(x);
    	
    }
    
    /**Returns versus sine of angle
     * 
     * @param a angle
     * @param deg if true you use degrees, else rads
     * @return versus sine
     * @since 1.1
     */
    public static double versin(double a, boolean deg)
    {
    	double result = 1.0-cos(a,deg);
    	return result;
    	
    }
    /**Returns versus cosine of angle
     * 
     * @param a angle
     * @param deg if true you use degrees, else rads
     * @return versus cosine
     * @since 1.1
     */
    public static double vercos(double a, boolean deg)
    {
    	double result = 1.0-sin(a, deg);
    	return result;
    	
    }
    /**Returns haversine of angle
     * 
     * @param a angle
     * @param deg if true you use degrees, else rads
     * @return haversine
     * @since 1.1
     */
    public static double haversin(double a, boolean deg)
    {
    	double result = versin(a, deg)/2.0;
    	return result;
    	
    }
    /**Returns havercosine of angle
     * 
     * @param a angle
     * @param deg if true you use degrees, else rads
     * @return havercosine
     * @since 1.1
     */
    public static double havercos(double a, boolean deg)
    {
    	double result = vercos(a,deg)/2.0;
    	return result;
    	
    }
    /**Returns exsecant of angle
     * 
     * @param a angle
     * @param deg if true you use degrees, else rads
     * @return exsecant
     * @since 1.1
     */
    public static double exsec(double a, boolean deg)
    {
    	double result = sec(a, deg)-1.0;
    	return result;
    	
    }
    /**Returns excosecant of angle
     * 
     * @param a angle
     * @param deg if true you use degrees, else rads
     * @return excosecant
     * @since 1.1
     */
    public static double excsc(double a, boolean deg)
    {
    	double result = csc(a, deg)-1.0;
    	return result;
    	
    }
    
    /**Returns Gudermann function (hyperbolic amlitude)
     * 
     * @param x argument for gd(x)
     * @return Gudermann function
     * @since 1.6.0
     * @see arcgd
     */
    public static double gd(double x)
    {
    	return toRad(arcsin(tanh(x)));
    	
    }
    /**Returns Lambert function (reversed Gudermann function)
     * 
     * @param x argumnet fir arcgd(x)
     * @return Lambert function
     * @since 1.6.0
     * @see gd
     */
    public static double arcgd(double x)
    {
    	return arctanh(sin(x, false));
    	
    }
    
    /**Returns arcsine of number, I use degrees
     * 
     * @param num - number arcsine of you'll get
     * @return arcsine of a number
     * @since 0.9.9.11
     */
    public static double arcsin(double num)
    {
    	if(num>1.0 || num<-1.0)
    	{
    		return NaN;
    		
    	}
    	double result = 0;
    	
    	result = arctan(num/root(1-pow(num,2),2));
    	
    	//result = round(result,7);
    	
    	return result;
    	
    }
    /**Returns arccosine of number, I use degrees
     * 
     * @param num - number arccosine of you'll get
     * @return arccosine of a number
     * @since 0.9.9.11
     */
    public static double arccos(double num)
    {
    	return 90.0-arcsin(num);
    	
    }
    /**Returns arctangent of number, I use degrees
     * 
     * @param num - number arctangent of you'll get
     * @return arctangent of a number
     * @since 0.9.9.11
     */
    public static double arctan(double num)
    {	
    	if(num<0.0)
    	{
    		return -arctan(-num);
    		
    	}
    	if(num==0.0)
		{
			return 0.0;
			
		}
    	else if(num==POSITIVE_INFINITY)
		{
			return 90.0;
			
		}
    	else if(num>=0 && num<=0.5)
		{
			return QuadraticInterpolation(0, 0.25, 0.5, 0, 14.0362435, 26.56505117707799).execute(num);
			
		}
		else if(num>0.5 && num<=1.0)
		{
			return QuadraticInterpolation(0.5, 0.75, 1.0, 26.5650512, 36.8698976, 45.0).execute(num);
			
		}
		else if(num>1.0 && num<=3.0)
		{
			//return QuadraticInterpolation(1.0, 2.0, 3.0, 45.0, 63.43494882292201, 71.5650512).execute(x);
			return QuadraticInterpolation(1.0, 2.0, 3.0, 45.0, 63.43494882292201, 71.5650512).execute(num);
		}
		else if(num>=3.0 && num<=5.0)
		{
			return QuadraticInterpolation(3.0, 4.0, 5.0, 71.560512, 75.9637565, 78.6900675).execute(num);
			
		}
		else if(num>5.0 && num<=7.0)
		{
			return QuadraticInterpolation(5.0, 6.0, 7.0, 78.6900675, 80.5376778, 81.8698976).execute(num);
			
		}
		else if(num>7.0 && num<=10.0)
		{
			return QuadraticInterpolation(7.0, 8.5, 10.0, 81.8698976, 83.2901632, 84.2894069).execute(num);
			
		}
		else if(num>10.0 && num<=15.0)
		{
			return QuadraticInterpolation(10.0, 12.5, 15.0, 84.2894069, 85.4260787, 86.1859252).execute(num);
			
		}
		else if(num>15.0 && num<=50.0)
		{
			return QuadraticInterpolation(15.0, 20.0, 50.0, 86.1859252, 87.1375948, 88.8542371618249).execute(num);
			
		}
		else if(num>50.0 && num<=1000.0)
		{
			return QuadraticInterpolation(50.0, 100.0, 1000, 88.8542371618249, 89.4270613, 89.9427042).execute(num);
			
		}
		else if(num>1000.0)
		{
			return QuadraticInterpolation(1000.0, 1500.0, 2147483647.0,  89.9427042, 89.9618028193, 89.9999999733).execute(num);
			
		}
		return NaN;	
    	
    }
    /**Returns arccotangent of number, I use degrees
     * 
     * @param num - number arccotangent of you'll get
     * @return arccotangent of a number
     * @since 0.9.9.11
     */
    public static double arccot(double num)
    {
    	if(num==0)
    	{
    		return 0;
    		
    	}
    	double result = 0;
    	result = arctan(1/num);
    	return result;
    	
    }
    /**Returns arcsecant of number, I use degrees
     * 
     * @param num - number arcsecant of you'll get
     * @return arcsecant of a number
     * @since 0.9.9.11
     */
    public static double arcsec(double num)
    {
    	double result = 0;
    	result = arccos(reverse(num));
    	
    	return result;
    	
    }
    /**Returns arccosecant of number, I use degrees
     * 
     * @param num - number arccosecant of you'll get
     * @return arccosecant of a number
     * @since 0.9.9.11
     */
    public static double arccosec(double num)
    {
    	double result = 0;
    	result = arcsin(reverse(num));
    	
    	return result;
    	
    }
    
    /**Return hyperbolic arcsine
     * 
     * @param x asinh x
     * @return hyperbolic arcsine
     * @since 1.4.0
     */
    public static double arcsinh(double x)
    {
    	double result = MyMath.ln(x+MyMath.sqrt(MyMath.pow(x, 2)+1));
    	return result;
    	
    }
    /**Return hyperbolic arccosine
     * 
     * @param x acosh x
     * @return hyperbolic arccosine
     * @since 1.4.0
     */
    public static double arccosh(double x)
    {
    	double result = MyMath.ln(x+MyMath.sqrt(MyMath.pow(x, 2)-1));
    	return result;
    	
    }
    /**Return hyperbolic arctangent
     * 
     * @param x atanh x
     * @return hyperbolic arctangent
     * @since 1.4.0
     */
    public static double arctanh(double x)
    {
    	return MyMath.ln((MyMath.sqrt(1.0-MyMath.pow(x, 2)))/(1.0-x));
    	
    }
    /**Return hyperbolic arccotangent
     * 
     * @param x acoth x
     * @return hyperbolic arccotangent
     * @since 1.4.0
     */
    public static double arccoth(double x)
    {
    	return arctanh(1.0/x);
    	
    }
    /**Return hyperbolic arcsecant
     * 
     * @param x asech x
     * @return hyperbolic arcsecant
     * @since 1.4.0
     */
    public static double arcsech(double x)
    {
    	return arccosh(1.0/x);
    	
    }
    /**Return hyperbolic arccosecant
     * 
     * @param x acosech x
     * @return hyperbolic arccosecant
     * @since 1.4.0
     */
    public static double arccosech(double x)
    {
    	return arcsinh(1.0/x);
    	
    }
    
    /**Retuns arcversine of a
     * 
     * @param a number
     * @return arcversine
     * @since 1.2.0
     */
    public static double arcversin(double a)
    {
    	return arccos(1.0-a);
    	
    }
    /**Retuns arcvercosine of a
     * 
     * @param a number
     * @return arcvercosine
     * @since 1.2.0
     */
    public static double arcvercos(double a)
    {
    	return arcsin(1.0-a);
    	
    }
    /**Returns archaversine
     * 
     * @param a number
     * @return archaversine
     * @since 1.2.0
     */
    public static double archaversin(double a)
    {
    	return arcversin(a*2.0);
    	
    }
    /**Returns archavercosine
     * 
     * @param a number
     * @return archavercosine
     * @since 1.2.0
     */
    public static double archavercos(double a)
    {
    	return arcvercos(a*2.0);
    	
    }
    /**Returns arcexsecant of a
     * 
     * @param a number
     * @return arcexsecant
     * @since 1.2.0
     */
    public static double arcexsec(double a)
    {
    	return arcsec(a+1.0);
    	
    }
    /**Returns arcexcosecant of a
     * 
     * @param a number
     * @return arcexcosecant
     * @since 1.2.0
     */
    public static double arcexcosec(double a)
    {
    	return arccosec(a+1.0);
    	
    }
    
    /**Returns two-argument arctangent
     * 
     * @param y - ordinat
     * @param x - abciss
     * @return double
     * @since 1.0.0
     */
    public static double arctan2(double y, double x) 
	{
		if(x>0)
			return arctan(y/x);
		else if(x<0 && y>=0)
			return arctan(y/x)+MyMath.PI;
		else if(x<0 && y<0)
			return arctan(y/x)-MyMath.PI;
		else if(x==0)
			return sgn(y)*MyMath.PI/2;
		else return 0;
		
	}
    
    /**Returns 1 if a = true else returns 0
     * 
     * @param a boolean
     * @return double
     * @since 1.8.0
     */
    public static int IversonBracket(boolean a)
    {
    	return a ? 1 : 0;
    	
    }
    public static double fastpow(double b, int a)
    {
    	double res = 1;
    	for(int i = 0; i<a; i++)
	    	res*=b;
    	return res;
    	
    }
    /**Returns exponent of x (e<sup>x</sup> or exp(x))
     * 
     * @param x number exponent of you get
     * @return exp(x)
     * @since 0.9.9.32
     * @see e
     * @see E
     */
    public static double exp(double x)
    {
    	//return Math.exp(x);
    	if(x<0)
    		return 1/exp(-x);
    	else
    	{
    		/*final long tmp = (long) (1512775 * x + (1072693248 - 60801));
    	    return Double.longBitsToDouble(tmp << 32);*/
    		//return (362880+x*(362880+x*(181440+x*(60480+x*(15120+x*(3024+x*(504+x*(72+x*(9+x)))))))))*2.75573192e-6;
    		double res = 0;
        	for(int i = 0;i<50;i++)
        	{
        		res+=fastpow(x, i)/fastFact(i);
        		
        	}
        	return res;
    		
    	}

    }
    
    /**Returns absolute of a number |x| (if number is negative you get number negative to it, else you get number)
     * 
     * @param number number absolute of which you get
     * @return |x|
     * @since 0.5
     */
    public static double abs(double num)
    {
    	return num>=0 ? num : -num;
    	
    }
    /**Returns signum of number x (if x>0 sgn x=1; if x=0 sgn x=0; if x<0 sgn x=-1)
     * 
     * or sgn(x)=(|x|)'=d|x|/dx
     * 
     * @param x number signum of you get
     * @return signum of x
     * @since 0.9.9.25
     */
    public static double sgn(double x)
    {
    	/*double result = 0;
    	
    	if(x>0)
    	{
    		result = 1;
    		
    	}
    	else if(x==0)
    	{
    		result = 0;
    		
    	}
    	else if(x<0)
    	{
    		result = -1;
    		
    	}
    	
    	return result;*/
    	if(x==0.0)
    		return 0.0;
    	return x<0 ? -1.0 : 1.0;
    	
    }
    /**Returns heaviside's function for x (&theta;(x)) (if x>=0 &theta;(x)=1; if x<0 &theta;(x)=0)
     * 
     * <h3>&theta;(x)=[x&GreaterEqual;0]</h3>
     * 
     * @param x - number heaviside's function of you get
     * @return &theta;(x)
     * @since 0.9.9.25
     */
    public static double heavis(double x)
    {
    	/*double result = 0;
    	
    	if(x>=0)
    	{
    		result = 1;
    		
    	}
    	else if(x<0)
    	{
    		result = 0;
    		
    	}
    	
    	return result;*/
    	return IversonBracket(x>0);
    	
    }
    /**Returns ceiling of number (&#8968;x&#8969; nearest number forward on number line)
     * 
     * @param number - number ceiling of you'll get
     * @return ceiling of number
     * @since 0.5
     */
    public static int ceil(double x)
    {
    	/*double result = round(number, 0);
    	
    	if(result+0.5<number)
    	{
    		result++;
    		
    	}
    	
    	return (int) result;*/
    	int xi = (int)x;
		return x > xi ? xi - 1 : xi;
    	
    }
    /**Returns floor of number (&#8970;x&#8971; nearest number back on number line)
     * 
     * @param number - number floor of you'll get
     * @return floor of number
     * @since 0.5
     */
    public static int floor(double x)
    {
    	int xi = (int)x;
		return x < xi ? xi - 1 : xi;
    	
    }
    /**Returns negative number to number you wrote there
     * 
     * @param f - number negative of you get
     * @return negative number to your number
     * @since 0.5
     */
    public static double changeSign(double f)
    {
    	return -f;
    	
    }
    /**Returns rounded number
     * 
     * @param number - number you want to round
     * @param save - how many numbers after dot save
     * @return round number
     * @since 0.5
     */
    public static double round(double number, int save)
    {
    	if(number==NaN || number == POSITIVE_INFINITY || number == NEGATIVE_INFINITY)
    	{
    		return number;
    		
    	}
    	double mult = pow(10, save);
    	return (int)(number*mult)/mult;
    	
    }
    /**Returns <pre>MyMath.round(num, 0);</pre>
     * 
     * @param num number
     * @return rounded number
     * @since 1.7.0
     */
    public static int round(double num)
    {
    	return (int)num;
    	
    }
    /**Returns how many left after f/div
     * 
     * @param f number
     * @param div number (f/div)
     * @return how many left
     * @since 0.7
     */
    public static double remainder(double f, double div)
    {
    	double result = f-(floor(f/div)*div);
    	
		return result;
    	
    }
    /**Returns reversed number (0.5 & 2 as an example)
     * 
     * @param num number reversed of you'll get
     * @return reversed number
     * 
     * @since 0.9.9
     */
    public static double reverse(double num)
    {
    	double result=0;
    	result=1/num;
    	
    	return result;
    	
    }
    
    /**Returns Ariphmetic-Geometric Mean
     * 
     * @param a
     * @param b
     * @param itter
     * @return
     * @since 0.9.9
     */
    public static double AGM(double a, double b)
    {
    	double a1 = a;
        double g1 = b;
        while (abs(a1 - g1) >= 1.0e-14) {
            double arith = (a1 + g1) / 2.0;
            double geom = sqrt(a1 * g1);
            a1 = arith;
            g1 = geom;
        }
        return a1;
    	
    }
    /**Returns Ariphmetic Mean
     * 
     * @param mass
     * @return
     * @since 0.9.9.5
     */
    public static double AM(double mass[])
    {
    	double result = 0;
    	
    	for(int i=0;i<mass.length;i++)
    	{
    		result=result+mass[i];
    		
    	}
    	
    	result=result/mass.length;
    	
    	return result;
    	
    }
    /**Returns Ariphmetic Mean between a and b
     * 
     * @param a
     * @param b
     * @return (a+b)/2
     * 
     * @since 0.9.9.25
     * 
     */
    public static double AM(double a, double b)
    {
    	return (a+b)/2;
    	
    }
    /**Returns Ariphmetic Weighted Mean
     * 
     * @param mass - your array with numbers
     * @param weights - your array with weights
     * @return Ariphmetic Weighted Mean
     * 
     * @since 0.9.9.32
     * 
     */
    public static double AWM(double mass[], double weights[])
    {
    	double result = 0;
    	
    	if(mass.length!=weights.length)
    	{
    		result = Double.NaN;
    		
    	}
    	else
    	{
    		for(int i=0; i<mass.length;i++)
    		{
    			result = result+(mass[i]*weights[i]);
    			
    		}
    		
    		result=result/masssum(weights);
    		
    		
    	}
    	
    	return result;
    	
    }
    /**Returns Geometric Mean
     * 
     * @param mass
     * @return
     * 
     * @since 0.9.9.5
     */
    public static double GM(double mass[])
    {
    	double result = 1;
    	
    	for(int i=0; i<mass.length; i++)
    	{
    		result=result*mass[i];
    		
    	}
    	
    	result=root(result, mass.length);
    	
    	return result;
    	
    }
    /**Returns Geometric Mean between a and b
     * 
     * @param a
     * @param b
     * @return √(a*b)
     * 
     * @since 0.9.9.25
     */
    public static double GM(double a, double b)
    {
    	double result = 1;
    	
    	result = root(a*b, 2);
    	
    	return result;
    	
    }
    /**Returns Geometric Weighted Mean
     * 
     * @param mass - your array of numbers
     * @param weights - your array of weights
     * @return Geometric Weighted Mean
     * 
     * @since 0.9.9.32
     */
    public static double GWM(double mass[], double weights[])
    {
    	double result = 1.0;
    	
    	if(mass.length!=weights.length)
    	{
    		result = Double.NaN;
    		
    	}
    	else
    	{
    		for(int i=0;i<mass.length;i++)
    		{
    			result = result*(pow(mass[i],weights[i]));
    			
    		}
    		
    		result=root(result, masssum(weights));
    		
    	}
    	
    	return result;
    	
    }
    /**Returns Harmonic Mean of mass
     * 
     * @param mass - your array with numbers
     * @return Harmonic Mean
     * 
     * @since 0.9.9.32
     */
    public static double HM(double mass[])
    {
    	double result = 0;
    	
    	for(int i=0;i<mass.length;i++)
    	{
    		result = result+(reverse(mass[i]));
        		
    	}
    	
    	result=mass.length/result;
    	
    	return result;
    	
    }
    /**Returns Harmonic Weighted Mean
     * 
     * @param mass - your array with numbers
     * @param weights - your array with weights
     * @return Harmonic Weighted Mean
     * @since 0.9.9.32
     */
    public static double HWM(double mass[], double weights[])
    {
    	double result = 0;
    	
    	if(mass.length!=weights.length)
    	{
    		result=Double.NaN;
    		
    	}
    	else
    	{
    		for(int i=0;i<mass.length;i++)
    		{
    			result=result+(weights[i]/mass[i]);
    			
    		}
    		
    		result=masssum(weights)/result;
    		
    	}
    	
    	return result;
    	
    }
    
    /**Returns random number from min to max
     * 
     * @param min - minimal number
     * @param max - max number
     * @return random from min to max
     * 
     * @since 0.5
     */
     public static double random(double min, double max)
    {
    	double reservemax=max;
    	max -= min;
    	double result = (random() * ++max) + min;
    	
    	while(result>=reservemax)
    	{
    		result = (random() * ++max) + min;
    		
    	}
    	
    	return result;
    	
    }
     /**Returns random number from 0.0 to 1.0
      * 
      * @return random number
      * @since 1.6.0
      */
     public static double random()
     {
    	 Random rnd = neededMethods.randomNumberGenerator;
    	 if(rnd==null) rnd = neededMethods.initRNG();
    	 return rnd.nextDouble();
    	 
     }
     /**
      * @deprecated
      * @return works only if you have a microphone
      */
     public static double secureRandom()
     {
    	 int audiornd = getRandomKey(32);
    	 while(Math.floor(audiornd)!=0)
    	 {
    		 audiornd/=10;
    		 
    	 }
    	 //audiornd*=10;
    	 SecureRandom rnd = neededMethods.secureRandom;
    	 if(rnd==null) rnd = neededMethods.initSRNG();
    	 double mathrnd = rnd.nextDouble();
    	 if(isInRange(0.0, 1.0, audiornd+mathrnd))
    	 {
    		 return audiornd+mathrnd;
    		 
    	 }
    	 else
    	 {
    		 if(rnd.nextBoolean())
    		 {
    			 return mathrnd;
    			 
    		 }
    		 else return audiornd;
    		 
    	 }
    	 
     }
     private static int getRandomKey(int keyLength) {
         int [] randomInts = getRandomIntArray(keyLength);
         int res = 0;
         for (int randomInt: randomInts) {
             res = (randomInt % 10)/11;
         }
         return res;
     }
     private static boolean isMicrophoneAvailable()
     {
    	 return false;
    	 
     }
     private static int[] getRandomIntArray(int desiredLength) {
         int [] out = null;
         AudioFormat format = new AudioFormat(8000.0f, 16, 1, false, false);
         TargetDataLine microphone;
         try {
             out = new int[desiredLength];
             byte[] data = new byte[2];

             DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
             if(AudioSystem.getClip() == null)
             {
            	 int res[] = new int[1];
            	 res[0] = 0;
            	 return res;
            	 
             }
             if(info == null)
             {
            	 int res[] = new int[1];
            	 res[0] = 0;
            	 return res; 
            	 
             }
             microphone = (TargetDataLine) AudioSystem.getLine(info);
             
             microphone.open(format);
             microphone.start();

             while (data[1] < 100) {
                 microphone.read(data, 0, data.length);
             }
             byte [] leastSig = new byte[2];
             for (int i = 0; i < desiredLength * 2; i++) {
                 microphone.read(data, 0, data.length);
                 leastSig[i % 2] = data[1];
                 if (i % 2 == 1) {
                     out[(i + 1) / 2 - 1] = leastSig[0]<<8 &0xFF00 | leastSig[1]&0xFF;
                 }
             }
             microphone.close();
         } catch (LineUnavailableException e) {
             e.printStackTrace();
         }
         return out;
     }
     /**Returns random long
      * 
      * @return random long
      * @since 1.6.0
      */
     public static long randomLong()
     {
    	 Random rnd = neededMethods.randomNumberGenerator;
    	 if(rnd==null) rnd = neededMethods.initRNG();
    	 return rnd.nextLong();
    	 
     }
     
     /**Sets seed for random number
      * 
      * @param seed new seed
      * @since 1.6.0
      */
     public static void srand(int seed)
     {
    	 MyMath.seed = seed;
    	 
     }
     
     /**Seed for random number
      * @since 1.6.0
      */
     public static long seed = 15663;
     /**Some values for random generating
      * @since 1.6.0
      */
     private static long multiplier=0x5DEECE66DL, addend=0xBL, mask=(1L << 48)-1;
     
     private static int x = 1;
     private static long lastRand = (multiplier*seed+addend)%mask;
     
     /**Returns random number
      * 
      * @since 1.6.0
      * @return random number with Linear Congruent method
      */
     public static long LinearCongruentRandom()
     {
    	 long x1 = (multiplier*lastRand+addend)%mask;
    	 x1++;
    	 lastRand = x1;
		 seed = (seed*multiplier+addend) & mask;
		 seed = seed >>> (48-32);
    	 return x1;
    	 
     }
     /**Returns triangle random
      * @since 1.6.0
      * @return triangle random
      */
     public static double triangleRandom()
     {
    	 double a = abs(LinearCongruentRandom());
    	 double b = abs(LinearCongruentRandom());
    	 double c = abs(LinearCongruentRandom());
    	 final double RAND_MAX=1.0;
    	 final double RAND_MIN=0.0;
    	 
    	 double U = abs(LinearCongruentRandom())/RAND_MAX;
    	 double F = (c-a)/(b-a);
    	 if(U<=F)
    	 {
    		 return a+Math.sqrt(U*(b-a)*(c-a));
    		 
    	 }
    	 else return b-Math.sqrt((1-U)*(b-a)*(c-a));
    	 
     }
     
     /**Returns random int between min and max
      * 
      * @param min min number
      * @param max max number
      * @return int
      * @since 1.2.0
      */
     public static int random(int min, int max)
     {
    	 double min1 = min;
    	 double max1 = max;
    	 return (int)random(min1, max1);
    	 
     }
     /**Return random long between min and max
      * 
      * @param min min number
      * @param max max number
      * @return random
      * @since 1.6.0
      */
     public static long random(long min, long max)
     {
    	 double min1 = min;
    	 double max1 = max;
    	 return (int)random(min1, max1);
    	 
     }
     /**Creates odd number
      * @return odd number
      * @since 1.6.0
      */
     public static long createLongOdd()
     {
    	 long odd = random(2, (long) POSITIVE_INFINITY);
    	 odd*=2;
    	 odd-=1;
    	 odd=(long) abs(odd);
    	 return odd;
    	 
     }
     /**Creates even number
      * @return even number
      * @since 1.6.0
      */
     public static long createLongEven()
     {
    	 long odd = random(2, (long) POSITIVE_INFINITY);
    	 odd*=2;
    	 odd=(long) (odd*sgn(odd));
    	 return odd;
    	 
     }
     /**Returns true if long is odd
      * 
      * @param n your long
      * @return boolean
      * @since 1.6.0
      */
     public static boolean isLongOdd(long n)
     {
    	 if(n%2!=0)
    	 {
    		 return true;
    		 
    	 }
    	 else return false;
    	 
     }
     /**Returns true if long is even
      * 
      * @param n your long
      * @return boolean
      * @since 1.6.0
      */
     public static boolean isLongEven(long n)
     {
    	 if(n%2==0)
    	 {
    		 return true;
    		 
    	 }
    	 else return false;
    	 
     }
     /**Creates odd number
      * @return odd number
      * @since 1.6.0
      */
     public static int createOdd()
     {
    	 return createOdd(false);
    	 
     }
     /**Creates even number
      * @return even number
      * @since 1.6.0
      */
     public static int createEven()
     {
    	 return createEven(false);
    	 
     }
     /**Creates odd number
      * @param allowNegative if true you can get negative numbers
      * @return odd number
      * @since 1.6.0
      */
     public static int createOdd(boolean allowNegative)
     {
    	 int odd = 2*random(2, (int) POSITIVE_INFINITY)-1;
    	 if(!allowNegative) odd=(int) abs(odd);
    	 return odd;
    	 
     }
     /**Creates even number
      * @param allowNegative if true you can get negative numbers
      * @return even number
      * @since 1.6.0
      */
     public static int createEven(boolean allowNegative)
     {
    	 int even = 2*random(1, (int) POSITIVE_INFINITY);
    	 if(!allowNegative) even=(int) abs(even);
    	 return even;
    	 
     }
     
     /**Returns Fibbonaci number (F<sub>n</sub>)
      * 
      * @param n F<sub>n</sub>
      * @throws IllegalArgumentException if <pre>n&lt;=0</pre>
      * @return Fibbonaci number
      * @since 1.6.0
      */
     public static long Fibonacci(int n)
     {
    	 if(n<=0) throw new IllegalArgumentException("n must be positive");
    	 else if(n==1) return 0;
    	 else if(n==2) return 1;
    	 else if(n==3) return 1;
    	 else if(n==4) return 2;
    	 else if(n==5) return 3;
    	 else if(n==6) return 5;
    	 else if(n==7) return 8;
    	 else if(n==8) return 13;
    	 else if(n==9) return 21;
    	 else if(n==10) return 34;
    	 else if(n==11) return 55;
    	 else if(n==12) return 89;
    	 else if(n==13) return 144;
    	 else if(n==14) return 233;
    	 else if(n==15) return 377;
    	 else if(n==16) return 610;
    	 else if(n==17) return 987;
    	 else if(n==18) return 1597;
    	 else if(n==19) return 2584;
    	 else if(n==20) return 4181;
    	 else if(n==21) return 6765;
    	 else if(n==22) return 10946;
    	 else if(n==23) return 17711;
    	 else if(n==24) return 28657;
    	 else if(n==25) return 46368;
    	 else if(n==26) return 75025;
    	 else if(n==27) return 121393;
    	 else if(n==28) return 196418;
    	 else if(n==29) return 317811;
    	 else if(n==30) return 514229;
    	 else if(n==31) return 832040;
    	 else if(n==32) return 1346269;
    	 else if(n==33) return 2178309;
    	 else if(n==34) return 3524578;
    	 else if(n==35) return 5702887;
    	 else if(n==36) return 9227465;
    	 else if(n==37) return 14930352;
    	 else if(n==38) return 24157817;
    	 else if(n==39) return 39088169;
    	 else if(n==40) return 63245986;
    	 else if(n==41) return 102334155;
    	 else if(n==42) return 165580141;
    	 else if(n==43) return 267914296;
    	 else if(n==44) return 433494437;
    	 else if(n==45) return 701408733;
    	 else if(n==46) return 1134903170;
    	 else if(n==47) return 1836311903;
    	 else if(n==48) return 2971215073L;
    	 else if(n==49) return 4807526976L;
    	 else if(n==50) return 7778742049L;
    	 else return Fibonacci(n-2)+Fibonacci(n-1);
    	 
     }
    
    /**Returns max number of two
     * 
     * @param a - max number
     * @param b - second number
     * @return max number of a and b
     * 
     * @since 0.9.9.17
     */
    public static double max(double a, double b)
    {
    	return a>=b ? a : b;
    	
    }
    /**Returns min number of two
     * 
     * @param a - max number
     * @param b - second number
     * @return min number of a and b
     * 
     * @since 0.9.9.17
     */
    public static double min(double a, double b)
    {
    	return a>=b ? b : a;
    	
    }
    /**Returns max number in mass[]
     * 
     * @param mass[] - massive
     * @return max number in mass[]
     * 
     * @since 0.9.9.17
     */
    public static double max(double mass[])
    {
    	double result = min_value;
    	
    	for(int i = 0;i<mass.length;i++)
    	{
    		if(mass[i]>result)
    		{
    			result = mass[i];
    			
    		}
    		
    	}
		return result;
    	
    	
    }
    /**Returns min number in mass[]
     * 
     * @param mass[] - massive
     * @return min number in mass[]
     * 
     * @since 0.9.9.17
     */
    public static double min(double mass[])
    {
    	double result = max_value;
    	
    	for(int i = 0;i<mass.length;i++)
    	{
    		if(mass[i]<result)
    		{
    			result = mass[i];
    			
    		}
    		
    	}
		return result;
    	
    	
    }
    
    /**Returns degrees converted into radians
     * 
     * @param deg - degrees
     * @return radians
     * 
     * @since 0.7
     */
    public static double toRad(double deg)
    {
    	return deg*pi/180;
    	
    }
    /**Returns radians converted into degrees
     * 
     * @param rad - radians
     * @return degrees
     * 
     * @since 0.7
     */
    public static double toDeg(double rad)
    {
		return rad*180/pi;
    	
    }
    
    /**Converts decimal to binary
     * 
     * @param dec
     * @return string
     * 
     * @since 0.8
     */
    public static String toBin(int dec)
    {
    	String result = Integer.toBinaryString(dec);
    	
    	return result;
    	
    }
    /**Converts decimal to hex
     * 
     * @param dec
     * @return string
     * 
     * @since 0.8
     */
    public static String toHex(double dec)
    {
    	String result = Double.toHexString(dec);
    	
    	return result;
    	
    }
    /**Converts decimal to octo
     * 
     * @param dec
     * @return string
     * 
     * @since 0.8
     */
    public static String toOct(int dec)
    {
    	String result = Integer.toOctalString(dec);
    	
		return result;
    	
    }
    
    /**Converts binary to dec
     * 
     * @param bin number in binary
     * @return integer
     * 
     * @since 0.8
     */
    public static int BinToDec(String bin)
    {
    	int result = Integer.parseInt(bin, 2);
    	
		return result;
    	
    }
    /**Converts hex to dec
     * 
     * @param hex number in hexagonal
     * @return integer
     * 
     * @since 0.8
     */
    public static int HexToDec(String hex)
    {
    	int result = Integer.parseInt(hex, 16);
    	
		return result;
    	
    }
    /**Converts Octo to Dec
     * 
     * @param octo number in ocotogonal
     * @return integer
     * 
     * @since 0.8
     */
    public static int OctoToDec(String octo)
    {
    	int result = Integer.parseInt(octo, 8);
    	
		return result;
    	
    }
    
    /**Converts doubles into Complex
     * 
     * @param num - number you convert
     * @return Complex
     * @since 1.1.0
     */
    public static Complex toComplex(double num)
    {
    	Complex result = new Complex(num, 0);
    	return result;
    	
    }
    /**Converts array of doubles into array of Complex
     * 
     * @param num - your array
     * @return Complex[]
     * @since 1.1.0
     */
    public static Complex[] toComplex(double[] num)
    {
    	Complex[] result = new Complex[num.length];
    	for(int i=0;i<num.length;i++)
    	{
    		result[i]=new Complex(num[i],0);
    		
    	}
    	return result;
    	
    }
    
    /**Returns number fraction-like (1/2=0.5)
     * 
     * @param num - number you convert into fraction
     * @return Fraction
     * 
     * @since 0.9.9.35
     */
    public static Fraction toFraction(double num)
    {
    	return new Fraction(neededMethods.fractionUp(num), neededMethods.fractionDown(num));
    	
    }
    /**Converts array of doubles into array of Fractions
     * 
     * @param num - your array
     * @return - Fraction[]
     * @since 1.1.0
     */
    public static Fraction[] toFraction(double[] num)
    {
    	Fraction result[] = new Fraction[num.length];
    	for(int i=0;i<num.length;i++)
    	{
    		result[i]=new Fraction(neededMethods.fractionUp(num[i]),neededMethods.fractionDown(num[i]));
    		
    	}
    	return result;
    	
    }
    /**Returns number fraction-like (1/2=0.5)
     * 
     * @param num - number you convert into fraction
     * @param downOrUp - if 0 you'll get down, if 1 you'll get up
     * @return double
     * 
     * @since 0.9
     */
    public static double toFraction(double num, int downOrUp)
    {
    	double result = 0;
    	
    	if(downOrUp==1)
    	{
    		result = neededMethods.fractionUp(num);
    		
    	}
    	if(downOrUp==0)
    	{
    		result = neededMethods.fractionDown(num);
    		
    	}
    	
    	return result;
    }
    public static boolean[] toBooleanArray(int a)
    {
    	String s = Integer.toBinaryString(a);
    	boolean[] res = new boolean[s.length()];
    	
    	for(int i = 0; i<s.length(); i++)
    	{
    		if(s.charAt(i)=='1')
    			res[i] = true;
    		else res[i] = false;
    		
    	}
    	return res;
    	
    }
    public static boolean[] toInversedBooleanArray(int a)
    {
    	String s = Integer.toBinaryString(a);
    	boolean[] res = new boolean[s.length()];
    	
    	for(int i = 0; i<s.length(); i++)
    	{
    		if(s.charAt(i)=='1')
    			res[i] = false;
    		else res[i] = true;
    		
    	}
    	return res;
    	
    }
    public static int inverseInt(int a)
    {
    	boolean[] b = toInversedBooleanArray(a);
    	int res = 0;
    	
    	for(int i = 1; i<b.length; i++)
    	{
    		res+=fastpow(2, b.length-1-i)*IversonBracket(b[i]);
    		
    	}
    	
    	return b[0] ? -res : res;
    	
    }
    /**Returns mediant of two numbers (a/b, c/d = (a+c)/(b+d))
     * 
     * @param x - first number
     * @param y - second number
     * @return mediant
     * 
     * @since 0.9.9.25
     */
    public static double mediant(double x, double y)
    {
    	double result = 0;
    	
    	result = (toFraction(x, 1)+toFraction(y,1))/(toFraction(x,0)+toFraction(y,0));
    	
    	return result;
    	
    }
    /**Returns mediant of two numbers (a/b, c/d = (a+c)/(b+d))
     * 
     * @param x - first number
     * @param y - second number
     * @return mediant <table>
     * <tr><td style="border:0;border-bottom:5px">a+c</td></tr>
     * <tr><td style="border:0;border-top:5px">b+d</td></tr>
     * </table>
     * 
     * @since 1.0.0
     */
    public static Fraction mediant(Fraction x, Fraction y)
    {
    	return new Fraction(x.num+y.num, x.den+y.den);
    	
    }
    /**Newton's methods to find function nulls
     * 
     * @param x0 1<sup>st</sup> approximation
     * @param f your function
     * @return x where f(x) = 0
     * @since 1.3.0
     */
    public static double NewtonNull(double x0, DoubleFunction f)
    {
    	/*final double eps = 0.00001;
    	DoubleFunction df = derivative(f);
    	double x1 = x0 - f.execute(x0)/df.execute(x0);
    	while(MyMath.abs(x1-x0)>eps)
    	{
    		x0=x1;
    		x1 = x0 - f.execute(x0)/df.execute(x0);
    		
    	}
    	
    	return x1;*/
    	return NewtonNull(x0, f, derivative(f));
    	
    }
    /**Newton's methods to find function nulls
     * 
     * @param x0 1<sup>st</sup> approximation
     * @param f your function
     * @param df derivative of f
     * @return x where f(x) = 0
     * @since 1.3.0
     */
    public static double NewtonNull(double x0, DoubleFunction f, DoubleFunction df)
    {
    	final double eps = 0.00000001;
    	double x1 = x0 - f.execute(x0)/df.execute(x0);
    	while(MyMath.abs(x1-x0)>eps)
    	{
    		x0=x1;
    		x1 = x0 - f.execute(x0)/df.execute(x0);
    		
    	}
    	
    	return x1;
    	
    }
    
    /**Returns Quadratic Interpolation between 3 points
     * 
     * @param x1 x coordinate of first point
     * @param x2 x coordinate of second point
     * @param x3 x coordinate of third point
     * @param y1 y coordinate of first point
     * @param y2 y coordinate of second point
     * @param y3 y coordinate of third point
     * @return Quadratic Interpolation
     * @since 1.5.0
     */
    public static DoubleFunction QuadraticInterpolation(double x1, double x2, double x3, double y1, double y2, double y3)
    {
    	return new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				return NaN;
			}
			
			@Override
			public double execute(double x) {
				//double f = y1*(((x-x2)*(x-x3))/((x1-x2)*(x1-x3)));
				//double s = y1*(((x-x0)*(x-x2))/((x1-x0)*(x1-x2)));
				//double t = y2*(((x-x0)*(x-x1))/((x2-x1)*(x2-x1)));
				double ft = y1*(x-x2)*(x-x3);
				double fb = (x1-x2)*(x1-x3);
				double f = ft/fb;
				
				double st = y2*(x-x1)*(x-x3);
				double sb = (x2-x1)*(x2-x3);
				double s = st/sb;
				
				double tt = y3*(x-x1)*(x-x2);
				double tb = (x3-x1)*(x3-x2);
				double t = tt/tb;
				
				return f+s+t;
				
			}
		};
    	
    }
    
    /**Returns Linear Interpolation
     * 
     * @param x0 first argument
     * @param x1 second argument
     * @param y0 f(x0)
     * @param y1 f(x1)
     * @return DoubleFunction
     * @since 1.5.0
     */
    public static DoubleFunction LinearInterpolation(double x0, double x1, double y0, double y1)
    {
    	return new DoubleFunction(){

			@Override
			public double execute(double x) {
				double f = (y1-y0)*(x-x0)/(x1-x0);
				return y0+(y1-y0)*(x-x0)/(x1-x0);
						
			}

			@Override
			public double reversedFunction(double x) {
				
				return 0;
			}};
    	
    }
    /*public static DoubleFunction NewtonInterpolation(double n, double m)
    {
    	double result = MyMath.sum(n, 0, new DoubleUnaryOperator() {
			
			@Override
			public double applyAsDouble(double operand) {
				double result = bin(operand, x);
				result*=sum(m, , f)
			}
		})
    	
    }*/
    /*
     * * <pre>new DoubleUnaryOperator(){
     * &#64;override 
     * public double applyAsDouble(a)
     * {
     * return /*Your func here*&#47;;
     * }});</pre> 
     */
    
    /**Returns differential 
     * 
     * @param x point
     * @param dx precision
     * @param f your function
     * @return df(x)
     * @since 1.0.0
     */
    public static double differential(double x, double dx, DoubleFunction f)
    {
    	/*double dx1 = dx;
    	   double dx2 = dx1 * 2;
    	   double dx3 = dx1 * 3;

    	   double m1 = (f.execute(x + dx1) - f.execute(x - dx1)) / 2;
    	   double m2 = (f.execute(x + dx2) - f.execute(x - dx2)) / 4;
    	   double m3 = (f.execute(x + dx3) - f.execute(x - dx3)) / 6;

    	   double fifteen_m1 = 15 * m1;
    	   double six_m2     =  6 * m2;
    	   double ten_dx1    = 10 * dx1;

    	   return ((fifteen_m1 - six_m2) + m3) / ten_dx1;*/
    	return f.execute(x+dx)-f.execute(x);
    	
    }
    /*public static double derivative(double x, DoubleFunction f)
    {
    	double result = 0;
    	double h = reverse(max_value);
    	double h12 = h * 12;
    	result = -f.execute(x+2*h)+8*f.execute(x+h)-8*f.execute(x-h)+f.execute(x-2*h);
    	return (x) -> result/h12;
    	
    }*/
    /**
     *  f'(x) or dy/dx
     * @param f function derivative of you get
     * @return derivative of f
     * @since 1.2.0
     */
    public static DoubleFunction derivative(DoubleFunction f)
    {
    	double h = 0.000001; //One to million
    	DoubleFunction f1 = f;
    	
    	return new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				return 0;
			}
			
			@Override
			public double execute(double x) 
			{
				double dx = 0.0001;
				double y1 = f1.execute(x);
				double y2 = f1.execute(x+dx);
				double dy = y2-y1;
				if(dy==dx)
				{
					return 1;
					
				}
				return /*round(dy/dx, 12)*/ dy/dx;
			}
		};
    	
    }
    
    /**Returns Minkowski function for x (?x)
     * 
     * @param x number Minkowski function of you get
     * @return ?x
     * 
     * @since 0.9.9.25
     */
    public static double Minkowski(double x)
    {
    	long p = (long) x;
        if ((double)p > x) p--;
        long q = 1, r = p + 1, s = 1, m, n;
        double d = 1, y = p;
        if (x < (double)p || (p < 0) ^ (r <= 0))
            return x;
        for (;;) 
        {
            d /= 2;
            if (y + d == y)
                break;
            m = p + r;
            if ((m < 0) ^ (p < 0))
                break;
            n = q + s;
            if (n < 0)
                break;

            if (x < (double)m / n) {
                r = m;
                s = n;
            } else {
                y += d;
                p = m;
                q = n;
            }
        }
        return y + d;
    	
    }
    
    /**Returns Bernoulli number B<sub>n</sub>
     * 
     * @param n B<sub>n</sub>
     * @return Bernoulli number
     * @throws IllegalArgumentException if <pre>n&lt;0</pre>
     * @since 1.0.0
     */
    public static double Bernoulli(int n)
    {
    	if(n==0)
	    	return 1;
    	else if(n==1)
    		return -0.5;
    	else if(n%2==1 && n!=1)
    		return 0;
    	else
    	{
    		DoubleFunction f = new DoubleFunction() {
				
				@Override
				public double reversedFunction(double x) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public double execute(double x) {
					double bin = fact(n+1)/(fact(x+1)*fact(n-x));
					return bin*Bernoulli((int) (n-x));
				}
			};
			return -sum(n, 1, f)/(n*n+2*n+1);
    		
    	}
    	
    }
    /**Returns binomial coefficent for n & k
     * 
     * @param n B<sub>n</sub><sup>k</sup>
     * @param k B<sub>n</sub><sup>k</sup>
     * @return B<sub>n</sub><sup>k</sup>
     * @since 1.0.0
     */
    public static double binomial(int n, int k)
    {
    	double result = 0;
    	result = (fact(n)/fact(k))/fact(n-k);
    	
    	return result;
    	
    }
    
    /**Returns M&ouml;bius function (&mu;(n)). 1 if number is free from squares of prime numbers, 0 if it's not free from squares
     * 
     * @param n number
     * @return 	&mu;(n)
     * @since 1.0.0
     */
    public static int Mobius(int n)
    {
    	if (n == 1) 
            return 1;
        int p = 0; 
        for (int i = 1; i <= n; i++) { 
            if (n % i == 0 && isPrime(i)) {
                if (n % (i * i) == 0) 
                	return 0; 
                else
                	p++; 
            } 
        }
        return (p%2!=0) ? -1 : 1; 
    	
    }
    /**Returns Mertens function for n
     * 
     * @param n M(n)
     * @return int
     * @since 1.0.0
     */
    public static int Mertens(int n)
    {
    	double result = 0;
    	result = sum(n, 1, new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return Mobius((int)x);
			}
		});
		return (int) result;
    	
    }
    private static double minOnePow(int n)
    {
    	if(n%2==0)
    		return 1.0;
    	else return -1.0;
    	
    }
    /**Returns Riemann's zeta function for s
     * 
     * @param s number
     * @param n precision
     * @return double
     * @since 1.2.0
     */
    public double zeta(double s, int n)
	{
		double res = 0.0;
		if(s==1.0)
			return Double.POSITIVE_INFINITY;
		else if(s==0.0)
			return 0.5;
		else if(s<0.0)
		{
			return (Math.pow(2*MyMath.PI, s)*MyMath.sin(MyMath.PI*s/2, false)*MyMath.fact(-s)*zeta(-s+1, n))/MyMath.PI;
			
		}
		else
		{
			for(int i = 1; i<n; i++)
			{
				res+=Math.pow(-1, i)/Math.pow(i, s);
				
			}
			res/=(Math.pow(2, 1-s)-1);
			return res;
			
		}
		
	}
    /** Calculates first n primes
     * 
     * @param n
     */
    public static void calculatePrimes(int n)
    {
    	ArrayList<Double> prime = new ArrayList<Double>();
		int i = 2;
		while(prime.size()<n)
		{
			if(MyMath.isPrime(i))
			{
				prime.add((double)i);
				
			}
			i++;
			
		}
		primeNums = new double[prime.size()];
    	primes = prime.toArray(new Double[0]);
    	for(int j = 0; j < prime.size(); j++)
    	{
    		primeNums[j] = prime.get(j);
    		
    	}
    }
    private static Double[] primes = {2.0, 3.0, 5.0, 7.0, 11.0, 13.0, 17.0, 19.0, 23.0, 29.0, 31.0, 37.0, 41.0, 43.0, 47.0, 53.0, 59.0, 61.0, 67.0, 71.0, 73.0, 79.0, 83.0, 89.0, 97.0, 101.0};
    public static double[] primeNums = {2.0, 3.0, 5.0, 7.0, 11.0, 13.0, 17.0, 19.0, 23.0, 29.0, 31.0, 37.0, 41.0, 43.0, 47.0, 53.0, 59.0, 61.0, 67.0, 71.0, 73.0, 79.0, 83.0, 89.0, 97.0, 101.0};
    /**Returns Eta Dirihle function (&eta;(s))
     * 
     * @param s &eta;(s)
     * @param n precision
     * @return &eta;(s)
     * @since 1.7.0
     */
    public static double EtaDir(double s, int n)
    {
    	double result = 0;
    	DoubleFunction f = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				
				return 0;
			}
			
			@Override
			public double execute(double x) {
				double up = Math.pow(-1.0, x-1.0);
				double down = Math.pow(n, s);
				return up/down;
			}
		};
		result = sum(n, 1, f);
		return result;
    	
    }
    
    /**Priem Distribution Function
     * 
     * @param a your number
     * @return how many prime numbers before your
     * @since 1.2.0
     */
    public static int primeDF(double a)
    {
    	int result = 0;
    	for(int i=0;i<=a;i++)
    	{
    		if(isPrime(i))
    		{
    			result++;
    			
    		}
    		
    	}
    	return result;
    	
    }
    
    /**Returns Gamma function for a
     * 
     * @param a G(a)
     * @return double
     * @since 1.0.0
     */
    public static double Gamma(double a)
    {
    	if(isNatur(a))
    	{
    		return fact(a-1.0);
    		
    	}
    	double result = 0;
    	result = exp(gammln(a));
    	return result;
    	
    }
    /**Returns error function (erf(x)&asymp;tanh(x*pi/&radic;6))
     * 
     * @param x - argument
     * @return erf(x)
     * @since 1.8.0
     */
    public static double erf(double x)
    {
    	if(abs(x)>40)
    	{
    		return sgn(x);
    		
    	}
    	double piOverSqrt6 = 1.28254983016;
    	return tanh(x*piOverSqrt6);
    	
    }
    /**Returns complementary error function (1-erf(x))
     * 
     * @param x argument
     * @return erfc(x)
     * @since 1.8.0
     */
    public static double erfc(double x)
    {
    	return 1-erf(x);
    	
    }
    /**Returns Pi Function (Factorial for x<0 and x&isin;&Copf; & x&isin;&Ropf;
     * 
     * @param x number factorial of you get
     * @return &prod;(x)
     * @since 1.7.0
     */
    public static double PiFunction(double x)
    {
    	/*double up = Math.pow(POSITIVE_INFINITY, x+1.0);
    	double down = x+1.0;
    	return -1*(up/down);*/
    	if(isNatur(x))
    	{
    		return fact(x);
    		
    	}
    	else return Gamma(x+1.0);
    	
    }
    /**natural log of gamma f
     * 
     * @param xx param
     * @return double
     * @since 1.0.0
     */
    private static double gammln(double xx) {
		double x, y, tmp, ser;
		x = y = tmp = ser = 0.0;

		final double[] cof = { 76.18009172947146, -86.50532032941677,
			24.01409824083091, -1.231739572450155, 0.1208650973866179e-2,
			-0.5395239384953e-5 };
		int j;
		y = x = xx;
		tmp = x + 5.5;
		tmp -= (x + 0.5) * log(tmp);
		//ser = 1.000000000190015;
		ser = 1.0000000000000000015;
		for (j = 0; j <= 5; j++) {
			ser += cof[j] / ++y;
		}

		return -tmp + log(2.5066282746310005 * ser / x);
	}
    
    /**Returns Greatest Common Divisor of num1 and num2
     * 
     * @param num1 your number
     * @param num2 your number
     * @return GCD of your numbers
     * @since 0.9.9.35
     */
    public static int gcd(int num1, int num2)
    {
    	while (num1 != num2) {
        	if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
    	
    	return num2;
    	
    }
    /**Returns Least Common Multiplier of num1 and num2
     * 
     * @param num1 your number
     * @param num2 your number
     * @return LCM of your numbers
     * @since 0.9.9.35
     */
    public static int lcm(int num1, int num2)
    {
    	return (num1 / gcd(num1, num2)) * num1;
    	
    }
    
    /**Needed to make operations with your non-decimal numbers
     *  
     * @param num1 1st number 
     * @param num2 2nd number 
     * @param system 2, 8, 16 
     * @param oper +, -, /, 
     * @return String 
     *
     * @since 0.9.8 
     */
    public static String nonDecOperations(String num1, String num2, int system, Operation oper)
    {
    	double dec1 = Integer.parseInt(num1, system);
    	double dec2 = Integer.parseInt(num2, system);
    	double decresult = 0;
    	if(oper == Operation.ADD)
    	{
    		decresult = dec1+dec2;
    		
    	}
    	else if(oper == Operation.SUBTRACT)
    	{
    		decresult = dec1-dec2;
    		
    	}
    	else if(oper == Operation.MULTIPLY)
    	{
    		decresult = dec1*dec2;
    		
    	}
    	else if(oper == Operation.DIVIDE)
    	{
    		decresult = dec1/dec2;
    		
    	}
    	else if(oper == Operation.POW)
    	{
    		decresult = MyMath.pow(dec1, dec2);
    		
    	}
    	else if(oper == Operation.ROOT)
    	{
    		decresult = root(dec1, dec2);
    		
    	}
    	else if(oper == Operation.LOG)
    	{
    		decresult =log(dec1, dec2);
    		
    	}
    	return Integer.toString((int) decresult, system);
    	
    }
    
    /**Euler's number e&asymp;2.718281828459045...
     * 
     * Needed for calulating exponent (e<sup>x</sup>)
     * 
     * @since 0.5
     * 
     */
    final public static double e = 2.7182818284590452353602874713526;
    /**&#960; number &#960;&asymp;3.14159265358979...
     * 
     * Needed for calculating radius of a circle and converting degrees to radians and back
     * 
     * @since 0.5
     * 
     */
    final public static double pi = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;
    
    /**Max possible value is (2<sup>31</sup>)-1
     * @since 0.9.9.17
     */
    final public static double max_value = 2147483647;
    /**Minimal possible value is (-2<sup>31</sup>)+1
     * @since 0.9.9.17
     */
    final public static double min_value = max_value*-1;;
    
    /**Positive infinity
     * @since 1.0.0
     */
    final public static double posInf = Double.POSITIVE_INFINITY;
    /**Negative infinity
     * @since 1.0.0
     */
    final public static double negInf = Double.NEGATIVE_INFINITY;
    /**NaN
     * @since 1.0.0
     */
    final public static double NaN = Double.NaN;
    
    /**Eiler's number e&asymp;2.718281828459045...
     * 
     * Needed for calulating exponent (e<sup>x</sup>)
     * 
     * @since 1.5.0
     * 
     */
    final public static double E = 2.7182818284590452353602874713526;
    /**&#960; number &#960;&asymp;3.14159265358979...
     * 
     * Needed for calculating radius of a circle and converting degrees to radians and back
     * 
     * @since 1.5.0
     * 
     */
    final public static double PI = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;
    
    /**Max possible value is (2<sup>31</sup>)-1
     * @since 1.5.0
     */
    final public static double MAX_VALUE = 2147483647;
    /**Minimal possible value is (-2<sup>31</sup>)+1
     * @since 1.5.0
     */
    final public static double MIN_VALUE = max_value*-1;;
    
    /**Positive infinity
     * @since 1.5.0
     */
    final public static double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    /**Negative infinity
     * @since 1.5.0
     */
    final public static double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    
    /**Returns true if n is prime (divides only by n and 1)
     * 
     * @param n number
     * @return boolean
     * 
     * @since 1.0.0
     */
    public static boolean isPrime(int n)
    {
    	if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        int sqrtN = (int)sqrt(n)+1;
        for(int i = 6; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    	
    }
    /**Returns true if n is natural
     * 
     * @param n number
     * @return boolean
     * @since 1.0.0
     */
    public static boolean isNatur(double n)
    {
    	return n==(int)n && n>0;
    	
    }
    /**Returns true if n is finite
     * 
     * @param n number
     * @return boolean
     * @since 1.0.0
     */
    public static boolean isFinite(double n)
    {
    	return !isInfinite(n);
    	
    }
    /**Returns true if n is infinite
     * 
     * @param n number
     * @return boolean
     * @since 1.0.0
     */
    public static boolean isInfinite(double n)
    {
    	return n==Double.POSITIVE_INFINITY || n==Double.NEGATIVE_INFINITY;
    	
    }
    /**Returns true if n is NaN
     * 
     * @param n number
     * @return boolean
     * @since 1.0.0
     */
    public static boolean isNaN(double n)
    {
    	return n==NaN;
    	
    }
    /**Returns true if n is positive
     * 
     * @param n number
     * @return boolean
     * @since 1.0.0
     */
    public static boolean isPos(double n)
    {
    	return n>0;
    	
    }
    /**Returns true if n is negative
     * 
     * @param n number
     * @return boolean
     * @since 1.0.0
     */
    public static boolean isNeg(double n)
    {
    	return n<0;
    	
    }
    
    /**Returns true if n is odd
     * 
     * @param n number
     * @return boolean
     * @since 1.6.0
     */
    public static boolean isOdd(int n)
    {
    	return n%2!=0;
    	
    }
    /**Returns true if n is even
     * 
     * @param n number
     * @return boolean
     * @since 1.6.0
     */
    public static boolean isEven(int n)
    {
    	return n%2==0;
    	
    }
    /**If number is integer returns true else false
     * 
     * @param n number
     * @return boolean
     * @since 1.7.0
     */
    public static boolean isInteger(double n)
    {
    	return n==(int)n;
    	
    }
    /**If min<=num<=max returns true else false
     * 
     * @param min floor of range
     * @param max ceiling of range
     * @param num number
     * @return boolean
     * @since 1.8.0
     */
    public static boolean isInRange(double min, double max, double num)
    {
    	if(max<min)
    		return isInRange(max, min, num);
    	return (num<=max)&&(num>=min);
    	
    }
    /**Copies sign to magnitude
     * 
     * @param magnitude number digits of you get
     * @param sign number sign of you get
     * @return magnitude multiplied to sign's sign
     * @since 1.7.0
     */
    public static double copySign(double magnitude, double sign)
    {
    	if(magnitude==0.0)
    	{
    		return 0;
    		
    	}
    	else if(sign==0.0)
    	{
    		return magnitude;
    		
    	}
    	else if(sgn(magnitude)!=sgn(sign))
    	{
    		return -magnitude;
    		
    	}
    	else return magnitude;
    	
    }
    /**Use it to make custom name for your engine
     * 
     */
    public MyMath()
    {
    	credit();
    	
    }
    
    /*public static void main(String[] args)
    {
    	System.out.println("This program is using MyMath library made by ©JavaGamesJAR (https://github.com/JavaGamesJAR)");
    	
    }*/
    /**Methods needed for proper work of this library
     *    
     * @author JavaGamesJAR
     *
     */
    public static class neededMethods
    {
    	/*public double powplusround(base, power)
    	{
            double 
    		return result;
    		
    	}*/
    	/**Returns down part of fraction (up/down)
    	 * 
    	 * @since 0.9.5
    	 * 
    	 * */
    	public static int fractionDown(double num)
        {

            int result = 0;
            double eatNum = num;

                result=1;

                while(!isInteger(eatNum))
                {
                    eatNum=eatNum*10;
                    result=result*10;

                }

                return result;

            

        }
    	/**Returns upper part of fraction (up/down)
    	 * @param num number
    	 * @since 0.9.5
    	 * @return upper part of fraction
    	 * */
    	public static int fractionUp(double num)
        {
    		double result = 0;
            double eatNum = num;
            
                result=1;

                while(!isInteger(eatNum))
                {
                    eatNum=eatNum*10;
                    result=result*10;

                }

                return (int) eatNum;
                
        }
    	
    	/**Thing needed for ln calculating*/
    	final public static double ln2=0.693147180559945309417; // 0.6931471805
    	
    	/**Needed to make random numbers
    	 * @since 1.6.0
    	 */
    	private static Random randomNumberGenerator;
    	/**Needed to make secure random numbers
    	 * @since 1.8.0
    	 */
    	private static SecureRandom secureRandom;
    	
    	/**Needed to make random numbers
    	 * @since 1.6.0
    	 * @return Random
    	 */
        private static synchronized Random initRNG() {
            Random rnd = randomNumberGenerator;
            return (rnd == null) ? (randomNumberGenerator = new Random()) : rnd;
        }
        /**Needed to make secure random numbers
         * @since 1.8.0
         * @return SecureRandom
         */
        private static synchronized SecureRandom initSRNG()
        {
        	SecureRandom rnd = secureRandom;
        	return (rnd == null) ? (secureRandom = new SecureRandom()) : rnd;
        	
        }
    		
    }

}
