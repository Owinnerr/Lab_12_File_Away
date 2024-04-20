import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = ""; // Initialize variable rec (to read each line)
        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { // Condition: If the user picked a file,
                selectedFile = chooser.getSelectedFile(); // What the user chose
                Path file = selectedFile.toPath(); // Convert it to a path
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                Path path = Paths.get("D:/data.txt"); // Create object of Path
                Path name = path.getFileName(); // Call getFileName() and get name path object
                System.out.println("File name: " + name.toString()); // Output the file name
                int line = 0; // Initialize line variable
                int words = 0; // Initialize words variable
                int chars = 0; // Initialize chars variable
                while(reader.ready()) { // Loop: While the reader is ready,
                    rec = reader.readLine(); // Reads a line from the file and sets as a variable
                    line++; // Increase line by 1
                    String[] result = rec.split(" "); // Create an array and split the line from the spaces to put the substrings in the array
                    words += result.length; // Set words to words plus the length of the array
                    chars += rec.length(); // Set chars to chars plus the length of the line
                }
                System.out.println("Number of lines: " + line); // Output the number of lines
                System.out.println("Number of words: " + words); // Output the number of words
                System.out.println("Number of characters: " + chars); // Output the number of characters
                reader.close(); // Close the file
            } else {
                System.out.println("No file selected, exiting.\nRun the program again and select a file."); // Output that there is no file
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found."); // Output that the file is not found
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
