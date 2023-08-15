package net.sovliv.gallows;

import lombok.extern.slf4j.Slf4j;
import net.sovliv.gallows.service.InitService;
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
    InitService initService;

    public GallowsApplication(ParseDictionaryService dictionaryService, InitService initService) {
        this.dictionaryService = dictionaryService;
        this.initService = initService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("If you want to start a new game input 1, if you want to close game input 0...");

        int mistakeCounter = 0;
        int allMistakes = 5;
        int switcher;

        var scanner = new Scanner(System.in);
        switcher = scanner.nextInt();

        if (switcher != 0) {
            log.info("Let's play!");
            var letterScanner = new Scanner(System.in);

            var randomWordIndex = initService.getRandomIndex();
            var hiddenWord = dictionaryService.getNounDictionary()
                    .getWords().get(randomWordIndex).getNoun();

            int hiddenWordLettersCounter = hiddenWord.length();
            System.out.println("hidden word is: " + hiddenWord);

            var letters = dictionaryService.parseWordByLetters(hiddenWord);
            var encryptedWord = initService.hideWord(hiddenWord);

            while (mistakeCounter < allMistakes && switcher != 0) {
                System.out.println(encryptedWord + " mistakes: " + mistakeCounter);

                System.out.println("choose a letter...");
                var letter = letterScanner.next().charAt(0);

                if (letters.contains(letter)) {
                    System.out.println("you have found correct letter!");
                    int i = letters.indexOf(letter);
                    letters.set(i, letter);
                    encryptedWord.setCharAt(i, letter);
                    hiddenWordLettersCounter--;
                    if (hiddenWordLettersCounter == 0) {
                        System.out.println("you won! do you want play again?");
                        switcher = scanner.nextInt();
                    }
                } else {
                    mistakeCounter++;
                    System.out.println("you have made mistake! mistake(s) - " + mistakeCounter + "\n"
                            + "now you have just - " + (allMistakes - mistakeCounter) + " mistake(s)!");
                }

                System.out.println(encryptedWord);
            }

        } else {
            log.info("Close game...");
            System.exit(0);
        }
    }
}
