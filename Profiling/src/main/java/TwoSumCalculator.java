import java.util.stream.IntStream;
import java.util.HashMap;
import java.util.Map;

public class TwoSumCalculator {
    public static void main(String[] args) {
        int[] numbers = IntStream.range(1, 12354578).toArray();
        int target = 512602080;
        getTwoSum(numbers, target);
    }

    public static void getTwoSum(final int[] numbers, final int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    System.out.println("Pair found: " + numbers[i] + ", " + numbers[j]);
                    return;
                }
            }
        }
        System.out.println("No pair found");
    }

    public static void getTwoSumImproved(final int[] numbers, final int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (numMap.containsKey(complement)) {
                System.out.println("Pair found: " + numbers[i] + ", " + complement);
                return;
            }
            numMap.put(numbers[i], i);
        }
        System.out.println("No pair found");
    }
}
