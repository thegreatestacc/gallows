package net.sovliv.gallows.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dictionary {
    List<Word> words;

    public Dictionary(List<Word> words) {
        this.words = words;
    }
}
