import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int[] timeline = readTimeline3("input.txt");
        //System.out.println("проверяем - исходный массив");
        //System.out.println(Arrays.toString(timeline));
        int otvet = findMaxInterval(timeline);
        System.out.println("ответ "+otvet);
        writeOtvetToFile(otvet, "output.txt");
    }

    private static void writeOtvetToFile(int otvet, String fname) {
        try (FileWriter fileWriter = new FileWriter(fname)) {
            fileWriter.write(String.valueOf(otvet)); // Записываем число в файл, конвертируя число в строку
            fileWriter.flush(); // Очищаем буфер потока
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findMaxInterval(int[] timeline) {
        int[] lastVisitTime = new int[101];
        Arrays.fill(lastVisitTime, -1);
        int maxInterval=0;
        for (int i = 0; i < timeline.length; i++) {
            int num = timeline[i];
            if(lastVisitTime[num] != -1) {
                int interval = i - lastVisitTime[num];
                if( maxInterval < interval)
                    maxInterval = interval;
            }
            lastVisitTime[num] = i;
        }
        return maxInterval;
    }

    private static int[] readTimeline3(String fname) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fname));
        int n = scanner.nextInt();
        scanner.nextLine(); //надо добавить переход на следующую строку
        int[] numbers = new int[n];
        String bigStr = scanner.nextLine();
        scanner.close();
        Scanner scanner2 = new Scanner(bigStr);
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner2.nextInt();
        }

        return numbers;
    }

    private static int[] readTimeline2(String fname) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fname));
        int n = scanner.nextInt();
        scanner.nextLine(); //надо добавить переход на следующую строку
        int[] numbers = new int[n];
        String bigStr = scanner.nextLine();
        scanner.close();
        String[] masStr = bigStr.split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(masStr[i]);
        }

        return numbers;
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