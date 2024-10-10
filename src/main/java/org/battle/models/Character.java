package org.battle.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
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
            // TODO подключить логгер
            System.out.println(
                    this.name + " атакует " +
                    opponent.name + " с " +
                    weapon.getName() + " и наносит " +
                    weapon.getDamage() + " урона. У " +
                    opponent.name + " осталось " +
                    opponent.health + " здоровья");
        } else {
            // TODO подключить логгер
            System.out.println(
                    this.name + " атакует " +
                    opponent.name + " с " +
                    weapon.getName() + ", но урона не наносит"
            );
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}