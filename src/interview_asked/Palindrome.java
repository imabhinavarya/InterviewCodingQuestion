package interview_asked;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
//        String s = "malayalam";
//        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String str) {
        int s=0, e = str.length()-1;
        while(s<e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            s++; e--;
        }
        return true;
    }

    ////////////////////////////////////////////////////////////////////
    public static int binary(int[] arr, int tar){
        int si=0,ei=arr.length-1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(arr[mid]==tar){
                return mid;
            } else if(arr[mid]<tar){
                si=mid+1;
            } else{
                ei=mid-1;
            }
        }
        return -1;
    }
}
