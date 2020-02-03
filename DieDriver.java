import java.util.Scanner;

public class DieDriver
{
    public static void main(String[] args)
    {
        Die die = new Die();
        boolean gameOver = false;
        int goal = 100;
        int numPlayers = 8;
        int[] scores = {0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("Welcome to the horse races, place your bets!");
        pause();
        System.out.println("...and they're off!");
        while (!gameOver)
        {
            for (int i = 0; i < numPlayers; i++)
            {
                int roll = die.roll();
                if (scores[i] + roll <= goal)
                {
                    scores[i] += roll;
                }
                String printScore = fixedLengthString("Player #" + (i + 1) + ": " + scores[i], 15);
                String printRoll = fixedLengthString("(rolled " + roll + ")", 12);
                System.out.println(printScore + printRoll + "|" + repeatChar("-", scores[i]) + (i + 1) + repeatChar("-", goal - scores[i]) + ">");
                if (scores[i] == goal)
                {
                    System.out.println("Player #" + (i + 1) + " wins!");
                    gameOver = true;
                    break;
                }
            }
            pause();
        }
    }

    static void pause()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        in.nextLine();
    }

    static String repeatChar(String ch, int len)
    {
        String str = "";
        for (int i = 0; i < len; i++)
        {
            str += ch;
        }
        return str;
    }

    static String fixedLengthString(String input, int len)
    {
        if (input.length() > len)
        {
            return input.substring(0, len);
        }
        else
        {
            return input + repeatChar(" ", len - input.length());
        }
    }
}