import java.util.ArrayList;

public class ListOfExceptions 
{
    ArrayList<Object> myList = new ArrayList<Object>();
    
    public void listActions()
    {
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        try
        {
            for(int i = 0; i < myList.size(); i++) 
            {
                Integer castedValue = (Integer) myList.get(i);
            }
        }
        catch (ClassCastException e)
        {
            System.out.println("ERROR!! There is a class cast exception occuring ERROR!!");
            System.out.println(e);
        }
    }
}
