package leet_1647;

import java.util.Arrays;
import java.util.OptionalInt;

public class Main {

    // 26 알파벳 array 0으로 init 하고
    // 앞에서 부터 확인하면서 ++  -> n
    // 정렬 -> 26log26

    // 앞에서부터 확인하면서, frequency가 중복되는지 확인

    // 결국 다 해봐야되는거 아닌가,,?
    // 최적의 방법은 없고, 중복되는애를 a ~ char - 1 까지 중복되지 않도록 만들어서 확인하는 방법 밖에는,,

    // 결국 중복되는애를 줄여서 어디론가 보내야한다.
    // 정렬해서 작은애를 작은 수로 보내는게 좋을듯.

    //n 으로 풀수 있을듯.
    //26*26

    public static int minDeletions(String s) {
        int frequency[] = new int[26];
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        Arrays.sort(frequency);

        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i - 1] != 0 && frequency[i] == frequency[i - 1]) {
                //중복 이니깐, prev를 낮춰버린다.

                for (int j = frequency[i - 1] - 1; j >= 0; j--) {
                    int finalJ = j;
                    OptionalInt find = Arrays.stream(frequency).filter(f -> finalJ == f).findFirst();
                    if (find.isEmpty() || finalJ == 0) {
                        result += frequency[i - 1] - finalJ;
                        frequency[i - 1] = finalJ;
                        break;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("ceabaacb"));
    }
}
