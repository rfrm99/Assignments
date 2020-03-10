import java.util.Scanner;
import java.util.Arrays;

class No1 {
    public static void main(String[] args) {
        int[] x1 = new int[10]; //creates an array
        Scanner scan = new Scanner(System.in);

        System.out.println("No. 1");
        for (int i = 0; i < x1.length; i++) {
            System.out.println("Enter number " + (i + 1) + ": ");
            x1[i] = scan.nextInt();
        }
        for (int i = 0; i < x1.length; i++) {
            System.out.println(x1[i]);
        }
    }
}