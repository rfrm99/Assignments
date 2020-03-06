import java.util.Scanner;
import java.util.Arrays;

class No4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("No. 4");
        int[] x3 = new int[5];
        int sum = 0;
        int prod = 1;
        for(int i = 0; i < x3.length; i++) {
            System.out.println("Enter number " + (i + 1) + ": ");
            x3[i] = scan.nextInt();
        }
        for(int i = 0; i < x3.length; i++) {
            sum += x3[i];
            prod = prod*x3[i];
        }
        System.out.println("Sum of all elements: "+sum);
        System.out.println("Product of all elements: " +prod);
    }
}