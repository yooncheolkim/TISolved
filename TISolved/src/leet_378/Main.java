package leet_378;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static int kthSmallest(int[][] matrix, int k) {
        List<Integer> all = new ArrayList();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                all.add(matrix[i][j]);
            }
        }

        Collections.sort(all);
        return all.get(k - 1);
    }

    public static void main(String[] args) {
        int input[][] = new int[3][3];
        input[0] = new int[]{1, 5, 9};
        input[1] = new int[]{10, 11, 13};
        input[2] = new int[]{12, 13, 15};

        System.out.println(kthSmallest(input, 8));
    }
}
