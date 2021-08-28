using System;

namespace MyMath
{
    public class MyMath
    {
        /******************************
         * 
         * Constants
         *
         ******************************/
        public static readonly double PI = 3.1415926535897932384626433832;
        public static readonly double E = 2.718281828459045;
        public static readonly double Ln2 = 0.6931471805599453094172321214581765680755001343602552541206800094;
        public static readonly double Ln5 = 1.6094379124341003746007593332261876395256013542685177219126478914;
        public static readonly double Ln10 = Ln2 + Ln5;
        public static readonly double Sqrt2 = 1.4142135623730950488016887242096980785696718753769480731766797379;
        public static readonly double NaN = Double.NaN;
        /******************************
         * 
         * Some basic stuff
         *
         ******************************/
        public static int Sgn(double x)
        {
            return (x == NaN || x == 0.0) ? (int)x : (2 * RawSgn(x) - 1);

        }
        private static int RawSgn(double x)
        {
            return 1-(int)((uint)x>>31 & 1);

        }
        public static double Abs(double x)
        {
            return x >= 0 ? x : -x;

        }
        public static int Factorial(int x)
        {
            if (x < 0)
                return x % 2 == 0 ? Int32.MinValue : Int32.MaxValue;
            else
            {
                int res = 1;
                for (int i = 2; i <= x; i++)
                {
                    res *= i;

                }
                return res;

            }


        }

        public static int Gcd(int x, int y)
        {
            while (x != y)
            {
                if (x > y)
                    x -= y;
                else
                    y -= x;

            }
            return x;

        }
        public static int Lcm(int x, int y)
        {
            return x * y / Gcd(x, y);

        }
        /******************************
         * 
         * Integer converters
         *
         ******************************/
        public static int Floor(double x)
        {
            int xi = (int)x;
            return xi > x ? xi - 1 : xi;

        }
        public static int Round(double x)
        {
            return (int)x;

        }
        public static double Round(double x, int save)
        {
            int exp10 = (int)FastPow(10, save);
            return (int)(x * exp10) / (exp10 * 1.0d);

        }
        public static int Ceil(double x)
        {
            int xi = (int)x;
            return xi < x ? xi + 1 : xi;

        }

        public static int[] ToFraction(double n)
        {
            double bufNum = n;
            int res = 1;

            while ((int)bufNum != bufNum)
            {
                res *= 10;
                bufNum *= 10;

            }
            int gcd = Gcd(res, (int)bufNum);
            res /= gcd;
            bufNum /= gcd;
            return new int[] { (int)bufNum, res };

        }
        /******************************
         * 
         * Interpolators
         *
         ******************************/
        public static double LinearInterpolation(double x, double x0, double y0, double x1, double y1)
        {
            return y0 + (x - x0) * (y1 - y0) / (x1 - x0);

        }
        public static double QuadraticInterpolation(double x, double x1, double x2, double x3, double y1, double y2, double y3)
        {
            return y1 * (x - x2) * (x - x3) / ((x1 - x2) * (x1 - x3)) + y2 * (x - x1) * (x - x3) / ((x2 - x1) * (x2 - x3)) + y3 * (x - x1) * (x - x2) / ((x3 - x1) * (x3 - x2));

        }
        public static double CubicInterpolation(double x, double x0, double x1, double x2, double x3, double y0, double y1, double y2, double y3)
        {
            double l0 = (x - x1) / (x0 - x1) * (x - x2) / (x0 - x2) * (x - x3) / (x0 - x3);
            double l1 = (x - x0) / (x1 - x0) * (x - x2) / (x1 - x2) * (x - x3) / (x1 - x3);
            double l2 = (x - x0) / (x2 - x0) * (x - x1) / (x1 - x1) * (x - x3) / (x2 - x3);
            double l3 = (x - x0) / (x3 - x0) * (x - x2) / (x3 - x2) * (x - x1) / (x3 - x1);

            return y0 * l0 + y1 * l1 + y2 * l2 + y3 * l3;

        }

        public static double LagrangeInterpolation(double x, double[] xn, double[] yn)
        {
            double res = 0;

            for (int i = 0; i < xn.Length; i++)
            {
                res += lN(x, xn, i) * yn[i];

            }
            return res;

        }
        private static double lN(double x, double[] xn, int n)
        {
            double res = 1;

            for (int i = 0; i < xn.Length; i++)
            {
                if (i == n)
                    continue;
                res *= (x - xn[i]) / (xn[n] - xn[i]);

            }
            return res;

        }
        /******************************
         * 
         * Pows, Roots & Logs
         *
         ******************************/
        public static double FastPow(double x, int n)
        {
            if (n < 0)
                return 1 / FastPow(x, -n);
            double res = 1;

            for (int i = 0; i < n; i++)
            {
                res *= x;

            }
            return res;

        }
        public static double FastRoot(double x, int n)
        {
            double eps = 0.000001;
            double y0 = 2 * x / n;
            double y1 = y0 + 1;

            while (Abs(y1 - y0) > eps)
            {
                y0 = y1;
                y1 = y0 - y0 / n + x / (n * FastPow(y0, n - 1));

            }
            return y1;

        }
        public static double Pow(double x, double n)
        {
            if (n < 0)
                return 1 / Pow(x, -n);
            int fl = Floor(n);
            double fr = n - fl;
            int[] frac = ToFraction(fr);
            return FastPow(x, fl) * FastPow(FastRoot(x, frac[1]), frac[0]);

        }
        public static double Root(double x, double n)
        {
            return Pow(x, 1 / n);

        }
        public static double Sqrt(double x)
        {
            double eps = 0.000001;
            double y0 = x / 2;
            double y1 = y0 + 1;

            while (Abs(y1 - y0) > eps)
            {
                y0 = y1;
                y1 = y0 / 2 + x / (2 * y0);

            }
            return y1;

        }
        public static double Cbrt(double x)
        {
            double eps = 0.000001;
            double y0 = 2 * x / 3;
            double y1 = y0 + 1;

            while (Abs(y1 - y0) > eps)
            {
                y0 = y1;
                y1 = y0 - y0 / 3 + x / (3 * y0 * y0);

            }
            return y1;

        }
        public static double Exp(double x)
        {
            if (x < 0)
                return 1 / Exp(-x);
            else
            {
                /*final long tmp = (long) (1512775 * x + (1072693248 - 60801));
                return Double.longBitsToDouble(tmp << 32);*/
                //return (362880+x*(362880+x*(181440+x*(60480+x*(15120+x*(3024+x*(504+x*(72+x*(9+x)))))))))*2.75573192e-6;
                double res = 0;
                for (int i = 0; i < 50; i++)
                {
                    res += FastPow(x, i) / Factorial(i);

                }
                return res;

            }

        }
        public static double Ln(double x)
        {
            double y0 = (x - 1) / (x + 1);
            double y1 = y0 + 1;
            double eps = 0.00000001;
            while (Abs(y0 - y1) > eps)
            {
                y1 = y0;
                y0 = y1 - 1 + x / Exp(y1);

            }

            return y0;

        }
        public static double Log(double a, double b)
        {
            return Ln(a) / Ln(b);

        }
        public static double Lb(double x)
        {
            return Ln(x) / Ln2;

        }
        public static double Lg(double x)
        {
            return Ln(x) / Ln10;

        }
        /******************************
         * 
         * Trig
         *
         ******************************/
        public static double Sin(double x)
        {
            if (x < 0)
                return -Sin(-x);
            else if (x > PI / 2.0)
                return Sin(PI - x);
            else
            {
                if (x >= 0 && x <= PI / 6)
                    return CubicInterpolation(x, 0, PI / 24, PI / 12, PI / 6, 0, 0.13052619222, 0.2588190451, 0.5);
                else if (x > PI / 6 && x <= PI / 3)
                    return CubicInterpolation(x, PI / 6, PI / 5, PI / 4, PI / 3, 0.5, 0.58778525229, 0.7071067811865, 0.866025403784);
                else if (x > PI / 3 && x <= PI / 2)
                    return CubicInterpolation(x, PI / 5, PI / 4, PI / 3, PI / 2, 0.58778525229, 0.7071067811865, 0.866025403784, 1);
                else return NaN;

            }

        }
        public static double Cos(double x)
        {
            return Sin(PI / 2 - x);

        }
        public static double Tan(double x)
        {
            return Sin(x) / Cos(x);

        }
        public static double Tg(double x)
        {
            return Sin(x) / Cos(x);

        }
        public static double Cot(double x)
        {
            return Cos(x) / Sin(x);

        }
        public static double Ctg(double x)
        {
            return Cos(x) / Sin(x);

        }
        public static double Sec(double x)
        {
            return 1 / Cos(x);

        }
        public static double Csc(double x)
        {
            return 1 / Sin(x);

        }
        /******************************
         * 
         * Inverse Trig
         *
         ******************************/
        public static double Arcsin(double x)
        {
            return Arctan(x / Sqrt(1 - x * x));

        }
        public static double Arccos(double x)
        {
            return PI / 2 - Arcsin(x);

        }
        public static double Arctan(double x)
        {
            if (x < 0)
                return -Arctan(-x);
            else if (x == Double.PositiveInfinity)
                return PI / 2;
            else
            {
                if (x >= 0 && x <= 0.5)
                    return CubicInterpolation(x, 0, 0.125, 0.25, 0.5, 0, 0.1243549945, 0.244978664, 0.463647609);
                else if (x > 0.5 && x <= 1.0)
                    return QuadraticInterpolation(x, 0.5, 0.75, 1, 0.463647609, 0.643501108, PI / 4);
                else if (x > 1.0 && x <= 3)
                    return QuadraticInterpolation(x, 1, 2, 3, PI / 4, 1.10714872, 1.24904577);
                else if (x > 3 && x <= 5)
                    return QuadraticInterpolation(x, 3, 4, 5, 1.24904577, 1.32581766, 1.37340077);
                else if (x > 5 && x <= 7)
                    return QuadraticInterpolation(x, 5, 6, 7, 1.37340077, 1.40564765, 1.42889927);
                else if (x > 7 && x <= 10)
                    return QuadraticInterpolation(x, 7, 8.5, 10, 1.42889927, 1.45368758, 1.47112767);
                else if (x > 10 && x <= 15)
                    return QuadraticInterpolation(x, 10, 12.5, 15, 1.45368758, 1.49096634, 1.50422816);
                else if (x > 15 && x <= 50)
                    return QuadraticInterpolation(x, 15, 25, 50, 1.50422816, 1.53081764, 1.55079899);
                else if (x > 50 && x <= 1000)
                    return QuadraticInterpolation(x, 50, 500, 1000, 1.55079899, 1.56879633, 1.56979633);
                else
                    return QuadraticInterpolation(x, 500, 1000, Double.MaxValue, 1.56879633, 1.56979633, PI / 2);

            }

        }
        public static double Arccot(double x)
        {
            if (x == 0)
                return PI / 2;
            return Arctan(1 / x);

        }
        public static double Arcsec(double x)
        {
            return Arccos(1 / x);

        }
        public static double Arccsc(double x)
        {
            return Arcsin(1 / x);

        }
        public static double Atan2(double y, double x)
        {
            if (x == 0)
                return Sgn(y) * PI / 2;
            else if (x > 0)
                return Arctan(y / x);
            else if (x < 0 && y >= 0)
                return Arctan(y / x) + PI;
            else if (x < 0 && y < 0)
                return Arctan(y / x) - PI;
            else
                return NaN;

        }
        /******************************
         * 
         * Hyperbolic Trig
         *
         ******************************/
        public static double Sinh(double x)
        {
            double exp = Exp(x);
            return (exp - 1 / exp) / 2;

        }
        public static double Cosh(double x)
        {
            double exp = Exp(x);
            return (exp + 1 / exp) / 2;

        }
        public static double Tanh(double x)
        {
            double exp = Exp(x);
            return (exp - 1 / exp) / (exp + 1 / exp);

        }
        public static double Coth(double x)
        {
            double exp = Exp(x);
            return (exp + 1 / exp) / (exp - 1 / exp);

        }
        public static double Sech(double x)
        {
            double exp = Exp(x);
            return 2 / (exp + 1 / exp);

        }
        public static double Csch(double x)
        {
            double exp = Exp(x);
            return 2 / (exp - 1 / exp);

        }
        /******************************
         * 
         * Inverse Hyperbolic Trig
         *
         ******************************/
        public static double Arsinh(double x)
        {
            return Ln(x + Sqrt(x * x + 1));

        }
        public static double Arcosh(double x)
        {
            return Ln(x + Sqrt(x * x - 1));

        }
        public static double Artanh(double x)
        {
            return Ln((1 + x) / (1 - x)) / 2;

        }
        public static double Arcoth(double x)
        {
            /*if (x == 0)
                return 1;*/
            return Artanh(1 / x);

        }
        public static double Arsech(double x)
        {
            return Arcosh(1 / x);

        }
        public static double Arcsch(double x)
        {
            return Arsinh(1 / x);

        }
        /******************************
         * 
         * Special Functions
         *
         ******************************/
        private static double GammaLn(double x, int k)
        {
            double res = -Ln(x);
            for (int i = 0; i < k; i++)
            {
                res += x * Ln(1 + 1.0d / i) - Ln(1 + x / i);

            }
            return res;

        }
        public static double Gamma(double x, int k)
        {
            return Exp(GammaLn(x, k));

        }
        public static double Factorial(double x, int n)
        {
            return Gamma(x + 1, n);

        }
        public static double Erf(double x)
        {
            if (x < 0)
                return -Erf(-x);
            double a = 0.140012288687; // 8/(3pi)*(3-pi)/(pi-4)
            double arg = -x * x * (4 / PI + a * x * x) / (1 + a * x * x);
            return Sqrt(1 - Exp(arg));

        }
        public static double PolyLog(double x, double n, int k)
        {
            double res = 0;
            for(int i = 0; i<k; i++)
                res+=FastPow(x, i) / Pow(i, n);

            return res;

        }
        public static int IversonBracket(bool a)
        {
            return a ? 1 : 0;

        }
        private static double Minus1Pow(int n)
        {
            return n % 2 == 0.0 ? 1.0 : -1.0;

        }
        public static double Zeta(double x, int n)
        {
            if (x == 0)
                return 0.5;
            else if (x < 0)
                return -Pow(2 * PI, x) * Sin(PI * x / 2) * Factorial(x, n) * Zeta(1 - x, n)/PI;
            double a = Pow(2, 1 - x);
            double res = 0;
            for(int i = 0; i<n; i++)
            {
                res += Minus1Pow(i)/Pow(i, x);

            }
            return res / a;

        }
        public static double Beta(double x, double y, int n)
        {
            return Gamma(x, n) * Gamma(y, n) / Gamma(x + y, n);

        }
    
    }

}