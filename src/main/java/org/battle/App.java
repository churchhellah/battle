package org.battle;

import org.battle.models.AbstractWarrior;
import org.battle.models.Weapons;

public final class App {
    public static void main(String[] args ) {
        // Создаем оружие
        Weapons knife = new Weapons("KNIFE", 11),
               gun = new Weapons("GUN", 20);

        // Создаем участников команд
        AbstractWarrior vasya = new AbstractWarrior("COMMANDER", "ВАСЯ", 30, gun, 15),
                  petya = new AbstractWarrior("WARRIOR", "ПЕТЯ", 25, gun, 10),
                  vova = new AbstractWarrior("COMMANDER", "ВОВА", 30, gun, 15),
                  kolya = new AbstractWarrior("WARRIOR", "КОЛЯ", 25, knife, 10);

        // Создаем первую команду, передаем в нее имя и членов команды
        Team terrorists = new Team("TERRORISTS", vasya, petya),
        // Создаем вторую команду, передаем в нее имя и членов команды
             counterTerrorists = new Team("COUNTER-TERRORISTS", vova, kolya);

        // Создаем битву, передаем команды, которые будут в ней учавствовать
        Battle battle = new Battle(terrorists, counterTerrorists);
        // Начинаем битву
        battle.start();
    }
}
