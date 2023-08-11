package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static java.lang.Float.MAX_VALUE;
import static java.lang.Float.MIN_VALUE;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String name;
    private final float price;
    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "bunName - {0}. bunPrice - {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Супер булка", 1000},
                {"Super bun", 1000},
                {"", 1000},
                {" ", 1000},
                {null, 1000},
                {"1234567", 1000},
                {"%*/@", 1000},
                {"Супер булка 1 Супер булка 1 Супер булка 1 Супер булка 1 Супер булка 1 Супер булка 1 Супер булка 1 Супер булка 1 Супер булка 1 ", 1000},
                {"Флюоресцентная булка R2-D2", 1},
                {"Флюоресцентная булка R2-D2", 0},
                {"Флюоресцентная булка R2-D2", -1},
                {"Флюоресцентная булка R2-D2", -1000},
                {"Флюоресцентная булка R2-D2", MIN_VALUE},
                {"Флюоресцентная булка R2-D2", MAX_VALUE},

        };
    }
    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }
    @Test
    public void bunPriceTest(){
        float actualPrice = bun.getPrice();
        float expectedPrice = price;
        assertEquals(expectedPrice, actualPrice, 0);
    }
    @Test
    public void bunNameTest(){
        String actualName = bun.getName();
        String expectedName = name;
        assertEquals(expectedName, actualName);
    }
}
