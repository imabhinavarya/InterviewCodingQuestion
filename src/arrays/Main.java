package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Main main = new Main();
        int[] cand = {10,1,2,7,6,1,5};
        int tar=8;
//        int[] cand = {2,5,2,1,2};
//        int tar=5;
        List<List<Integer>> list = main.allCombinationOfTarget(cand, tar);
        System.out.println(list);

        System.out.println("===============4================");
        int[] h={7,7,8,6,5};
        System.out.println(minArrow(h));
    }

    private static void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    public List<List<Integer>> allCombinationOfTarget(int[] arr, int tar){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        helper(0, arr, tar, ans, new ArrayList<>());
        return ans;
    }

    public void helper(int idx, int[] arr, int tar, List<List<Integer>> ans, List<Integer> temp){
        if(tar==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if(i>idx && arr[i]==arr[i-1]) continue;
            if(tar<arr[i]) break;

            temp.add(arr[i]);
            helper(i+1,  arr,tar-arr[i], ans,temp);
            temp.removeLast();
        }
    }

    public static int minArrow(int[] h){
        // 7 7 8 6 5
        int count=0;
        for(int i : h){
            int max = maxi(h);
            if(max<0) break;
            for(int j=0;j<h.length;j++){
                if(max==h[j]){
                    h[j]=0;
                    max--;
                }
            }
            if(max>0) count++;
        }
        return count;
    }

    public static int maxi(int[] h){
        int max=-1;
        for(int i : h){
            if(i>max){
                max=i;
            }
        }
        return max;
    }
}