package org.battle;
import org.battle.models.Character;
import org.battle.models.Weapon;

public final class App
{
    public static void main( String[] args ) {
        Weapon knife = new Weapon("KNIFE", 11),
               gun = new Weapon("GUN", 20);

        Team team1 = new Team("TERRORISTS"),
             team2 = new Team("COUNTER-TERRORISTS");

        team1.addMember(new Character("COMMANDER", "ВАСЯ", 30, gun, 15));
        team1.addMember(new Character("WARRIOR", "ПЕТЯ", 25, gun, 10));
        team2.addMember(new Character("COMMANDER", "ВОВА", 30, gun, 15));
        team2.addMember(new Character("WARRIOR", "КОЛЯ", 25, knife, 10));

        Battle battle = new Battle(team1, team2);
        battle.start();
    }
}
