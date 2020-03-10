import java.util.Scanner;
import java.util.Arrays;

class No2 {
    //Function for number 2, finding out if an element exists in an array
    public static void findElement(int[] arr, int y) {
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == y) {
                flag = 1;
                break;
            } else {
                flag = 0;
            }
        }
        if (flag == 1) {
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    public static void main(String[] args) {
        int[] x1 = new int[10]; //creates an array
        Scanner scan = new Scanner(System.in);

        System.out.println("No. 2");
        for(int i = 0; i < x1.length; i++) {
            System.out.println("Enter number " + (i+1) + ": " );
            x1[i] = scan.nextInt();
        }
        for(int i = 0; i<x1.length; i++) {
            System.out.println(x1[i]);
        }
        System.out.println("Enter number you want to find in the array: ");
        int number = scan.nextInt();
        findElement(x1, number);
    }
}