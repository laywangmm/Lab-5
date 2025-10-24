import java.util.Scanner;
import java.io.*;

/**
 * Program Description:
 * Reads grades from an input file and writes the results
 * (A/B/C/D/F counts, high, low, avg) to an output file.
 * 
 * 
 * @author Layipaun Wang
 * @version v1.0
 * @since 10/23/25
 */
public class Grades {

    public static void main(String[] args) throws IOException {
        String inFile, outFile;
        inFile = getInFile();
        outFile = getOutFile();
        processFile(inFile, outFile);
        
        System.out.println("Grade processing completed");
        System.out.println("You can retrieve the output file at, " + outFile);
    }

    public static String getInFile() {
        File file;
        String fileName;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the input file (ie input.txt): ");
        fileName = keyboard.nextLine();
        file = new File(fileName);

        while (!file.exists()) {
            System.out.print("Enter the name of the input file (ie input.txt): ");
            fileName = keyboard.nextLine();
            file = new File(fileName);
        }
        return fileName;
    }

    public static String getOutFile() {
        Scanner keyboard = new Scanner(System.in);
        String fileName;
        System.out.print("Enter the name of the output file (ie output.txt): ");
        fileName = keyboard.nextLine();
        return fileName;
    }

    public static void processFile(String inInFile, String inOutFile) throws IOException {
        Scanner inStream = new Scanner(new File(inInFile));
        PrintWriter outStream = new PrintWriter(inOutFile);

        int set = 1;

        while (inStream.hasNextLine()) {
            String line = inStream.nextLine().trim();
            if (line.isEmpty()) continue;

            Scanner pit = new Scanner(line);
            int As = 0, Bs = 0, Cs = 0, Ds = 0, Fs = 0;
            int total = 0, count = 0;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            while (pit.hasNextInt()) {
                int number = pit.nextInt();
                if (number == -1) break;

                count++;
                total += number;
                if (number < min) min = number;
                if (number > max) max = number;

                if (number >= 90)      As++;
                else if (number >= 80) Bs++;
                else if (number >= 70) Cs++;
                else if (number >= 60) Ds++;
                else                   Fs++;
            }
            pit.close();

            outStream.println("Set " + set + " of grades calculated");
            if (count == 0) {
                outStream.println("No grades to average");
                outStream.println();
                set++;
                continue;
            }

            outStream.println("Number of As: " + As);
            outStream.println("Number of Bs: " + Bs);
            outStream.println("Number of Cs: " + Cs);
            outStream.println("Number of Ds: " + Ds);
            outStream.println("Number of Fs: " + Fs);
            outStream.println("The high score was: " + max);
            outStream.println("The low score was: " + min);
            double avg = (double) total / count;
            outStream.printf("The avg score is: %.1f%n", avg);
            outStream.println();

            set++;
        }

        inStream.close();
        outStream.close();
    }
}
