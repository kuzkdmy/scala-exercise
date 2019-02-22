package algorithms.sort.bubble;

public final class BubbleSort {
    public static void sort(int[] arr) {
        boolean isSorted = false;
        int lastSortedEnd = arr.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastSortedEnd; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
            lastSortedEnd -= 1;
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int v1 = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = v1;
    }
}
