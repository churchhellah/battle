package org.battle.models;

// Фабрика для создания MachineGun
public class MachineGunFactory extends Weapons {
    @Override
    public AbstractWeapon createWeapon() {
        return new MachineGun(); // Возвращаем объект MachineGun
    }
}
