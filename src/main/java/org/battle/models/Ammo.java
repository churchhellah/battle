package org.battle.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Ammo {
    DEFAULT(10, 20, 25),
    ARMOR_PIERSING(20, 100, 50),
    SELF_MADE(7, 14, 10);

    private final int damage;
    private final int critDamage;
    private final int critChance;
}