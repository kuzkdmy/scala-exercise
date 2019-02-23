package algorithms.sort.counting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CountingSortTest {
    @Test
    public void shouldSort() {
        int[] arr = new int[]{3, 2, 1, 4, 5, 6, 7, 8, 9, 0};
        CountingSort.sort(arr);
        assertArrayEquals(
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                arr
        );
    }
}