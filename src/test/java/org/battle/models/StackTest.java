package org.battle.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StackTest {

    Stack<Ammo> clip;

    @BeforeEach
    void setClip() {
        clip = new Stack<>();
    }

    @Test
    void testStackInitialization() {
        Assertions.assertEquals(0, clip.getClip().size(),
                "Newly created clip should be empty");
    }

    @Test
    void testIsEmptyForEmptyClip() {
        Assertions.assertTrue(clip.isEmpty(),
                "Method 'isEmpty' should return true for new Stack object");
    }

    @Test
    void testIsEmptyForFullClip() {
        clip.push(Ammo.DEFAULT);
        Assertions.assertFalse(clip.isEmpty(),
                "Method 'isEmpty' should return false for Stack with Ammo in it");
    }

    @Test
    void testPushToStack() {
        List<Ammo> testClip = new ArrayList<>(List.of(Ammo.DEFAULT));
        clip.push(Ammo.DEFAULT);
        Assertions.assertEquals(testClip, clip.getClip(), "Method 'push' should add Ammo to Stack");
        Assertions.assertEquals(1, clip.getClip().size(), "Method 'push' should increase Stack on 1");
    }

    @Test
    void testPopFromEmptyStack() {
        Assertions.assertNull(clip.pop(),
                "Method 'pop' should return null if Stack is empty");
    }

    @Test
    void testPopFromFullStack() {
        for (int i = 0; i < 5; i++) {
            clip.push(Ammo.ARMOR_PIERSING);
        }
        Assertions.assertEquals(5, clip.getClip().size(),
                "Stack size should be equal to number of Ammo in it");
        Assertions.assertEquals(Ammo.ARMOR_PIERSING, clip.pop(),
                "Method 'pop' should return object, which was pushed in it");
        Assertions.assertEquals(4, clip.getClip().size(),
                "Size of clip should decrease by 1 after 'pop' method call");
    }
}
