package org.battle;

import org.battle.models.Team;
import org.battle.services.Battle;

public final class App
{
    public static void main(String[] args ) {

        // Создаем первую команду, передаем в конструктор имя
        Team terrorists = new Team("TERRORISTS"),
        // Создаем вторую команду, передаем в конструктор имя
             counterTerrorists = new Team("COUNTER-TERRORISTS");

        // Создаем битву, передаем команды, которые будут в ней учавствовать
        Battle battle = new Battle(terrorists, counterTerrorists);
        // Начинаем битву
        battle.start();
    }
}
