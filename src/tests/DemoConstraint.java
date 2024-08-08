package tests;

import constraints.PrecedenceConstraint;
import constraints.Activity;



public class DemoConstraint
{
	public static void main (String [] arg)
	{
	        
	        Activity ac1=new Activity("se lever",15);
			Activity ac2=new Activity("aller au travail",2);
			Activity ac3=new Activity("prendre une douche",3);
			Activity ac4=new Activity("rendre petit déjeuner",6);
			
			
			PrecedenceConstraint p1=new PrecedenceConstraint(ac1,ac2);
			PrecedenceConstraint p2=new PrecedenceConstraint(ac3,ac4);
			PrecedenceConstraint p3=new PrecedenceConstraint(ac2,ac3);
			PrecedenceConstraint p4=new PrecedenceConstraint(ac4,ac2);


			System.out.println(p1.isSatisfied(5,20)? " sont satisfaites" : "ne sont pas satisfaites");
			System.out.println(p2.isSatisfied(0,10)? " sont satisfaites" : "ne sont pas satisfaites");
			System.out.println(p3.isSatisfied(5,0) ? " sont satisfaites" : "ne sont pas satisfaites");
			System.out.println(p4.isSatisfied(5,2) ? " sont satisfaites" : "ne sont pas satisfaites");
	
	}
}
