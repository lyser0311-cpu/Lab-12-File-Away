import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInspector
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser("src");
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            Path filePath = chooser.getSelectedFile().toPath();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = Files.newBufferedReader(filePath))
            {
                String line;

                while ((line = reader.readLine()) != null)
                {
                    System.out.println(line);
                    lineCount++;
                    charCount += line.length();

                    String trimmedLine = line.trim();
                    if (!trimmedLine.isEmpty())
                    {
                        String[] words = trimmedLine.split("\\s+");
                        wordCount += words.length;
                    }
                }

                System.out.println("\n----- File Summary -----");
                System.out.println("File Name: " + filePath.getFileName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);
            }
            catch (IOException e)
            {
                System.out.println("Error reading the file.");
            }
        }
        else
        {
            System.out.println("No file selected.");
        }
    }
}