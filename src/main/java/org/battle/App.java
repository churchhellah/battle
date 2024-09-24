package org.battle;

import org.battle.models.Character;
import org.battle.models.Weapon;

public final class App {
    public static void main(String[] args ) {
        // Создаем оружие
        Weapon knife = new Weapon("KNIFE", 11),
               gun = new Weapon("GUN", 20);

        // Создаем участников команд
        Character vasya = new Character("COMMANDER", "ВАСЯ", 30, gun, 15),
                  petya = new Character("WARRIOR", "ПЕТЯ", 25, gun, 10),
                  vova = new Character("COMMANDER", "ВОВА", 30, gun, 15),
                  kolya = new Character("WARRIOR", "КОЛЯ", 25, knife, 10);

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
