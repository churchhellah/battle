package org.battle;

import org.battle.models.Character;
import org.battle.models.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BattleTest {

    @Test
    void testBattleStart() {
        Weapon stick = new Weapon("STICK", 1);
        Weapon gun = new Weapon("GUN", 1000);
        Character dipsy = new Character("ЗЕЛЁНЫЙ", "ДИПСИ", 10, stick, 5);
        Character tinkyWinky = new Character("ФИОЛЕТОВЫЙ", "ТИНКИ ВИНКИ", 10, stick, 5);
        Character lalla = new Character("ЖЁЛТЫЙ", "ЛЯЛЯ", 10, gun, 5);
        Character po = new Character("КРАСНЫЙ", "ПО", 10, gun, 5);
        Team team1 = new Team("ТЕЛЕПУЗИКИ1", dipsy, tinkyWinky);
        Team team2 = new Team("ТЕЛЕПУЗИКИ2", lalla, po);
        Battle battle = new Battle(team1, team2);

        battle.start();
        Assertions.assertFalse(team1.hasAliveMembers());
        Assertions.assertTrue(team2.hasAliveMembers());
    }
    @Test
    void testBattleStartsWithNoException() {
        Weapon stick = new Weapon("STICK", 1);
        Weapon gun = new Weapon("GUN", 1000);
        Character dipsy = new Character("ЗЕЛЁНЫЙ", "ДИПСИ", 10, stick, 5);
        Character tinkyWinky = new Character("ФИОЛЕТОВЫЙ", "ТИНКИ ВИНКИ", 10, stick, 5);
        Character lalla = new Character("ЖЁЛТЫЙ", "ЛЯЛЯ", 10, gun, 5);
        Character po = new Character("КРАСНЫЙ", "ПО", 10, gun, 5);
        Team team1 = new Team("ТЕЛЕПУЗИКИ1", dipsy, tinkyWinky);
        Team team2 = new Team("ТЕЛЕПУЗИКИ2", lalla, po);
        Battle battle = new Battle(team1, team2);

        Assertions.assertDoesNotThrow(battle::start);
    }
}