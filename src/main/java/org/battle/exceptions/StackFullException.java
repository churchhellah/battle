package org.battle.exceptions;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public final class StackFullException extends Exception {
    int size;
}
