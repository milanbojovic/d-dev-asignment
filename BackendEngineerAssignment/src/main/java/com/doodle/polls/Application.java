package com.doodle.polls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.doodle.polls.beans.Poll;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PollRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // fetch all Polls from database
        System.out.println("Polls found with findAll():");
        System.out.println("-------------------------------");

        for (Poll poll : repository.findAll()) {
            System.out.println(poll);
        }
        System.out.println();
    }

}