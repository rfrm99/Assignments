import java.util.*;

public class Utility {
    public static void splitHigh(int n) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[n];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < n; i++) { ;
            arr[i] = scan.nextInt();
            if(i > 0){
                for(int j = 0; j < i; j++) {
                    if (arr[i] == arr[j]) {
                        System.out.println("Number Exists Input Another Number");
                        arr[i] = scan.nextInt();
                    }
                }
            }
        }
        int[] sampout = new int[arr.length + 1]; //a list to hold new values
        int biggest = arr[0];
        int nextbiggest = arr[0];
        int keepindex = -1;
        System.out.println("Before process: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            if (arr[i] > biggest) {
                biggest = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > nextbiggest && arr[i] < biggest) {
                nextbiggest = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == biggest) {
                sampout[i] = nextbiggest;
                sampout[i + 1] = biggest - nextbiggest;
                keepindex = i;
            }else if (keepindex == -1){
                sampout[i] = arr[i];

            } else if (i > keepindex) {
                sampout[i + 1] = arr[i];
            }
        }
        arr = sampout; //giving original list the new values
        System.out.println("After process: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void switcheroo(int[] arr, int rotation) {
        int[] arrtemp = new int[arr.length];

        for (int i = 0; i < rotation; i++) {
            arrtemp[0] = arr[arr.length - 1];

            for (int j = 0; j < arrtemp.length - 1; j++) {
                arrtemp[1 + j] = arr[j];
            }
            for (int k = 0; k < arrtemp.length; k++) {
                arr[k] = arrtemp[k];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void symmetry() {
        Scanner scan = new Scanner(System.in);
        int flag = 0;
        int[][] multi = new int[3][3];
        int[][] transpose = new int[3][3];
        System.out.println("Enter 9 numbers to input to a matrix");
        for (int i = 0; i < multi.length; i++) {
            for (int j = 0; j < multi[i].length; j++) {
                multi[i][j] = scan.nextInt();
            }
        }
        System.out.println("Inputed Matrix:\n");
        for (int i = 0; i < multi.length; i++) {
            for (int j = 0; j < multi[i].length; j++) {
                System.out.print(multi[i][j] + " ");
            }
            System.out.print("\n");
        }
        for (int i = 0; i < multi[0].length; i++) {
            for (int j = 0; j < multi.length; j++) {
                if (multi[i][j] == multi[j][i]){
                    flag = 1;
                }
                else{
                    flag = 0;
                    break;
                }
            }
        }
        if (flag == 1){
            System.out.println("Symmetrical");
        }else{
            System.out.println("Not Symetrical");
        }
    }

    static void magicSquare(int n)
    {
        int[][] magicSquare = new int[n][n];

        // Initialize position for 1 since one is always in the same area
        int i = n/2;
        int j = n-1;

        // One by one put all values in magic square
        for (int num=1; num <= n*n; )
        {
            if (i==-1 && j==n) //3rd condition for value placement
            {
                j = n-2;
                i = 0;
            }
            else
            {
                //1st condition helper if next number goes out of index
                if (j == n)
                    j = 0;

                //1st condition helper if next number goes put of index
                if (i < 0)
                    i=n-1;
            }

            //2nd condition for value input
            if (magicSquare[i][j] != 0)
            {
                j -= 2;
                i++;
                continue;
            }
            else
                //set number
                magicSquare[i][j] = num++;

            //1st condition
            j++;  i--;
        }

        // print magic square
        System.out.println("The Magic Square for "+n+":");
        System.out.println("Sum of each row or column "+n*(n*n+1)/2+":"); //equation to find out the sum
        for(i=0; i<n; i++)
        {
            for(j=0; j<n; j++)
                System.out.print(magicSquare[i][j]+" ");
            System.out.println();
        }
    }
}

