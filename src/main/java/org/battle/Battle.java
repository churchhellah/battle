package org.battle;

import lombok.AllArgsConstructor;
import org.battle.models.AbstractWarrior;

@AllArgsConstructor
public final class Battle {
    private final Team team1,
                 team2;

    public void start() {
        // Пока в каждой из команд есть живые участники
        while (team1.hasAliveMembers() && team2.hasAliveMembers()) {
            // Получаем по одному участнику из команды
            AbstractWarrior character1 = team1.getAliveMember(),
                      character2 = team2.getAliveMember();
            // Участник первой команды атакует участника второй команды
            character1.attack(character2);
            // Если HP атакуемого кончились
            if (!character2.isAlive()) {
                // TODO подключить логгер
                System.out.println(character2.getName() + " повержен!");
            }
            // Проверяем, остались ли живые участники в команде после атаки
            if (team2.hasAliveMembers()) { // Если остались
                // Участник второй команды атакует участника первой команды
                character2.attack(character1);
                // Если HP атакуемого кончились
                if (!character1.isAlive()) {
                    // TODO подключить логгер
                    System.out.println(character1.getName() + " повержен!");
                }
            }
        }
        // Если, после выхода из цикла в первой команде остались живые
        if (team1.hasAliveMembers()) {
            // TODO подключить логгер
            System.out.println("Команда " + team1.getName() + " победила!");
        } else { // Если, после выхода из цикла во второй команде остались живые
            // TODO подключить логгер
            System.out.println("Команда " + team2.getName() + " победила!");
        }
    }
}
