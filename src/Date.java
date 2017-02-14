/**
 * The date class represents a date. It consists of three instance variables
 * as an integer value for month, day, and year. The date is mutable and 
 * is accessible via getters and setters.
 * 
 * The Standard format is the US variation Month/Day/Year
 * Class Invariants: Day must between 1 and 31, Year must be greater than
 * 0, and month must be between 1 and 12.
 * 
 * @author Connor Teal
 */
public class Date {
    private int day = 1;
    private int month = 1;
    private int year = 1;

    /**
     * No Argument Constructor sets values to zero
     */
    public Date(){
    }

    /**
     * Copy Constructor for preventing privacy leaks
     */
    public Date(Date other){
        this.month = other.month;
        this.day = other.day;
        this.year = other.year;
    }

    /**
     * Constructor that takes month day and year as 
     * paramaters
     * 
     * @param int month to set
     * @param int day to set
     * @param int year to set
     */
    public Date(int month, int day, int year){
        this.setDate(month,day,year);
    }

    /**
     * dayRangeCheck tests a day to see if it is within the valid 
     * range (1-31)
     * 
     * @param int day to check
     * @return boolean true if valid
     */
    private boolean dayRangeCheck(int day) throws Exception{
        if(day < 1 || day > 31){
            throw new Exception("Day must be between 1 and 31");
        }
        return true;
    }

    /**
     * monthRangeCheck tests to see if month is within the valid 
     * range (1-12)
     * 
     * @param int month to check
     * @return boolean true if valid
     */
    private boolean monthRangeCheck(int month) throws Exception{
        if(month < 1 || month > 12){
            throw new Exception("Month must be between 1 and 12");
        }
        return true;
    }

    /**
     * yearRangeCheck tests to see if the year is valid (greater than 0)
     * 
     * @param int year to check
     * @return boolean true if valid
     */
    private boolean yearRangeCheck(int year) throws Exception{
        if(year < 0){
            throw new Exception("Year must be greater than 0.");
        }
        return true;
    }

    /**
     * isValidDate checks to see if a date is within the invariant
     * range
     * 
     * @param int month to check
     * @param int day to check
     * @param int year to check
     * @return boolean true if valid
     */
    public boolean isValidDate(int month, int day, int year) throws Exception{
        if(dayRangeCheck(day) && monthRangeCheck(month) && yearRangeCheck(year)){
            return true;
        }
        return false;
    }
    
    /**
     * setDay sets the day
     * 
     * @param int day to set
     * @return Nothing
     */
    public void setDay(int day){
        try{
            dayRangeCheck(day);
            this.day = day;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * setYear sets the year
     * 
     * @param int year to set
     * @return Nothing
     */
    public void setYear(int year){
        try{
            yearRangeCheck(year);
            this.year = year;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * setMonth sets the month
     * 
     * @param int month to set (1 - jan.. etc)
     * @return Nothing
     */
    public void setMonth(int month){
        try{
            monthRangeCheck(month);
            this.month = month;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sets date using month, day, and year
     * 
     * @param int month to set
     * @param int day to set
     * @param int year to set
     */
    public void setDate(int month, int day, int year){
        this.setMonth(month);
        this.setDay(day);
        this.setYear(year);
    }
    
    /**
     * datePrecedes will check to see if the object date
     * precedes a date passed as an argument
     * 
     * @param Date the date to check
     * @return boolean true object date precedes arg date
     */
    public boolean datePrecedes(Date otherDate){
        Date temp = new Date(otherDate);
        
        //if the year procedes it must procede
        if(yearPrecedes(temp.getYear())){
            return true;
        }
        //if year is equal we must check month and day
        if(yearEquals(temp.getYear())){
            if(monthPrecedes(temp.getMonth())){
                return true;
            }
            if(monthEquals(this.getMonth()) && dayPrecedes(temp.getDay())){
                return true;
            }
        }
        return false;
    }
    
    /**
     * yearPrecedes will check if the object year
     * precedes a given year
     * 
     * @param int year to check
     * @return boolean true object precedes year
     */
    private boolean yearPrecedes(int year){
        if(this.year < year){
            return true;
        }
        return false;
    }
    
    /**
     * yearEquals will check if the object year is equal
     * to the year passed as an argument
     * 
     * @param int year to check
     * @return boolean true if equal
     */
    private boolean yearEquals(int year){
        if(this.year == year){
            return true;
        }
        return false;
    }
    
    /**
     * dayPrecedes will check if the object day
     * precedes a given day
     * 
     * @param int day to check
     * @return boolean true object precedes day
     */
    private boolean dayPrecedes(int day){
        if(this.day < day){
            return true;
        }
        return false;
    }
    
    /**
     * monthPrecedes will check if the object month
     * precedes a given month
     * 
     * @param int month to check
     * @return boolean true object precedes month
     */
    private boolean monthPrecedes(int month){
        if(this.month < month){
            return true;
        }
        return false;
    }
    
    /**
     * monthEquals will check to see if the object month
     * is equal to the argument month
     * 
     * @param month to check
     * @return boolean true if equal
     */
    private boolean monthEquals(int month){
        if(this.month == month){
            return true;
        }
        return false;
    }
    
    /**
     * getYear will return the year
     * 
     * @return int the year
     */
    public int getYear(){
        return new Date(this).year;
    }
    
    
    /**
     * getMonth will return the month
     * 
     * @return int the month
     */
     public int getMonth(){
        return new Date(this).month;
    }
    
    
    /**
     * getDay will return the day
     * 
     * @return int the day
     */
     public int getDay(){
        return new Date(this).day;
    }

    /**
     * equals compares 2 dates to see if they're equivalent.
     * 
     * @param Date to compare
     * @return boolean true if equal
     */
    public boolean equals(Date other){
        if(this.month == other.month && this.day == other.day 
        && this.year == other.year){
            return true;
        }
        return false;
    }

    /**
     * toString returns the date as a string
     * 
     * @return String the date
     */
    @Override
    public String toString(){
        return this.month + "/" + this.day + "/" + this.year;
    }
}