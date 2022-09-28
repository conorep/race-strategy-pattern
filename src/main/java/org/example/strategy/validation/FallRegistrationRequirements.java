package org.example.strategy.validation;

import org.example.entities.Document;
import org.example.entities.Runner;

import java.util.Set;
import java.util.stream.Collectors;

public class FallRegistrationRequirements implements IRaceValidation
{
    @Override
    public Set<Runner> filterRunners(Set<Runner> runners)
    {
        //required doc(s)
        Document requiredDoc = new Document("Fall Registration");

        return runners.stream().filter(runner -> runner.getDocuments().contains(requiredDoc))
                .collect(Collectors.toSet());
    }
}
