package JGJAR.libraries.MyMath.vectors;

import JGJAR.libraries.MyMath.MyMath;
import JGJAR.libraries.MyMath.Rotation.EulerAngles;
import JGJAR.libraries.MyMath.linearAlgebra.Matrix;

/**<h1>MyMath Vector</h1>
 * 
 * Class of Vectors
 * @author JavaGamesJAR
 * @version 1.1
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
	public Vector(double alpha, double beta)
	{
		EulerAngles ea = new EulerAngles(alpha, beta, 0);
		Vector a = ea.toVector();
		this.x = a.x;
		this.y = a.y;
		this.z = a.z;
		
	}
	//Components
	public double x, y, z;
	
	public final static Vector I = new Vector(1, 0, 0), J = new Vector(0, 1, 0), K = new Vector(0, 0, 1);
	
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
	public static Vector add(Vector a, Vector b, Vector c)
	{
		return new Vector(a.x+b.x+c.x, a.y+b.y+c.y, a.z+b.z+c.z);
		
	}
	/**Gets direction of vector (Vector with magnitude = 1 and parallel to a)
	 * 
	 * @param a Vector
	 * @return dir(a)
	 * @since 1.1 (MyMath 2.0.0)
	 */
	public static Vector direction(Vector a)
	{
		return Vector.multiply(a, 1/a.abs());
		
	}
	/**Gets direction of vector (Vector with magnitude = 1 and parallel to a)
	 * 
	 * @return dir(a)
	 * @since 1.1 (MyMath 2.0.0)
	 */
	public Vector direction()
	{
		return direction(this);
		
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
	public Matrix toMatrix()
	{
		double[][] c = {{x},{y},{z}};
		return new Matrix(c);
		
	}
	/**Converts Vector to String
	 * @since 1.1 (MyMath 2.0.0)
	 */
	public String toString()
	{
		return "("+x+"; "+y+"; "+z+")";
		
	}
	/**Parses Vector from String
	 * 
	 * @param s String
	 * @return Vector
	 * @since 1.1 (MyMath 2.0.0)
	 */
	public static Vector parseVector(String s)
	{
		s = s.replaceAll("(", "");
		s = s.replaceAll(")", "");
		s = s.trim();
		
		String[] compsStr = s.split(";");
		
		double[] c = new double[3];
		
		for(int i = 0; i<3; i++)
			c[i] = Double.parseDouble(compsStr[i]);
		
		return new Vector(c[0], c[1], c[2]);
		
	}

}
