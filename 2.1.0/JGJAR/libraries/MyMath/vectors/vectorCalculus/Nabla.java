package JGJAR.libraries.MyMath.vectors.vectorCalculus;

import JGJAR.libraries.MyMath.vectors.Vector;
import JGJAR.libraries.MyMath.vectors.VectorFunction;

/**<h1>Nabla class</h1>
 * 
 * @author JavaGamesJAR
 * @version 1.0
 * @since 2.0.0
 *
 */
public class Nabla 
{
	/**Returns curl (&nabla;&Cross;v) of a function
	 * 
	 * @param f function
	 * @return curl f
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public static VectorFunction curl(VectorFunction f)
	{
		VectorFunction x = new VectorFunction() {
			
			@Override
			public Vector apply(Vector a) {
				return Vector.VectorProduct(f.apply(a), Vector.I);
			}
		};
		VectorFunction y = new VectorFunction() {
			
			@Override
			public Vector apply(Vector a) {
				return Vector.VectorProduct(f.apply(a), Vector.J);
			}
		};
		VectorFunction z = new VectorFunction() {
			
			@Override
			public Vector apply(Vector a) {
				return Vector.VectorProduct(f.apply(a), Vector.K);
			}
		};
		VectorFunction dx = VectorDerivative.easyDerivativeX(x);
		VectorFunction dy = VectorDerivative.easyDerivativeY(y);
		VectorFunction dz = VectorDerivative.easyDerivativeZ(z);
		
		return new VectorFunction() {
			
			@Override
			public Vector apply(Vector a) {
				return Vector.add(dx.apply(a), dy.apply(a), dz.apply(a));
			}
		};
		
	}
	/**Returns divergence (&nabla;&sdot;v) of a function
	 * 
	 * @param f function
	 * @return div f
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public static ScalarAtPointFunction div(VectorFunction f)
	{
		final ScalarAtPointFunction x = new ScalarAtPointFunction() {
			
			@Override
			public double apply(Vector a) {
				return f.apply(a).x;
			}
		};
		final ScalarAtPointFunction y = new ScalarAtPointFunction() {
			
			@Override
			public double apply(Vector a) {
				return f.apply(a).y;
			}
		};
		final ScalarAtPointFunction z = new ScalarAtPointFunction() {
			
			@Override
			public double apply(Vector a) {
				return f.apply(a).z;
			}
		};
		return new ScalarAtPointFunction() {
			
			@Override
			public double apply(Vector a) {
				return ScalarAtPointFunction.derivX(x).apply(a)+
						ScalarAtPointFunction.derivY(y).apply(a)+ScalarAtPointFunction.derivZ(z).apply(a);
			}
		};
		
	}
	/**Returns gradient (&nabla;&phi;) of a function
	 * 
	 * @param f function
	 * @return grad f
	 * @since 1.0 (MyMath 2.0.0)
	 */
	public static VectorFunction grad(ScalarAtPointFunction f)
	{
		return new VectorFunction() {
			
			@Override
			public Vector apply(Vector a) {
				return new Vector(ScalarAtPointFunction.derivX(f).apply(a), 
						ScalarAtPointFunction.derivY(f).apply(a), ScalarAtPointFunction.derivZ(f).apply(a));
			}
		};
		
	}

}
