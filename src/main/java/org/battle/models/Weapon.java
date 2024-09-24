package org.battle.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class Weapon {
    private final String name;
    private final int damage;
}
