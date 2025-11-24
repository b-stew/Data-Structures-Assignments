/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 9
IDE Name: Microsoft Visual Studio
**/

import java.util.*;

public class ReachabilityMatrix
{
    //initializing variables
    private static int numNodes = 1;
    private static int[][] adjacencyMatrix;
    public static int[][] reachabilityMatrix;

    //print menu
    public static void print_menu()
    {
        System.out.println();
        System.out.println("------MAIN MENU------");
        System.out.println("1. Enter graph data");
        System.out.println("2. Print outputs");
        System.out.println("3. Exit program");
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        //initialize variables and objects
        int userOption;
        Scanner scanner = new Scanner(System.in);
        do
        {
            print_menu();
            System.out.println("Enter an option: ");
            userOption = scanner.nextInt();
            scanner.nextLine();
            switch (userOption) {
                case 1://enter data
                    readData(scanner);
                    break;
                case 2://print output
                    if(adjacencyMatrix == null)
                    {
                        System.out.println("Enter data fiirst.");
                        break;
                    }
                    System.out.println("Input Matrix: ");
                    printMatrix(adjacencyMatrix);
                    System.out.println("\nReachability Matrix:");
                    printMatrix(reachabilityMatrix);
                    System.out.println("\nIn-degrees:");
                    inDegree();
                    System.out.println("\nOut-degrees:");
                    outDegree();
                    System.out.println("\nTotal number of self-loops: " + selfLoops());
                    System.out.println("Total number of cycles of length " + numNodes + " edges: " + nCycles(numNodes));
                    System.out.println("Total number of paths of length 1 edge: " + computePaths(1));
                    System.out.println("Total number of paths of length " + numNodes + " edges: " + computePaths(numNodes));
                    System.out.println("Total number of paths of length 1 to " + numNodes + " edges: " + allPaths());
                    System.out.println("Total number of cycles of length 1 to " + numNodes + " edges: " + allCycles());
                    break;
                case 3://exit
                    System.out.println("Exiting...");
                    break;
                default://invalid
                    System.out.println("Invalid option.");
                    break;
            }
        } while (userOption != 3);
        scanner.close();
    }
    public static void readData(Scanner scanner)
    {
        System.out.println("Enter number of nodes: ");
        numNodes = scanner.nextInt();
        scanner.nextLine();
        //check node value
        if(numNodes <= 0 || numNodes > 5)
        {
            System.out.println("Invalid number of nodes.");
            numNodes = 0;
            return;
        }
        //create adjacency matrix
        adjacencyMatrix = new int[numNodes][numNodes];
        for(int i = 0; i < numNodes; i++)
        {
            for(int j = 0; j < numNodes; j++)
            {
                System.out.print("Enter A1[" + i + ", " + j + "]:");
                adjacencyMatrix[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }
        //create reachability matrix
        reachMatrix(adjacencyMatrix);
    }
    public static void printMatrix(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void reachMatrix(int[][] matrix)
    {
        //initialize matrix
        reachabilityMatrix = new int[numNodes][numNodes];
        int[][] powMatrix = new int[numNodes][numNodes];
        //copy over matrix
        for(int i = 0; i < numNodes; i++)
        {
            for(int j = 0; j < numNodes; j++)
            {
                powMatrix[i][j] = matrix[i][j];
            }
        }
        //adding original matrix to reachability matrix
        for(int i = 0; i < numNodes; i++)
            {
                for(int j = 0; j < numNodes; j++)
                {
                    reachabilityMatrix[i][j] += powMatrix[i][j];
                }
            }
        for (int l = 1; l < numNodes; l++)
        {
            int[][] newPowMatrix = new int[numNodes][numNodes];
            for (int i = 0; i < numNodes; i++)
            {
                for (int j = 0; j < numNodes; j++)
                {
                    for (int k = 0; k < numNodes; k++)
                    {
                        newPowMatrix[i][j] += powMatrix[i][k] * adjacencyMatrix[k][j];
                    }
                }
            }
            powMatrix = newPowMatrix;
            //adding new power matric to reachability matrix
            for(int i = 0; i < numNodes; i++)
            {
                for(int j = 0; j < numNodes; j++)
                {
                    reachabilityMatrix[i][j] += powMatrix[i][j];
                }
            }
        }
    }
    public static void inDegree()
    {
        int[] inDegree = new int[numNodes];
        for(int i = 0; i < numNodes; i++)
        {
            for(int j = 0; j < numNodes; j++)
            {
                inDegree[i]+=adjacencyMatrix[j][i];
            }
        }
        for(int i = 0; i < numNodes; i++)
        {
            System.out.println("Node " + (i+1) + " in-degree is " + inDegree[i]);
        }
    }
    public static void outDegree()
    {
        int[] outDegree = new int[numNodes];
        for(int i = 0; i < numNodes; i++)
        {
            for(int j = 0; j < numNodes; j++)
            {
                outDegree[i]+=adjacencyMatrix[i][j];
            }
        }
        for(int i = 0; i < numNodes; i++)
        {
            System.out.println("Node " + (i+1) + " out-degree is " + outDegree[i]);
        }
    }
    public static int selfLoops()
    {
        int selfLoops = 0;
        for(int i = 0; i < numNodes; i++)
        {
            //adding diagonal of matrix
            selfLoops += adjacencyMatrix[i][i];
        }
        return selfLoops;
    }
    public static int nCycles(int length)
    {
        int numCycles = 0;
        int[][] powMatrix = new int[numNodes][numNodes];
        //copy adjacency matrix
        for (int i = 0; i < numNodes; i++)
        {
            for (int j = 0; j < numNodes; j++)
            {
                powMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }
        //calculate power matrix
        for (int l = 1; l < length; l++)
        {
            int[][] newPowMatrix = new int[numNodes][numNodes];
            for (int i = 0; i < numNodes; i++)
            {
                for (int j = 0; j < numNodes; j++)
                {
                    for (int k = 0; k < numNodes; k++)
                    {
                        newPowMatrix[i][j] += powMatrix[i][k] * adjacencyMatrix[k][j];
                    }
                }
            }
            powMatrix = newPowMatrix;
        }
        //count cycles
        for (int i = 0; i < numNodes; i++)
        {
            numCycles += powMatrix[i][i];
        }
        return numCycles;
    }
    public static int computePaths(int length)
    {
        int numPaths = 0;
        int[][] powMatrix = new int[numNodes][numNodes];
        //copy adjacency matrix
        for (int i = 0; i < numNodes; i++)
        {
            for (int j = 0; j < numNodes; j++)
            {
                powMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }
        //calculate power matrix
        for (int l = 1; l < length; l++)
        {
            int[][] newPowMatrix = new int[numNodes][numNodes];
            for (int i = 0; i < numNodes; i++)
            {
                for (int j = 0; j < numNodes; j++)
                {
                    for (int k = 0; k < numNodes; k++)
                    {
                        newPowMatrix[i][j] += powMatrix[i][k] * adjacencyMatrix[k][j];
                    }
                }
            }
            powMatrix = newPowMatrix;
        }
        //count paths
        for (int i = 0; i < numNodes; i++)
        {
            for (int j = 0; j < numNodes; j++)
            {
                numPaths += powMatrix[i][j];
            }
        }
        return numPaths;
    }
    public static int allPaths()
    {
        int numPaths = 0;
        for(int i = 1; i <= numNodes; i++)
        {
            numPaths += computePaths(i);
        }
        return numPaths;
    }
    public static int allCycles()
    {
        int numCycles = 0;
        for(int i = 1; i <= numNodes; i++)
        {
            numCycles += nCycles(i);
        }
        return numCycles;
    }
}
