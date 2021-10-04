import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava 
{
    Random randMachine = new Random();

    public ArrayList getTenRolls()
    {
        ArrayList<Integer> tenRolls = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) 
        {
            tenRolls.add(randMachine.nextInt(20) + 1);
        }

        return tenRolls;
    }

    public char getRandomLetter()
    {
        char[] alphabet = new char[26];
        int index = 0;

        for (int i = 97; i <= 122; i++)
        {
            alphabet[index] = (char)i;
            index++;
        }

        int randNum = randMachine.nextInt(26);

        return alphabet[randNum];
    }

    public String generatePassword()
    {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++)
        {
            password.append(getRandomLetter());
        }

        return password.toString();
    }

    public ArrayList getNewPasswordSet(int x)
    {
        ArrayList<String> passwords = new ArrayList<String>();

        for (int i = 0; i < x; i++)
        {
            passwords.add(generatePassword());
        }

        return passwords;
    }
}
