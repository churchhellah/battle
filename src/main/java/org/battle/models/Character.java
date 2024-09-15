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
    
//    public Character(String name, Weapon weapon) {
//        Character character = new Character("WARRIOR", name, 100, weapon, 5);
//    }
//
//    public Character Commander(String name, Weapon weapon) {
//        return new Character("COMMANDER", name, 150, weapon, 15);
//    }

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
                    weapon.getDamage() + " урона");
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