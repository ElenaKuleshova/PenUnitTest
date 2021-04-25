import org.testng.Assert;
import org.testng.annotations.Test;



public class WriteAndIsWorkTest {

    @Test(dataProvider = "getWriteDataConstructor1",  dataProviderClass = StaticProvider.class)
    public void testWriteWith1Param(int inkContainerValue,String enteredWord, String expected) {
        Pen pen = new Pen(inkContainerValue);
        String actual = pen.write(enteredWord);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getWriteDataConstructor2",  dataProviderClass = StaticProvider.class)
    public void testWriteWith2Params(int inkContainerValue, double sizeLetter, String enteredWord, String expected){
        Pen pen = new Pen (inkContainerValue, sizeLetter);
        String actual = pen.write(enteredWord);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "AllConstructorTypesWithPositiveInkContainer", dataProviderClass = StaticProvider.class)
    public void testIsWorkMethodTrue (Pen pen){
          Assert.assertTrue(pen.isWork());

    }
    @Test(dataProvider = "AllConstructorTypesWithNegativeOrZeroInkContainer", dataProviderClass = StaticProvider.class)
    public void testIsWorkMethodFalse (Pen pen){
        Assert.assertFalse(pen.isWork());
    }
}
