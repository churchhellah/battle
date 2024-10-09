package org.battle.models;

import org.battle.AbstractWarrior;
import org.battle.types.ShootType;

public class General extends AbstractWarrior {
    public General() {
        super(200, 0.3, 0.9, Weapons.getInstance().createWeapon(50, ShootType.BURST));
    }
}