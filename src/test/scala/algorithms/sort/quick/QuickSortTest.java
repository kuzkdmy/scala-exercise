package algorithms.sort.quick;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void shouldSort() {
        int[] arr = new int[]{3, 2, 1, 4, 5, 6, 7, 8, 9, 0};
        QuickSort.sort(arr);
        assertArrayEquals(
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                arr
        );
    }
}