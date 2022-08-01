package leet_62;

public class Main {

    static int mem[][] = new int[101][101];

    public static int dp(int m, int n) {
        if (mem[m][n] != -1) return mem[m][n];

        mem[m][n] = dp(m - 1, n) + dp(m, n - 1);
        return mem[m][n];
    }

    public static int uniquePaths(int m, int n) {

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                mem[i][j] = -1;
            }
        }
        mem[0][0] = 0;
        for (int i = 1; i < 101; i++) {
            mem[i][1] = 1;
            mem[1][i] = 1;
        }
        mem[1][1] = 1;
        return dp(m, n);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
