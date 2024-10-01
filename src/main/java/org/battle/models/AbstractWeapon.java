package org.battle.models;

import lombok.AllArgsConstructor;
import org.battle.exceptions.StackFullException;

@AllArgsConstructor
public abstract class AbstractWeapon {
    // Переменная, содержащая максимальное количество патронов в магазине
    private final int maxClipSize;
    // Переменная, содержащая тип стрельбы оружия
    private final ShootType shootType;
    // Переменная, содержащая обойму
    private Stack<Ammo> clip;
    // Переменная, содержащая признак, что обойма пуста
    private boolean isEmptyClip;

    // Метод создания патрона
    private Ammo createAmmo(String ammoType) {
        switch (ammoType) {
            case "SELF_MADE":
                return Ammo.SELF_MADE;
            case "ARMOR_PIERSING":
                return Ammo.ARMOR_PIERSING;
            case "DEFAULT":
                return Ammo.DEFAULT;
            default:
                return Ammo.DEFAULT;
        }
    }

    // Метод перезарядки
    public void reload(String ammoType) {
        for (int i = 0; i < maxClipSize; i++) {
            try {
                clip.push(createAmmo(ammoType));
            } catch (StackFullException e) {

            }
        }
    }
    // Метод получения патрона для выстрела
    public Ammo getAmmoForShoot() {
        return clip.getAmmo();
    }
}
