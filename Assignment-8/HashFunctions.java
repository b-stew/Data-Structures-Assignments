/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 8
IDE Name: Microsoft Visual Studio
**/

import java.util.*;
public class HashFunctions 
{
    public static void print_menu()//print menu
    {
        System.out.println();
        System.out.println("-----MAIN MENU--------------------------------------");
        System.out.println("1. Run HF1 (Division method with Linear Probing)");
        System.out.println("2. Run HF2 (Division method with Quadratic Probing)");
        System.out.println("3. Run HF3 (Division method with Double Hashing)");
        System.out.println("4. Run HF4 (Student Designed HF)");
        System.out.println("5. Exit program");
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[][] hashTable = new int[50][2];
        int[] keys = 
        {
            1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
            5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
            5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
            5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
            5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523
        };
        int userOption = 0;

        while(userOption != 5)
        {
            print_menu();
            System.out.println("Enter option number: ");
            userOption = scanner.nextInt();
            scanner.nextLine();

            switch (userOption) {
                case 1:
                    resetTable(hashTable);
                    H1(hashTable, keys);
                    System.out.println("Hash table resulted from H1:");
                    printTable(hashTable);
                    break;
                case 2:
                    resetTable(hashTable);
                    H2(hashTable, keys);
                    System.out.println("Hash table resulted from H2:");
                    printTable(hashTable);
                    break;
                case 3:
                    resetTable(hashTable);
                    H3(hashTable, keys);
                    System.out.println("Hash table resulted from H3:");
                    printTable(hashTable);
                    break;
                case 4:
                    resetTable(hashTable);
                    H4(hashTable, keys);
                    System.out.println("Hash table resulted from H4:");
                    printTable(hashTable);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        scanner.close();
    }
    private static void H1(int[][] hashTable, int[] keys)
    {
        for(int key : keys)
        {
            int index = key % hashTable.length;
            int count = 0;
            while(hashTable[index][0] != -1)
            {
                index = (index + 1) % hashTable.length;//linear probe
                count++;
            }
            hashTable[index][0] = key;
            hashTable[index][1] = count;
        }
    }
    private static void H2(int[][] hashTable, int[] keys)
    {
        for (int key : keys) 
        {
            int index = key % hashTable.length;
            int count = 0;
            int j = 1;
            while (hashTable[index][0] != -1) 
            {
                index = (key + j * j) % 50; //quadratic probe
                count++;
                j++;
            }
            hashTable[index][0] = key;
            hashTable[index][1] = count;
        }
    }
    private static void H3(int[][] hashTable, int[] keys)
    {
        for(int key : keys)
        {
            int index = key % hashTable.length;
            int count = 0;
            int hash2 = 30 - (key % 25);//calc second hash
            int j = 1;
            while(hashTable[index][0] != -1 && j <= 50)
            {
                index = (key + j * hash2 + hashTable.length) % hashTable.length;//double hash probing
                count++;
                j++;
            }
            if(j > 50)
            {
                System.out.println("Unable to hash key " + key + " to the table");
            }
            else
            {
                hashTable[index][0] = key;
                hashTable[index][1] = count;
            }
        }
    }
    private static void H4(int[][] hashTable, int[] keys)//implementing folding hash function
    {
        for (int key : keys) 
        {
            int keyVal = key;
            int sum = 0;
            while (key > 0) 
            {
                sum += key % 100; // mod operator to split the number into two-digit parts
                key /= 100;
            }
            int index = sum % hashTable.length;
            int count = 0;
            int j = 1;
            int hash2 = 27 - (keyVal % 27);//calc second hash (honestly just picked random numbers until it got lower
            while(hashTable[index][0] != -1 && j < 50)
            {
                index = (key + j * hash2 + hashTable.length) % hashTable.length;//double hash probing
                count++;
                j++;
            }
            if(j >= 50)
            {
                System.out.println("Unable to hash key " + key + " to the table");
            }
            else
            {
                hashTable[index][0] = keyVal;
                hashTable[index][1] = count;
            }
        }
    }
    private static void resetTable(int[][] hashTable)
    {
        for(int i = 0; i < hashTable.length; i++)
        {
            hashTable[i][0] = -1;//keys
            hashTable[i][1] = 0;//probes
        }
    }
    private static void printTable(int[][] hashTable)//printing table function
    {
        System.out.println("\nIndex\tKey\tprobes");
        System.out.println("------------------------");
        for(int i = 0; i < hashTable.length; i++)
        {
                System.out.println(i + "\t" + hashTable[i][0] + "\t" + hashTable[i][1]);
        }
        System.out.println("------------------------\n");
        System.out.println("Sum of probe values = " + sumProbes(hashTable) + " probes.");
    }
    private static int sumProbes(int[][] hashTable)//adds probe values up
    {
        int sum = 0;
        for(int[] val : hashTable)
        {
            sum += val[1];
        }
        return sum;
    }
}
