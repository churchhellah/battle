package org.battle.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.battle.models.Team;
import org.battle.Warrior;

@Slf4j
@AllArgsConstructor
public final class Battle {
    private final Team team1,
                 team2;

    public void start() {
        log.info("Команда {}: {}, Команда {}: {}",
                team1.getName(),
                team1.getMembers().
                        stream().
                        map(Warrior -> Warrior.getClass().getSimpleName()).toList(),
                team2.getName(),
                team2.getMembers().
                        stream().
                        map(Warrior -> Warrior.getClass().getSimpleName()).toList());
        // Пока в каждой из команд есть живые участники
        while (team1.hasAliveMembers() && team2.hasAliveMembers()) {
            // Получаем по одному участнику из команды
            Warrior character1 = team1.getAliveMember(),
                      character2 = team2.getAliveMember();
            // Участник первой команды атакует участника второй команды
            character1.attack(character2);
            log.info("{}.{}: начинает атаку на {}.{}",
                    character1.getClass().getSimpleName(),
                    team1.getName(),
                    character2.getClass().getSimpleName(),
                    team2.getName());
            // Если HP атакуемого кончились
            if (character2.isKilled()) {
                log.info("Атаковал {}.{}: {}.{} повержен!",
                        character1.getClass().getSimpleName(),
                        team1.getName(),
                        character2.getClass().getSimpleName(),
                        team2.getName());
            }
            // Проверяем, остались ли живые участники в команде после атаки
            if (team2.hasAliveMembers()) { // Если остались
                // Участник второй команды атакует участника первой команды
                character2.attack(character1);
                log.info("{}.{} атакует {}.{}",
                        character2.getClass().getSimpleName(),
                        team2.getName(),
                        character1.getClass().getSimpleName(),
                        team1.getName());
                // Если HP атакуемого кончились
                if (character1.isKilled()) {
                    log.info("Атаковал {}.{}: {}.{} повержен!",
                            character2.getClass().getSimpleName(),
                            team2.getName(),
                            character1.getClass().getSimpleName(),
                            team1.getName());
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