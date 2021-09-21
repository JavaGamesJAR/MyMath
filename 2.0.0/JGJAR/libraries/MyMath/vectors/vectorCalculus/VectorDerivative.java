package JGJAR.libraries.MyMath.vectors.vectorCalculus;

import JGJAR.libraries.MyMath.vectors.Vector;
import JGJAR.libraries.MyMath.vectors.VectorFunction;

public class VectorDerivative 
{
	static double eps = 0.000001;
	public static VectorFunction easyDerivativeX(VectorFunction f)
	{
		return new VectorFunction() {
			
			@Override
			public Vector apply(Vector a) {
				return Vector.multiply(Vector.subtract(f.apply(Vector.add(a, new Vector(eps, 0, 0))), f.apply(a)), 1/eps);
			}
		};
		
	}
	public static VectorFunction easyDerivativeY(VectorFunction f)
	{
		return new VectorFunction() {
			
			@Override
			public Vector apply(Vector a) {
				return Vector.multiply(Vector.subtract(f.apply(Vector.add(a, new Vector(0, eps, 0))), f.apply(a)), 1/eps);
			}
		};
		
	}
	public static VectorFunction easyDerivativeZ(VectorFunction f)
	{
		return new VectorFunction() {
			
			@Override
			public Vector apply(Vector a) {
				return Vector.multiply(Vector.subtract(f.apply(Vector.add(a, new Vector(0, 0, eps))), f.apply(a)), 1/eps);
			}
		};
		
	}

}
