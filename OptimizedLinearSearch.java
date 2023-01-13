import java.util.HashMap;
import java.util.Random;

public class OptimizedLinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        int target = random.nextInt(10000);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        long startTime = System.nanoTime();
        int result = map.getOrDefault(target, -1);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Optimized linear search took " + duration + " milliseconds. Result found at index: " + result);
    }
}
