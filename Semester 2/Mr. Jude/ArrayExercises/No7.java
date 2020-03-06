import java.util.Scanner;
import java.util.Arrays;

class No7 {
    public static void main(String[] args) {
        System.out.println("No. 7");
        int[] mainarr = {1,2,3,4,5,6,7,8,9,10};
        int[] firstarr = new int[mainarr.length / 2];
        int[] secondarr = new int[firstarr.length];
        System.out.println("Before split: ");
        for(int i = 0; i < mainarr.length; i++) {
            System.out.println(mainarr[i]);
            if (i < firstarr.length) {
                firstarr[i] = mainarr[i];
            } else {
                secondarr[i-firstarr.length] = mainarr[i];
            }
        }
        System.out.println("After split: ");
        System.out.println("First half: ");
        for(int i = 0; i < firstarr.length; i++) {
            System.out.println(firstarr[i]);
        }
        System.out.println("Second half: ");
        for(int i = 0; i < secondarr.length; i++) {
            System.out.println(secondarr[i]);
        }
    }
}