package org.battle.models;

public abstract class AbstractWeapon {
    // Переменная, содержащая максимальное количество патронов в магазине
    private int maxClipSize;
    // Переменная, содержащая тип стрельбы оружия
    private ShootType shootType;
    // Переменная, содержащая обойму
    private Stack<Ammo> clip;
    // Переменная, содержащая признак, что обойма пуста
    private boolean isEmptyClip = clip.isEmpty();

    // Метод создания патрона
    public abstract Ammo createAmmo(String ammoType);

    // Метод перезарядки
    public abstract void reload(String ammoType);

    // Метод получения патрона для выстрела
    public abstract Ammo getAmmoForShoot();
}
