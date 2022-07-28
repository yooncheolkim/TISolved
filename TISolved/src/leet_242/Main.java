package leet_242;

public class Main {

    public static boolean isAnagram(String s, String t) {
        int sCount[] = new int[26];
        int tCount[] = new int[26];

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sCount[i] != tCount[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("nl", "cx"));
    }
}
