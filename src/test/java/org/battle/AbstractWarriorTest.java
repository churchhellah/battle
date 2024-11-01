package org.battle;

import org.battle.models.AbstractWeapon;
import org.battle.models.Soldier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class AbstractWarriorTest {

    private TestSoldier soldier;
    private Soldier opponent;
    private AbstractWeapon mockWeapon;

    static class TestSoldier extends Soldier {
        @Override
        protected void reload() {
            super.reload();
        }
    }

    @BeforeEach
    void setUp() {
        // Создаем mock для оружия
        mockWeapon = mock(AbstractWeapon.class);

        // Подменим оружие у солдата через spy
        soldier = spy(new TestSoldier());
        doReturn(mockWeapon).when(soldier).getWeapon();

        opponent = spy(new Soldier());
    }

    @Test
    void testAttackWithEmptyClip() { // тут мы провряем,
                                     // что при пустой обойме
                                     // совершается перезарядка
                                     // и оппоненту не наносится урон
        soldier.attack(opponent);

        verify(soldier, times(1)).reload();
        verify(opponent, times(0)).takeDamage(anyInt());
    }

    @Test
    void testAttackWithFullClip() {// тут мы провряем,
                                          // что при полной обойме
                                          // оппоненту наносится урон
        soldier.reload();
        soldier.attack(opponent);

        verify(opponent, times(1)).takeDamage(anyInt());
    }

    @Test
    void takeDamage() {
        soldier.reload();
        soldier.attack(opponent);

        Assertions.assertTrue(opponent.getMaxHealth() > opponent.getCurrentHealth());
    }

    @Test
    void getDodge() {
        Assertions.assertEquals(0.1, soldier.getDodge());
    }

    @Test
    void reload() {
        Assertions.assertTrue(soldier.weapon.getClip().isEmpty());
        soldier.reload();
        Assertions.assertFalse(soldier.weapon.getClip().isEmpty());
    }

    @Test
    void getMaxHealth() {
        Assertions.assertEquals(100, soldier.getMaxHealth());
    }

    @Test
    void getCurrentHealth() {
        soldier.reload();
        soldier.attack(opponent);
        Assertions.assertNotEquals(opponent.getCurrentHealth(), opponent.getMaxHealth());
    }

    @Test
    void getAccuracy() {
        Assertions.assertEquals(0.7, soldier.getAccuracy());
    }

    @Test
    void getWeapon() {
        Assertions.assertEquals(mockWeapon, soldier.getWeapon());
    }
}