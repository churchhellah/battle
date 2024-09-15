package org.battle;

import org.battle.models.Character;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Character> members;

    public Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addMember(Character member) {
        this.members.add(member);
    }

    public boolean hasMembers() {
        return this.members.stream().anyMatch(Character::isAlive);
    }

    public Character getAliveMembers() {
        for(Character member : members) {
            if(member.isAlive()) {
                return member;
            }
        } return null;
    }
}
