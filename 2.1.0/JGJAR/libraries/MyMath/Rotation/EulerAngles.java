package JGJAR.libraries.MyMath.Rotation;

import static JGJAR.libraries.MyMath.MyMath.*;
import JGJAR.libraries.MyMath.linearAlgebra.Matrix;
import JGJAR.libraries.MyMath.vectors.Vector;
/**<h1>MyMath EulerAngles</h1>
 * Class for Euler angles
 * @author JavaGamesJAR
 * @since MyMath 2.0.0
 * @version 1.0
 *
 */
public class EulerAngles 
{
	public EulerAngles(double alpha, double beta, double gamma)
	{
		this.a = alpha;
		this.b = beta;
		this.g = gamma;
		this.fullRot = Matrix.multiply(Rz(g), Matrix.multiply(Rx(b), Rz(a)));
		
	}
	double a, b, g;
	Matrix fullRot;
	private Matrix Rz(double a)
	{
		double cosa = cos(a, false);
		double sina = sin(a, false);
		double c[][] = new double[3][3];
		c[0][0] = cosa;
		c[1][0] = -sina;
		c[2][0] = 0;
		c[0][1] = sina;
		c[1][1] = cosa;
		c[2][1] = 0;
		c[0][2] = 0;
		c[1][2] = 0;
		c[2][2] = 1;
		return new Matrix(c);
		
	}
	private Matrix Rx(double a)
	{
		double cosa = cos(a, false);
		double sina = sin(a, false);
		double c[][] = new double[3][3];
		c[0][0] = 1;
		c[1][0] = 0;
		c[2][0] = 0;
		c[0][1] = 0;
		c[1][1] = cosa;
		c[2][1] = -sina;
		c[0][2] = sina;
		c[1][2] = cosa;
		c[2][2] = 1;
		return new Matrix(c);
		
	}
	public Vector toVector()
	{
		double x = cos(a, false)*cos(b, false);
		double y = sin(b, false);
		double z = sin(a, false)*cos(b, false);
		
		return new Vector(x, y, z);
		
	}
	public Vector toVector(double abs)
	{
		return Vector.multiply(toVector(), abs);
		
	}

}
