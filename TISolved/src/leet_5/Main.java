package leet_5;

public class Main {


    // 팰린드롬인지 확인하는 함수 n
    // 다 확인하면 n^2
    // -> n^2 * n  = n^3
    // 1000 * 1000 * 1000  = 10억 .. 너무 큼
//    public static String longestPalindrome(String s) {
//        if (s.length() == 1) {
//            return s;
//        }
//        int maxLength = Integer.MIN_VALUE;
//        String result = "";
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                String compareStr = s.substring(i, j);
//                if (maxLength < compareStr.length() && isPalindrome(compareStr)) {
//                    maxLength = compareStr.length();
//                    result = compareStr;
//                }
//            }
//        }
//        return result;
//    }


    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }

    static String[][] mem;
    static String fullStr;

    public static String longestPalindrome(String s) {
        mem = new String[1001][1001];
        fullStr = s;

        for (int i = 0; i < s.length(); i++) {
            mem[i][i + 1] = String.valueOf(s.charAt(i));
        }

        return dp(0, s.length());
    }


    public static String dp(int i, int j) {
        if (i < 0 || j < 0) {
            return "";
        }
        if (mem[i][j] != null) {
            return mem[i][j];
        }

        String currStr = fullStr.substring(i, j);
        if (isPalindrome(currStr)) {
            mem[i][j] = currStr;
            return currStr;
        }
        String firstStr = dp(i, j - 1);
        String secondStr = dp(i + 1, j);

        String moreStr = firstStr.length() < secondStr.length() ? secondStr : firstStr;
        return moreStr;
    }

    public static void main(String[] args) {
        System.out.printf(longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }
}
