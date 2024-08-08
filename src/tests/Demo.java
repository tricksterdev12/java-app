package tests;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import constraints.Activity;
import constraints.PrecedenceConstraint;
import constraints.PrecedenceConstraintWithGap;
import constraints.MeetConstraint;
import constraints.BinaryConstraint;
import constraints.Constraint;
import constraints.MaxSpanConstraint;

import solvers.Verifier;
import solvers.RandomScheduler;


import constraintstests.ActivityTests;
import constraintstests.PrecedenceConstraintTests;
import constraintstests.MeetConstraintTests;
import constraintstests.PrecedenceConstraintWithGapTests;
import constraintstests.AbstractionTests;
import constraintstests.MaxSpanConstraintTests;

import solverstests.VerifierTests;
import solverstests.RandomSchedulerTests;

public class Demo
{
	public static void main (String [] arg)
	{
				boolean ok = true;

				// Activities
				ActivityTests activityTester = new ActivityTests();
				ok = ok && activityTester.testGetDescription();
				ok = ok && activityTester.testGetDuration();
						
				// Precedence constraints
				PrecedenceConstraintTests precedenceConstraintTester = new PrecedenceConstraintTests();
				ok = ok && precedenceConstraintTester.testExtends();
				ok = ok && precedenceConstraintTester.testImplements();
				ok = ok && precedenceConstraintTester.testGetActivities();
				ok = ok && precedenceConstraintTester.testGetFirst();
				ok = ok && precedenceConstraintTester.testGetSecond();
				ok = ok && precedenceConstraintTester.testIsSatisfied();
						
				// Meet constraints
				MeetConstraintTests meetConstraintTester = new MeetConstraintTests();
				ok = ok && meetConstraintTester.testExtends();
				ok = ok && meetConstraintTester.testImplements();
				ok = ok && meetConstraintTester.testGetActivities();
				ok = ok && meetConstraintTester.testGetFirst();
				ok = ok && meetConstraintTester.testGetSecond();
				ok = ok && meetConstraintTester.testIsSatisfied();
						
				// Precedence constraints with gap
				PrecedenceConstraintWithGapTests precedenceConstraintWithGapTester = new PrecedenceConstraintWithGapTests();
				ok = ok && precedenceConstraintWithGapTester.testExtends();
				ok = ok && precedenceConstraintWithGapTester.testImplements();
				ok = ok && precedenceConstraintWithGapTester.testGetActivities();
				ok = ok && precedenceConstraintWithGapTester.testGetFirst();
				ok = ok && precedenceConstraintWithGapTester.testGetSecond();
				ok = ok && precedenceConstraintWithGapTester.testIsSatisfied();

				// Abstract class
				AbstractionTests abstractionTester = new AbstractionTests();
				ok = ok && abstractionTester.testImplements();
				ok = ok && abstractionTester.testGetActivities();
				ok = ok && abstractionTester.testIsSatisfied();
						
				// MaxSpanConstraint
				MaxSpanConstraintTests maxSpanConstraintTester = new MaxSpanConstraintTests();
				ok = ok && maxSpanConstraintTester.testImplements();
				ok = ok && maxSpanConstraintTester.testGetActivities();
				ok = ok && maxSpanConstraintTester.testIsSatisfied();

				// Class verifier
				VerifierTests verifierTester = new VerifierTests();
				ok = ok && verifierTester.testUnsatisfied();
				
				// Class randomScheduler
				RandomSchedulerTests randomSchedulerTester = new RandomSchedulerTests(1722117051601202760L);
				ok = ok && randomSchedulerTester.testGenerateSchedule();
				
				System.out.println(ok ? "All tests passed" : "At least one test failed");
			
			
	}
}

