import java.util.Scanner;
import java.util.Arrays;

class No6 {
    //Function for number 6, checking if its the same front and back
    public static void check(int[] arr){
        int flag = 0;
        for (int i = 0; i <= arr.length/2 && arr.length!= 0; i++){ //looping until half an array size
            if (arr[i] != arr[arr.length - i - 1]) { //Checking if the first element != the last element
                flag = 0;
            }else{
                flag = 1;
            }
        }
        if(flag == 1) {
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
    public static void main(String[] args) {
        System.out.println("No. 6");
        int[] x4 = {1, 2, 3, 3, 2, 1};
        for(int i = 0; i < x4.length; i++){
            System.out.println(x4[i]);
        }
        System.out.println("Is it a the same front and back?");
        check(x4);
    }
}