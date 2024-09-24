package org.battle.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public final class Character {
    private static final Logger logger = LoggerFactory.getLogger(Character.class);

    private final String rank;
    @Getter
    private final String name;
    private int health;
    private final Weapon weapon;
    private final int defence;

    public void attack(Character opponent) {
        int damage = weapon.getDamage() - opponent.defence;
        if (damage > 0) {
            opponent.health -= damage;
            logger.info("{} атакует {} с {} и наносит {} урона. У {} осталось {} здоровья",
                    this.name,
                    opponent.name,
                    weapon.getName(),
                    weapon.getDamage(),
                    opponent.name,
                    opponent.health);
        } else {
            logger.info("{} атакует {} с {}, но урона не наносит",
                    this.name,
                    opponent.name,
                    weapon.getName());
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}