import java.util.Scanner;
import java.util.Arrays;

class No10 {
    public static void main(String[] args) {
        System.out.println("No. 10");
        int[] x5 = {5, 2, 3, 1, 6, 7, 4};
        int temp5 = 0;
        int temp = 0;
        System.out.println("Before Sorting:");
        for (int i = 0; i < x5.length; i++) {
            System.out.println(x5[i]);
            for (int j = i; j > 0; j--) { //this part checks every possible pair from the front one by one
                if (x5[j] < x5[j - 1]) {
                    temp = x5[j];
                    x5[j] = x5[j - 1];
                    x5[j - 1] = temp;
                }
            }
        }
        System.out.println("After Sorting: ");
        for (int i = 0; i < x5.length; i++) {
            System.out.println(x5[i]);
        }
        //Can use java.util.Array.sort
    }
}