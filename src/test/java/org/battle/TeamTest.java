package org.battle;

import org.battle.models.Character;
import org.battle.models.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void testTeamCreation() {
        Weapon stick = new Weapon("STICK", 1);
        Character dipsy = new Character("ЗЕЛЁНЫЙ", "ДИПСИ", 10, stick, 5);
        Team team1 = new Team("ТЕЛЕПУЗИКИ1", dipsy);

        Assertions.assertEquals("ТЕЛЕПУЗИКИ1", team1.getName());
    }
    @Test
    void testHasAliveMembersTrue() {
        Weapon stick = new Weapon("STICK", 1);
        Character dipsy = new Character("ЗЕЛЁНЫЙ", "ДИПСИ", 10, stick, 5);
        Character tinkyWinky = new Character("ФИОЛЕТОВЫЙ", "ТИНКИ ВИНКИ", 10, stick, 5);
        Character deadTeletubbie1 = new Character("UNKNOWN", "UNKNOWN", 0, stick, 5);
        Character deadTeletubbie2 = new Character("UNKNOWN", "UNKNOWN", 0, stick, 5);
        Team team3 = new Team("МЕРТВЕПУЗИКИ", deadTeletubbie1, deadTeletubbie2);
        Team team1 = new Team("ТЕЛЕПУЗИКИ1", dipsy, tinkyWinky);

        Assertions.assertTrue(team1.hasAliveMembers());
        Assertions.assertFalse(team3.hasAliveMembers());
    }

    @Test
    void testGetAliveMember() {
        Weapon stick = new Weapon("STICK", 1);
        Weapon fork = new Weapon("FORK", 100);
        Character dipsy = new Character("ЗЕЛЁНЫЙ", "ДИПСИ", 10, stick, 5);
        Character po = new Character("КРАСНЫЙ", "ПО", 10, fork, 5);
        Team team1 = new Team("ТЕЛЕПУЗИКИ1", dipsy);

        Assertions.assertEquals(dipsy, team1.getAliveMember());
        po.attack(dipsy);
        Assertions.assertNull(team1.getAliveMember());
    }
}