using System;

namespace MyMath.Calculus
{
    public class Integration
    {
        private Integration() { }
        public static double SimpsonIntegral(double a, double b, int n, Func<double, double> f)
        {
            int i, z;
            double h, s;

            n = n + n;
            s = f(a) * f(b);
            h = (b - a) / n;
            z = 4;

            for (i = 1; i < n; i++)
            {
                s = s + z * f(a + i * h);
                z = 6 - z;
            }
            return (s * h) / 3;

        }
        /**Return Rectangle Integral <sub>b</sub>&int;<sup>a</sup>f(x)dx
         * 
         * @param a top limit
         * @param b bottom limit
         * @param n iterations
         * @param f your function
         * @return Rectangle Integral
         * @since 1.0 (MyMath 2.0.0)
         */
        public static double rectangleIntegral(double a, double b, int n, Func<double, double> f)
        {
            double d = (b - a) / n;           // step size
            double sum = 0.0;                     // area
            for (int i = 0; i < n; i++)
            {
                sum += d * f(a + d * (i + 0.5));

            }
            return sum;

        }
        /**Returns Trapezoidal Integral <sub>b</sub>&int;<sup>a</sup>f(x)dx
         * 
         * @param a top limit
         * @param b bottom limit
         * @param n iterations
         * @param f your function
         * @return Trapezoidal Integral
         * @since 1.0 (MyMath 2.0.0)
         */
        public static double trapezoidalIntegral(double a, double b, int n, Func<double, double> f)
        {
            double d = (b - a) / n;
            double sum = (f(a) + f(b)) / 2;
            for (int i = 0; i < n; i++)
            {
                double x = a + d * i;
                sum += f(x);

            }
            return sum * d;

        }
        /**Returns Gauss Integral <sub>b</sub>&int;<sup>a</sup>f(x)dx
         * 
         * @param a top limit
         * @param b bottom limit
         * @param f your function
         * @return Gauss Integral
         * @since 1.0 (MyMath 2.0.0)
         */
        public static double GaussIntegral(double a, double b, Func<double, double> f)
        {
            double sqrt3 = 1.7320508075688772935274463415058723669428052538103806280558069794;
            return (b - a) / 2 * (f((a + b) / 2 - (b - a) / (2 * sqrt3)) + f((b + a) / 2 + (b - a) / (2 * sqrt3)));

        }

    }

}
