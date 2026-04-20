import java.util.Scanner;

public class SafeInput
{
    private static Scanner in = new Scanner(System.in);

    public static String getNonZeroLenString(String prompt)
    {
        String input;
        do
        {
            System.out.print(prompt + ": ");
            input = in.nextLine();
        } while (input.isEmpty());

        return input;
    }

    public static int getInt(String prompt)
    {
        int value = 0;
        boolean done = false;

        while (!done)
        {
            System.out.print(prompt + ": ");
            if (in.hasNextInt())
            {
                value = in.nextInt();
                in.nextLine();
                done = true;
            }
            else
            {
                System.out.println("Invalid input. Enter an integer.");
                in.nextLine();
            }
        }
        return value;
    }

    public static boolean getYNConfirm(String prompt)
    {
        String input;
        do
        {
            System.out.print(prompt + " (Y/N): ");
            input = in.nextLine();
        } while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N"));

        return input.equalsIgnoreCase("Y");
    }
}