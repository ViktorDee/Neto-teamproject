package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldReturnFalseByNotAddGame() {

        GameStore store = new GameStore();
        Game game1 = new Game("Нетология", "Симуляторы", store);

        assertFalse(store.containsGame(game1));
    }
    // другие ваши тесты
}
