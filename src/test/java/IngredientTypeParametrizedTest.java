import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTypeParametrizedTest {
    @ParameterizedTest
    @EnumSource(IngredientType.class)
    public void testIngredientType(IngredientType ingredientType){
        IngredientType type = ingredientType;
        assertEquals(type,IngredientType.valueOf(ingredientType.name()), "Некорректный тип ингредиента");
    }
}
