package org.battle.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public final class Weapons {
    private static Weapons instance;

    private Weapons() {}

    public static Weapons getInstance() {
        if (instance == null) {
            instance = new Weapons();
        }
        return instance;
    }
}
