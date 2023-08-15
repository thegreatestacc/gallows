package net.sovliv.gallows.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class InitService {

    public StringBuilder hideWord(String inputWord) {
        var sb = new StringBuilder();
        sb.append("*".repeat(inputWord.length()));
        return sb;
    }

    public int getRandomIndex() {
        return new Random().ints(0, 16)
                .findFirst().getAsInt();
    }
}
