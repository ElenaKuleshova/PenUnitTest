import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test (dataProvider = "ConstructorWith1Or2Params", dataProviderClass = StaticProvider.class)
    public void testDoSomethingElse (Pen pen){
        //Pen obj = new Pen (inkContainerValue);
        pen.doSomethingElse();
        assertEquals(consoleContent.toString().trim(), "BLUE");
    }

        @Test(dataProvider = "ConstructorWith3Params",  dataProviderClass = StaticProvider.class)

        public void testDoSomethingElse(int inkCont, double size, String color) {
            Pen obj = new Pen (inkCont, size, color);
            obj.doSomethingElse();
            assertEquals(consoleContent.toString().trim(), color);
        }

@AfterMethod
    public void restoreStream() {
        System.setOut(this.originalOut);
        this.consoleContent = new ByteArrayOutputStream();
    }

}
