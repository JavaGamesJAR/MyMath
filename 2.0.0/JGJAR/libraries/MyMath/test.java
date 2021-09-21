package JGJAR.libraries.MyMath;

import JGJAR.libraries.MyMath.Random.NormalDistribution;
import JGJAR.libraries.MyMath.Random.NormalDistribution2D;
import JGJAR.libraries.MyMath.Rotation.RotationMatrix;
import JGJAR.libraries.MyMath.calculus.Function2D;
import JGJAR.libraries.MyMath.calculus.Limit;
import JGJAR.libraries.MyMath.calculus.Sum;
import JGJAR.libraries.MyMath.vectors.Vector;
import JGJAR.libraries.MyMath.vectors.VectorFunction;
import JGJAR.libraries.MyMath.vectors.vectorCalculus.Nabla;
import JGJAR.libraries.MyMath.vectors.vectorCalculus.ScalarAtPointFunction;
import JGJAR.libraries.MyMath.linearAlgebra.Matrix;

public class test {
	public static double floor(double number)
    {
    	int xi = (int)number;
		return number < xi ? xi - 1 : xi;
    	
    }

	public static void main(String[] args) 
	{
		/*for(int i = 0; i<10; i++)
		{
			System.out.println(MyMath.random()+" "+MyMath.secureRandom());
			
		}*/
		/*String n1 = "11";
		String n2 = "1001";
		Operation oper = Operation.MULTIPLY;
		System.out.println(MyMath.nonDecOperations(n1, n2, 2, oper)+" "+MyMath.BinToDec(n1)+" "+MyMath.BinToDec(n2)+" "+MyMath.BinToDec(MyMath.nonDecOperations(n1, n2, 2, oper)));*/
		//Complex z = new Complex(-2, 0.0);
		//String str = "0.5";
		//System.out.println(Complex.asin(z)+" "+Complex.divide(new Complex(-2.94419, -0.01961), new Complex(2, 0))+" "+Complex.tan(new Complex(1.4720985468699563, -0.009805178288320357)));
		//str.indexOf("/");
		//ComplexFormat cf = new ComplexFormat();
		//Complex.parseComplex("5.0+1.0i");
		//System.out.println(Math.sqrt(-1.0));
		//System.out.println(Complex.LambertW(new Complex(-MyMath.pi/2.0, 0.0)));
		//System.out.println(MyMath.LambertW(-Math.PI/2.0));
		//System.out.println(Complex.productLog(Complex.multiply(Complex.I, Complex.ONE_SECOND_OF_PI)));
		//System.out.println(Complex.tetration(Complex.TWO, Complex.TWO));

		/*double[] c = {1.0, 1.0, 35.0, 10};
		
		Polynomial p = new Polynomial(c);
		
		System.out.println(p.toString());
		
		p.derivative();
		
		System.out.println(p);
		
		p.integrate(1.0);
		
		System.out.println(p);*/
		
		//https://www.desmos.com/calculator/upsvecyoyw  approx arctg x
		
		/*LinearCongruentRandom rng = new LinearCongruentRandom(Long.MAX_VALUE/100, 10, 1, Integer.MAX_VALUE);
		
		for(int i = 0; i<25; i++)
		{
			System.out.println(rng.next());
			
		}
		System.out.println(MyMath.pow(3, 5));*/
		
		/*double[] c = {2.0, 3.0, 4.0};
		
		Polynomial p = new Polynomial(c);
		
		System.out.println(p);
		
		p.derivative();
		
		System.out.println(p);
		
		p.integrate(17.0);
		
		System.out.println(p);*/
		/*Monomial m = new Monomial(1, 2);
		
		m.integrate(0.0);
		
		System.out.println(m);*/
		/*double[][] c = {{10.0, 1.0, 0.0},{3.0, 5.0, 6.7},{100.3, 5.3, 12.23}};
		Matrix A = new Matrix(c);
		double[][] b = {{12.0, 124.0, 124.0},{1.0, 214.0, 7325.0},{10.0, 35.0, 98.0}};
		Matrix B = new Matrix(b);
		System.out.println(A+"\n");
		System.out.println(B+"\n");
		//System.out.println(Matrix.UnitMatrix(3));
		System.out.println(Matrix.multiply(A, A));*/
		/*ArrayList<Double> primes = new ArrayList<Double>();
		int i = 3;
		while(primes.size()<168)
		{
			if(MyMath.isPrime(i))
			{
				primes.add((double)i);
				
			}
			i++;
			
		}
		*/
		/*MyMath.calculatePrimes(50000);
		String res = "{2.0";
		
		for(int j = 1; j < MyMath.primeNums.length; j++)
		{
			res+=", "+MyMath.primeNums[j];
			
		}
		res+="};";*/
		//System.out.println(res);
		/*Complex s = new Complex(-5.0, MyMath.pi/MyMath.ln(5.0));
		System.out.println(Complex.zeta(s));
		*/
		/*double[][] c1= {{1.0, 2.0, 3.0},{2.0, 3.0, 1.0},{3.0, 2.0, 1.0}};
		Matrix B = Matrix.UnitMatrix(2);
		System.out.println(Matrix.det(B));*/
		/*double[][] c = {{3.0, 2.0},{2.0, 3.0}};
		Matrix A = new Matrix(c);
		Matrix B = Matrix.adj(A);
		System.out.println(Matrix.multiply(B, 1/*//*Matrix.det(A)*//*));*/
		
		//Quaternion q = new Quaternion(1, 2, 3, 4);
		//System.out.println(Complex.sqrt(Complex.I));
		
		/*double test = 3;
		long startMath = System.nanoTime();
		double a = Math.pow(test, 1);
		long durationMath = System.nanoTime()-startMath;
		
		long startMyMath = System.nanoTime();
		a = MyMath.fastpow(test, 1);
		long durationMyMath = System.nanoTime()-startMyMath;
		
		System.out.println("Standart: "+durationMath+"ns");
		System.out.println("My: "+durationMyMath+"ns");
		System.out.println(a);*/
		
		//System.out.println(MyMath.inverseInt(1));
		
		//Performance test
		
		/*DoubleFunction f1 = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return Math.exp(x);
			}
		};
		DoubleFunction f2 = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return MyMath.exp(x);
			}
		};
		double arg = /*MyMath.random(Double.MIN_VALUE, Double.MAX_VALUE)*/ /*MyMath.random(-10, 3.0);
		PerformanceTest t1 = new PerformanceTest(f1, TimeUnits.NANOSECOND), t2 = new PerformanceTest(f2, TimeUnits.NANOSECOND);
		System.out.println("Math: "+t1.test(arg)+" ns");
		System.out.println(f1.execute(arg));
		
		System.out.println("MyMath: "+t2.test(arg)+" ns");
		System.out.println(f2.execute(arg));
		
		System.out.println("Argument: "+arg);*/
		
		//Taylor Series test
		
		/*DoubleFunction f = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return MyMath.cos(x);
			}
		};
		Polynomial p = Polynomial.TaylorSeries(f, 5);
		System.out.println(p);*/
		//System.out.println((int)Double.POSITIVE_INFINITY);
		/*Function2D f = new Function2D() {
			
			@Override
			public double apply(double x, double y) {
				return 1/MyMath.pow(y, x);
			}
		};
		Sum s = new Sum(f, 1, 100000);
		
		System.out.println(s.apply(2)*6);*/
		/*DoubleFunction f = new DoubleFunction() {
			
			@Override
			public double reversedFunction(double x) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public double execute(double x) {
				return MyMath.sin(x)/x;
			}
		};
		Limit lim = new Limit(f, 0, 0.000000001);
		System.out.println(lim.apply());*/
		/*Vector v = new Vector(1, 0, 0);
		RotationMatrix A = new RotationMatrix(MyMath.PI/2, 0, MyMath.pi/2);*/
		/*Matrix A = Matrix.UnitMatrix(2);
		A = Matrix.multiply(A, 2);*/
		/*MyMath.sgn(0);
		double[][] c = {{0, 1},{1, 0}};
		Matrix A = new Matrix(c);
		System.out.println(A);
		System.out.println(Matrix.exp(A, 1000));*/
		/*double[] mu = {5, 5};
		double[] c = {1, 1};
		NormalDistribution2D normDist = new NormalDistribution2D(mu, c);
		NormalDistribution norm = new NormalDistribution(5, 5);
		/*try
		{
			System.out.println(normDist.get());
			
		}
		catch(StackOverflowError e){}*//*
		for(int i = 0; i<100; i++)
		{
			System.out.println(normDist.get());
			
		}*/
		ScalarAtPointFunction gradTest = new ScalarAtPointFunction() {
			
			@Override
			public double apply(Vector a) {
				return Vector.ScalarProduct(a, new Vector(1, MyMath.ln(a.x), 1));
			}
		};
		VectorFunction grad = Nabla.grad(gradTest);
		System.out.println(grad.apply(Vector.I));
		
	}

}
