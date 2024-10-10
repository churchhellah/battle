package org.battle.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CharacterTest {

    @ParameterizedTest
    @CsvSource(value = {
            "purple, Tinky Winky, 1, 1, sword, 10",
            "зелёный, Дипси, -1, 100, fork, 4",
            "yellow, Lalla, 10000, 1, gun, -4",
            "red, Po, 1, 1, grenade, 1000"
    })
    void testCharacterCreation(String rank, String name, int health, int defence, String weaponName, int weaponDamage) {
        Character teletubbie = new Character(rank, name, health, new Weapon(weaponName, weaponDamage), defence);

        Assertions.assertEquals(rank, teletubbie.getRank());
        Assertions.assertEquals(name, teletubbie.getName());
        Assertions.assertEquals(health, teletubbie.getHealth());
        Assertions.assertEquals(defence, teletubbie.getDefence());
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