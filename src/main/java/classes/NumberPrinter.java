package classes;

public class NumberPrinter{

    //private FizzBuzz fizzBuzz;
    private NumberCalculator numberCalculator;
    private Printer printer;

    public NumberPrinter(NumberCalculator numberCalculator, Printer printer) { //constructor injection
        this.numberCalculator = numberCalculator;
        this.printer = printer;
    }

    public void printNumbers(int limit) {
        if (limit < 1) {
            throw new RuntimeException("limit must be >= 1");
        }
        for (int i = 1; i <= limit; i++) {
            try {
                //printer.print(fizzBuzz.calculate(i));
                printer.print(numberCalculator.calculate(i));
            } catch (Exception e) {

            }
        }
    }

    public interface NumberCalculator {
        String calculate(int number);
    }

    public interface Printer {
        void print(String s);
    }
}
