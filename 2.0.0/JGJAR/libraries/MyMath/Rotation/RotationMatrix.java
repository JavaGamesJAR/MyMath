package JGJAR.libraries.MyMath.Rotation;

import JGJAR.libraries.MyMath.complex.Quaternion;
import JGJAR.libraries.MyMath.linearAlgebra.Matrix;
/**<h1>MyMath RotationMatrix</h1>
 * Class for matrix of rotation
 * @author JavaGamesJAR
 * @since MyMath 2.0.0
 * @version 1.0
 *
 */
public class RotationMatrix extends Matrix
{
	private RotationMatrix(double[][] c) 
	{
		super(c);
		
	}
	public RotationMatrix(double alpha, double beta, double gamma)
	{
		super(new EulerAngles(alpha, beta, gamma).fullRot.c);
		
	}
	public RotationMatrix(Quaternion q)
	{
		super(null);
		double w = q.a, x = q.b, y = q.c, z = q.d;
		double[][] c = {{1-2*y*y-2*z*z, 2*x*y+2*z*w, 2*x*z-2*y*w},
					{2*x*y-2*z*w, 1-w*x*x-2*z*z, 2*y*z+2*x*w},
					{1-2*x*x-2*y*y}};
		new RotationMatrix(c);
		
	}
	public Matrix toMatrix()
	{
		return this;
		
	}
	public String toString()
	{
		return this.toMatrix().toString();
		
	}
	

}
