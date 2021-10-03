import java.util.ArrayList;

public class BasicJava 
{
    public void printTo255()
    {
        for (int i = 1; i <= 255; i++)
        {
            System.out.println(i);
        }
    }

    public void printOddTo255()
    {
        for (int i = 1; i <= 255; i += 2)
        {
            System.out.print(i);
        }
    }

    public int sumOf255()
    {
        int sum = 0;

        for (int i = 1; i <= 255; i++)
        {
            sum += i;
        }

        return sum;
    }

    public void iterateThrough(int[] x)
    {

        for (int i = 0; i < x.length; i++)
        {
            System.out.print(x[i] + " ");
        }
    }

    public int findMax(int[] inputArray)
    {
        int max = inputArray[0];

        for (int i = 0; i < inputArray.length; i++)
        {
            if (max < inputArray[i])
            {
                max = inputArray[i];
            }
        }

        return max;
    }

    public ArrayList arrayListOddTo255()
    {
        ArrayList<Integer> y = new ArrayList<Integer>();

        for (int i = 1; i <= 255; i += 2)
        {
            y.add(i);
        }

        return y;
    }
}