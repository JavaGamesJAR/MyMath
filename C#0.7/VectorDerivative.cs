using System;

namespace MyMath.Vectors.VectorCalculus
{
    public class VectorDer
    {
        public static Vector derivX(Func<Vector, Vector> f, Vector a, double dx)
        {
            Vector y1 = f(Vector.Add(a, new Vector(dx, 0, 0)));
            Vector y0 = f(Vector.Add(a, new Vector(-dx, 0, 0)));
            return Vector.Mult(Vector.Add(y1, y0.Mult(-1.0)),1/(2*dx));

        }
        public static Vector derivY(Func<Vector, Vector> f, Vector a, double dy)
        {
            Vector y1 = f(Vector.Add(a, new Vector(0, dy, 0)));
            Vector y0 = f(Vector.Add(a, new Vector(0, -dy, 0)));
            return Vector.Mult(Vector.Add(y1, y0.Mult(-1.0)), 1 / (2 * dy));

        }
        public static Vector derivZ(Func<Vector, Vector> f, Vector a, double dz)
        {
            Vector y1 = f(Vector.Add(a, new Vector(0, 0, dz)));
            Vector y0 = f(Vector.Add(a, new Vector(0, 0, -dz)));
            return Vector.Mult(Vector.Add(y1, y0.Mult(-1.0)), 1 / (2 * dz));

        }

    }

}
