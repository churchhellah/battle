package org.battle.models;

import org.battle.types.ShootType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneralTest {

    @Test
    void testCaptainInitialization() {
        General general = new General();
        Assertions.assertEquals(200, general.getMaxHealth(),
                "General max health after initialization should be equal to 200");
        Assertions.assertEquals(0.3, general.getDodge(),
                "General dodge should be equal to 0.3");
        Assertions.assertEquals(0.9, general.getAccuracy(),
                "General accuracy should be equal to 0.9");
        Assertions.assertEquals(50, general.getWeapon().getMaxClipSize(),
                "General's weapon max clip size should be equal to 50");
        Assertions.assertEquals(ShootType.BURST, general.getWeapon().getShootType(),
                "General's weapon shoot type should be equal to BURST");
    }
}
