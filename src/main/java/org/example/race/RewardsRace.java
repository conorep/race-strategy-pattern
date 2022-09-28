package org.example.race;

import lombok.Data;
import org.example.entities.Runner;
import org.example.strategy.validation.IRaceValidation;

import java.time.LocalDate;

@Data
public class RewardsRace extends Race
{
    private int raceLengthKilometers;
    private String reward;

    public RewardsRace(String name, LocalDate dayOfRace, int raceLengthKilometers, IRaceValidation validation)
    {
        super(name, dayOfRace, validation);
        this.raceLengthKilometers = raceLengthKilometers;
    }

    @Override
    public void raceDay()
    {        //welcome people to the race
        System.out.println("Welcome to - " + getName());
        System.out.println("Registered today: ");
        getRunners().stream().forEach(System.out::println);
        System.out.println();

        //make sure everyone can run
        setRunners(getValidation().filterRunners(getRunners()));

        System.out.println("Ready to run today: ");
        getRunners().stream().forEach(System.out::println);
        System.out.println();

        //simulate the race
        Runner winner = waitForWinner();
        System.out.println(winner.getName() + " won the race!");
        setReward();
        System.out.println("Their reward: " + reward);
    }

    private void setReward()
    {
        if(raceLengthKilometers <= 0)
        {
            reward = "no reward for no race...";
        } else if(raceLengthKilometers <= 5)
        {
            reward = "a high five and $100!";
        } else if (raceLengthKilometers <= 10)
        {
            reward = "a hug and $500!";
        } else if(raceLengthKilometers <= 20)
        {
            reward = "a consensual kiss and $1000!";
        } else if (raceLengthKilometers <= 50)
        {
            reward = "two high fives, a hug, a massage, and a vacation to Portland, Maine!";
        }
    }
}
