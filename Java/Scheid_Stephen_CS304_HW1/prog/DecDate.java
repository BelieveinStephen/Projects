// The DecDate class
// Do not make changes to anything other than the body of decrement() method
// Stevie Scheid

public class DecDate extends Date
{
    // copy constructor
    public DecDate(Date o)
    {
        super(o.m_month, o.m_day, o.m_year);
    }
    
    // constructor
    public DecDate(int month, int day, int year)
    {
        super(month, day, year);
    }
    
    public void decrement()
    {
         
         boolean leapYear = false;
         //Array with days of month
         int [] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        //used to prove leapYear true
        if(m_year % 400 ==0)
            leapYear = true;
        else if(m_year % 4 == 0 && m_year % 100 != 0)
            leapYear = true;
         //decrement day
         m_day-= 1;
         
         //if day is 0 we decrement month
         if(m_day == 0)
         {   
               m_month--;   
            //if month is 1 then month goes to 12 and we decrement year
            if(m_month == 0)
            {
               m_month = 12;
               m_year--;
            }
         //if input matches 2 and leapyear is true we set days to our exception of 29 else we make the days
         //equal the days of the month preceding our input
         if(m_month == 2 && leapYear)
               m_day = 29;      
         else
            m_day = daysInMonths[m_month -1];
         }
    }  
}