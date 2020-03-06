import java.util.Scanner;
import java.util.Arrays;

class No3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("No. 3");
        int[] x2 = new int[20];
        int postotal = 0;
        int negtotal = 0;
        int odd = 0;
        int even = 0;
        int zeros = 0;


        for (int i = 0; i < x2.length; i++) {
            System.out.println("Enter number " + (i + 1) + ": ");
            x2[i] = scan.nextInt();
        }
        for (int i = 0; i < x2.length; i++) {
            if (x2[i] > 0 && x2[i] % 2 != 0) {
                postotal += 1;
                odd += 1;
            } else if (x2[i] > 0 && x2[i] % 2 == 0) {
                postotal += 1;
                even += 1;
            } else if (x2[i] < 0 && x2[i] % 2 != 0) {
                odd += 1;
                negtotal += 1;
            } else if (x2[i] < 0 && x2[i] % 2 == 0) {
                even += 1;
                negtotal += 1;
            } else if (x2[i] == 0) {
                zeros += 1;
            }
        }
        System.out.println("Positive Numbers: " + postotal);
        System.out.println("Negative Numbers: " + negtotal);
        System.out.println("Odd Numbers: " + odd);
        System.out.println("Even Numbers: " + even);
        System.out.println("Number of Zeros: " + zeros);
    }
}