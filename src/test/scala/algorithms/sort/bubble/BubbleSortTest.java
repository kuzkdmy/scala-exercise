package algorithms.sort.bubble;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {
    @Test
    public void shouldSort() {
        int[] arr = new int[]{3, 2, 1, 4, 5, 6, 7, 8, 9, 0};
        BubbleSort.sort(arr);
        assertArrayEquals(
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                arr
        );
    }
}