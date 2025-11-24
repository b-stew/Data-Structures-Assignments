/** 
Name: Bradley Stewart
Class: CS 3305/Section 01
Term: Spring 2024
Instructor: Dr. Haddad
Assignment: 6
IDE Name: Microsoft Visual Studio
**/

import java.util.*;
public class MyTestBST 
{
    public static void print_menu()//menu
    {
        System.out.println();
        System.out.println("----------------MAIN MENU---------------");
        System.out.println("0. Enter Tree Data Type (integer or string)");
        System.out.println("1. Insert Data Element");
        System.out.println("2. Delete Data Element");
        System.out.println("3. Search for Data Element"); 
        System.out.println("4. Print Tree Size");
        System.out.println("5. Path from Root to Data Element");
        System.out.println("6. Check if Empty Tree");
        System.out.println("7. Print Preorder Traversal");
        System.out.println("8. Print Inorder Traversal");
        System.out.println("9. Print Postorder Traversal");
        System.out.println("10. Exit program ");
        System.out.println();
    }
    public static void main(String[] args)
    {
        //initialize objects and variables
        Scanner scanner = new Scanner(System.in);
        BST<String> stringTree = new BST<String>();
        BST<Integer> integerTree = new BST<Integer>();
        int userOption = 0;
        String dataType = "";
        boolean success = false;
        //initial setting of type
        while(!(dataType.equals("integer") || dataType.equals("string")))
        {
            System.out.println("Enter Tree Data Type (integer or string)");
            dataType = scanner.nextLine().strip().toLowerCase();
        }
        while(userOption != 10)
        {
            print_menu();
            System.out.println("Enter option number: ");
            userOption = scanner.nextInt();
            scanner.nextLine();
            switch(userOption)
            {
                case 0://data type
                    dataType = scanner.nextLine().strip().toLowerCase();
                    if(dataType.equals("integer") || dataType.equals("string"))
                    {
                        System.out.println("Data type set.");
                    }
                    else
                    {
                        System.out.println("Invalid type");
                    }
                    break;
                case 1://insert
                    System.out.println("Enter the data element you want to insert");
                    if(dataType.equals("integer"))
                    {
                        int userInputInteger = scanner.nextInt();
                        scanner.nextLine();
                        integerTree.insert(userInputInteger);
                    }
                    else if(dataType.equals("string"))
                    {
                        String userInputString = scanner.nextLine().strip();
                        stringTree.insert(userInputString);
                    }
                    break;
                case 2://delete
                    if(dataType.equals("integer"))
                    {
                        if(integerTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.println("Enter the element you want to delete: ");
                        int userInputInteger = scanner.nextInt();
                        scanner.nextLine();
                        success = integerTree.delete(userInputInteger);
                    }
                    else if(dataType.equals("string"))
                    {
                        if(stringTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.println("Enter the element you want to delete: ");
                        String userInputString = scanner.nextLine().strip();
                        success = stringTree.delete(userInputString);
                    }
                    if(success)
                    {
                        System.out.println("Successfully deleted.");
                    }
                    else
                    {
                        System.out.println("Node not found.");
                    }
                    break;
                case 3://search
                    if(dataType.equals("integer"))
                    {
                        if(integerTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.println("Enter the element you want to search for: ");
                        int userInputInteger = scanner.nextInt();
                        scanner.nextLine();
                        success = integerTree.search(userInputInteger);
                    }
                    else if(dataType.equals("string"))
                    {
                        if(stringTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.println("Enter the element you want to search for: ");
                        String userInputString = scanner.nextLine().strip();
                        success = stringTree.search(userInputString);
                    }
                    if(success == true)
                    {
                        System.out.println("Element found.");
                    }
                    break;
                case 4://tree size
                    if(dataType.equals("integer"))
                    {
                        System.out.println("Tree size: " + integerTree.size);
                    }
                    else if(dataType.equals("string"))
                    {
                        System.out.println("Tree size: " + stringTree.size);
                    }
                    break;
                case 5://path from root
                    if(dataType.equals("integer"))
                    {
                        if(integerTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.println("Enter the element you want to find the path to: ");
                        int userInputInteger = scanner.nextInt();
                        scanner.nextLine();
                        ArrayList<BST.TreeNode<Integer>> path = integerTree.path(userInputInteger);
                        System.out.print("Path is: ");
                        for (int i = 0; path != null && i < path.size(); i++)//printing loop
                        {
                            System.out.print(path.get(i).element + " ");
                        }
                    }
                    else if(dataType.equals("string"))
                    {
                        if(stringTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.println("Enter the element you want to find the path to: ");
                        String userInputString = scanner.nextLine().strip();
                        ArrayList<BST.TreeNode<String>> path = stringTree.path(userInputString);
                        System.out.print("Path is: ");
                        for (int i = 0; path != null && i < path.size(); i++)//printing loop
                        {
                            System.out.print(path.get(i).element + " ");
                        }
                    }
                    System.out.println();
                    break;
                case 6://check if empty
                    if(dataType.equals("integer"))
                    {
                        if(integerTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                        }
                        else
                        {
                            System.out.println("Tree is not empty.");
                        }
                    }
                    else if(dataType.equals("string"))
                    {
                        if(stringTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                        }
                        else
                        {
                            System.out.println("Tree is not empty.");
                        }
                    }
                    break;
                case 7://preorder
                    if(dataType.equals("integer"))
                    {
                        if(integerTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.print("Preorder: ");
                        integerTree.preorder();
                    }
                    else if(dataType.equals("string"))
                    {
                        if(stringTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.print("Preorder: ");
                        stringTree.preorder();
                    }
                    System.out.println();
                    break;
                case 8://in order
                    if(dataType.equals("integer"))
                    {
                        if(integerTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.print("Inorder: ");
                        integerTree.inorder();
                    }
                    else if(dataType.equals("string"))
                    {
                       if(stringTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.print("Inorder: ");
                        stringTree.inorder();
                    }
                    System.out.println();
                    break;
                case 9://post order
                    if(dataType.equals("integer"))
                    {
                        if(integerTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.print("Postorder: ");
                        integerTree.postorder();
                    }
                    else if(dataType.equals("string"))
                    {
                        if(stringTree.isEmpty())//empty case
                        {
                            System.out.println("Tree is empty.");
                            break;
                        }
                        System.out.print("Postorder: ");
                        stringTree.postorder();
                    }
                    System.out.println();
                    break;
                case 10://exit
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        scanner.close();
    }
}
