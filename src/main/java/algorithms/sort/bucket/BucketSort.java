package algorithms.sort.bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    @SuppressWarnings("unchecked")
    public static void sort(float[] arr, int numBuckets) {
        float min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min < arr[i]) min = arr[i];
        }
        List<Float>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList();
        }
        for (int i = 0; i < arr.length; i++) {
            float element = arr[i];
            int bucketIdx = (int) ((element - min) / numBuckets);
            buckets[bucketIdx].add(element);
        }
        for (int i = 0; i < buckets.length; i++) {
            List<Float> bucket = buckets[i];
            Collections.sort(bucket); // just don't care, this is usually insertion sort(on small amounts)
        }
        for (int i = 0, insertIdx = 0; i < buckets.length; i++) {
            List<Float> sortedInBucket = buckets[i];
            for (float element : sortedInBucket) {
                arr[insertIdx] = element;
                insertIdx++;
            }
        }
    }
}
