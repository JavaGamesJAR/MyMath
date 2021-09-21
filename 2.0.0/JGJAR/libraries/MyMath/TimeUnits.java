package JGJAR.libraries.MyMath;

public enum TimeUnits 
{
	YEAR,
	DAY,
	HOUR,
	MINUTE,
	SECOND,
	MILISECOND,
	MICROSECOND,
	NANOSECOND,
	PICOSECOND;
	
	public String toString()
	{
		switch(this)
		{
			case YEAR:
				return "years";
			case DAY:
				return "days";
			case HOUR:
				return "hours";
			case MINUTE:
				return "mins";
			case SECOND:
				return "s";
			case MILISECOND:
				return "ms";
			case MICROSECOND:
				return "μs";
			case NANOSECOND:
				return "ns";
			case PICOSECOND:
				return "ps";
			default:
				return "s";
		
		}
		
	}

}
