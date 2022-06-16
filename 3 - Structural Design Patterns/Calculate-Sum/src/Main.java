import java.io.File;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("input1.txt");
        SumCalculator sumCalculator = new SumCalculator();
        SumCalculatorAdapter sumCalculatorAdapter = new SumCalculatorAdapter();

        System.out.println("Calculating sum for the file with integers separated " +
                "with spaces");
        try {
            System.out.println("SumCalculator returns: " + sumCalculator.getSum(inputFile));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        inputFile = new File("input2.txt");
        System.out.println("\nCalculating sum for the file with integers separated " +
                "with '~'");

        try {
            System.out.println("SumCalculatorAdapter returns: " + sumCalculatorAdapter.getSum(inputFile));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
