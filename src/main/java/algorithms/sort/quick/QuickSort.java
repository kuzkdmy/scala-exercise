package algorithms.sort.quick;

public final class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            sort(arr, lo, p - 1);
            sort(arr, p + 1, hi);
        }
    }

    // Hoare partitioning principle(generally split on 3 parts and return 2 indexes are more efficient, don't care)
    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi]; // set of technics exists with choosing correct pivot
        int idxLeft = lo;
        int idxRight = hi;
        do {
            while (arr[idxRight] > pivot) idxRight--;
            while (arr[idxLeft] <= pivot) idxLeft++;
            if (idxLeft > idxRight) return idxRight;
            swap(arr, idxLeft, idxRight);
        } while (idxLeft < idxRight);
        return idxRight;
    }

    private static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
