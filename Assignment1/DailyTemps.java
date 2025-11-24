/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 1
IDE Name: Microsoft Visual Studio
**/

public class DailyTemps 
{
    //initialize variables
    int[] temperatureList;
    int freezingCount = 0;

    //constructor
    DailyTemps(int[] newTemps)
    {
        temperatureList = newTemps;
    }

    //setter method
    public void setTemp(int index, int newTemp)
    {
        temperatureList[index] = newTemp;
    }

    //method to find number of days below freezing
    public int Freezing()
    {
        //loop to count days below 32
        for(int i:temperatureList)
        {
            if(i<32)
            {
                freezingCount++;
            }
        }
        return freezingCount;
    }

    //method to find warmest day
    public String Warmest()
    {
        //initialize variables
        int warmestTemp = Integer.MIN_VALUE;
        int warmestIndex = 0;

        //loop to find warmest temp/index
        for(int i = 0; i<temperatureList.length; i++)
        {
            if(temperatureList[i] > warmestTemp)
            {
                warmestIndex = i;
                warmestTemp = temperatureList[i];
            }
        }
        //switch statement for returning name of day
        switch(warmestIndex)
        {
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
            case 6:
                return "Sunday";
            default:
                return null;
        }
    }

    //printer method
    public void printTemps()
    {
        System.out.println("Monday\t\t" + temperatureList[0]);
        System.out.println("Tuesday\t\t" + temperatureList[1]);
        System.out.println("Wednesday\t" + temperatureList[2]);
        System.out.println("Thursday\t" + temperatureList[3]); 
        System.out.println("Friday\t\t" + temperatureList[4]);
        System.out.println("Saturday\t" + temperatureList[5]);
        System.out.println("Sunday\t\t" + temperatureList[6]);
    }
}
