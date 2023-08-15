package net.sovliv.gallows;

import lombok.extern.slf4j.Slf4j;
import net.sovliv.gallows.service.ParseDictionaryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
@Slf4j
public class GallowsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GallowsApplication.class, args);
    }

    ParseDictionaryService dictionaryService;

    public GallowsApplication(ParseDictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("If you want to start a new game input 1, if you want to close game input 0...");

        int mistakeCounter;

        var scanner = new Scanner(System.in);

        while (scanner.nextInt() != 0) {
            log.info("Let's play!");
            var letterScanner = new Scanner(System.in);

            var randomWordIndex = new Random().ints(0, 16)
                    .findFirst().getAsInt();

            var hiddenWord = dictionaryService.getNounDictionary().getWords().get(randomWordIndex).getNoun();

            //todo remove this row
            System.out.println(hiddenWord);


            char[] chars = new char[hiddenWord.length()];
            for (int i = 0; i < hiddenWord.length(); i++) {
                chars[i] = hiddenWord.charAt(i);
            }

            var sb = new StringBuilder();
            for (int i = 0; i < hiddenWord.length(); i++) {
                sb.append("*");
            }

            //todo remove this row
            System.out.println(sb);
        }

        log.info("Close game...");
        System.exit(0);
    }
}
