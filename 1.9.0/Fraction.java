package JGJAR.libraries.MyMath;


/**Fraction class needed for MyMath work
 * 
 * @author JavaGamesJAR
 * @version 1.0
 *
 */
public class Fraction extends Number
{
	/**Creates new Fraction
	 * 
	 * @param up - numinator of fraction
	 * @param down - down part of fraction
	 */
	public Fraction(int up, int down)
	{
		if(down==0)
		{
			this.den = (int) MyMath.NaN;
			this.num = (int) MyMath.NaN;
			
		}
		else if(up==0)
		{
			this.num=0;
			this.den=1;
			
		}
		else
		{
			int gcd = MyMath.gcd(up, down);
			this.num = up/gcd;
			this.den = down/gcd;
			
		}
		
		
	}
	/**Creates new Fraction
	 * 
	 * @param num number you make Fraction
	 * @since 0.8.5 (MyMath 1.2.0)
	 */
	public Fraction(double num)
	{
		int up = MyMath.neededMethods.fractionUp(num);
		int down = MyMath.neededMethods.fractionDown(num);
		
		if(MyMath.sgn(down)==0)
		{
			this.num = (int) MyMath.NaN;
			this.den = (int) MyMath.NaN;
			
		}
		else if(MyMath.sgn(up)==0)
		{
			this.num=0;
			this.den=1;
			
		}
		else
		{
			this.num = up/MyMath.gcd(up, down);
			this.den = down/MyMath.gcd(up, down);
		
		}
		
	}
	
	/**Upper and down parts of your fraction
	 * 
	 */
	public int num;

	public int den;
	
	/**0/1
	 * @since 0.5 (MyMath 0.9.9.35)
	 */
	public final static Fraction zero = new Fraction(0, 1);
	/**0/1
	 * @since 0.9 (MyMath 1.6.0)
	 */
	public final static Fraction ZERO = zero;
	/**1/1
	 * @since 0.9 (MyMath 1.6.0)
	 */
	public final static Fraction one = new Fraction(1,1);
	/**1/1
	 * @since 0.9 (MyMath 1.6.0)
	 */
	public final static Fraction ONE = one;
	/**103993/33102
	 * @since 0.9 (MyMath 1.6.0)
	 */
	public final static Fraction pi = new Fraction(103993,33102);
	/**103993/33102
	 * @since 0.9 (MyMath 1.6.0)
	 */
	public final static Fraction PI = pi;
	
	/**Your fraction+number
	* 
	* @param number new fraction
	* @return Fraction
	* @since 0.5 (MyMath 0.9.9.35)
	*/
	protected Fraction add(Fraction number)
	{
		Fraction result = number;
		
		int lcm = MyMath.lcm(result.den, this.den);
		
		result.num *=lcm;
		this.num *=lcm;
		result.den = lcm;
		this.den = lcm;
		
		result.num = result.num+num;
		
		return result;
		
	}
	/**Your fraction-number
	 * 
	 * @param number new fraction
	 * @return Fraction
	 * @since 0.5 (MyMath 0.9.9.35)
	 */
	protected Fraction subtract(Fraction number)
	{
		Fraction result = number;
		
		int lcm = MyMath.lcm(result.den, this.den);
		
		result.num *=lcm;
		num *=lcm;
		result.den = lcm;
		den = lcm;
		result.num = this.num-result.num;
		
		return result;
		
	}
	/**Your fraction*number
	 * 
	 * @param number new fraction
	 * @since 1.6.0
	 * @return Fraction
	 */
	protected Fraction multiply(Fraction number)
	{
		return Fraction.multiply(this, number);
		
	}
	/**Your fraction/number
	 * 
	 * @param number new fraction
	 * @since 1.6.0
	 * @return Fraction
	 */
	protected Fraction divide(Fraction number)
	{
		return Fraction.divide(this, number);
		
	}
	/**Adds number2 to number1
	 * 
	 * @param number1 Fraction
	 * @param number2 Fraction
	 * @return Fraction
	 * @since 1.6.0
	 */
	public static Fraction add(Fraction number1, Fraction number2)
	{
		number1.add(number2);
		return number1;
		
	}
	/**Subtracts number2 from number1
	 * 
	 * @param number1 Fraction
	 * @param number2 Fraction
	 * @return Fraction
	 * @since 1.6.0
	 */
	public static Fraction subtract(Fraction number1, Fraction number2)
	{
		number1.subtract(number2);
		return number1;
		
	}
	/**Your fraction*number
	 * 
	 * @param number1 Fraction
	 * @param number2 Fraction
	 * @return Fraction
	 * @since 0.5 (MyMath 0.9.9.35)
	 */
	public static Fraction multiply(Fraction number1, Fraction number2)
	{
		Fraction result = new Fraction(number2.num*number1.num, number2.den*number1.den);
		
		return result;
		
	}
	/**Your fraction/number
	 * 
	 * @param number1 Fraction
	 * @param number2 Fraction
	 * @return Fraction
	 * @since 0.5 (MyMath 0.9.9.35)
	 */
	public static Fraction divide(Fraction number1, Fraction number2)
	{
		Fraction result = new Fraction(number2.den, number2.num);
		result = multiply(number1, new Fraction(number2.num, number2.den));
		
		return result;
		
	}
	
	/**Returns a<sup>b</sup>
	 * 
	 * @param a - a<sup>b</sup>
	 * @param b - a<sup>b</sup>
	 * @return Fraction
	 * @since 0.6 (MyMath 1.0.0)
	 */
	public Fraction pow(Fraction a, Fraction b)
	{
		if(b.num==1)
		{
			return new Fraction(MyMath.root(a.doubleValue(), b.den));
			
		}
		else if(b.num==0) return Fraction.ONE;
		Fraction result = MyMath.toFraction(MyMath.pow(a.doubleValue(), b.doubleValue()));
		return result;
		
	}
	/**Returns <sup>n</sup>&#8730;a
	 * 
	 * @param a - <sup>n</sup>&#8730;a
	 * @param n - <sup>n</sup>&#8730;a
	 * @return Fraction
	 * @since 0.6 (MyMath 1.0.0)
	 */
	public static Fraction root(Fraction a, Fraction n)
	{
		Fraction result = MyMath.toFraction(MyMath.root(a.doubleValue(), n.doubleValue()));
		return result;
		
	}
	/**Returns square root of x
     * 
     * @param a
     * @return &#8730;a
     * @since 0.6 (MyMath 1.0.0)
     */
	public static Fraction sqrt(Fraction a)
	{
		return root(a, new Fraction(2,1));
		
	}
	/**Returns cube root of x
     * 
     * @param a
     * @return 	&#8731;a
     * @since 0.6 (MyMath 1.0.0)
     */
	public static Fraction cbrt(Fraction a)
	{
		return root(a, new Fraction(3,1));
		
	}
	/**Returns natural logariphm of a
	 * 
	 * @param a - Fraction
	 * @return Fraction
	 * @since 0.8 (MyMath 1.1.0)
	 */
	public static Fraction ln(Fraction a)
	{
		Fraction result = new Fraction(MyMath.ln(a.num)-MyMath.ln(a.den))/*MyMath.toFraction(MyMath.ln(a.doubleValue()))*/;
		return result;
		
	}
	/**Returns log<sub>base</sub>result
	 * 
	 * @param base - base of the log
	 * @param result - result of power
	 * @return Fraction
	 * @since 0.9 (MyMath 1.2.0)
	 */
	public static Fraction log(Fraction base, Fraction result)
	{
		Fraction power = ZERO/*ln(result)*/;
		power = divide(ln(result), base);
		return power;
		
	}
	
	/**Parses Fraction from String
	 * 
	 * @param str String
	 * @return Fraction
	 * @since 1.0(MyMath 1.8.0)
	 */
	public static Fraction parseFraction(String str)
	{
		int div = str.indexOf("/");
		if(div==-1)
		{
			try {
				throw new FractionFormatException("Symbol \"/\" doesn't exist in your String!", 
				new Throwable("Fraction.parseFraction(String str), str doesn't have / symbol"));
			} catch (FractionFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		int n = Integer.parseInt(str.substring(0, div));
		int d = Integer.parseInt(str.substring(div+1, str.length()));
		return new Fraction(n, d);
		
	}

	/**Converts Fraction into double
	 * @since 0.5 (MyMath 0.9.9.35)
	 */
	@Override
	public double doubleValue() {
		double num1=this.num;
		double den1 = this.den;
		return num1/den1;
	}
	/**Converts Fraction into float
	 * @since 0.5 (MyMath 0.9.9.35)
	 */
	@Override
	public float floatValue() {
		float num1=this.num;
		float den1 = this.den;
		return (num1/den1);
	}
	/**Converts Fraction into int
	 * @since 0.5 (MyMath 0.9.9.35)
	 */
	@Override
	public int intValue() {
		return this.num/this.den;
	}
	/**Converts Fraction into long
	 * @since 0.5 (MyMath 0.9.9.35)
	 */
	@Override
	public long longValue() {
		return this.num/this.den;
	}
	/**Converts fraction to String
	 * @return Fraction.num"/"Fraction.den
	 */
	@Override
	public String toString()
	{
		return this.num+"/"+this.den;
		
	}
	
	
}
