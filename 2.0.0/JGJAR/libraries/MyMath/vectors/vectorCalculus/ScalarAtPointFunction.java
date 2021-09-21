package JGJAR.libraries.MyMath.vectors.vectorCalculus;

import JGJAR.libraries.MyMath.vectors.Vector;

public interface ScalarAtPointFunction 
{
	static double eps = 0.000001;
	public abstract double apply(Vector a);
	
	public static ScalarAtPointFunction derivX(ScalarAtPointFunction f)
	{
		return new ScalarAtPointFunction() {
			
			@Override
			public double apply(Vector a) {
				Vector add = new Vector(eps, 0, 0);
				double y1 = f.apply(Vector.add(a, add));
				double y0 = f.apply(Vector.subtract(a, add));
				double dy = y1-y0;
				return dy/(2*eps);
			}
		};
		
	}
	public static ScalarAtPointFunction derivY(ScalarAtPointFunction f)
	{
		return new ScalarAtPointFunction() {
			
			@Override
			public double apply(Vector a) {
				Vector add = new Vector(0, eps, 0);
				double y1 = f.apply(Vector.add(a, add));
				double y0 = f.apply(Vector.subtract(a, add));
				double dy = y1-y0;
				return dy/(2*eps);
			}
		};
		
	}
	public static ScalarAtPointFunction derivZ(ScalarAtPointFunction f)
	{
		return new ScalarAtPointFunction() {
			
			@Override
			public double apply(Vector a) {
				Vector add = new Vector(0, 0, eps);
				double y1 = f.apply(Vector.add(a, add));
				double y0 = f.apply(Vector.subtract(a, add));
				double dy = y1-y0;
				return dy/(2*eps);
			}
		};
		
	}

}
