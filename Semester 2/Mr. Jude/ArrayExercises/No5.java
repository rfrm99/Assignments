import java.util.Scanner;
import java.util.Arrays;

class No5 {
    public static void main(String[] args) {
        int[] x3 = {4,5,3,2,1};
        System.out.println("No. 5");
        int tempbig = x3[0];
        int tempsmol = x3[0];
        for (int i = 1; i < x3.length;i++){
            if(x3[i] > tempbig){
                tempbig = x3[i];
            }
        }
        for (int i = 1; i < x3.length;i++) {
            if (x3[i] < tempsmol) {
                tempsmol = x3[i];
            }
        }
        System.out.println("Biggest Number: " + tempbig);
        System.out.println(("Smallest Number: " + tempsmol));
    }
}