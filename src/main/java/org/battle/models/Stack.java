package org.battle.models;

import lombok.Getter;
import org.battle.exceptions.StackEmptyException;
import org.battle.exceptions.StackFullException;

import java.util.ArrayList;
import java.util.List;

@Getter
public final class Stack<T extends Ammo> {
    // Переменная, которая будет содержать тип патрона
    private T ammo;
    // Переменная, которая будет содержать обойму
    private List<T> clip;

    // В констуркторе инициализируем ammo и создаем пустую обойму
    public Stack(T ammo) {
        this.ammo = ammo;
        this.clip = new ArrayList<>();
    }

    // Метод для добавления патрона в обойму
    public void push(T ammo) throws StackFullException {
        // TODO добавить лимит патронов в зависимости от оружия
//        if (AbstractWeapon.getClipLimit == clip.length) {
//            throw new StackFullException(magazine.length);
//        }
        clip.add(ammo);
    }

    // Метод для получения паторона из обоймы для выстрела
    public T pop() throws StackEmptyException {
        // Если обойма пустая, то вернется Exception
        if (clip.isEmpty()) {
            throw new StackEmptyException();
        }
        // Иначе вернется первый объект из исписка
        // и он же удалится
        return clip.remove(0);
    }

    // Метод для проверки обоймы на пустоту
    public boolean isEmpty() {
        return clip.isEmpty();
    }
}
