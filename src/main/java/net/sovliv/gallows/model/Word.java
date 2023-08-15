package net.sovliv.gallows.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Word {
    String noun;

    public Word(String noun) {
        this.noun = noun;
    }
}
