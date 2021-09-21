package JGJAR.libraries.MyMath;

/**<h1>MyMath library</h1>
 * <h2>DoubleFunction</h2><br>
 * @author JavaGamesJAR, website: <a href="http://fedorx.ru/index.php?id=0">fedorx.ru</a>
 * @version 0.7 (MyMath 1.7.0)
 * 
 * An interface to make a function which can pass in methods' parameters
 *
 */
public interface DoubleFunction
{
	/**Sine function
	 * @return execute - sine <br> reversedFunction - arcsine
	 * @since 1.7.0
	 */
	public static DoubleFunction sin = new DoubleFunction() {
		
		@Override
		public double reversedFunction(double x) {
			return MyMath.toRad(MyMath.arcsin(x));
		}
		
		@Override
		public double execute(double x) {
			return MyMath.sin(x,false);
		}
	};
	/**Sine function
	 * @return execute - cosine <br> reversedFunction - arccosine
	 * @since 1.7.0
	 */
	public static DoubleFunction cos = new DoubleFunction() {
		
		@Override
		public double reversedFunction(double x) {
			return MyMath.toRad(MyMath.arccos(x));
		}
		
		@Override
		public double execute(double x) {
			return MyMath.cos(x,false);
		}
	};
	/**What function returns
	 * 
	 * @param x parameter
	 * @return double
	 */
	public abstract double execute(double x);
	
	/**Reversed function
	 * @param x function parameter
	 * @return execute(reversedFunction.execute(x))=x
	 */
	public abstract double reversedFunction(double x);

}
