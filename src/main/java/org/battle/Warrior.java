package org.battle;

/*
Создай интерфейс война
Свойства
- isKilled,
- шанс избежать попадания.
Методы
- атаковать — на вход принимает противника (Warrior),
- получить урон — на вход принимает количество урона.
 */

public interface Warrior {

    boolean isKilled(); // Проверка на то, убит ли воин

    double getDodge(); // Шанс уклонения

    void attack(Warrior opponent); // атаковать противника

    void takeDamage(int damage); // получить урон
}
