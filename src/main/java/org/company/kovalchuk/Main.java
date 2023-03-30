package org.company.kovalchuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.ukrposhta.kovalchuk")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
