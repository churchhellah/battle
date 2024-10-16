package org.battle;

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
public abstract class AbstractWarrior implements Warrior {

    private final int maxHealth; // максимальный уровень здоровья
    private int currentHealth; // текущий уровень здоровья
    private final double dodge; // уклонение — шанс избежать попадания
    private final double accuracy; // точность — вероятность попадания
    protected final AbstractWeapon weapon; // оружие

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
        if (weapon.isEmptyClip()) { // Если обойма пустая - вызвать метод перезарядки оружия
            reload();
            return;
        }
        Stack<Ammo> ammo = weapon.getAmmoForShoot(); // Создаем объект типа Stack, в него складываем патроны для выстрела,
                                                     // так как стрелять могут одиночным выстрелом или очередью
        int totalDamage = 0; // Переменная, в которую складываем общий урон от атаки
        // А здесь проверяем критический урон от выстрела
        for (Ammo bullet : ammo) { // пока объект Ammo в очереди на стрельбу
            // Если случайное число меньше точности война и больше уклонения оппонента, то
            if (Math.random() < accuracy && Math.random() > opponent.getDodge()) {
                // Инициализируем переменную - в ней случайное число для подсчета крита
                double critChance = Math.random();
                // Инициализируем переменную урона - в нее кладем урон от пули
                int damage = bullet.getDamage();
                // Если critChance меньше шанса крита пули, то урон удваивается
                if (critChance < bullet.getCritChance()) {
                    damage *= 2;
                }
                // Прибавляем полученный урон к общему урону
                totalDamage += damage;
            }
        }
        // Передаем оппоненту, что он не жилец!
        opponent.takeDamage(totalDamage);
    }

    @Override
    public void takeDamage(int damage) {
        currentHealth -= damage;
    }

    @Override
    public double getDodge() {
        return dodge;
    }
    // Реализуем абстактный метод перезарядки,
    // чтобы наследники могли перезаряжать оружие разными типами патронов
    protected abstract void reload();
}