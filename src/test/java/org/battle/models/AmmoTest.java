package org.battle.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AmmoTest {

    Ammo bullet;

    @Test
    void testDefaultAmmoInitialization() {
        bullet = Ammo.DEFAULT;
        Assertions.assertEquals(Ammo.DEFAULT, bullet, "'bullet' should equals to Ammo.DEFAULT");
        Assertions.assertEquals(10, bullet.getDamage(), "damage of default bullet should be 10");
        Assertions.assertEquals(0.25, bullet.getCritChance(), "critical chance of default bullet should be 0.25");
    }

    @Test
    void testArmourPiersingAmmoInitialization() {
        bullet = Ammo.ARMOR_PIERSING;
        Assertions.assertEquals(Ammo.ARMOR_PIERSING, bullet, "'bullet' should equals to Ammo.ARMOR_PIERSING");
        Assertions.assertEquals(20, bullet.getDamage(), "damage of default bullet should be 20");
        Assertions.assertEquals(0.3, bullet.getCritChance(), "critical chance of armor piersing bullet should be 0.3");
    }

    @Test
    void testSelfMadeAmmoInitialization() {
        bullet = Ammo.SELF_MADE;
        Assertions.assertEquals(Ammo.SELF_MADE, bullet, "'bullet' should equals to Ammo.SELF_MADE");
        Assertions.assertEquals(7, bullet.getDamage(), "damage of default bullet should be 7");
        Assertions.assertEquals(0.15, bullet.getCritChance(), "critical chance of armor piersing bullet should be 0.15");
    }
}
