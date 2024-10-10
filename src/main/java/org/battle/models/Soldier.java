package org.battle.models;

import org.battle.AbstractWarrior;
import org.battle.types.ShootType;

public class Soldier extends AbstractWarrior {
    public Soldier() {
        super(100, 0.1, 0.7, Weapons.getInstance().createWeapon(30, ShootType.SINGLE_SHOT));
    }
}