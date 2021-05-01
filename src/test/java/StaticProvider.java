import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class StaticProvider {

    @DataProvider(name = "getPenObjects")
    public static Object[][] getPenObjects() {
                return new Object[][]{
                {new Pen(1)},
                {new Pen(120, 2.5)},
                {new Pen(1200, 2.5, "")}
        };
    }


    @DataProvider(name = "provideInkContainerValue")
    public static Object[][] provideInkContainerValue() {
        return new Object[][]{
                {10},
                {0},
                {-10}
        };
    }

    @DataProvider(name = "providePenObjectWithColor")
    public static Object[][] providePenObjectWithColor() {
        return new Object[][]{
                {100, 3, "Olive"}
        };
    }

    @DataProvider(name = "provideWriteTestWithNegativeData")
    public static Object[][] provideWriteTestWithNegativeData() {
        return new Object[][]{
                {new Pen(4), "", ""},
                {new Pen(10), null, ""},
                {new Pen(3), " 123", "123"},
                {new Pen(3, 0), "abcde123", ""},
                {new Pen(1, -3), "abc", ""}

        };
    }

    @DataProvider(name = "provideWriteTestWithPositiveData")
    public static Object[][] provideWriteTestWithPositiveData(Method m) {
        if (m.getName().equalsIgnoreCase("checkWriteReturnsEmptyString")) {
            return new Object[][]{
                    {new Pen(-100), "Any word"},
                    {new Pen(-1000, 2.5), "asdasd"}
            };
        }
        if (m.getName().equalsIgnoreCase("checkWriteReturnsWord")) {
            return new Object[][]{
                    {new Pen(20, 1.0), "asd"},
                    {new Pen(3, 1.0), "asd"},
                    {new Pen(3, 0.9), "asd"},
                    {new Pen(3, 1.1), "as"},
                    {new Pen(3, 1.5), "asd"},
                    {new Pen(4, 2.0), "we"}
            };
        }
        if  (m.getName().equalsIgnoreCase("checkWriteReturnsPartOfWord")) {
            return new Object[][]{
                    {new Pen(6), "abcdefghijklnm", "abcdef"},
                    {new Pen(1, 0.5), "abc", "ab"},
                    {new Pen(5, 2), "123", "12"}

            };
        }
        else {
            return new Object[][]{
                    {new Pen (100), "Hello!", "Hello!"}
            };
        }

    }
}

