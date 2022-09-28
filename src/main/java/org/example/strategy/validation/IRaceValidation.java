package org.example.strategy.validation;

import org.example.entities.Runner;

import java.util.Set;

public interface IRaceValidation
{
    Set<Runner> filterRunners(Set<Runner> runners);
}
