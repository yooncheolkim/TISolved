package leet_2171;

import java.util.Arrays;

public class Main {
    // 결국 전체 탐색 해야하는데
    // 특정한 수로 맞추는 작업 -> 그 특정한 수? 알수 없으니깐
    // 가장 큰수부터 차례로 작아지면서, 최소값을 구하면 될듯..?
    // 100000 * 100000  = 10000000000

    //줄일수 잇는 방법
    // 정렬해서 생각해보자
    // 100000 * log 100000

    // 0으로 계속 만들어나가는 값을 계산하고,, 앞에서부터
    // 어디까지 0으로 만들고 이후는 그걸로 낮출거냐를 결정하면된다.

    // int sum [2][beans.length] =

    // 0 : 0 ~ i까지 0으로 만드는 비용합
    // 1 : i+1부터, 나머지를 i+1로 만드는 비용

    public static long minimumRemoval(int[] beans) {
        if (beans.length == 1) {
            return 0;
        }

        Arrays.sort(beans);
        long sum = 0;
        for (int b : beans) {
            sum += b;
        }
        long result = Long.MAX_VALUE;
        for (int i = 0; i < beans.length; i++) {
            long beansToRemove = sum - (long) beans[i] * (beans.length - i);
            result = Math.min(result, beansToRemove);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {43, 44, 45, 46, 47};
        System.out.println(minimumRemoval(input));
    }
}
