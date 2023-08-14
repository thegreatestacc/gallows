package net.sovliv.gallows;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class GallowsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GallowsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("If you want to start a new game input 1, if you want to close game input 0...");

		var scanner = new Scanner(System.in);

		if (scanner.nextInt() == 1) {
			log.info("Let's play!");
			var next = scanner.next();
		} else {
			log.info("Close game...");
			System.exit(0);
		}
	}
}
