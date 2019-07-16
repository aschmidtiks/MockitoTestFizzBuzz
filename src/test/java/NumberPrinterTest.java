import classes.NumberPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NumberPrinterTest {

    @Mock
    private NumberPrinter.Printer printer;

    @Mock
    private NumberPrinter.NumberCalculator numberCalculator;

    @InjectMocks
    private NumberPrinter numberPrinter;

    @Test
    public void printsCalculatorResultsHundredTimes() {
        // arrange
        int limit = 100;
        when(numberCalculator.calculate(anyInt()))
                .thenReturn("0")  // first invocation returns "0"
                .thenReturn("1"); // other invocations return "1"
        // act
        numberPrinter.printNumbers(limit);
        // assert
        verify(numberCalculator, times(limit)).calculate(anyInt());
        verify(printer, times(1)).print("0");
        verify(printer, times(limit - 1)).print("1");
        verifyNoMoreInteractions(numberCalculator, printer);

        /*
            Für calculate in numbercalculator wird festgelegt dass
            beim ersten mal 0 und die nächsten male 1 zurückgegeben wird

            Dann wird die Methode printNumbers aufgerufen, mit den Regeln die in "when()..." festgelegt wurden (printNumbers ruft calculate auf)

            Dies wird mit verify überprüft und bestätigt:
            Prüft zuerst ob Methode überhaupt aufgerufen wird
            Dann ob beim ersten mal eine 0 zurückgegeben wird
            Dann ob bei allen anderen Iterationen 1 zurückgegeben wird

            Mit verifyNoMoreInteractions wird geprüft ob alle Interaktionen zwischen den Moks abgearbeitet sind und keine Interaktionen mehr stattfinden
            Moks merken sich alle Interaktionen, diese können hinterher selektiv verifiziert werden
        */
    }
}
