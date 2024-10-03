package org.battle.models;

// Фабрика для создания SubmachineGun
public class SubmachineGunFactory extends Weapons {
    @Override
    public AbstractWeapon createWeapon() {
        return new SubmachineGun(); // Возвращаем объект SubmachineGun
    }
}
