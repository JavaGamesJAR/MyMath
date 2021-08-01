package JGJAR.libraries.MyMath;

/**
 * <h1>MyMath Complex</h1>
 * Class of Complex numbers
 * @author JavaGamesJAR, website: <a href="http://fedorx.ru/index.php?id=0">fedorx.ru</a>
 * 
 * @version 1.0
 *
 */
public class Complex extends Number
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 478536911151575201L;


	/**Creates new complex number (if imaginary part is 0 your number is rational)
	 * 
	 * @param notImPart not imaginary part
	 * @param ImPart imaginary part
	 * @since 0.5(MyMath 1.0.0)
	 */
	public Complex(double Real, double Imaginary)
	{
		this.Re=Real;
		this.Im=Imaginary;
		
	}
	/**Creates new real number typed as Complex
	 * 
	 * @param n your number
	 * @since 0.9 (MyMath 1.7.0)
	 */
	public Complex(double Real)
	{
		this.Re=Real;
		this.Im=0;
		
	}
	
	/**Just zero
	 * @since 0.5 (MyMath 1.0.0)
	 */
	final public static Complex ZERO = new Complex(0,0);
	/**Just one
	 * @since 0.5 (MyMath 1.0.0)
	 */
	final public static Complex ONE = new Complex(1.0, 0.0);
	/**Just two
	 * @since 0.5 (MyMath 1.0.0)
	 */
	final public static Complex TWO = new Complex(2,0);
	/**imaginary unit (i<sup>2</sup>=-1)
	 * @since 0.5 (MyMath 1.0.0)
	 */
	final public static Complex I = new Complex(0,1);
	/**imaginary minus unit (i<sup>2</sup>=-1)
	 * @since 0.9 (MyMath 1.7.0)
	 */
	final public static Complex MINUS_I = new Complex(0,-1);
	/**NaN
	 * @since 0.7 (MyMath 1.1.0)
	 */
	final public static Complex NaN = new Complex(MyMath.NaN, MyMath.NaN);
	/**
	 * Infinity
	 * @since 0.7 (MyMath 1.1.0)
	 */
	final public static Complex POSITIVE_INFINITY = new Complex(MyMath.posInf, MyMath.posInf);
	/**
	 * &pi;&approx;3.141592653589793238462643383279...
	 * Pi number
	 * @since 0.9 (MyMath 1.7.0)
	 */
	final public static Complex PI = new Complex(Math.PI);
	/**
	 * &pi/2;&approx;1.57079633...
	 * Pi/2 number
	 * @since 0.9 (MyMath 1.7.0)
	 */
	final public static Complex ONE_SECOND_OF_PI = new Complex(Math.PI/2.0, 0);
	/**i/2
	 * @since 0.9 (MyMath.1.7.0)
	 */
	final public static Complex I_TO_TWO = new Complex(0.0, 0.5);
	/**-i/2
	 * @since 0.9 (MyMath.1.7.0)
	 */
	final public static Complex MINUS_I_TO_TWO = new Complex(0.0, -0.5);
	/**Epsilon const for precision
	 * @since 1.0(MyMath 1.8.0)
	 */
	final private static Complex EPS = new Complex(0.000001, 0.0);
	
	/**Complex number - a+bi, where i is a imaginary unit
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public double Re;
	/**Complex number - a+bi, where i is a imaginary unit
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public double Im;
	
	
	/**Returns complex number z<sub>1</sub>+z<sub>2</sub>
	 * 
	 * @param z1 - your number
	 * @param z2 - your number
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public static Complex add(Complex z1, Complex z2)
	{
		Complex result = new Complex(0, 0);
		result = new Complex((z1.Re+z2.Re), (z1.Im+z2.Im));
		
		return result;
		
	}
	/**Adds Complex to your current complex
	 * 
	 * @param n - your number
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public Complex add(Complex n)
	{
		Complex result = new Complex(0, 0);
		result = add(this, n);
				
		return result;
		
	}
	/**Adds double to a complex
	 * 
	 * @param z1 - your Complex
	 * @param z2 - your double
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public static Complex add(Complex z1, double z2)
	{
		Complex result = add(z1, new Complex(z2, 0));
		
		return result;
		
	}
	/**Adds double to your current Complex
	 * 
	 * @param z2 - your double
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public Complex add(double z2)
	{
		Complex result = add(new Complex(z2, 0));
		
		return result;
		
	}
	
	/**Returns Complex f-s
	 * 
	 * @param f - f-s
	 * @param s - f-s
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public static Complex subtract(Complex f, Complex s)
	{
		Complex result = new Complex(f.Re-s.Re,f.Im-s.Im);
		return result;
		
	}
	/**Returns Complex your complex-n
	 * 
	 * @param n - your complex-n
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public Complex subtract(Complex n)
	{
		Complex result = subtract(this,n);
		return result;
		
	}
	/**Returns Complex f-s
	 * 
	 * @param f - f-s
	 * @param s - f-s
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public static Complex subtract(Complex f, double s)
	{
		Complex result = subtract(f,new Complex(s,0));
		return result;
		
	}
	/**Returns Complex your complex-n
	 * 
	 * @param n - your complex-n
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public Complex subtract(double n)
	{
		Complex result = subtract(this,n);
		return result;
		
	}
	
	/**Returns f*s
	 * 
	 * @param f - f*s
	 * @param s - f*s
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public static Complex multiply(Complex f, Complex s)
	{
		/*double x1 = f.Re*s.Re;
		double x2 = f.Im*s.Im;
		double x3 = f.Im*s.Re;
		double x4 = f.Re*s.Im;
		Complex result = new Complex(x1-x2, x3+x4);
		return result;*/
		return new Complex(f.Re*s.Re-f.Im*s.Im, f.Re*s.Im+f.Im*s.Re);
		
	}
	/**Returns this*z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9 (MyMath 1.7.0)
	 */
	/*public Complex multiply(Complex z)
	{
		return multiply(this, z);
		
	}*/
	/**Returns z1/z2
	 * 
	 * @param z1 z1/z2
	 * @param z2 z1/z2
	 * @return Complex
	 * @throws DivideByZeroException if z2=0
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public static Complex divide(Complex z1, Complex z2)
	{
		if(z2.equals(ZERO))
		{
			try {
				throw new DivideByZeroException("Can't divide by 0!", new Throwable("Complex.divide() where divisor=0"));
			} catch (DivideByZeroException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		double re1 = z1.Re*z2.Re+z1.Im*z2.Im;
		double div = z2.Re*z2.Re+z2.Im*z2.Im;
		double re = re1/div;
		
		double im1 = z1.Im*z2.Re-z1.Re*z2.Im;
		double im = im1/div;
		
		Complex res = new Complex(re, im);
		return res;
		
	}
	/**Returns square root of z
     * 
     * @param z - &#8730;z
     * @return &#8730;z
     * @since 0.5 (MyMath 1.0.0)
     */
	public static Complex sqrt(Complex z)
	{
		if(z.Re==-1.0 && z.Im==0.0)
		{
			return I;
			
		}
		/*double gamma = MyMath.sqrt((z.Re+MyMath.sqrt(MyMath.pow(z.Re,2)+MyMath.pow(z.Im,2)))/(2));
		double delta = MyMath.sgn(z.Im)*MyMath.sqrt((-1*z.Re+MyMath.sqrt(MyMath.pow(z.Re,2)+MyMath.pow(z.Im,2))/2));
		Complex result = Complex.ZERO;
		result = new Complex(gamma,delta);
		return result;*/
		return pow(z, new Complex(0.5, 0.0));
		//return root(z, TWO);
		
	}
	/**Returns square root of z
     * 
     * @param z &#8731;z
     * @return &#8731;z
     * @since 0.9 (MyMath 1.7.0)
     */
	public static Complex cbrt(Complex z)
	{
		return pow(z, new Complex(1.0/3.0, 0.0));
		
	}
	/**Returns log<sub>a</sub>b
	 * 
	 * @param a - log<sub>a</sub>b
	 * @param b - log<sub>a</sub>b
	 * @return Complex
	 * @since 0.7 (MyMath 1.1.0)
	 */
	public static Complex log(Complex a, Complex b)
	{
		return divide(ln(b),ln(a));
		
	}
	/**Returns natural logariphm of z ln z
	 * 
	 * @param z - your Complex
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public static Complex ln(Complex z)
	{
		/*if(isReal(z))
		{
			if(z.Re>=0)
			{
				return new Complex(MyMath.ln(z.Re), 0.0);
				
			}
			else
			{
				return new Complex(MyMath.ln(-z.Re), MyMath.PI);
				
			}
			
		}
		double r = abs(z);
		Complex result = new Complex(MyMath.ln(r), Arg(z));
		
		return result;*/
		return new Complex(Math.log(z.abs()), z.Arg());
		
	}
	/**Returns argument of z (atan2((Im(z), Re(z)))
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9 (MyMath 1.7.0)
	 */
	public static double Arg(Complex z)
	{
		double res = Math.atan2(z.Im, z.Re);
		//double res = Math.asin(z.Im/z.abs());
		return res;
		
	}
	/**Returns argument of your Complex (let it be z) (atan2((Im(z), Re(z)))
	 * 
	 * @return Complex
	 * @since 0.9 (MyMath 1.7.0)
	 */
	public double Arg()
	{
		return Arg(this);
		
	}
	/**Returns exponent of your Complex (e<sup>z</sup>) with Euler formula (e<sup>a+bi</sup> = e<sup>a</sup>(cos b + isin b))
	 * 
	 * @param z your Complex
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public static Complex exp(Complex z)
	{
		/*if(z.Re==0)
		{
			return new Complex(-MyMath.cos(z.Im, false), MyMath.sin(z.Im, false));
			
		}*/
		Complex result = Complex.ZERO;
		double e = Math.exp(z.Re);
		result = new Complex(e*Math.cos(z.Im), e*Math.sin(z.Im));
		
		return result;
		
	}
	/**Returns a<sup>b</sup>
	 * 
	 * @param a a<sup>b</sup>
	 * @param b a<sup>b</sup>
	 * @return Complex
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public static Complex pow(Complex a, Complex b)
	{
		Complex result = Complex.ZERO;
		
		result = exp(multiply(ln(a),b));
		
		return result;
		
	}
	/**Returns <sup>n</sup>&#8730;x
	 * 
	 * @param x - <sup>n</sup>&#8730;x
	 * @param n - <sup>n</sup>&#8730;x
	 * @return Complex
	 * @since 0.7 (MyMath 1.1.0)
	 */
	public static Complex root(Complex x, Complex n)
	{
		return pow(x, divide(ONE,n));
		
	}
	/**Returns tetration (hyperoperator-4) <sup>b</sup>a or a&uarr;&uarr;b
	 * 
	 * @param a <sup>b</sup>a
	 * @param b <sup>b</sup>a
	 * @return tetration
	 * @since 1.0(MyMath 1.8.0)
	 */
	/*public static Complex tetration(Complex a, Complex b)
	{
		/*if(isReal(b))
		{
			if(MyMath.isInteger(b.doubleValue()))
			{
				Complex result = b;
				for(int i = 1; i<b.doubleValue(); i++)
	        	{
	        		result = pow(a, result);
	        		
	        	}
				return result;
				
			}
			
		}
		Complex r = Complex.ZERO;
		r = Complex.multiply(Complex.subtract(b, Complex.ONE), Complex.ln(a));
		r = Complex.exp(r);
		r = Complex.ln(r);
		r = Complex.multiply(r, a);
		r = Complex.exp(r);
		return r;*//*
		return pow(a, pow(a, subtract(b, ONE)));
		
	}*/
	/**Returns absolute value of z |z|
	 * 
	 * @param z
	 * @return &radic;(Re(z)<sup>2</sup>+Im(z)<sup>2</sup>)
	 * @since 0.9 (MyMath 1.7.0)
	 */
	public static double abs(Complex z)
	{
		double re = z.Re*z.Re;
		double im = z.Im*z.Im;
		return MyMath.sqrt(re+im);
		
	}
	/**Returns absolute value of your Complex
	 * 
	 * @return Complex
	 * @since 0.9 (MyMath 1.7.0)
	 * @see abs
	 */
	public double abs()
	{
		return abs(this);
		
	}
	/**Returns Greatest common divisor of a and b
	 * 
	 * @param a Complex
	 * @param b Complex
	 * @return Complex 
	 * @since 
	 */
	/*public static Complex gcd(Complex a, Complex b)
	{
	    	while (!equals(a, b)) {
	        	if(isMore(a,b))
	                a = subtract(a,b);
	            else
	            	b = subtract(b,a);
	        }
	    	
	    	return b;
	    	
	    
		
	}*/
	/**Returns sine of z (in radians)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex sin(Complex z)
	{
		/*if(z.Im==0)
		{
			return new Complex(exp(new Complex(0, z.Re)).Im, 0);
			
		}
		else if(z.Re==0)
		{
			return new Complex(0, MyMath.sinh(z.Im));
			
		}
		else
		{*/
		return new Complex(Math.sin(z.Re)*MyMath.cosh(z.Im), Math.cos(z.Re)*MyMath.sinh(z.Im));
			
		//}
		/*Complex sh = sinh(new Complex(-z.Im, z.Re));
		Complex res = divide(sh,i);
		//return res;
		
		return res;*/
		/*if(z.Re==0)
		{
			return multiply(i, sinh(z));
			
		}
		return NaN;*/
		/*Complex res = Complex.zero;
		for(int n=0;n<75;n++)
		{
			Complex top = new Complex(MyMath.pow(-1.0, n),0);
			Complex bottom = new Complex(MyMath.fact(2*n+1), 0);
			Complex multiplier = pow(z, new Complex(2*n+1, 0));
			Complex adder = multiply(divide(top, bottom), multiplier);
			res = Complex.add(res, adder);
			
		}
		return res;*/
		
	}
	/**Returns cosine of z (in radians)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex cos(Complex z)
	{
		Complex arg = subtract(ONE_SECOND_OF_PI, z);
		return sin(arg);
		
	}
	/**Returns tangent of z (in radians)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex tan(Complex z)
	{
		return divide(sin(z), cos(z));
		
	}
	/**Returns cotangent of z (in radians)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex cot(Complex z)
	{
		return divide(cos(z), sin(z));
		
	}
	/**Returns cotangent of z (in radians)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex sec(Complex z)
	{
		return divide(ONE, cos(z));
		
	}
	/**Returns cotangent of z (in radians)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex csc(Complex z)
	{
		return divide(ONE, sin(z));
		
	}
	/**Returns arcsine of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex asin(Complex z)
	{
		/*if(z.Re==1 && z.Im==0)
		{
			return ONE_SECOND_OF_PI;
			
		}
		else if(z.Re==0.5 && z.Im==0)
		{
			return new Complex(MyMath.PI/6.0, 0);
			
		}
		else if(z.Re==Math.sqrt(0.5) && z.Im==0)
		{
			return new Complex(MyMath.PI/4.0, 0);
			
		}
		else if(z.Re==Math.sqrt(0.75) && z.Im==0)
		{
			return new Complex(MyMath.PI/3.0, 0);
			
		}
		else if(z.Re==Math.sqrt(0.75) && z.Im==0)
		{
			return new Complex(MyMath.PI/3.0, 0);
			
		}
		else if(z.Re==0 && z.Im==0)
		{
			return ZERO;
			
		}
		else if(z.Re<0 && z.Im==0)
		{
			return negate(asin(new Complex(abs(z), 0.0)));
			
		}
		/*if(isReal(z) && z.Re<=1.0 && z.Re>=-1.0)
		{
			return new Complex(MyMath.toRad(MyMath.arcsin(z.Re)));
			
		}*/
		/*Complex iz = multiply(I, z);
		Complex sqrt1subz2 = sqrt(subtract(ONE, multiply(z, z)));
		Complex arg = add(iz, sqrt1subz2);
		Complex mylog = ln(arg);
		Complex res = multiply(MINUS_I, mylog);
		return res;*/
		/*Complex res = Complex.multiply(I, ln(subtract(sqrt(Complex.subtract(ONE, Complex.multiply(z, z))), z.inverse())));
		return res;*/
		/*if(isReal(z))
		{
			if(z.Re<=1.0 || z.Re>=-1.0)
			{
				return new Complex(MyMath.arcsin(z.Re), 0.0);
				
			}
			
		}*/
		/*Complex res = atan(divide(z, sqrt(subtract(ONE, pow(z, TWO)))));
		return res;*/
		//return new Complex(MyMath.round(res.Re, 10), MyMath.round(res.Im, 10));
		return Complex.multiply(I, ln(subtract(sqrt(subtract(ONE,multiply(z, z))),multiply(z,I))));
		
	}
	/**Returns arccosine of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex acos(Complex z)
	{
		return subtract(ONE_SECOND_OF_PI, asin(z));
		
	}
	/**Returns arctangent of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex atan(Complex z)
	{
		/*if(isReal(z))
		{
			return new Complex(MyMath.toRad(MyMath.arctan(z.Re)), 0.0);
			
		}*/
		if(z.Re==1.0 && z.Im==0.0)
		{
			return new Complex(MyMath.PI/4.0);
			
		}
		Complex one = new Complex(1.0, 0.0);
		Complex lntop = Complex.add(one, z.inverse());
		Complex lnbottom = Complex.add(one, z.inverse().negate());
		Complex ln = ln(divide(lntop,lnbottom));
		Complex res = Complex.multiply(MINUS_I_TO_TWO, ln);
		return res;
		
	}
	/**Returns arccotangent of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex acot(Complex z)
	{
		if(z.equals(ZERO))
		{
			return ONE_SECOND_OF_PI;
			
		}
		else
			return Complex.divide(ONE, atan(z));
		
	}
	/**Returns arcsecant of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex asec(Complex z)
	{
		return acos(Complex.divide(ONE, z));
		
	}
	/**Returns arccosecant of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex acsc(Complex z)
	{
		return asin(Complex.divide(ONE, z));
		
	}
	/**Returns hyperbolic sine of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex sinh(Complex z)
	{
		Complex exp1 = exp(z);
		Complex exp2 = divide(ONE, exp1);
		Complex top = subtract(exp1, exp2);
		Complex res = divide(top, new Complex(2, 0));
		return res;
		
	}
	/**Returns hyperbolic cosine of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex cosh(Complex z)
	{
		Complex exp1 = exp(z);
		Complex exp2 = divide(ONE, exp1);
		Complex top = add(exp1, exp2);
		Complex res = divide(top, new Complex(2, 0));
		return res;
		
	}
	/**Return hyperbolic tangent of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex tanh(Complex z)
	{
		Complex exp0 = exp(multiply(z,new Complex(2.0)));
		Complex up = subtract(exp0, ONE);
		Complex down = add(exp0, ONE);
		return divide(up, down);
		
	}
	/**Return hyperbolic cotangent of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex coth(Complex z)
	{
		Complex exp0 = exp(multiply(z,new Complex(2.0)));
		Complex down = subtract(exp0, ONE);
		Complex up = add(exp0, ONE);
		return divide(up, down);
		
	}
	/**Returns hyperbolic secant of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex sech(Complex z)
	{
		return divide(ONE, cosh(z));
		
	}
	/**Returns hyperbolic cosecant of z
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex csch(Complex z)
	{
		return divide(ONE, sinh(z));
		
	}
	
	/**Returns area-sine (inversed hyperbolic sine)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex asinh(Complex z)
	{
		return ln(add(z, sqrt(add(multiply(z, z), ONE))));
		
	}
	/**Returns area-cosine (inversed hyperbolic cosine)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex acosh(Complex z)
	{
		return ln(add(z, sqrt(subtract(multiply(z, z), ONE))));
		
	}
	/**Returns area-tangent (inversed hyperbolic tangent)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex atanh(Complex z)
	{
		return ln(divide(sqrt(subtract(ONE, multiply(z, z))),subtract(ONE, z)));
		
	}
	/**Returns area-cotangent (inversed hyperbolic cotangent)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex acoth(Complex z)
	{
		return ln(divide(sqrt(subtract(multiply(z, z), ONE)),subtract(z, ONE)));
		
	}
	/**Returns area-secant (inversed hyperbolic secant)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex asech(Complex z)
	{
		return acosh(divide(ONE, z));
		
	}
	/**Returns area-cosecant (inversed hyperbolic cosecant)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex acsch(Complex z)
	{
		return asinh(divide(ONE, z));
		
	}
	
	/*
	 * <br/>gd x =<sub>0</sub>&int;<sup>x</sup><table>
	 * <tr><td>dt</td></tr>
	 * <tr><td>cosh t</td></tr>
	 * </table>*/
	/**Returns Guderman function
	 * <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/3a54bc66004f8f6afcbee890ad3e0e84226094ec"/>
	 * <br/><strong>or</strong><br/>
	 * <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/5fdd9cc8886b981e0795486a56bcce2ab42822d1"/>
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex gd(Complex z)
	{
		return asin(tanh(z));
		
	}
	/**Returns Anti-Guderman function<br/>
	 * <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/4807d18c79bbb802973e0f4699b1279262600d0e"/>
	 * @param z Complex
	 * @return Complex
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Complex arcgd(Complex z)
	{
		return ln(Complex.add(tan(z), sec(z)));
		
	}
	
	/**Returns -z
	 * 
	 * @param z Complex
	 * @return -z
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex negate(Complex z)
	{
		return new Complex(-z.Re, -z.Im);
		
	}
	/**Returns -z
	 * 
	 * @return -z
	 * @since 1.0(MyMath 1.8.0)
	 */
	public Complex negate()
	{
		return negate(this);
		
	}
	/**Returns conjugated number to z (x+yi=z x-yi is conjugated number)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex conjugate(Complex z)
	{
		return new Complex(z.Re, -z.Im);
		
	}
	/**Returns conjugated number to z (x+yi=z x-yi is conjugated number)
	 * 
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public Complex conjugate()
	{
		return conjugate(this);
		
	}
	/**Return inversed number to z (x+yi=z y+xi is inversed number to z)
	 * 
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public Complex inverse()
	{
		return inverse(this);
		
	}
	/**Return inversed number to z (x+yi=z y+xi is inversed number to z)
	 * 
	 * @param z Complex
	 * @return Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex inverse(Complex z)
	{
		/*return new Complex(z.Im, z.Re);*/
		return multiply(z, MINUS_I).conjugate();
		
	}
	/**Returns zeros of function using Newton's tangent method
	 * 
	 * @param x0 first approximation
	 * @param f your function
	 * @param df derivative of function
	 * @return x, where f(x)=0
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Complex NewtonNull(Complex x0, ComplexFunction f, ComplexFunction df)
	{
		Complex x1 = ZERO;
		while(f.execute(x1).equals(ZERO))
		{
			x1 = subtract(x0, divide(f.execute(x0), df.execute(x0)));
			x0 = x1;
			
		}
		return x0;
		
	}
	/**Returns zeros of function using Newton's tangent method
	 * 
	 * @param x0 first approximation
	 * @param f your function
	 * @return x, where f(x)=0
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Complex NewtonNull(Complex x0, ComplexFunction f)
	{
		Complex x1 = x0;
		Complex x2 = ZERO;
		ComplexFunction df = derivative(f);
		while(f.execute(x1).equals(ZERO))
		{
			x2 = subtract(x1, divide(f.execute(x1), df.execute(x1)));
			x1 = new Complex(x2.Re, x2.Im);
			
		}
		return x1;
		
	}
	/**Returns Lambert W function (W(x)e<sup>W(x)</sup> = x)
	 * 
	 * @param z argument of function
	 * @return W(z)
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Complex LambertW(Complex z)
	{
		/*double w = 0;
    	for(int i = 0; i<100; i++)
    	{
    		double wTimesExpW = w*exp(w);
    		double wPlusOneTimesExpW = (w+1.0)*exp(w);
    		w-=(wTimesExpW-z)/(wPlusOneTimesExpW-w-2.0)*(wTimesExpW - z)/(2.0*w+2.0);
    		
    	}
    	return w;*/
		/*Complex w = ZERO;
		for(int i = 0; i<100; i++)
		{
			Complex wexpw = multiply(w, exp(w));
			Complex wplus1expw = multiply(add(w, ONE), exp(w));
			w = divide(divide(subtract(wexpw, z), multiply(subtract(subtract(wplus1expw, w), TWO), subtract(wexpw, z))), add(multiply(TWO, w), TWO));
			
		}
		return w;*/
		ComplexFunction f = new ComplexFunction() {
			
			@Override
			public Complex reversed(Complex x) {return null;}
			
			@Override
			public Complex execute(Complex x) {return subtract(productLog(x), z);}
		};
		ComplexFunction df = new ComplexFunction() {
			
			@Override
			public Complex reversed(Complex x) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Complex execute(Complex x) {
				Complex exp = exp(x);
				return add(exp, multiply(x, exp));
			}
		};
		return NewtonNull(new Complex(1, 1), f, df);
		
	}
	/**Returns xe<sup>x</sup>
	 * 
	 * @param z argument
	 * @return ze<sup>z</sup>
	 * @since 1.0 (MyMath 1.8.0)
	 */
	private static Complex productLog(Complex z)
	{
		return multiply(z, exp(z));
		
	}
	/**Returns derivative of a function
	 * 
	 * @param f function
	 * @return f'(x)
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static ComplexFunction derivative(ComplexFunction f)
	{
		return new ComplexFunction() {
			
			@Override
			public Complex reversed(Complex x) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Complex execute(Complex x) 
			{
				return divide(subtract(f.execute(add(x, EPS)), f.execute(x)), EPS);
			}
		};
		
	}
	/**Returns Fibonacci numbers F<sub>z</sub>
	 *  with analytic continuation of Binet formula<br/>
	 *  <img src = "https://wikimedia.org/api/rest_v1/media/math/render/svg/da0d8154648fdc8c68374763d87fcef6af886551"/>
	 * 	<br/><strong>where</strong><br/>
	 * 	&phi;&asymp;1.61803399
	 * @param z F<sub>z</sub>
	 * @return Fibonacci number F<sub>z</sub>
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Complex Fibonacci(Complex z)
	{
		Complex f = new Complex(0.44721359549995793928183473374625, 0.0);
		Complex fi = new Complex(1.6180339887498948482045868343657, 0.0);
		Complex fiToZ = Complex.pow(fi, z);
		Complex s = Complex.subtract(fiToZ, Complex.divide(Complex.cos(Complex.multiply(PI, z)), fiToZ));
		if(isReal(z))
		{
			if(MyMath.isInteger(z.doubleValue()))
			{
				//return MyMath.Fibonacci(z.Re);
				return new Complex(MyMath.round(Complex.multiply(f, s).Re));
				
			}
			
		}
		return Complex.multiply(f, s);
		
	}
	/**Logs str to console
	 * 
	 * @param str String
	 * @since 1.0 (MyMath 1.8.0)
	 */
	private static void log(String str)
	{
		System.out.println(str);
		
	}
	/**Parses Complex from String
	 * 
	 * @param str String
	 * @return Complex
	 * @throws NumberFormatException if str isn't a number
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Complex parseComplex(String str)
	{
		str.trim();
		
		if(str=="i")
		{
			return I;
			
		}
		/*else if(str=="-i");
		{
			return MINUS_I;
			
		}*/
		else
		{
		int z = str.indexOf("i");
		if(z<0)
		{
			return new Complex(Double.parseDouble(str), 0.0);
			
		}
		
		else
		{
			StringBuilder sb = new StringBuilder(str);
			String s = sb.reverse().toString();
			/*int sign = s.indexOf("-");
			if(sign<0)
			{
				sign = s.indexOf("+");
				
			}
			double im = Double.parseDouble(str.substring(sign, i-1));
			double re = Double.parseDouble(str.substring(0, sign-1));
			return new Complex(re, im);*/
			char ch;
			boolean prevdigit = false;
			String res = "";
			char[] c = str.toCharArray();
			double re = 0;
			int endReIndex = 0;
			for(int i=0;i<str.length();i++)
			{
				if(((c[i]=='+' || c[i]=='-' || c[i]==' ') && (prevdigit)))
				{
					//str = str.substring(0, i);
					re = Double.parseDouble(res);
					endReIndex = i;
					break;
				} 
				
				
				prevdigit = !(c[i]=='+' || c[i]=='-' || c[i]==' ');
				res+=c[i];
				
			}
			double im = 0.0;
			if(str.substring(endReIndex, str.length())=="i")
			{
				im = 1.0;
				
			}
			/*else if(str.substring(endReIndex, str.length()).trim()=="-i")
			{
				im = -1.0;
				
			}*/
			else
			{
				im = Double.parseDouble(str.substring(endReIndex, str.length()-1));
				
			}
			
			if(res.isEmpty())
			{
				return new Complex(0.0, im);
				
			}
			else
			{
				return new Complex(re, im);
				
			}
			
		}}
		
	}
	/**Returns sum of n elements starting from k-th of function(n)
	 * 
	 * @param n number of iterations
	 * @param k starting iteration
	 * @param f function
	 * @return &sum;f(n)
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Complex sum(int n, int k, ComplexFunction f)
	{
		Complex res = new Complex(0.0, 0.0);
		
		for(int i = k; i<=n; i++)
		{
			res = Complex.add(res, f.execute(new Complex(i,0.0)));
			
		}
		return res;
		
	}
	/**Returns square of x
	 * 
	 * @param x Complex
	 * @return x<sup>2</sup>
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Complex sqr(Complex x)
	{
		return multiply(x, x);
		
	}
	public static Complex zeta(Complex s)
	{
		if(isReal(s))
		{
			return new Complex(MyMath.RiemannZeta(s.Re), 0.0);
			
		}
		Complex res = ONE;
    	{
    		for(int i = 0; i<MyMath.primeNums.length; i++)
    		{
    			res = divide(res, subtract(ONE, pow(new Complex(MyMath.primeNums[i],0.0), multiply(s, new Complex(-1.0, 0.0)))));
    			
    		}
    		
    	}
    	return res;
		
	}
	/**Returns Pi function of z 
	 * 
	 * <h3>&Pi;(z) = <sub>0</sub>&int;<sup>&infin;</sup>x<sup>z</sup>e<sup>-x</sup>dx</h3>
	 * 
	 * @param z argument
	 * @return z!
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Complex factorial(Complex z)
	{
		if(isReal(z))
		{
			return new Complex(MyMath.fact(z.doubleValue()), 0.0);
			
		}
		else
		{
			double a = z.Re;
			double b = z.Im;
			DoubleFunction f1 = new DoubleFunction() {
				
				@Override
				public double reversedFunction(double n) {
					return 0.0;
				}
				
				@Override
				public double execute(double n) {
					double f = MyMath.ln(n);
					double s = a*MyMath.ln(1+1/n);
					double t = MyMath.ln((n+a)*(n+a)+b*b)/2.0;
					return f+s-t;
					
				}
			};
			DoubleFunction f2 = new DoubleFunction() {
				
				@Override
				public double reversedFunction(double x) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public double execute(double n) {
					double f = b*MyMath.ln(1+1/n);
					double s = 2*MyMath.arctan(b/(n+a+MyMath.sqrt((n+a)*(n+a)+b*b)));
					return f-s;
				}
			};
			int k = 10000;
			double sum1 = MyMath.sum(k, 1, f1);
			double sum2 = MyMath.sum(k, 1, f2);
			double esum1 = MyMath.exp(sum1);
			double Re = esum1*MyMath.cos(sum2, false);
			double Im = esum1*MyMath.sin(sum2, false);;
			
			return new Complex(Re, Im);
			
		}
		
	}
	/**Returns true if a=b
	 * 
	 * @param a Complex
	 * @param b Complex
	 * @return boolean
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static boolean equals(Complex a, Complex b)
	{
		if(a.Re==b.Re && a.Im==b.Im)
		{
			return true;
			
		}
		else return false;
		
	}
	/**Returns true if z is a real number
	 * 
	 * @param z Complex
	 * @return boolean
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static boolean isReal(Complex z)
	{
		if(z.Im==0.0)
		{
			return true;
			
		}
		else return false;
		
	}
	/**Returns true if z is an imaginary number
	 * 
	 * @param z Complex
	 * @return boolean
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static boolean isImaginary(Complex z)
	{
		if(z.Re==0.0 && z.Im!=0.0)
		{
			return true;
			
		}
		else return false;
		
	}
	
	
	@Override
	/**If b=0 return a else 0
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public double doubleValue() {
		if(this.Im==0)
		{
			return this.Re;
			
		}
		else
		{
			try {
				throw new ReturnsComplexException("Your number has imaginary part!", new Throwable("doubleValue(z) where !Complex.isReal(z)"), true, true);
			} catch (ReturnsComplexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return (int) MyMath.NaN;
	}
	@Override
	/**If b=0 return a else 0
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public float floatValue() {
		if(this.Im==0)
		{
			return (float) this.Re;
			
		}
		else
		{
			try {
				throw new ReturnsComplexException("Your number has imaginary part!", new Throwable("floatValue(z) where !Complex.isReal(z)"), true, true);
			} catch (ReturnsComplexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return (float) MyMath.NaN;
	}
	@Override
	/**If b=0 return a else 0
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public int intValue() {
		if(this.Im==0)
		{
			return (int) this.Re;
			
		}
		else
		{
			try {
				throw new ReturnsComplexException("Your number has imaginary part!", new Throwable("intValue(z) where !Complex.isReal(z)"), true, true);
			} catch (ReturnsComplexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return (int) MyMath.NaN;
		
	}
	@Override
	/**If b=0 return a else 0
	 * @since 0.5 (MyMath 1.0.0)
	 */
	public long longValue() {
		if(this.Im==0)
		{
			return (long) this.Re;
			
		}
		else
		{
			try {
				throw new ReturnsComplexException("Your number has imaginary part!", new Throwable("longValue(z) where !Complex.isReal(z)"), true, true);
			} catch (ReturnsComplexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return (int) MyMath.NaN;
	}
	/**Converts Complex to string
	 * @since 0.9 (MyMath 1.7.0)
	 */
	@Override
	public String toString()
	{
		/*String str = "";
		if(this.Im==1 && this.Re!=1 && this.Re!=0)
		{
			str=this.Re+"+i";
			
		}
		else if(this.Im==-1 && this.Re!=0)
		{
			str=this.Re+"-i";
			
		}
		else if(this.Im==1 && this.Re==0)
		{
			str="i";
			
		}
		else if(this.Im==-1 && this.Re==0)
		{
			str="-i";
			
		}
		else if(this.Im==1 && this.Re==1)
		{
			str=this.Re+"+i";
			
		}
		else if(this.Im<0 && this.Re!=0)
		{
			str = this.Re+""+this.Im+"i";
			
		}
		else if(this.Im>0 && this.Re!=0)
		{
			str = this.Re+"+"+this.Im+"i";
			
		}
		else if(this.Im==0 && this.Re!=0)
		{
			str = this.Re+"";
			
		}
		else if(this.Im!=0 && this.Re==0)
		{
			str = this.Im+"i";
			
		}
		else if(this.Im==0 && this.Re==0)
		{
			str = "0";
			
		}
		
		return str;*/
		String str = "";
		if(isReal(this))
		{
			str = this.Re+"";
			
		}
		else if(isImaginary(this))
		{
			if(this.Im==1.0)
			{
				str = "1i";
				
			}
			else if(this.Im==-1.0)
			{
				str = "-1i";
				
			}
			else if(this.Im<0)
			{
				str = "-"+(-this.Im)+"i";
				
			}
			else
				str = ""+this.Im+"i";
			
		}
		else
		{
			if(this.Im==1.0)
			{
				str = this.Re+"+"+"1i";
				
			}
			else if(this.Im==-1.0)
			{
				str = this.Re+"-"+"1i";
				
			}
			else if(this.Im<0.0)
			{
				str = this.Re+"-"+(-this.Im)+"i";
				
			}
			else if(this.Im>0)
			{
				str = this.Re+"+"+(this.Im)+"i";
				
			}
			
		}
		return str;
		
	}
	/**If z equals to your Complex returns true
	 * 
	 * @param z Complex
	 * @return boolean
	 * @since 0.9(MyMath 1.7.0)
	 */
	public boolean equals(Complex z)
	{
		if(this.Re==z.Re && this.Im==z.Im) return true;
		else return false;
		
	}
	/**Returns random Complex number where Real and Imaginary parts are between 0.0 and 1.0
	 * 
	 * @return random Complex
	 * @since 0.9(MyMath 1.7.0)
	 */
	public static Complex random()
	{
		return new Complex(MyMath.random(), MyMath.random());
		
	}
	/**Returns Complex number with random real and imaginary parts in range
	 * 
	 * @param RealMin
	 * @param RealMax
	 * @param ImMin
	 * @param ImMax
	 * @return Complex
	 * @since 1.0.0 (MyMath 1.8.0)
	 */
	public static Complex random(double RealMin, double RealMax, double ImMin, double ImMax)
	{
		return new Complex(MyMath.random(RealMin, RealMax), MyMath.random(ImMin, ImMax));
		
	}
	/**Returns Complex number with absolutely random real and imaginary
	 * 
	 * @return Complex
	 * @since 1.0.0 (MyMath 1.8.0)
	 */
	public static Complex AbsRandom()
	{
		return random(MyMath.MIN_VALUE, MyMath.MAX_VALUE, MyMath.MIN_VALUE, MyMath.MAX_VALUE);
		
	}
	
}
