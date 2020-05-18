package assign_cookies_455;

public class SolutionByCdtft {

    public int findContentChildren(int[] g, int[] s) {
        quickSort(g, 0, g.length);
        quickSort(s, 0, s.length);
        int index = 0;
        int total = 0;
        for (int i = 0; i < g.length; i++) {
            while(index < s.length) {
                if (g[i] <= s[index]) {
                    total++;
                    index++;
                    break;
                }
                index++;
            }
        }
        return total;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int p = partition(array, left, right);
        quickSort(array, left, p - 1);
        quickSort(array, p + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int index = left;
        int checkValue = array[right];
        for (int i = index; i < right; i++) {
            if (array[i] < checkValue) {
                if (i == index) {
                    index++;
                } else {
                    int temp = array[index];
                    array[index++] = array[i];
                    array[i] = temp;
                }
            }
        }
        int temp = array[index];
        array[index] = checkValue;
        array[right] = temp;
        return index;
    }
}
