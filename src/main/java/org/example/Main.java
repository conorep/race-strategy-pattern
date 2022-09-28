package org.example;

import org.example.entities.Document;
import org.example.entities.Runner;
import org.example.race.Race;
import org.example.race.RewardsRace;
import org.example.strategy.validation.FallRegistrationRequirements;
import org.example.strategy.validation.SpringRegistrationRequirements;
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
                                                                new Document("Liability Waiver"))),
                new Runner("Jim James", Arrays.asList(new Document("Spring Registration"),
                                                                new Document("Liability Waiver"))),
                new Runner("Harris Harrianos", Arrays.asList(new Document("Spring Registration"))),
                new Runner("Corey Sarah", Arrays.asList(new Document("Spring Registration"),
                                                                new Document("Liability Waiver"))),
                new Runner("Sarah Corey", Arrays.asList(new Document("Spring Registration"),
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
        Race winterSnowRace = new Race("Winter Snow Funanza",
                LocalDate.of(2022, 12, 5), new WinterRegistrationRequirements());

        Arrays.stream(runners).forEach(winterSnowRace::register);
        System.out.println();

        winterSnowRace.raceDay();

        /*TESTING REWARDS RACE OBJECT*/

        //creating a third race with different registration
        Race springRace = new RewardsRace("Spring Forth Race",
                LocalDate.of(2023, 04, 20), 10, new SpringRegistrationRequirements());

        Arrays.stream(runners).forEach(springRace::register);
        System.out.println();

        springRace.raceDay();

        //creating a fourth race testing out raceLength
        RewardsRace fallRaceRewards = new RewardsRace("Fall Backwards Race",
                LocalDate.of(2024, 11, 22), 52, new FallRegistrationRequirements());

        Arrays.stream(runners).forEach(fallRaceRewards::register);
        System.out.println();

        fallRaceRewards.raceDay();

        //creating a fourth race testing out raceLength
        RewardsRace winterRaceRewards = new RewardsRace("Winter Things Race",
                LocalDate.of(2024, 02, 28), 3, new WinterRegistrationRequirements());

        Arrays.stream(runners).forEach(winterRaceRewards::register);
        System.out.println();

        winterRaceRewards.raceDay();
    }
}