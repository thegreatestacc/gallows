package net.sovliv.gallows.service;

import lombok.extern.slf4j.Slf4j;
import net.sovliv.gallows.model.Dictionary;
import net.sovliv.gallows.model.Word;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ParseDictionaryService {

    private final static String PATH_TO_DICTIONARY = "src/main/resources/dictionary.txt";

    public Dictionary getNounDictionary() throws IOException {
        var result = new ArrayList<Word>();

        try (var reader = new BufferedReader(new BufferedReader(new FileReader(PATH_TO_DICTIONARY)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(new Word(line));
            }
        }
        return new Dictionary(result);
    }

    public List<Character> parseWordByLetters(String word) {
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            result.add(word.charAt(i));
        }
        return result;
    }

}
