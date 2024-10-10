package org.battle;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.battle.models.Character;

@AllArgsConstructor
@Slf4j
public final class Battle {

    private final Team team1,
                 team2;

    public void start() {
        // Пока в каждой из команд есть живые участники
        while (team1.hasAliveMembers() && team2.hasAliveMembers()) {
            // Получаем по одному участнику из команды
            Character character1 = team1.getAliveMember(),
                      character2 = team2.getAliveMember();
            // Участник первой команды атакует участника второй команды
            character1.attack(character2);
            // Если HP атакуемого кончились
            if (!character2.isAlive()) {
                log.info("{} повержен!", character2.getName());
            }
            // Проверяем, остались ли живые участники в команде после атаки
            if (team2.hasAliveMembers()) { // Если остались
                // Участник второй команды атакует участника первой команды
                character2.attack(character1);
                // Если HP атакуемого кончились
                if (!character1.isAlive()) {
                    log.info("{} повержен!", character1.getName());
                }
            }
        }
        // Если, после выхода из цикла в первой команде остались живые
        if (team1.hasAliveMembers()) {
            log.info("Команда {} победила!", team1.getName());
        } else { // Если, после выхода из цикла во второй команде остались живые
            log.info("Команда {} победила!", team2.getName());
        }
    }
}
