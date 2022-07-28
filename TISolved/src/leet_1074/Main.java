package leet_1074;

public class Main {

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }

    //시작점 끝점 정하고
    //다 더해서
    // target이랑 비교

    // 100^4 인거 같은데,,, 이거 다 모아서 더하는것까지 하면, 1억 + a = 1초 넘을거 같다.
    // 부분합 문제인거 같다. 일단 (0,0) 부터 (n,n)까지 합을 다 만들어 놓기
    // 이건 100^2 * n^2 걸릴거 같다.
    // A - B - C + (공통으로 뺀거) 로 target이랑 같은지 비교해서 하자..


    public int numSubmatrixSumTarget(int[][] matrix, int target) {


        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {

                for (int dy = y + 1; dy < matrix.length; dy++) {
                    for (int dx = x + 1; dx < matrix[0].length; dx++) {
                        //부분합 해야하나...
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {

    }
}
