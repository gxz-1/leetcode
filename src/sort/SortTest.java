package sort;

import org.junit.jupiter.api.Test;
import sort.impl.QuickSort;

import java.util.Arrays;

public class SortTest {
    int[] arr1 = {7, 2, 5, 1, 4, 9, 6, 8, 3};
    int[] arr2 = {3, 5, 2, 7, 3, 8, 4, 5, 6, 2};
    int[] arr3 = {5, 2, 6, 3, 8, 5, 7, 4, 2, 9, 5, 1, 6, 3, 8, 4, 2, 7, 9, 1};
    int[] arr4 = {17, 5, 10, 3, 19, 13, 1, 14, 8, 9, 12, 20, 4, 18, 2, 7, 11, 16, 15, 6};
    int[] arr5 = {37, 15, 48, 22, 30, 6, 8, 43, 11, 41, 1, 3, 40, 23, 2, 17, 20, 47, 13, 42, 14, 31, 46, 9, 28, 45, 21,
            36, 16, 34, 33, 5, 35, 25, 29, 7, 19, 10, 49, 26, 38, 18, 27, 39, 4, 12, 32, 44, 24};

    @Test
    void test() {
        SortMethod sortMethod=new QuickSort();
        sortMethod.sort(arr1);
        sortMethod.sort(arr2);
        sortMethod.sort(arr3);
        sortMethod.sort(arr4);
        sortMethod.sort(arr5);
        assert Arrays.equals(arr1, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        assert Arrays.equals(arr2, new int[]{2, 2, 3, 3, 4, 5, 5, 6, 7, 8});
        assert Arrays.equals(arr3, new int[]{1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9});
        assert Arrays.equals(arr4, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
        assert Arrays.equals(arr5, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49});
    }
}
