import java.util.*;
public class test 
{
    public static void main(String[] args)
    {
        
        String[][] table = 
        {
            {"John","Billy", "Jane", "Brad", "Levi", "Logan", "Jake", "Emma", "Ady", "Amanda"},
            {"86", "37", "92", "100", "59", "0", "82", "17", "47", "28"}
        };
        int[] gradeArray = new int[5];
        String tempName;
        String tempGrade;
        for (int i = 0; i < table.length; i++)
        {
            for (int j = i+1; j < table.length; j++)
            {
                if(Integer.valueOf(table[1][j]) > Integer.valueOf(table[1][j+1]))
                {
                    tempName = table[0][j];
                    tempGrade = table[1][j];
                    table[0][j] = table[0][j+1];
                    table[1][j] = table[1][j+1];
                    table[0][j+1] = tempName;
                    table[1][j+1] = tempGrade;
                }
            }
        }
        for (int i = 0; i < table.length; i++)
        {
            if(Integer.valueOf(table[1][i])>=90)
            {
                gradeArray[0]+=1;
            }
            else if(Integer.valueOf(table[1][i])>=80)
            {
                gradeArray[1]+=1;
            }
            else if(Integer.valueOf(table[1][i])>=70)
            {
                gradeArray[2]+=1;
            }
            else if(Integer.valueOf(table[1][i])>=60)
            {
                gradeArray[3]+=1;
            }
            else
            {
                gradeArray[4]+=1;
            }
        }
        for (int i = 0; i < gradeArray.length; i++)
        {
            System.out.print(gradeArray[i]);
        }
    }
}
