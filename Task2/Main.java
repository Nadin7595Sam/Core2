import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(5); // Генерируем массив случайных чисел
        boolean result = hasAdjacentZeros(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Соседние нули: " + result);
    }

    public static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(2);
        }
        return arr;
    }

    public static boolean hasAdjacentZeros(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }
}