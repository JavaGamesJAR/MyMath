using System;

namespace MyMath.Vectors.VectorCalculus
{
    public class Nabla
    {
        //No way to init as object
        private Nabla() { }

        public static Func<Vector, double> Divergence(Func<Vector, Vector> v, double dx)
        {
            double res(Vector a)
            {
                double x = (v(Vector.Add(a, new Vector(dx, 0, 0))).x - v(Vector.Add(a, new Vector(-dx, 0, 0))).x) / (2 * dx);
                double y = (v(Vector.Add(a, new Vector(0, dx, 0))).y - v(Vector.Add(a, new Vector(0, -dx, 0))).y) / (2 * dx);
                double z = (v(Vector.Add(a, new Vector(0,  0, dx))).z - v(Vector.Add(a, new Vector(0, 0, -dx))).z) / (2 * dx);
                return x + y + z;

            }
            return res;

        }
        public static Func<Vector, Vector> Curl(Func<Vector, Vector> v, double dx)
        {
            Vector res(Vector a)
            {
                Vector x(Vector c)
                {
                    return Vector.VectorProd(v(c), Vector.I);

                }
                Vector y(Vector c)
                {
                    return Vector.VectorProd(v(c), Vector.J);

                }
                Vector z(Vector c)
                {
                    return Vector.VectorProd(v(c), Vector.K);

                }
                return Vector.Add(Vector.Add(VectorDer.derivX(x, a, dx), VectorDer.derivY(y, a, dx)), VectorDer.derivZ(z, a, dx));

            }
            return res;

        }
        public static Func<Vector, Vector> Gradient(Func<Vector, double> f, double dx)
        {
            Vector res(Vector a)
            {
                double x()
                {
                    double f1 = f(Vector.Add(a, new Vector(dx, 0, 0)));
                    double f2 = f(Vector.Add(a, new Vector(-dx, 0, 0)));
                    return (f1 - f2) / (2 * dx);

                }
                double y()
                {
                    double f1 = f(Vector.Add(a, new Vector(0, dx, 0)));
                    double f2 = f(Vector.Add(a, new Vector(0, -dx, 0)));
                    return (f1 - f2) / (2 * dx);

                }
                double z()
                {
                    double f1 = f(Vector.Add(a, new Vector(0, 0, dx)));
                    double f2 = f(Vector.Add(a, new Vector(0, 0, -dx)));
                    return (f1 - f2) / (2 * dx);

                }
                return new Vector(x(), y(), z());

            }
            return res;

        }

    }

}