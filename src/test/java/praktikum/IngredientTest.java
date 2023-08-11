package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "Соус", 100},
                {FILLING, "Мясо", 200},
        };
    }
    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testIngredient() {
        assertEquals(type, ingredient.type);
        assertEquals(name, ingredient.name);
        assertEquals(price, ingredient.price,0);
    }

    @Test
    public void getPrice() {
        assertEquals(price, ingredient.getPrice(),0);
    }

    @Test
    public void getName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals(type, ingredient.getType());
    }
}
