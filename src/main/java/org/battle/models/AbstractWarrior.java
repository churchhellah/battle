package org.battle.models;

import java.util.Random;

/*
Абстрактный класс AbstractWarrior, который реализует интерфейс Warrior.

Свойства:
- максимальный уровень здоровья,
- уклонение — шанс избежать попадания,
- точность — вероятность попадания,
- оружие,
- текущий уровень здоровья.
Методы
- Атаковать (метод интерфейса):
    если патронов в оружии нет, перезарядить оружие и пропустить ход.
    В противном случае получить патроны для выстрела.
    Для каждого из них проверить, соответствует ли патрон точности война и уклонению противника.
    Для патронов, которые попадают в противника, рассчитать суммарный урон.
    Нанести урон врагу.
- Понести урон (метод интерфейса) — отнять от текущего уровня здоровья урон.
 */
public abstract class AbstractWarrior implements Warrior {

    private final int maxHealth; // максимальный уровень здоровья
    private final int dodge; // уклонение — шанс избежать попадания
    private final int accuracy; // точность — вероятность попадания
    private final Weapons weapon; // оружие
    private int currentHealth; // текущий уровень здоровья

    public AbstractWarrior(int maxHealth, int dodge, int accuracy, int maxClipSize, ShootType shootType, ) {
        this.maxHealth = maxHealth;
        this.dodge = dodge;
        this.accuracy = accuracy;
        this.weapon = Weapons.getInstance().createWeapon();
        this.currentHealth = maxHealth;
    }

    @Override
    public void attack(AbstractWarrior opponent) {
        // если патронов в оружии нет, перезарядить оружие и пропустить ход.
        if (weapon.) {
            weapon.reload();
        }
        else {
            Random random = new Random();
            // Если точность текущего война больше, чем шанс уклониться у противника
            if (this.accuracy > opponent.dodgeChance()) {
                // Если оружие стреляет одиночными выстрелами
                if (ShootType.SINGLE_SHOT.equals(weapon.getShootType())) {
                    Ammo ammo = weapon.getAmmoForShoot();
                    // Проверяем, будет ли нанесен критический урон
                    boolean isCrit = ammo.getCritChance() > random.nextDouble();
                    opponent.takeDamage(isCrit ? ammo.getCritDamage() : ammo.getDamage());
                // Если оружие стреляет очередями
                } else if (ShootType.BURST.equals(weapon.getShootType())) {
                    Ammo ammo = weapon.getAmmoForShoot();
                    // Проверяем, будет ли нанесен критический урон
                    boolean isCrit = ammo.getCritChance() > random.nextDouble();
                    if (isCrit) {

                    }
                }
            }
        }
    }

    @Override
    public void takeDamage(int damage) {
        this.currentHealth -= damage;
    }
}