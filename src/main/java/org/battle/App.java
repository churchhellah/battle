package org.battle;
import org.battle.models.Character;
import org.battle.models.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.List.of;

public final class App
{
    public static void main(String[] args ) {
        Weapon knife = new Weapon("KNIFE", 11),
               gun = new Weapon("GUN", 20);

        // Создаем изменяемые списки, в которые положим участников команд
        List<Character> team1 = new ArrayList<>(),
                        team2 = new ArrayList<>();
        // Создаем участников команд
        Character vasya = new Character("COMMANDER", "ВАСЯ", 30, gun, 15),
                  petya = new Character("WARRIOR", "ПЕТЯ", 25, gun, 10),
                  vova = new Character("COMMANDER", "ВОВА", 30, gun, 15),
                  kolya = new Character("WARRIOR", "КОЛЯ", 25, knife, 10),
                  test = new Character("WARRIOR", "TEST", 25, knife, 10);
        // Добавляем участников первой команды в список
        team1.add(vasya);
        team1.add(petya);
        // Добавляем участников второй команды в список
        team2.add(vova);
        team2.add(kolya);
        // Создаем первую команду, передаем в нее изменяемый список
        Team terrorists = new Team("TERRORISTS", team1),
        // Создаем вторую команду, передаем в нее изменяемый список
             counterTerrorists = new Team("COUNTER-TERRORISTS", team2);

        // Создаем битву
        Battle battle = new Battle(terrorists, counterTerrorists);
        team2.add(test);
        // Начинаем битву
        battle.start();
    }
}
