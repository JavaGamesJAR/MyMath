using System;

namespace MyMath.Calculus
{
	public class Limit
	{
		public Limit(Func<double, double> f, double a, double dx)
		{
			this.f = f;
			this.a = a;
			this.dx = dx;

		}
		public double a, dx;
		public Func<double, double> f;

		public double Apply()
		{
			return (f(a + dx) + f(a - dx)) / 2.0;

		}

	}

}
