package leet_2171;

import java.util.Arrays;

public class Main {

    // 100000 * 100000 =

    // 제거하는거만 가능하다.

    // 결국 전체 탐색 해야하는데
    // 특정한 수로 맞추는 작업 -> 그 특정한 수? 알수 없으니깐
    // 가장 큰수부터 차례로 작아지면서, 최소값을 구하면 될듯..?
    // 100000 * 100000  = 10000000000


    //줄일수 잇는 방법
    // 정렬해서 생각해보자
    // 100000 * log 100000

    // 2 2 3 10  -> 0 0 0 10
    // 전체합 17
    // 전체합
    // 1 4 5 6   -> 0 4 4 4

    // 0으로 계속 만들어나가는 값을 계산하고,, 앞에서부터
    // 어디까지 0으로 만들고 이후는 그걸로 낮출거냐를 결정하면된다.

    // int sum [2][beans.length] =

    // 0 : 0 ~ i까지 0으로 만드는 비용합
    // 1 : i+1부터, 나머지를 i+1로 만드는 비용

    public static long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int cache[][] = new int[beans.length][2];

        int sum = 0;

        for(int b : beans){
            sum+= b;
        }

        cache[0][0] = beans[0];
        cache[0][1] = sum - cache[0][0] - beans[0]*(beans.length - 1);

        for(int i = 1 ; i < beans.length; i++){
            cache[i][0] = cache[i-1][0] + beans[i];
            cache[i][1] = sum - cache[i][0] - beans[i]*(beans.length - i - 1);
        }

        long result = Long.MAX_VALUE;

        for(int i = 1 ; i < beans.length; i++){
            result = result > cache[i][0] + cache[i][1] ? cache[i][0] + cache[i][1] : result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {2, 10, 3, 2};
        System.out.println(minimumRemoval(input));
    }
}
