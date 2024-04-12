import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int[] timeline = readTimeline("input.txt");
        //System.out.println("проверяем - исходный массив");
        //System.out.println(Arrays.toString(timeline));
        int otvet = findMaxInterval(timeline);
        System.out.println("ответ "+otvet);
    }

    private static int findMaxInterval(int[] timeline) {
        return -9999;
    }

    private static int[] readTimeline(String fname) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fname));
        int n = scanner.nextInt();
        int[] massiv = new int[n];
        for (int i = 0; i < n; i++) {
            massiv[i] = scanner.nextInt();
        }
        scanner.close();
        return massiv;
    }
}