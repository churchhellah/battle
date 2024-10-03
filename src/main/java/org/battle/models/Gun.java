package org.battle.models;

import lombok.AllArgsConstructor;
import org.battle.exceptions.StackFullException;

@AllArgsConstructor
public class Gun extends AbstractWeapon {
    // Переменная, содержащая максимальное количество патронов в магазине
    private final int maxClipSize;
    // Переменная, содержащая тип стрельбы оружия
    private final ShootType shootType;
    // Переменная, содержащая обойму
    private Stack<Ammo> clip;
    // Переменная, содержащая признак, что обойма пуста
    private boolean isEmptyClip = clip.isEmpty();

    public Ammo createAmmo(String ammoType) {
        switch (ammoType) {
            case "SELF_MADE":
                return Ammo.SELF_MADE;
            case "ARMOR_PIERSING":
                return Ammo.ARMOR_PIERSING;
            default:
                return Ammo.DEFAULT;
        }
    }

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

    public Ammo getAmmoForShoot() {
        return clip.getAmmo();
    }
}
