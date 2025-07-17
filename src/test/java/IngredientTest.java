import Const.Const;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    Ingredient ingredient;

    @BeforeEach
    public void setUp(){
        ingredient = new Ingredient(IngredientType.FILLING, Const.INGREDIENT_NAME_CHEESE, Const.INGREDIENT_CHEESE_PRICE);
    }

    @Test
    public void testIngredientName(){
        assertEquals(Const.INGREDIENT_NAME_CHEESE,ingredient.getName(),"Некорректное имя");
    }

    @Test
    public void testIngredientPrice(){
        assertEquals(Const.INGREDIENT_CHEESE_PRICE, ingredient.getPrice(), 0.01, "Некорректная цена");
    }

    @Test
    public void testIngredientType(){
        assertEquals(IngredientType.FILLING,ingredient.getType(), "Некорректный тип");
    }

}
