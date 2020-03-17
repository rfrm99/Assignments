import java.util.*;

public class Driver {
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Enter the length of array you want to input");
        int n = scan.nextInt();
        Utility.splitHigh(n);
        System.out.println("2. Enter numbers to create array of 5");
        int[] arr = {1,2,3,4,5};
        Utility.switcheroo(arr, 5);
        System.out.println("3. Symmetry");
        Utility.symmetry();
        int nn = scan.nextInt();
        Utility.magicSquare(nn);
    }
}
