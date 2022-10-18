import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class readFile {
    public static void main(String[] args) {
        if (args.length < 3 || args.length > 3) {
            System.out.println("Parameters input by user is incorrect.");
        }

        else {
            // java readFile -r <fileName> <output file>
            // argument [0]: -r: specify to read
            // argument [1]: name of file to read
            // argument [2]: specified file directory, containing the output file
            if (args[0].equalsIgnoreCase("-r")) {
                readFile.result(args[1], args[2]);
            }
        }

    }

    private static void outputFile(char[] msgarr, String outFile) {
        try {
            BufferedWriter writeOut = new BufferedWriter(new FileWriter(outputFile));
            for (Character line : msgarr) {
                writeOut.write(line);
            }
            writeOut.close();
        } catch (IOException ex) {
            System.out.println("Error: Output to file error");
        }

        System.out.println("File is exported successfully.");
    }

    private static String readInfile(String file_input) {
        String output = "";
        BufferedReader readIn = null;

        try {
            readIn = new BufferedReader(new FileReader(file_input));
        }

        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        try {

            String i;
            while ((i = readIn.readLine()) != null) {

                if (!i.isEmpty()) {

                    if (i.length() > 0) {

                        output += i.toString();

                    }
                }
            }
            readIn.close();
        } catch (IOException ex) {
            System.out.println("Error: Can't read from file.");
        }

        // System.out

        // Print?
        return output;
    }

    private static void result(String inFile, String outFile) {
        String output = "";

        output = readFile.readInfile(inFile);

        char[] msgarr = output.toCharArray();

        readFile.outputFile(msgarr, outFile);
    }
}
