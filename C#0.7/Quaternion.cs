using System;

namespace MyMath.Complex
{
	public class Quaternion
	{
		/******************************
         * 
         * Constructors
         *
         ******************************/
		public Quaternion(double x, double y, double z, double w)
		{
			this.a = x;
			this.b = y;
			this.c = z;
			this.d = w;

		}
		//Components
		public double a, b, c, d;

		/******************************
         * 
         * Constants
         *
         ******************************/
		public static readonly Quaternion ONE = new Quaternion(1, 0, 0, 0);
		public static readonly Quaternion I = new Quaternion(0, 1, 0, 0);
		public static readonly Quaternion J = new Quaternion(0, 0, 1, 0);
		public static readonly Quaternion K = new Quaternion(0, 0, 0, 1);
		/******************************
         * 
         * Basic stuff
         *
         ******************************/
		public static Quaternion Add(Quaternion q1, Quaternion q2)
        {
			return new Quaternion(q1.a + q2.a, q1.b + q2.b, q1.c + q2.c, q1.d + q2.d);

        }
		public static Quaternion Subtract(Quaternion q1, Quaternion q2)
		{
			return new Quaternion(q1.a - q2.a, q1.b - q2.b, q1.c - q2.c, q1.d - q2.d);

		}
		public static Quaternion Multiply(Quaternion q1, Quaternion q2)
		{
			double w = q1.a * q2.a - q1.b * q2.b - q1.c * q2.c - q1.d * q2.d;
			double x = q1.a * q2.b + q1.b * q2.a + q1.c * q2.d - q1.d * q2.c;
			double y = q1.a * q2.c - q1.b * q2.d + q1.c * q2.a + q1.d * q2.b;
			double z = q1.a * q2.d + q1.b * q2.c - q1.c * q2.b + q1.d * q2.a;

			return new Quaternion(w, x, y, z);

		}
		public Quaternion Mult(double s)
        {
			return new Quaternion(a * s, b * s, c * s, d * s);

        }
		public static Quaternion Divide(Quaternion q1, Quaternion q2)
        {
			Quaternion qConj = Conjugate(q2);
			double den = AbsSqr(q2);

			return Multiply(q1, qConj).Mult(1 / den);

        }
		public static Quaternion Conjugate(Quaternion q)
        {
			return new Quaternion(q.a, -q.b, -q.c, -q.d);

        }
		/******************************
         * 
         * Vector properties
         *
         ******************************/
		public static double AbsSqr(Quaternion q)
        {
			return q.a * q.a + q.b * q.b + q.c * q.c + q.d * q.d;

        }
		public static double Abs(Quaternion q)
        {
			return MyMath.Sqrt(AbsSqr(q));

        }
		public static double Arg(Quaternion q)
        {
			return MyMath.Arccos(q.a/Abs(q));

        }
		public static Quaternion Exp(Quaternion q)
		{
			Quaternion q1 = new Quaternion(MyMath.Exp(q.a), 0, 0, 0);
			Quaternion q2 = new Quaternion(MyMath.Cos(q.b), MyMath.Sin(q.b), 0, 0);
			Quaternion q3 = new Quaternion(MyMath.Cos(q.c), 0, MyMath.Sin(q.c), 0);
			Quaternion q4 = new Quaternion(MyMath.Cos(q.d), 0, 0, MyMath.Sin(q.d));

			Quaternion q5 = Multiply(q1, q2);
			Quaternion q6 = Multiply(q5, q3);
			Quaternion q7 = Multiply(q6, q4);

			return q7;

		}

	}

}

