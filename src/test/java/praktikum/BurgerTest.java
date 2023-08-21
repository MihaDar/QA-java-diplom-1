package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    List<Bun> bunList;
    List<Ingredient> ingredientList;

    @Mock
    Bun bun;
    @Mock
    Database database;

    @Before
    public void setUp() {
        burger = new Burger();
        database = new Database();
        bunList = database.availableBuns();
        ingredientList = database.availableIngredients();
        burger.setBuns(bun);
        burger.setBuns(bunList.get(0));
        burger.addIngredient(ingredientList.get(0));
        burger.addIngredient(ingredientList.get(4));
    }

    @Test
    public void testSetBuns() {
        Assert.assertEquals("не получилось", bunList.get(0), burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Assert.assertEquals("не получилось", 2, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(0);
        Assert.assertEquals("не получилось", 1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = burger.ingredients.get(1);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("не получилось", ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        assertEquals("не получилось", 500, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        String expected = "(==== black bun ====)\r\n" +
                "= sauce hot sauce =\r\n" +
                "= filling dinosaur =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 500,000000\r\n";
        assertEquals("не получилось", expected, burger.getReceipt());
    }
}
