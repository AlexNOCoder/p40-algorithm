package k_th_smallest_prime_fraction_786;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionByAlex {

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] temp = new int[2];
                temp[0] = arr[i];
                temp[1] = arr[j];
                list.add(temp);
            }
        }
        Collections.sort(list, (x, y) -> x[0] * y[1] - x[1] * y[0]);
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3};
        System.out.println(1^2^3^4^2);
    }
}


