package org.battle;

import org.battle.models.Character;
import org.battle.models.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BattleTest {

    private final Team team1 = new Team(
            "ТЕЛЕПУЗИКИ1",
            new Character(
                    "ЗЕЛЁНЫЙ",
                    "ДИПСИ",
                    10,
                    new Weapon(
                            "STICK",
                            1),
                    5),
            new Character(
                    "ФИОЛЕТОВЫЙ",
                    "ТИНКИ-ВИНКИ",
                    10,
                    new Weapon(
                            "STICK",
                            1),
                    5)
    );
    private final Team team2 = new Team(
            "ТЕЛЕПУЗИКИ2",
            new Character(
                    "ЖЁЛТЫЙ",
                    "ЛЯЛЯ",
                    10,
                    new Weapon(
                            "STICK",
                            10),
                    5),
            new Character(
                    "КРАСНЫЙ",
                    "ПО",
                    10,
                    new Weapon(
                            "STICK",
                            10),
                    5)
    );
    Battle battle1 = new Battle(team1, team2);

    @Test
    void start() {
        battle1.start();
        Assertions.assertFalse(team1.hasAliveMembers());
        Assertions.assertTrue(team2.hasAliveMembers());
    }
}