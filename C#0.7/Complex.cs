using System;
using MyMath;

namespace MyMath.Complex
{
	public class Complex
	{
		public Complex(double a, double b)
		{
			this.Re = a;
			this.Im = b;

		}
		public double Re, Im;
		public static readonly Complex One = new Complex(1, 0);
		public static readonly Complex I = new Complex(0, 1);
		public static readonly Complex Zero = new Complex(0, 0);
		/******************************
         * 
         * Some vector properties
         *
         ******************************/
		public double Arg()
        {
			return MyMath.Atan2(Im, Re);

        }
		public double AbsSqr()
        {
			return Re * Re + Im * Im;

        }
		public double Abs()
        {
			return MyMath.Sqrt(AbsSqr());

        }
		/******************************
         * 
         * Basic Operations
         *
         ******************************/
		public static Complex Add(Complex a, Complex b)
		{
			return new Complex(a.Re + b.Re, a.Im + b.Im);

		}
		public Complex Add(Complex z)
		{
			return new Complex(this.Re + z.Re, this.Im + z.Im);

		}
		public static Complex Subtract(Complex a, Complex b)
		{
			return new Complex(a.Re - b.Re, a.Im - b.Im);

		}
		public Complex Subtract(Complex z)
		{
			return new Complex(this.Re - z.Re, this.Im - z.Im);

		}
		public static Complex Mult(Complex a, Complex b)
		{
			return new Complex(a.Re * b.Re - a.Im * b.Im, a.Re * b.Im + a.Im * b.Re);

		}
		public Complex Mult(Complex z)
		{
			return new Complex(this.Re * z.Re - this.Im * z.Im, this.Re * z.Im + this.Im * z.Re);

		}
		public Complex Mult(double s)
        {
			return new Complex(this.Re*s, this.Im*s);

        }
		public static Complex Inverse(Complex z)
		{
			double aSqr = z.Re * z.Re + z.Im * z.Im;
			return new Complex(z.Re / aSqr, -z.Im / aSqr);

		}
		public static Complex Divide(Complex a, Complex b)
		{
			return Complex.Mult(a, Inverse(b));

		}
		public Complex Divide(Complex z)
		{
			return this.Mult(Inverse(z));

		}
		/******************************
         * 
         * Pow, Roots & Logs
         *
         ******************************/
		public static Complex Exp(Complex z)
		{
			double exp = MyMath.Exp(z.Re);
			return new Complex(exp * MyMath.Cos(z.Im), exp * MyMath.Sin(z.Im));

		}
		public static Complex Ln(Complex z)
        {
			return new Complex(MyMath.Ln(z.AbsSqr())/2, z.Arg());

        }
		public static Complex Log(Complex z, Complex baseOfLog)
        {
			return Ln(z).Divide(Ln(baseOfLog));

        }
		public static Complex Pow(Complex z0, Complex z1)
        {
			return Complex.Exp(z1.Mult(Ln(z0)));

        }
		public static Complex Root(Complex z0, Complex z1)
        {
			return Pow(z0, Inverse(z1));
			
        }
		public static Complex Sqrt(Complex z)
        {
			return Pow(z, new Complex(0.5, 0));

        }
		public static Complex Cbrt(Complex z)
		{
			return Pow(z, new Complex(1.0/3.0, 0));

		}
		/******************************
         * 
         * Special Functions
         *
         ******************************/
		public static Complex LambertW(Complex x0, Complex z)
        {
			Complex y0 = x0;
			Complex y1 = y0.Add(One);
			double eps = 0.0000001;

			while(y0.Subtract(y1).AbsSqr()>eps)
            {
				y0 = y1;
				y1 = y0.Subtract(y0.Divide(y0.Add(One)));
				y1 = y1.Add(z.Divide(y0.Add(One).Mult(Exp(y0))));

            }
			return y1;

        }
		public static Complex LambertW(Complex z)
        {
			return LambertW(Zero, z);

        }
		public static Complex Gamma(Complex z, int k)
        {
			Complex res = Ln(z).Mult(-1);

			for(int i = 0; i<k; i++)
            {
				res = res.Add(z.Mult(MyMath.Ln(1+1.0d/i)));
				res = res.Subtract(Ln(Add(One, z.Mult(1.0d/i))));

            }
			res = Exp(res);
			return res;

        }
		public static Complex Factorial(Complex z, int k)
        {
			return Gamma(z.Add(One), k);

        }

	}

}

