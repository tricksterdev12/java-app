package constraints;
public class PrecedenceConstraint extends BinaryConstraint
{
   
   public PrecedenceConstraint (Activity Ac1,Activity Ac2)
   {
	   super(Ac1, Ac2);
   }
   
   @Override
   public  boolean isSatisfied(int date1,int date2)
   {
	   int d=super.Ac1.getDuration();
	   if((date1+d) <= date2)
		return true;
	   else
	    return false;
	   
   }
   
   public String toString()
	{
		return "la première activité :"+super.Ac1.toString()+" la deuxiéme activité :"+super.Ac2.toString();
	}
}
