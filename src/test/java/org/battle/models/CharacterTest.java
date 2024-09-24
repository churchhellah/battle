package org.battle.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterTest {

    private final Character zina = new Character(
            "ЕФРЕЙТОР",
            "ЗИНА",
            10,
            new Weapon(
                    "machete",
                    10),
            4);
    private final Character lola = new Character(
            "КУК",
            "ЛОЛА",
            20,
            new Weapon(
                    "fork",
                    4),
            1
    );
    private final Character dead = new Character(
            "UNKNOWN",
            "UNKNOWN",
            0,
            new Weapon(
                    "stick",
                    1),
            1
    );

    @Test
    void attack() throws Exception {
        zina.attack(lola);
        Assertions.assertEquals(11, lola.getHealth());
    }

    @Test
    void isAlive() throws Exception {
        Assertions.assertTrue(zina.isAlive());
        Assertions.assertFalse(dead.isAlive());
    }

}