package org.example;

import org.example.entities.Document;
import org.example.entities.Runner;
import org.example.race.Race;
import org.example.strategy.validation.FallRegistrationRequirements;
import org.example.strategy.validation.WinterRegistrationRequirements;

import java.time.LocalDate;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        //some test runners
        Runner[] runners = {
                new Runner("Stan Williams", Arrays.asList(new Document("Winter Registration"))),
                new Runner("Michelle Smith", Arrays.asList(new Document("Fall Registration"),
                                                                 new Document("Liability Waiver"))),
                new Runner("Tyler Patrick", Arrays.asList(new Document("Winter Registration"),
                                                                new Document("Liability Waiver"))),
                new Runner("Jean Davis", Arrays.asList(new Document("Winter Registration"),
                                                                new Document("Liability Waiver"))),
                new Runner("Susie Brown", Arrays.asList(new Document("Fall Registration"))),
                new Runner("Terry Wilson", Arrays.asList(new Document("Fall Registration"),
                                                                new Document("Liability Waiver")))
        };

        //create a race
        Race fallCostumeRace = new Race("Fall Costume Bonanza",
                LocalDate.of(2022, 10, 31), new FallRegistrationRequirements());

        //turn the runners into a stream and register each of them
        //::register is method reference
        Arrays.stream(runners).forEach(fallCostumeRace::register);
        System.out.println();

        fallCostumeRace.raceDay();

        //creating a second race with different registration
        // winter registration doc and liability waiver
        //DON'T CHANGE THE RACE CLASS

        Race winterSnowRace = new Race("Winter Snow Funanza",
                LocalDate.of(2022, 12, 5), new WinterRegistrationRequirements());

        Arrays.stream(runners).forEach(winterSnowRace::register);
        System.out.println();

        winterSnowRace.raceDay();
    }
}