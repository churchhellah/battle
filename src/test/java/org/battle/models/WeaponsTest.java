package org.battle.models;

import org.battle.types.ShootType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WeaponsTest {

    @Test
    void testWeaponsInitialization() {
        Weapons weapon = Weapons.getInstance();
        Assertions.assertEquals(weapon, Weapons.getInstance(),
                "If instance of Weapons already excisits, then every call of 'getInstanse' will return link on the same object");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "10, BURST",
            "1, SINGLE_SHOT",
            "0, BURST",
            "10_000_000, BURST"
    })
    void testCreateWeapon(int maxClipSize, ShootType shootType) {
        Weapons weapon = Weapons.getInstance();
        AbstractWeapon testWeapon = weapon.createWeapon(maxClipSize, shootType);
        Assertions.assertEquals(maxClipSize, testWeapon.getMaxClipSize(),
                "AbstractWeapon should be created with maxClipSize in method parameters");
        Assertions.assertEquals(shootType, testWeapon.getShootType(),
                "AbstractWeapon should be created with shootType in method parameters");
    }
}
