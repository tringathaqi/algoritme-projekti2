import java.util.Arrays;
import java.util.Random;

public class OptimizedBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        int target = random.nextInt(10000);

        int threshold = 10; // threshold value to switch to linear search

        long startTime = System.nanoTime();
        int result = optimizedBinarySearch(arr, target, threshold);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Optimized binary search took " + duration + " milliseconds. Result found at index: " + result);
    }

    public static int optimizedBinarySearch(int[] arr, int x, int threshold) {
        if (arr.length <= threshold) {
            return linearSearch(arr, x);
        }
        Arrays.sort(arr);
        return binarySearch(arr, x);
    }

    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
