package org.battle.models;

/*
Синглтон-объект Weapons, который создаёт разные виды оружия.
Объект Weapons должен создавать анонимные объекты AbstractWeapon.
 */

import org.battle.types.ShootType;

class Weapons {
    private static Weapons instance;

    // Приватный конструктор для того, чтобы создавать объет можно было единожды
    private Weapons() {}

    // Метод для получения единственного экземпляра синглтона
    public static Weapons getInstance() {
        if (instance == null) {
            instance = new Weapons();
        }
        return instance;
    }

    // Фабричный метод, который возвращает анонимные классы оружия
    public AbstractWeapon createWeapon(int maxClipSize, ShootType shootType) {
        return new AbstractWeapon(maxClipSize, shootType) {
        };
    }
}
