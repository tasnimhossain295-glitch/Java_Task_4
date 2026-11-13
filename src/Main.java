import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // duomenys.txt ফাইল রিড করার জন্য
            File inputFile = new File("duomenys.txt");
            Scanner scanner = new Scanner(inputFile);

            if (!scanner.hasNextInt()) {
                scanner.close();
                return;
            }

            int n = scanner.nextInt();
            int negativeCount = 0;

            for (int i = 0; i < n; i++) {
                if (scanner.hasNextInt()) {
                    int temp = scanner.nextInt();
                    if (temp < 0) {
                        negativeCount++;
                    }
                }
            }
            scanner.close();

            // rezultatai.txt ফাইলে ফলাফল লেখার জন্য PrintWriter ব্যবহার করা
            PrintWriter writer = new PrintWriter("rezultatai.txt");

            if (negativeCount > 0) {
                writer.println("Number of days with negative temperatures: " + negativeCount);
            } else {
                writer.println("No negative temperatures recorded");
            }

            writer.close();
            System.out.println("Results successfully written to rezultatai.txt");

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        }
    }
}