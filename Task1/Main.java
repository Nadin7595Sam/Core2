import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String secretNumber = generateSecretNumber();
        Scanner scanner = new Scanner(System.in);
        int attempts = 3;

        System.out.println("Угадайте четырёхзначное число. У вас " + attempts + " попытки.");

        while (attempts > 0) {
            System.out.print("Введите вашу догадку: ");
            String guess = scanner.nextLine();

            if (!isValidGuess(guess)) {
                System.out.println("Пожалуйста, введите четырёхзначное число.");
                continue;
            }

            int bulls = countBulls(secretNumber, guess);
            int cows = countCows(secretNumber, guess);

            System.out.println("Быки: " + bulls);
            System.out.println("Коровы: " + cows);

            if (bulls == 4) {
                System.out.println("Ура! Вы угадали число: " + secretNumber);
                break;
            }

            attempts--;
            System.out.println("Осталось " + attempts + " попыток.");
        }

        if (attempts == 0) {
            System.out.println("Игра окончена. Загаданное число: " + secretNumber);
        }

        scanner.close();
    }

    private static String generateSecretNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }

    private static boolean isValidGuess(String guess) {
        return guess.length() == 4 && guess.matches("\\d+");
    }

    private static int countBulls(String secret, String guess) {
        int bulls = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
        }

        return bulls;
    }

    private static int countCows(String secret, String guess) {
        int cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            for (int j = 0; j < guess.length(); j++) {
                if (secret.charAt(i) == guess.charAt(j) && i != j) {
                    cows++;
                }
            }
        }

        return cows;
    }
}