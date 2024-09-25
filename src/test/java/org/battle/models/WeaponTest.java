package org.battle.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void testWeaponCreation() {
        Weapon fork = new Weapon("Fork", 4);
        Assertions.assertEquals("Fork", fork.getName());
        Assertions.assertEquals(4, fork.getDamage());
    }
}