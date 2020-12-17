public class MyMath 
{
    public static double plus(double f, double s)
    {
    	double result = f+s;
    	
    	return result;
    	
    }
    public static double minus(double f, double s)
    {
    	double result = f-s;
    	
    	return result;
    	
    }
    public static double times(double f, double s)
    {
    	double result = f*s;
    	
    	return result;
    	
    }
    public static double div(double f, double s)
    {
    	double result = f/s;
    	
    	return result;
    	
    }
    
    public static double root(double num, double n)
    {
    	int nope = 0;
    	
    	if(num<0)
    	{
    		return nope;
    		
    	}
    	double result = pow(num, 1/n);
    	
    	
    	return result;
    	
    }
    public static double pow(double base, double power)
    {
    	double result = Math.pow(base, power);
    	/*double result = 0;
    	 
    	 
    	 
    	
    	if(power>0 & round(power) == power)
    	{
            result = base;
    		
    		for(int i=0; i<power--; i++)
    		{
    			result = result*base;
    			
    		}
    		
    	}
    	
    	if(power<0 & round(power)==power)
    	{
    		/*result = (pow(base, mod(power)));*//*
    		for(int i=0; i<-1*power; i++)
    		{
    			result = result*base;
    			
    		}
    		result = 1/result;
    		
    	}
    	if(power==0)
    	{
    		result=1;
    		
    	}
    	if(power>0 & round(power)!=power)
    	{
    		//double ratpow = power;
    		//double down = 1;
    		//while(round(ratpow)!=power)
    		//{
    		//	ratpow=ratpow*10;
    		//	down=down*10;
    		//	
    		//}
    		
    		 
    		double ratpow = fractionUp(power);
    		double down = fractionDown(power);
    		
    		result=pow(root(base, down),ratpow);
    		
    	}
    	if(power>0 && round(power)!=power)
    	{
    		result=1/pow(base, power*-1);
    		
    	}*/
    	
    	return result;
    	
    }
    public static double log(double f)
    {
    	double result = Math.log(f);
    	
    	return result;
    	
    }
    public static double makePow(double base, double result)
    {
    	double power = Math.log(result)/Math.log(base);
    	
    	return power;
    	
    }
    public static double fact(double number)
    {
    	double result = 1;
    	for(int i = 1; i<number+1; i++)
    	{
    		result = result*i;
    		
    	}
    	if(number==0)
    	{
    		result = 1;
    	
    	}
    	
    	return result;
    	
    }
    public static double rowsum(double number)
    {
    	double result = 0;
    	for(int i = 1; i<number+1; i++)
    	{
    		result = result+i;
    		
    	}
    	
    	return result;
    	
    }
    
    public static double sin(double f)
    {
    	double result = Math.sin(f);
    	
    	/*double result=0;
    	double factpow = 1;
    	for(int i=0;i<Integer.MAX_VALUE;i++)
    	{
    		
    		result = result+(pow(f,factpow))/(fact(factpow))-(pow(f,factpow+2))/(fact(factpow+2));
    		
    		factpow=factpow+4;
    		
    	}*/
    		
    	return result;
    	
    }
    public static double cos(double f)
    {
    	double result = Math.cos(f);
    	
    	/*double result=0;
    	double factpow = 0;
    	for(int i=0;i<Integer.MAX_VALUE;i++)
    	{
    		
    		result = result+(pow(f,factpow))/(fact(factpow))-(pow(f,factpow+2))/(fact(factpow+2));
    		
    		factpow=factpow+4;
    		
    	}*/
    	
    	return result;
    	
    }
    public static double tan(double f)
    {
    	double result = sin(f)/cos(f);
    	
    	return result;
    	
    }
    public static double cot(double f)
    {
    	double result = cos(f)/sin(f);
    	
    	return result;
    	
    }
    public static double sec(double f)
    {
    	double result = 1/cos(f);
    	
    	return result;
    }
    public static double cosec(double f)
    {
    	double result = 1/sin(f);
    	
    	return result;
    }
    
    public static double mod(double number)
    {
    	double result = 0;
    	
    	result=number;
    	
    	if(number<0)
    	{
    		result = -1*number;
    		
    	}
    	
    	return result;
    	
    }
    public static double ceil(double number)
    {
    	double result = round(number);
    	
    	if(result+0.5<number)
    	{
    		result++;
    		
    	}
    	
    	return result;
    	
    }
    public static double floor(double number)
    {
    	double result = round(number);
    	
    	if(result-0.5>number)
    	{
    		result--;
    		
    	}
    	
    	return result;
    	
    }
    public static double minplu(double f)
    {
    	double result = -1*f;
    	
    	return result;
    	
    }
    /*public static double round(double number, String save)
    {
    	DecimalFormat round = new DecimalFormat(save);
    	double result = Double.parseDouble(round.format(number));
    	
    	return result;
    	
    }*/
    public static double round(double number)
    {
    	double result = Math.round(number);
    	
    	return result;
    	
    }
    public static double left(double f, double div)
    {
    	double result = f-(floor(f/div)*div);
    	
		return result;
    	
    }
    
    public static double random(double min, double max)
    {
    	double reservemax=max;
    	max -= min;
    	double result = (Math.random() * ++max) + min;
    	
    	while(result>=reservemax)
    	{
    		result = (Math.random() * ++max) + min;
    		
    	}
    	
    	return result;
    	
    }
    
    public static double toRad(double deg)
    {
    	double result = deg/(2*pi);
    	
		return result;
    	
    }
    public static double toDeg(double rad)
    {
    	double result = rad*(2*pi);
    	
		return result;
    	
    }
    
    public static String toBin(int dec)
    {
    	String result = Integer.toBinaryString(dec);
    	
    /*	double result = 0;
    	
    	double div = 0;
    	
    	int i = 0;
    	
    	double mas=(double) 1.0;
    	
    	while(left(div,2)!=0)
    	{
    		div = floor(ten/2);
    		
    		mas[i]=left(ten,2);
    		i++;
    		
    	}
    	
    	System.out.println(mas);*/
    	
    	return result;
    	
    }
    public static String toHex(double dec)
    {
    	String result = Double.toHexString(dec);
    	
    	return result;
    	
    }
    public static String toOct(int dec)
    {
    	String result = Integer.toOctalString(dec);
    	
		return result;
    	
    }
    
    public static int BinToDec(String bin)
    {
    	int result = Integer.parseInt(bin, 2);
    	
		return result;
    	
    }
    public static int HexToDec(String hex)
    {
    	int result = Integer.parseInt(hex, 16);
    	
		return result;
    	
    }
    public static int OctoToDec(String octo)
    {
    	int result = Integer.parseInt(octo, 8);
    	
		return result;
    	
    }
    
    public static double e = 2.7182818284590452353602874713526;
    public static double pi = 3.141592653589793238462643383279;
    
    public static double fractionDown(double num)
    {

        double result = 0;
        double eatNum = num;

            result=1;

            while(eatNum!=round(eatNum))
            {
                eatNum=eatNum*10;
                result=result*10;

            }

            return result;

        

    }
    public static double fractionUp(double num)
    {

        double result = 0;
        double eatNum = num;
        
            result=1;

            while(eatNum!=round(eatNum))
            {
                eatNum=eatNum*10;
                result=result*10;

            }

            return eatNum;

        

    }
    
 /*   public class neededMethods
    {
    	public double powplusround(base, power)
    	{
            double 
    		return result;
    		
    	}
    	
    }*/
}

