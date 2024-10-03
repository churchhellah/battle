package org.battle.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Фабрика
public abstract class Weapons {
    // Фабричный метод
    public abstract AbstractWeapon createWeapon();
}
