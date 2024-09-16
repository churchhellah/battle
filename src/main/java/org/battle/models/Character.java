package org.battle.models;

public class Character {
    private String rank;
    private String name;
    private int health;
    private Weapon weapon;
    private int defence;

    public Character(String rank, String name, int health, Weapon weapon, int defence) {
        this.rank = rank;
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.defence = defence;
    }

    public String getName() {
        return this.name;
    }

    public void attack(Character opponent) {
        int damage = weapon.getDamage() - opponent.defence;
        if(damage > 0) {
            opponent.health -= damage;
            System.out.println(
                    this.name + " атакует " +
                    opponent.name + " с " +
                    weapon.getName() + " и наносит " +
                    weapon.getDamage() + " урона. У " +
                    opponent.name + " осталось " +
                    opponent.health + " здоровья");
        } else {
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