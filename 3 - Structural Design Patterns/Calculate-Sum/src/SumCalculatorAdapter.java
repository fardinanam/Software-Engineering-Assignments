import java.io.*;

/**
 * CalculateSumAdapter can calculate the sum of integers.
 * To calculate it requires a file as input that contains
 * integers separated by '~'.
 */
public class SumCalculatorAdapter {
    private SumCalculator sumCalculator;

    /**
     *
     * @param inputFile A file containing integers separated by '~'.
     * @return the sum of the integers written in the input file.
     * @throws IOException If the input file can not be opened.
     * @throws NumberFormatException if the input file contains anything other than
     * integers or '~'.
     */
    public int getSum(File inputFile) throws IOException, NumberFormatException {
        sumCalculator = new SumCalculator();
        FileWriter tempInputWriter = new FileWriter("tempInputFile.txt", true);
        BufferedWriter writer = new BufferedWriter(tempInputWriter);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String input = reader.readLine();
        reader.close();
        writer.write(input.replaceAll("~", " "));
        writer.close();

        File tempFile = new File("tempInputFile.txt");
        int sum = sumCalculator.getSum(tempFile);
        tempFile.delete();

        return sum;
    }
}
