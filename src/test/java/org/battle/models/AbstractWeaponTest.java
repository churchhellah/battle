package org.battle.models;

import org.battle.types.ShootType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AbstractWeaponTest {

    AbstractWeapon testWeapon = Weapons.getInstance().createWeapon(100, ShootType.BURST);
    AbstractWeapon testSingleShotWeapon = Weapons.getInstance().createWeapon(100, ShootType.SINGLE_SHOT);

    @Test
    void testAbstractWeaponInit() {
        Assertions.assertEquals(100, testWeapon.getMaxClipSize());
        Assertions.assertEquals(ShootType.BURST, testWeapon.getShootType());
        Assertions.assertTrue(testWeapon.getClip().isEmpty());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "DEFAULT",
            "ARMOR_PIERSING",
            "SELF_MADE"
    })
    void testReload(Ammo ammo) {
        testWeapon.reload(ammo);
        Assertions.assertFalse(testWeapon.getClip().isEmpty());
        Assertions.assertEquals(100, testWeapon.getClip().getClip().size());
    }

    @Test
    void testGetAmmoForShootSingleShot() {
        testSingleShotWeapon.reload(Ammo.DEFAULT);
        Assertions.assertEquals(1, testSingleShotWeapon.getAmmoForShoot().getClip().size());
    }

    @Test
    void testGetAmmoForShootBurst() {
        testWeapon.reload(Ammo.DEFAULT);
        Assertions.assertEquals(3, testWeapon.getAmmoForShoot().getClip().size());
    }
}
