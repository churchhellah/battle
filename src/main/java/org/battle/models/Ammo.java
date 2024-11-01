package org.battle.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Ammo {
    DEFAULT(10, 0.25),
    ARMOR_PIERSING(20, 0.3),
    SELF_MADE(7, 0.15);

    private final int damage;
    private final double critChance;
}