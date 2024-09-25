package org.battle.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterTest {

    @Test
    void testCharacterCreation() {
        Weapon fork = new Weapon("Fork", 4);
        Character dipsy = new Character("purple", "Dipsy", 1, fork, 1);

        Assertions.assertEquals("purple", dipsy.getRank());
        Assertions.assertEquals("Dipsy", dipsy.getName());
        Assertions.assertEquals(1, dipsy.getHealth());
        Assertions.assertEquals(fork, dipsy.getWeapon());
        Assertions.assertEquals(1, dipsy.getDefence());
    }
    @Test
    void testAttack() {
        Weapon machete = new Weapon("Machete", 10);
        Weapon fork = new Weapon("Fork", 4);
        Character zina = new Character("ЕФРЕЙТОР", "ЗИНА", 10, machete, 4);
        Character lola = new Character("КУК", "ЛОЛА", 20, fork, 1);

        zina.attack(lola);
        Assertions.assertEquals(11, lola.getHealth());
    }

    @Test
    void testAttackNoDamage() {
        Weapon machete = new Weapon("Machete", 10);
        Weapon fork = new Weapon("Fork", 4);
        Character zina = new Character("ЕФРЕЙТОР", "ЗИНА", 10, machete, 4);
        Character lola = new Character("КУК", "ЛОЛА", 20, fork, 1);

        lola.attack(zina);
        Assertions.assertEquals(10, zina.getHealth());
    }

    @Test
    void testCharacterIsAlive() {
        Weapon machete = new Weapon("Machete", 20);
        Weapon fork = new Weapon("Fork", 4);
        Character zina = new Character("ЕФРЕЙТОР", "ЗИНА", 10, machete, 4);
        Character lola = new Character("КУК", "ЛОЛА", 20, fork, 0);

        zina.attack(lola);
        Assertions.assertFalse(lola.isAlive());
    }

}