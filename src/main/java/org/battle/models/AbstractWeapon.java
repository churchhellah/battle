package org.battle.models;

/*
Создай класс оружия AbstractWeapon.

Максимальное количество патронов в магазине.
Вид стрельбы
Магазин патронов. Используй класс Stack. Вначале магазин очевидно пуст.
Факт наличия патронов в магазине
Какие методы могут быть?

создание патрона необходимого типа;
перезарядка — создаётся новый магазин и заполняется патронами с помощью функции создания патрона;
получение патронов для выстрела — из магазина получаются патроны в соответствии с типом стрельбы для выстрела(-ов) (количество патронов в магазине должно уменьшаться).
*/

import lombok.Getter;

// Абстрактный класс для оружия
@Getter
public abstract class AbstractWeapon {
    protected int maxClipSize; // Переменная, содержащая максимальное количество патронов в магазине
    private ShootType shootType; // Переменная, содержащая тип стрельбы оружия
    Stack<Ammo> clip; // Переменная, содержащая обойму

    public AbstractWeapon(int maxClipSize, ShootType shootType) {
        this.maxClipSize = maxClipSize;
        this.shootType = shootType;
    }

    // Метод проверки наличия патронов в обойме
    public boolean isEmptyClip() {
        return clip.isEmpty();
    }

    // Абстрактный метод создания патрона
    protected abstract Ammo createAmmo();
    // Абстрактный метод перезарядки
    public abstract void reload();
    // Абстрактный метод получения патрона для выстрела
    public abstract Ammo getAmmoForShoot();
}
