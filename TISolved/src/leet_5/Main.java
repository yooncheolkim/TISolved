package leet_5;

public class Main {


    public static String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        int maxLength = Integer.MIN_VALUE;
        String result = "";
        for(int i = 0 ; i < s.length(); i++){
            for(int j = i+1 ; j <= s.length(); j++){
                String compareStr = s.substring(i,j);
                if(maxLength < compareStr.length() && isPalindrome(compareStr)){
                    maxLength = compareStr.length();
                    result = compareStr;
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String s){
        if(s.length() == 1){
            return true;
        }
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.printf(longestPalindrome("bb"));
    }
}
