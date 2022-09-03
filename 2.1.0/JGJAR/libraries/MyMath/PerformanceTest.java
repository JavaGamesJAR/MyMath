package JGJAR.libraries.MyMath;

public class PerformanceTest 
{
	public PerformanceTest(DoubleFunction f, TimeUnits t)
	{
		this.f = f;
		this.time = t;
		
	}
	DoubleFunction f;
	TimeUnits time;
	
	public long test(double arg)
	{
		long timeStart = System.nanoTime();
		f.execute(arg);
		long TimeNano = System.nanoTime()-timeStart;
		switch(this.time)
		{
			case NANOSECOND:
				return TimeNano;
			case PICOSECOND:
				return TimeNano*1000;
			case MICROSECOND:
				return TimeNano/1000;
			case MILISECOND:
				return TimeNano/1000000;
			case SECOND:
				return TimeNano/1000000000;
			case MINUTE:
				return (TimeNano/1000000000)/60;
			case HOUR:
				return (TimeNano/1000000000)/3600;
			case DAY:
				return (TimeNano/1000000000)/86400;
			case YEAR:
				return (TimeNano/1000000000)/(86400*365);
			default:
				return TimeNano;
		
		}
		
	}
	public long test()
	{
		return test(MyMath.random(Double.MIN_VALUE, Double.MAX_VALUE));
		
	}

}
