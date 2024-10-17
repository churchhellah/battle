package org.battle;

import lombok.extern.slf4j.Slf4j;
import org.battle.models.AbstractWeapon;
import org.battle.models.Ammo;
import org.battle.models.Stack;

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
@Slf4j
public abstract class AbstractWarrior implements Warrior {

    private final int maxHealth; // максимальный уровень здоровья
    private int currentHealth; // текущий уровень здоровья
    private final double dodge; // уклонение — шанс избежать попадания
    private final double accuracy; // точность — вероятность попадания
    private final AbstractWeapon weapon; // оружие

    public AbstractWarrior(int maxHealth,
                           double dodge,
                           double accuracy,
                           AbstractWeapon weapon) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.dodge = dodge;
        this.accuracy = accuracy;
        this.weapon = weapon;
    }

    @Override
    public boolean isKilled() {
        return currentHealth <= 0;
    }

    @Override
    public void attack(Warrior opponent) {
        // если патронов в оружии нет, перезарядить оружие и пропустить ход.
        if (weapon.isEmptyClip()) {
            weapon.reload(Ammo.DEFAULT);
            log.info("{} перезаряжает оружие", this.getClass().getSimpleName());
            return;
        }
        Stack<Ammo> ammo = weapon.getAmmoForShoot();
        int totalDamage = 0;

        for (Ammo bullet : ammo) {
            if (Math.random() < accuracy && Math.random() > opponent.getDodge()) {
                double critChance = Math.random();
                int damage = bullet.getDamage();
                if (critChance < bullet.getCritChance()) {
                    damage *= 2;
                    log.info("{} наносит критический урон",
                            this.getClass().getSimpleName());
                }
                totalDamage += damage;
            }
        }
        opponent.takeDamage(totalDamage);
        log.info("{} нанес {} {} урона",
                this.getClass().getSimpleName(),
                opponent.getClass().getSimpleName(),
                totalDamage);
    }

    @Override
    public void takeDamage(int damage) {
        currentHealth -= damage;
    }

    @Override
    public double getDodge() {
        return dodge;
    }
}