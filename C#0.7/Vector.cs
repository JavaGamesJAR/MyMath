using System;

namespace MyMath.Vectors
{
	public class Vector
	{
		/******************************
         * 
         * Coordinate vecs
         *
         ******************************/
		public static readonly Vector I = new Vector(1, 0, 0);
		public static readonly Vector J = new Vector(0, 1, 0);
		public static readonly Vector K = new Vector(0, 0, 1);
		/******************************
         * 
         * Constructors
         *
         ******************************/
		public Vector(double x, double y, double z)
		{
			this.x = x;
			this.y = y;
			this.z = z;

		}
		public Vector(double[] components)
        {
			this.x = components[0];
			this.y = components[1];
			this.z = components[2];

        }
		//Components
		public double x, y, z;
		/******************************
         * 
         * Basic operations
         *
         ******************************/
		public static Vector Add(Vector a, Vector b)
        {
			return new Vector(a.x + b.x, a.y + b.y, a.z + b.z);

        }
		public static Vector Mult(Vector a, double s)
        {
			return new Vector(a.x * s, a.y * s, a.z * s);

        }
		public Vector Mult(double s)
        {
			return Mult(this, s);

        }
		public static double ScalarProd(Vector a, Vector b)
		{
			return a.x * b.x + a.y * b.y + a.z * b.z;

		}
		public double ScalarProd(Vector a)
        {
			return ScalarProd(this, a);

        }
		public static Vector VectorProd(Vector a, Vector b)
		{
			return new Vector(a.y*b.z-a.z*b.y, a.z*b.x-a.x*b.z, a.x*b.y-a.y*b.z);

		}
		public Vector VectorProd(Vector a)
        {
			return VectorProd(this, a);

        }
		/******************************
         * 
         * Useful methods
         *
         ******************************/
		public string toString()
        {
			return "("+x+"; "+y+";"+z+")";

        }
		public static Vector Parse(String s)
        {
			s = s.Trim();
			s = s.Replace("(", "");
			s = s.Replace(")", "");
			string[] comps = s.Split((";").ToCharArray()[0]);
			return new Vector(double.Parse(comps[0]), double.Parse(comps[1]), double.Parse(comps[2]));

        }

	}

}

