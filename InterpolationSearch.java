import java.util.Random;
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        int target = random.nextInt(10000);

        long startTime = System.nanoTime();
        int result = interpolationSearch(arr, target);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Interpolation search took " + duration + " nanoseconds. Result found at index: " + result);
    }

    public static int interpolationSearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high && x >= arr[low] && x <= arr[high]) {
            if (low == high) {
                if (arr[low] == x) {
                    return low;
                }
                return -1;
            }
            mid = low + ((x - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[mid] == x) {
                return mid;
            }
            else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
