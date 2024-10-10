package org.battle.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public final class Character {
    private final String rank;
    private final String name;
    private int health;
    private final Weapon weapon;
    private final int defence;

    public void attack(Character opponent) {
        int damage = weapon.getDamage() - opponent.defence;
        if (damage > 0) {
            opponent.health -= damage;
            log.info("{} атакует {} с {} и наносит {} урона. У {} осталось {} здоровья",
                    this.name,
                    opponent.name,
                    weapon.getName(),
                    weapon.getDamage(),
                    opponent.name,
                    opponent.health);
        } else {
            log.info("{} атакует {} с {}, но урона не наносит",
                    this.name,
                    opponent.name,
                    weapon.getName());
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}