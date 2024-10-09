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
import org.battle.types.ShootType;

// Абстрактный класс для оружия
@Getter
public abstract class AbstractWeapon {
    protected int maxClipSize; // Переменная, содержащая максимальное количество патронов в магазине
    private final ShootType shootType; // Переменная, содержащая тип стрельбы оружия
    Stack<Ammo> clip; // Переменная, содержащая обойму

    public AbstractWeapon(int maxClipSize, ShootType shootType) {
        this.maxClipSize = maxClipSize;
        this.shootType = shootType;
        this.clip = new Stack<>();
    }

    // Метод перезарядки
    public void reload(Ammo ammoType) {
        clip = new Stack<>(); // Создается новая обойма
        for (int i = 0; i < maxClipSize; i++) {
            clip.push(ammoType); // Заполняем обойму
        }
    }

    // Метод получения патрона для выстрела
    public Stack<Ammo> getAmmoForShoot() {
        Stack<Ammo> ammoToShoot = new Stack<>();
        int shotsNumber = (shootType == ShootType.SINGLE_SHOT) ? 1 : Math.min(3, maxClipSize);
        for (int i = 0; i < shotsNumber; i++) {
            Ammo ammo = clip.pop();
            if (ammo != null) {
                ammoToShoot.push(ammo);
            }
        }
        return ammoToShoot;
    }

    // Метод проверки наличия патронов в обойме
    public boolean isEmptyClip() {
        return clip.isEmpty();
    }
}
