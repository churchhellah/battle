package org.battle.models;

import lombok.Getter;
import org.apache.commons.collections4.ListUtils;
import org.battle.Warrior;

import java.util.*;

public final class Team {
    // Команда содержит массив Warrior
    private final List<Warrior> members;
    @Getter
    private final String name;

    // Конструктор класса. Принимает на вход массив объектов Warrior
    // и делает из него неизменяемый List
    public Team(String name) {
        Random random = new Random();
        List<Warrior> tempTeam = new ArrayList<>();
        this.name = name;
        for (int i = 0; i < 10; i++) {
            double chance = random.nextDouble();
            if (chance < 0.1) {
                tempTeam.add(new General());
            } else if (chance < 0.5) {
                tempTeam.add(new Captain());
            } else {
                tempTeam.add(new Soldier());
            }
        }
        this.members = ListUtils.unmodifiableList(tempTeam);
    }

    // Метод проверки наличия живых участников в members
    public boolean hasAliveMembers() {
        return this.members
                .stream()
                .anyMatch(Warrior -> !Warrior.isKilled());
    }

    // Метод получения живого участника из members
    public Warrior getAliveMember() {
        return this.members
                .stream()
                .filter(Warrior -> !Warrior.isKilled())
                .findAny()
                .orElse(null);
    }
}