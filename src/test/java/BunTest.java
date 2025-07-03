import Const.Const;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import praktikum.Bun;

import static org.junit.jupiter.api.Assertions.*;

public class BunTest {
    private Bun bun;

    @BeforeEach
    void setUp() {
        bun = new Bun(Const.BUN_NAME, Const.BUN_PRICE);
    }

    @Test
    void testGetName() {
        assertEquals(Const.BUN_NAME, bun.getName(), "Ошибка названия булочки");
    }

    @Test
    void testGetPrice() {
        assertEquals(Const.BUN_PRICE, bun.getPrice(), 0.01, "Ошибка цены булочки");
    }
}
