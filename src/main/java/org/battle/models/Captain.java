package org.battle.models;

import org.battle.AbstractWarrior;
import org.battle.types.ShootType;

public class Captain extends AbstractWarrior {
    public Captain() {
        super(150, 0.2, 0.8, Weapons.getInstance().createWeapon(30, ShootType.BURST));
    }

    @Override
    protected void reload() {
        super.weapon.reload(Ammo.DEFAULT);
    }
}