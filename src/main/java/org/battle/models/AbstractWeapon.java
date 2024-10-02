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
    private boolean isEmptyClip = clip.isEmpty();

    // Метод создания патрона
    private Ammo createAmmo(String ammoType) {
        switch (ammoType) {
            case "SELF_MADE":
                return Ammo.SELF_MADE;
            case "ARMOR_PIERSING":
                return Ammo.ARMOR_PIERSING;
            default:
                return Ammo.DEFAULT;
        }
    }

    // Метод перезарядки
    public void reload(String ammoType) {
        if (isEmptyClip) {
            for (int i = 0; i < maxClipSize; i++) {
                try {
                    clip.push(createAmmo(ammoType));
                } catch (StackFullException e) {
                    // TODO catch body
                }
            }
        } //TODO else
    }
    // Метод получения патрона для выстрела
    public Ammo getAmmoForShoot() {
        return clip.getAmmo();
    }
}
