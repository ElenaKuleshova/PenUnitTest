import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name="ConstructorWith1Or2Params")
    public static Object[][] getConstructorWith1Or2Params() {
        return new Object[][]{
                {new Pen(120)},
                {new Pen(120, 2.5)}

        };
    }

    @DataProvider (name="ConstructorWith3Params")
    public static Object[][] getConstructorWith3Params() {
        return new Object[][]{
                {120, 2.5, "White"},
                {1000, 1, ""},
                {0,0, "Green"}
        };
    }

    @DataProvider(name="AllConstructorTypesWithPositiveInkContainer")
    public static Object[][] getPositiveInkContainerFromAllConstructors() {
        return new Object[][]{
                {new Pen(1)},
                {new Pen(120, 2.5)},
                {new Pen(1200, 2.5, "White")}
        };
    }
    @DataProvider(name="AllConstructorTypesWithNegativeOrZeroInkContainer")
    public static Object[][] getNegativeOrZeroInkContainerFromAllConstructors() {
        return new Object[][]{
                {new Pen(-1)},
                {new Pen(0, 2.5)},
                {new Pen(-1200, 2.5, "White")}
        };
    }

    @DataProvider(name = "getWriteDataConstructor1")
    public static Object[][] getWriteDataConstructor1() {
        return new Object[][]{
                {20, "abcde", "abcde"},
                {10, "1234567891", "1234567891"},//check boundary value
                {6, "abcdefghijklnm", "abcdef"},//check partofWord when sizeWord>inkContainer
                {-1, "abcd12", ""},//isWork == false
                {0, "asd", ""},//isWork ==false
                {5, " 12345 ", "12345"},//check spaces before and after word
                {2, "  ", ""},//check only spaces
                {10, "Some txt\n", "Some txt\n"}

        };
    }
    @DataProvider(name = "getWriteDataConstructor2")
    public static Object[][] getWriteDataConstructor2() {
        return new Object[][]{
                {10, 2.1, "12345", "12345"},//check partofWord when sizeWord>inkContainer -->StringIndexOutOfBoundException
                {2, 0.5, "abc", "abc"},
                {1, 0.5, "ab", "ab"},
                {1, 0.5, "abc", "a"},//это конечно очень странно, что ёмкость одна и та же, но пишем теперь только а, а не ab
                {4, 1.1, "abcd", "abcd"}// по скользкой дорожке, но проходишь..

        };
    }
}
