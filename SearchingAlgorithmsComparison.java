import java.util.Random;
public class SearchingAlgorithmsComparison {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        int target = random.nextInt(10000);

        long startTime = System.nanoTime();
        int linearResult = linearSearch(arr, target);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Linear search took " + duration + " nanoseconds. Result found at index: " + linearResult);

        startTime = System.nanoTime();
        int binaryResult = binarySearch(arr, target);
        endTime = System.nanoTime();
        duration = (endTime - startTime) ;


        System.out.println("Binary search took " + duration + " nanoseconds. Result found at index: " + binaryResult);
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
