package org.battle;

import org.battle.models.Character;
import org.battle.models.Weapon;

public final class Battle {
    private final Team team1,
                 team2;

    public Battle(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void start() {
        team2.addMember(new Character("WARRIOR", "ADSFA", 25, new Weapon("KNIFE", 11), 10));
        while (team1.hasMembers() && team2.hasMembers()) {
            Character character1 = team1.getAliveMember(),
                      character2 = team2.getAliveMember();
            character1.attack(character2);
            if(!character2.isAlive()) {
                System.out.println(character2.getName() + " повержен!");
            }

            if(team2.hasMembers()){
                character2.attack(character1);
                if(!character1.isAlive()) {
                    System.out.println(character1.getName() + " повержен!");
                }
            }
        }

        if(team1.hasMembers()){
            System.out.println("Команда " + team1.getName() + " победила!");
        } else System.out.println("Команда " + team2.getName() + " победила!");
    }
}
