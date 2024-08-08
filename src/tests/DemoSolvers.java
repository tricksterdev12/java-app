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

public class DemoSolvers
{
	public static void main (String [] arg)
	{
	        Activity ac1=new Activity("se lever",1);
			Activity ac2=new Activity("aller au travail",15);
			Activity ac3=new Activity("prendre une douche",10);
			Activity ac4=new Activity("prendre petit déjeuner",12);
			
			HashSet<Activity> listActivity=new HashSet<Activity>();
			
			listActivity.add(ac2);
			listActivity.add(ac3);
			listActivity.add(ac4);
			listActivity.add(ac1);
			
			
			
			PrecedenceConstraint p2=new PrecedenceConstraint(ac4,ac2);
			PrecedenceConstraint p3=new PrecedenceConstraint(ac3,ac4);
			
            HashSet<PrecedenceConstraint> listConstraint=new HashSet<PrecedenceConstraint>();
            
            listConstraint.add(p2);  
            listConstraint.add(p3);  
			
            
			TopologicalSorter t=new TopologicalSorter();
			ArrayList<Activity> list=t.bruteForceSort(listActivity,listConstraint);
			System.out.println(list);

			HashMap<Activity, Integer> d=new HashMap<Activity, Integer>();
			d=t.schedule(listActivity,listConstraint);
			System.out.println(d);

			d.forEach((key,value)->{
			System.out.println(key+" la date debut :"+value);});
	}
}
