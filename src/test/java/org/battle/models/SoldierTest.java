package org.battle.models;

import org.battle.types.ShootType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SoldierTest {

    @Test
    void testCaptainInitialization() {
        Soldier soldier = new Soldier();
        Assertions.assertEquals(100, soldier.getMaxHealth(),
                "Soldier max health after initialization should be equal to 100");
        Assertions.assertEquals(0.1, soldier.getDodge(),
                "Soldier dodge should be equal to 0.1");
        Assertions.assertEquals(0.7, soldier.getAccuracy(),
                "Soldier accuracy should be equal to 0.7");
        Assertions.assertEquals(30, soldier.getWeapon().getMaxClipSize(),
                "Soldier's weapon max clip size should be equal to 30");
        Assertions.assertEquals(ShootType.SINGLE_SHOT, soldier.getWeapon().getShootType(),
                "Soldier's weapon shoot type should be equal to SINGLE_SHOT");
    }
}
