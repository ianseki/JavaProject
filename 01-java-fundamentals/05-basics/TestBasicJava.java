public class TestBasicJava 
{
    
    public static void main(String[] args)
    {
        BasicJava test = new BasicJava();

        test.printTo255();

        test.printOddTo255();

        System.out.print(test.sumOf255());

        int[] x = {1, 3, 5, 7, 9, 11, 13};
        test.iterateThrough(x);

        int[] myArray= {-54, -4, -5};
        System.out.print(String.format("Max in array: %d",test.findMax(myArray)));

        System.out.print(test.arrayListOddTo255());
    }
}
