package tests;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import solvers.TopologicalSorter;
import solvers.RandomScheduler;
import solvers.Verifier;

import constraints.MaxSpanConstraint;
import constraints.PrecedenceConstraint;
import constraints.Activity;
import constraints.MeetConstraint;
import constraints.Constraint;

public class DemoEmploiDuTemps {
    public static void main(String[] args) {

        Activity ac1 = new Activity("se lever", 1);
        Activity ac2 = new Activity("prendre une douche", 15);
        Activity ac3 = new Activity("se brosser les dents", 10);
        Activity ac4 = new Activity("s'habiller", 3);

        Set<Constraint> constraints = new HashSet<>();

        // Contrainte : activity1 doit être planifiée avant activity2
        constraints.add(new PrecedenceConstraint(ac1, ac2));

        // Contrainte : activity4 doit commencer précisément quand activity3 se termine
        constraints.add(new MeetConstraint(ac3, ac4));

        // Contrainte : activity1, activity2 et activity3 doivent toutes
        // être exécutées en au plus 90 minutes
        Set<Activity> activities = new HashSet<>();
        activities.add(ac1);
        activities.add(ac2);
        activities.add(ac3);

        MaxSpanConstraint spanConstraint = new MaxSpanConstraint(activities, 90);
        constraints.add(spanConstraint);

        RandomScheduler randomScheduler = new RandomScheduler(new Random());
        Map<Activity, Integer> generateSchedule = randomScheduler.generateSchedule(activities, constraints, 0, 100, 10);

        System.out.println(generateSchedule);
    }
}
