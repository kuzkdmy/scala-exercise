package algorithms.sort.bucket;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class BucketSortTest {
    @Test
    public void shouldSort() {
        float[] arr = new float[]{3.12f, 2.12f, 1.00f, 4.123f, 5.987f, 6.13233f, 7.129f, 8.8f, 9.9999f, 0.000f};
        float[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        BucketSort.sort(arr, 10);
        assertArrayEquals(expected, arr, 0f);
    }
}