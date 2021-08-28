using System;

namespace MyMath.Calculus
{
    public class Derivative
    {
        private Derivative() { }
        public double easyDerivative(Func<double, double> f, double x, double dx)
        {
            return (f(x + dx) - f(x)) / dx;

        }
        //Sqr NOT because Squared!!! The lose of precision is proportional to d^2x
        public double DerivativeSqr(Func<double, double> f, double x, double dx)
        {
            return (f(x + dx) - f(x-dx)) / (2*dx);

        }
        public double easyLim(Func<double, double> f, double x, double dx)
        {
            double g(double h)
            {
                return (f(x + h) - f(x)) / h;

            }
            return new Limit(g, 0, dx).Apply();

        }
        public double sqrLim(Func<double, double> f, double x, double dx)
        {
            double g(double h)
            {
                return (f(x + h) - f(x-h)) / (2*h);

            }
            return new Limit(g, 0, dx).Apply();

        }

    }

}
