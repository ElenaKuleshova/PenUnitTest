import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

public class DoSomethingElseTest {
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

@BeforeMethod
    public void setUpStream() {
        System.setOut(new PrintStream(this.consoleContent));
    }

    @Test (dataProvider = "getPenObjects", dataProviderClass = StaticProvider.class)
    public void testDoSomethingElsePrintsColor (Pen pen) {
        pen.doSomethingElse();
        assertNotEquals(consoleContent.toString().trim(), null);
    }
@AfterMethod
    public void restoreStream() {
    System.setOut(this.originalOut);
    this.consoleContent = new ByteArrayOutputStream();
}
}
