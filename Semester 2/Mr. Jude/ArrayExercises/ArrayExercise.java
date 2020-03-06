import java.util.Scanner;
import java.util.Arrays;

class ArrayExercise {
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
    //Function for number 2, finding out if an element exists in an array
    public static void findElement(int[] arr, int y) {
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == y) {
                flag = 1;
                break;
            } else {
                flag = 0;
            }
        }
        if (flag == 1) {
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
    public static void main(String[] args) {
        int[] x1 = new int[10]; //creates an array
        Scanner scan = new Scanner(System.in);

        System.out.println("No. 1 and 2");
        for(int i = 0; i < x1.length; i++) {
            System.out.println("Enter number " + (i+1) + ": " );
            x1[i] = scan.nextInt();
        }
        for(int i = 0; i<x1.length; i++) {
            System.out.println(x1[i]);
        }
        System.out.println("Enter number you want to find in the array: ");
        int number = scan.nextInt();
        findElement(x1, number);

        //3
        System.out.println("No. 3");
        int[] x2 = new int[20];
        int postotal = 0;
        int negtotal = 0;
        int odd = 0;
        int even = 0;
        int zeros = 0;


        for(int i = 0; i < x2.length; i++) {
            System.out.println("Enter number " + (i+1) + ": " );
            x2[i] = scan.nextInt();
        }
        for(int i = 0; i<x2.length; i++) {
            if(x2[i] > 0 && x2[i] %2 != 0){
                postotal += 1;
                odd += 1;
            }else if(x2[i] > 0 && x2[i] %2 == 0){
                postotal += 1;
                even += 1;
            }else if(x2[i] < 0 && x2[i] % 2 != 0){
                odd += 1;
                negtotal += 1;
            }else if(x2[i] < 0 && x2[i] % 2 == 0){
                even += 1;
                negtotal += 1;
            }else if(x2[i] == 0){
                zeros += 1;
            }
        }
        System.out.println("Positive Numbers: " + postotal);
        System.out.println("Negative Numbers: " + negtotal);
        System.out.println("Odd Numbers: " + odd);
        System.out.println("Even Numbers: " + even);
        System.out.println("Number of Zeros: " + zeros);

        //4
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

        //5
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

        //6
        System.out.println("No. 6");
        int[] x4 = {1, 2, 3, 3, 2, 1};
        for(int i = 0; i < x4.length; i++){
            System.out.println(x4[i]);
        }
        System.out.println("Is it a the same front and back?");
        check(x4);

        //7
        System.out.println("No. 7");
        int[] mainarr = {1,2,3,4,5,6};
        //int[] mainarr = {1,2,3,4,5}; to try an odd number
        if(mainarr.length % 2 == 0) { //for even number length of list
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
        }else if(mainarr.length % 2 != 0){ //for odd number length of list
            int[] firstarr = new int[(mainarr.length+1)/2];
            int[] secondarr = new int[mainarr.length - firstarr.length];
            for(int i = 0; i < mainarr.length; i++) {
                if (i < firstarr.length) {
                    firstarr[i] = mainarr[i];
                } else {
                    secondarr[i - firstarr.length] = mainarr[i];
                }
            }
            System.out.println("After split: ");
            System.out.println("First half: ");
            for(int i = 0; i < firstarr.length; i++) {
                System.out.println(firstarr[i]);
            }
            System.out.println("Second half:");
            for(int i = 0; i < secondarr.length; i++) {
                System.out.println(secondarr[i]);
            }
        }

        //8
        System.out.println("No. 8");
        int[] sample = {4,8,6,3,2};
        int[] sampout = new int[sample.length+1]; //a list to hold new values
        int biggest = sample[0];
        int temp1 = 0;
        int temp2 = 0;
        int keepindex = 0;
        System.out.println("Before process: ");
        for (int i = 0; i < sample.length; i++) {
            System.out.println(sample[i]);
            if (sample[i] > biggest) {
                biggest = sample[i];
            }
        }
        for(int i = 0; i < sample.length; i++) {
            for (int j = i; j > 0; j--) {
                if ((sample[j] + sample[i]) == biggest) { //this part iterates through evey possible pair and finds the pair that matches

                    temp1 = sample[j];
                    temp2 = sample[i];
                }
            }
        }
        for(int i = 0; i < sample.length; i++) {
            if(sample[i] == biggest){
                sampout[i] = temp1;
                sampout[i+1] = temp2;
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

        //9
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
        //10
        System.out.println("No. 10");
        int[] x5 = {5,2,3,1,6,7,4};
        int temp5 = 0;
        System.out.println("Before Sorting:");
        for(int i = 0; i < x5.length; i++) {
            System.out.println(x5[i]);
            for(int j = i; j > 0; j--){ //this part checks every possible pair from the front one by one
                if (x5[j] < x5[j-1]){
                    temp = x5[j];
                    x5[j] = x5[j-1];
                    x5[j-1] = temp;
                }
            }
        }
        System.out.println("After Sorting: ");
        for(int i = 0; i < x5.length; i++) {
            System.out.println(x5[i]);
        }
        //Can use java.util.Array.sort
    }
}