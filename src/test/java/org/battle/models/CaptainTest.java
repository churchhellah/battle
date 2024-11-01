package org.battle.models;

import org.battle.types.ShootType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaptainTest {

    @Test
    void testCaptainInitialization() {
        Captain captain = new Captain();
        Assertions.assertEquals(150, captain.getMaxHealth(),
                "Captain max health after initialization should be equal to 150");
        Assertions.assertEquals(0.2, captain.getDodge(),
                "Captain dodge should be equal to 0.2");
        Assertions.assertEquals(0.8, captain.getAccuracy(),
                "Captain accuracy should be equal to 0.8");
        Assertions.assertEquals(30, captain.getWeapon().getMaxClipSize(),
                "Captain's weapon max clip size should be equal to 30");
        Assertions.assertEquals(ShootType.BURST, captain.getWeapon().getShootType(),
                "Captain's weapon shoot type should be equal to BURST");
    }
}