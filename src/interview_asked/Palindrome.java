package interview_asked;

public class Palindrome {
    public static void main(String[] args) {
        String s = "malayalam";
        System.out.println(isPalindrome(s));
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
}
