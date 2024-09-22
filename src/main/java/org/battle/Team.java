package org.battle;

import org.battle.models.Character;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
commons-collections4
com.google.guava
 */
//ImmutableSet.of()

public final class Team {
    private final String name;
    private final List<Character> members;

    // Конструктор класса. Принимает на вход изменяемый список и делает его неизменяемым
    public Team(String name, Character ... members) {
        this.name = name;
        this.members = Collections.unmodifiableList(members);

//        List<Character> tempMembers = new ArrayList<>();
//
//        members.addAll(tempMembers);
//
//        this.members = Collections.unmodifiableList(tempMembers);
    }

    public String getName() {
        return this.name;
    }

//    public void addMember(Character member) {
//        // Создаем изменяемую копию списка
//        //List<Character> modifiableMembers = new ArrayList<>(this.members);
//        // Добавляем в изменяемую копию списка member
//        this.tempMembers = new ArrayList<>(this.members);
//        tempMembers.add(member);
//        // Обновляем исходный список
//        //this.members = Collections.unmodifiableList(new ArrayList<>(modifiableMembers));
//    }

    public boolean hasMembers() {
        return this.members.stream().anyMatch(Character -> Character.isAlive());
    }

    public Character getAliveMember() {
        for(Character member : members) {
            if(member.isAlive()) {
                return member;
            }
        } return null;
    }
}