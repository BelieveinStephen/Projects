// The Date class that represents dates
// Do not make any changes to this file!
// Xiwei Wang

import java.io.*;

public class Date implements Serializable
{
    // instance variables
    protected int m_year;
    protected int m_month;
    protected int m_day;
    
    // copy constructor
    public Date(Date o)
    {
        m_year = o.m_year;
        m_month = o.m_month;
        m_day = o.m_day;
    }
    
    // constructor
    public Date(int month, int day, int year)
    {
        m_year = year;
        m_month = month;
        m_day = day;
    }
    
    // observers
    public int getYear()
    {
        return m_year;
    }
    
    public int getMonth()
    {
        return m_month;
    }
    
    public int getDay()
    {
        return m_day;
    }
    
    // return this date as a String
    public String toString()
    {
        return (m_month + "/" + m_day + "/" + m_year);
    }
}
