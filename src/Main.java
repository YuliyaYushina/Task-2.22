import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int length = 20;
        int min = 1;
        int max = 15;

        int[] randomNumbers = new int[length];

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomNumbers[i] = random.nextInt(max - min + 1) + min;
        }

        System.out.println(Arrays.toString(randomNumbers));

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int number : randomNumbers) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Число '" + entry.getKey() + "' встречается " + entry.getValue() + " раза");
            }
        }
    }
}