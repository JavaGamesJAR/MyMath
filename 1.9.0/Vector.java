package JGJAR.libraries.MyMath;

/**<h1>MyMath Vector</h1>
 * 
 * Class of Vectors
 * @author JavaGamesJAR
 * @version 1.0
 * @since MyMath 1.8.0
 *
 */
public class Vector 
{
	/**Vector constructor
	 * 
	 * @param x component
	 * @param y component
	 * @param z component
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public Vector(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	//Components
	double x, y, z;
	
	/**Length of vector
	 * 
	 * @return |v|
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public double abs()
	{
		return MyMath.sqrt(x*x+y*y+z*z);
		
	}
	/**Adds two vectors
	 * 
	 * @param a first vector
	 * @param b second vector
	 * @return a+b
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Vector add(Vector a, Vector b)
	{
		return new Vector(a.x+b.x, a.y+b.y, a.z+b.z);
		
	}
	/**Subtracts two vectors
	 * 
	 * @param a first vector
	 * @param b second vector
	 * @return a-b
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Vector subtract(Vector a, Vector b)
	{
		return new Vector(a.x-b.x, a.y-b.y, a.z-b.z);
		
	}
	/**Multiplies two vectors to scalar
	 * 
	 * @param a first vector
	 * @param b second vector
	 * @return a*b
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static double ScalarProduct(Vector a, Vector b)
	{
		return a.x*b.x+a.y*b.y+a.z*b.z;
		
	}
	/**Multiplies two vectors
	 * 
	 * @param a first vector
	 * @param b second vector
	 * @return [a&times;b]
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Vector VectorProduct(Vector a, Vector b)
	{
		return new Vector(a.y*b.z-a.z*b.y, a.z*b.z-a.z*b.z, a.x*b.y-a.y*b.x);
		
	}
	/**Multiplies three vectors to scalar
	 * 
	 * @param a first vector
	 * @param b second vector
	 * @param c third vector
	 * @return a*[b&times;c]
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static double MixedProduct(Vector a, Vector b, Vector c)
	{
		return ScalarProduct(a, VectorProduct(b, c));
		
	}
	/**Multiplies vector by scalar
	 * 
	 * @param a vector
	 * @param b scalar
	 * @return a*b
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static Vector multiply(Vector a, double b)
	{
		return new Vector(a.x*b, a.y*b, a.z*b);
		
	}
	/**Squares vector to scalar
	 * 
	 * @param a vector
	 * @return a*a
	 * @since 1.0 (MyMath 1.8.0)
	 */
	public static double ScalarSqr(Vector a)
	{
		return a.x*a.x+a.y*a.y+a.z*a.z;
		
	}

}
