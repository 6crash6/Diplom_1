import Const.Const;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @InjectMocks
    Burger burger;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }

    @Test
    public void checkSetBun() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);
        int expected = 1;
        assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void checkGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        when(bun.getPrice()).thenReturn(Const.BUN_PRICE);
        when(ingredient.getPrice()).thenReturn(Const.INGREDIENT_CHEESE_PRICE);

        float expected = Const.BUN_PRICE * 2 + Const.INGREDIENT_CHEESE_PRICE;

        assertEquals(expected, burger.getPrice(), 0.01);
    }


    @Test
    public void checkGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        when(bun.getName()).thenReturn(Const.BUN_NAME);
        when(bun.getPrice()).thenReturn(Const.BUN_PRICE);
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getName()).thenReturn(Const.INGREDIENT_NAME_SAUCE);
        when(ingredient.getPrice()).thenReturn(Const.INGREDIENT_SAUCE_PRICE);

        float totalPrice = Const.BUN_PRICE * 2 + Const.INGREDIENT_SAUCE_PRICE;
        String expected = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                Const.BUN_NAME,
                "filling",
                Const.INGREDIENT_NAME_SAUCE,
                Const.BUN_NAME,
                totalPrice
        );

        assertEquals(expected, burger.getReceipt());
    }

}
