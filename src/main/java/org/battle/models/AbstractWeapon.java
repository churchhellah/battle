package org.battle.models;

import lombok.AllArgsConstructor;

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
    // Метод перезарядки
    // Метод получения патрона для выстрела
}
