package org.battle.models;

// Фабрика для создания MachineGun
public class GunFactory extends Weapons {
    @Override
    public AbstractWeapon createWeapon() {
        return new Gun(); // Возвращаем объект Gun
    }
}
