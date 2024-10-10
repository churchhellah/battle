package org.battle.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public final class Stack<T> implements Iterable<T> {
    private final List<T> clip = new ArrayList<>();

    // Метод для добавления патрона в обойму
    public void push(T ammo) {
        clip.add(ammo);
    }

    // Метод для получения паторона из обоймы для выстрела
    public T pop() {
        // Если обойма пустая, то вернется null
        if (clip.isEmpty()) {
            return null;
        }
        // Иначе вернется первый объект из списка
        // и он же удалится
        return clip.remove(0);
    }

    // Метод для проверки обоймы на пустоту
    public boolean isEmpty() {
        return clip.isEmpty();
    }

    // Возвращаем итератор для поддержки foreach цикла
    @Override
    public Iterator<T> iterator() {
        return clip.iterator();
    }
}
