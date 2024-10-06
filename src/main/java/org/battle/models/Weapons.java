package org.battle.models;

import org.battle.exceptions.StackEmptyException;
import org.battle.exceptions.StackFullException;

/*
Синглтон-объект Weapons, который создаёт разные виды оружия.
Объект Weapons должен создавать анонимные объекты AbstractWeapon.
 */

class Weapons {
    private static Weapons instance;

    // Приватный конструктор для того, чтобы создавать объет можно было единожды
    private Weapons() {}

    // Метод для получения единстввенного экземпляра синглтона
    public static Weapons getInstance() {
        if (instance == null) {
            instance = new Weapons();
        }
        return instance;
    }

    // Фабричный метод, который возвращает анонимные классы оружия
    public AbstractWeapon createWeapon(int maxClipSize, ShootType shootType, String ammoType) {
        return new AbstractWeapon(maxClipSize, shootType) {
            // Метод для создания патрона
            @Override
            protected Ammo createAmmo() {
                return Ammo.valueOf(ammoType);
            }
            // Метод для перезарядки оружия
            @Override
            public void reload() {
                for (int i = 0; i < maxClipSize; i++) {
                    try {
                        clip.push(createAmmo());
                    } catch (StackFullException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            // Метод для получения патрона для выстрела
            @Override
            public Ammo getAmmoForShoot() {
                if (isEmptyClip()) {
                    return null;
                } else {
                    try {
                        Ammo ammo = clip.pop();
                        return ammo;
                    } catch (StackEmptyException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
    }
}
