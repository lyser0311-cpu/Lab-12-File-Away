import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DataSaver
{
    public static void main(String[] args)
    {
        ArrayList<String> records = new ArrayList<>();
        boolean moreData = true;
        int idCounter = 1;

        while (moreData)
        {
            String firstName = SafeInput.getNonZeroLenString("Enter First Name");
            String lastName = SafeInput.getNonZeroLenString("Enter Last Name");
            String email = SafeInput.getNonZeroLenString("Enter Email");
            int year = SafeInput.getInt("Enter Year of Birth");

            String idNumber = String.format("%06d", idCounter);
            idCounter++;

            String record = firstName + ", " +
                    lastName + ", " +
                    idNumber + ", " +
                    email + ", " +
                    year;

            records.add(record);

            moreData = SafeInput.getYNConfirm("Add another record?");
        }

        String fileName = SafeInput.getNonZeroLenString("Enter output file name (no extension)");
        Path filePath = Path.of("src", fileName + ".csv");

        try
        {
            Files.write(filePath, records);
            System.out.println("File saved successfully.");
        }
        catch (IOException e)
        {
            System.out.println("Error writing the file.");
        }
    }
}