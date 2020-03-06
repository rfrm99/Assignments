import java.util.Scanner;
import java.util.Arrays;

class No8 {
    public static void main(String[] args) {
        System.out.println("No. 8");
        int[] sample = {4,8,6,3,2};
        int[] sampout = new int[sample.length+1]; //a list to hold new values
        int biggest = sample[0];
        int nextbiggest = sample[0];
        int keepindex = 0;
        System.out.println("Before process: ");
        for (int i = 0; i < sample.length; i++) {
            System.out.println(sample[i]);
            if (sample[i] > biggest) {
                biggest = sample[i];
            }
        }
        for (int i = 0; i < sample.length; i++) {
            if (sample[i] > nextbiggest && sample[i] < biggest) {
                nextbiggest = sample[i];
            }
        }
        for(int i = 0; i < sample.length; i++) {
            if(sample[i] == biggest){
                sampout[i] = nextbiggest;
                sampout[i+1] = biggest- nextbiggest;
                keepindex = i;
            }else if(i > keepindex){
                sampout[i+1] = sample[i];
            }else{
                sampout[i] = sample[i];
            }
        }
        sample = sampout; //giving original list the new values
        System.out.println("After process: ");
        for(int i = 0; i < sample.length; i++) {
            System.out.println(sample[i]);
        }
    }
}