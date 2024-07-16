package arrays;

import java.util.Arrays;

public class Main {
    private static void rotateByK(int[] arr, int k){
    int n=arr.length;
    k= k % n;

    rev(arr,0,n-1);
    rev(arr,0,k-1);
    rev(arr,k,n-1);
    }

    private static void rev(int[] arr, int s, int e) {
        while(s<e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;e--;
        }
    }


    private static void rotate90(int[][] arr){
        int n=arr.length;
        for (int i=0;i<n/2;i++){
            for (int j = i; j <n-i-1 ; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n-j-1][i];
                arr[n-j-1][i] = arr[n-i-1][n-j-1];
                arr[n-i-1][n-j-1] = arr[j][n-i-1];
                arr[j][n-i-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("===============1================");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        rotate90(matrix);

        System.out.println("Rotated matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("===============2================");
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        rotateByK(arr,k);
        printArr(arr);

        System.out.println("===============3================");
    }

    private static void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i+ " ");
        }
        System.out.println();
    }
}