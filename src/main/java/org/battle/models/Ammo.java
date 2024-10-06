package org.battle.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Ammo {
    DEFAULT(10, 20, 0.25),
    ARMOR_PIERSING(20, 40, 0.3),
    SELF_MADE(7, 14, 0.15);

    private final int damage;
    private final int critDamage;
    private final double critChance;
}