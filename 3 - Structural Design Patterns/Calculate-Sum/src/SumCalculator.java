import java.io.*;

/**
 * CalculateSum can calculate the sum of integers.
 * To calculate it requires a file as input that contains
 * integers separated by spaces.
 */
public class SumCalculator {
    /**
     * @param inputFile A file containing integers separated by spaces.
     * @return the sum of the integers written in the input file.
     * @throws IOException If the input file can not be opened.
     * @throws NumberFormatException if the input file contains anything other than
     * integers or spaces.
     */
    public int getSum(File inputFile) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String[] input = br.readLine().split(" ");
        br.close();

        int sum = 0;

        for (String integer : input) {
            sum += Integer.parseInt(integer);
        }

        return sum;
    }
}
