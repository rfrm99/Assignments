import java.util.Scanner;
import java.util.Arrays;

class No9 {
    public static void main(String[] args) {
        System.out.println("No. 9");
        int temp = 0;
        int[] x6 = {1,2,3,4,5};
        int[] temparr = new int[5];
        System.out.println("Before swap: ");
        for(int i = 0; i < x6.length; i++) {
            System.out.println(x6[i]);
            temp = x6[i]; //sets temporary value
            temparr[x6.length-1-i] = temp; //temporary array given temporary value from a reverse index
        }
        x6 = temparr;
        System.out.println("After swap: ");
        for(int i = 0; i < x6.length; i++) {
            System.out.println(x6[i]);
        }
    }
}