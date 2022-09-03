package JGJAR.libraries.MyMath.vectors;

import JGJAR.libraries.MyMath.MyMath;

/**<h1>MyMath Vector2</h1>
 * 
 * Class of 2D Vectors
 * @author JavaGamesJAR
 * @version 1.0
 * @since MyMath 2.0.0
 *
 */
public class Vector2 
{
	/**Constructor
	 * 
	 * @param x component
	 * @param y component
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public Vector2(double x, double y)
	{
		this.x = x;
		this.y = y;
		
	}
	public double x, y;
	
	/**Adds two vectors
	 * 
	 * @param a Vector2
	 * @param b Vector2
	 * @return a+b
	 * @since 1.0 (MyMath 2.0.0) 
	 */
	public static Vector2 add(Vector2 a, Vector2 b)
	{
		return new Vector2(a.x+b.x, a.y+b.y);
		
	}
	/**Subtracts two vectors
	 * 
	 * @param a Vector2
	 * @param b Vector2
	 * @return a-b
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public static Vector2 subtract(Vector2 a, Vector2 b)
	{
		return new Vector2(a.x-b.x, a.y-b.y);
		
	}
	/**Multiplies vector by scalar
	 * 
	 * @param a Vector2
	 * @param s scalar
	 * @return a*s
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public static Vector2 mult(Vector2 a, double s)
	{
		return new Vector2(a.x*s, a.y*s);
		
	}
	/**Multiplies two vectors to a scalar
	 * 
	 * @param a Vector2
	 * @param b Vector2
	 * @return a*b
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public static double scalarProduct(Vector2 a, Vector2 b)
	{
		return a.x*b.x+a.y*b.y;
		
	}
	public double abs()
	{
		return MyMath.sqrt(x*x+y*y);
		
	}
	/**Converts vector to a String
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public String toString()
	{
		return "("+x+"; "+y+")";
		
	}
	public Vector toVector()
	{
		return new Vector(x, y, 0);
		
	}
	/**Converts String to Vector2
	 * 
	 * @param s String
	 * @return Vector2 in String
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public static Vector2 parseVector2(String s)
	{
		s = s.replaceAll("(", "");
		s = s.replaceAll(")", "");
		s = s.trim();
		String[] cs = s.split(";");
		return new Vector2(Double.parseDouble(cs[0]), Double.parseDouble(cs[1]));
		
	}

}
