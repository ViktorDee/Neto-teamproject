package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfSomeGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Шахматы Онлайн", "Аркады");
        Game game3 = store.publishGame("Хомяки", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game, 3);
        player.play(game2, 2);
        player.play(game2, 4);

        int expected = 9;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSumGenreIfNoGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 0;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowRuntimeExceptionIfNoGamesInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("", "Аркады");

        Player player = new Player("Petya");
        player.play(game, 3);

        assertThrows(RuntimeException.class, () -> {
            player.installGame(null);
        });
    }

    @Test
    public void shouldSumGenreOfOneGameIfSameGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMostPlayedByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Казаки", "Стратегии");
        Game game3 = store.publishGame("Герои", "Стратегии");
        Game game4 = store.publishGame("Шахматы", "Аркады");
        Game game5 = store.publishGame("Стрельба по Тарелкам", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.installGame(game5);
        player.play(game, 3);
        player.play(game2, 5);
        player.play(game3, 1);
        player.play(game4, 4);
        player.play(game5, 2);

        Game expected = game2;
        Game actual = player.mostPlayerByGenre("Казаки");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMostPlayedByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("", "");


        Player player = new Player("Petya");
        player.installGame(game);

        player.play(game, 3);


        String expected = null;
        Game actual = player.mostPlayerByGenre(game.getGenre());
        assertEquals(expected, actual);
    }
}