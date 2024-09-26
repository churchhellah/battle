package org.battle;

import lombok.Getter;
import org.battle.models.Character;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public final class Team {
    @Getter
    private final String name;
    // Команда содержит массив уникальных Character
    private final Set<Character> members;

    // Конструктор класса. Принимает на вход массив объектов Character
    // и делает из него неизменяемый Set
    public Team(String name, Character... members) {
        this.name = name;
        this.members = Set.of(members);
    }

    // Метод проверки наличия живых участников в members
    public boolean hasAliveMembers() {
        return this.members.stream().anyMatch(Character -> Character.isAlive());
    }

    // Метод получения живого участника из members
    public Character getAliveMember() {
        for (Character member : members) {
            if (member.isAlive()) {
                return member;
            }
        } return null;
    }
}