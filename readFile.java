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
            return;
        }

        else {
            if (args[0].equalsIgnoreCase("-r")) {
                readFile.result(args[1], args[2]);
            }
        }

    }

    private static void fileOutput(String outputZipFile) {
        String outpath = outdir + "/" + entry.getName();
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(outpath);
            int len = 0;
            while ((len = stream.read(buffer)) > 0) {
                output.write(buffer, 0, len);
            }
        } finally {
            // we must always close the output file
            if (output != null)
                output.close();
        }
        stream.close();
        System.out.println("File is exported successfully.");

    }

    private static void readZippedFile(String inZip) {
        byte[] buffer = new byte[2048];

        ZipEntry entry;
        while ((entry = stream.getNextEntry()) != null) {
            String s = String.format("Entry: %s len %d added %TD", entry.getName(), entry.getSize(),
                    new Date(entry.getTime()));
            System.out.println(s);
        }

    }

    private static void result(String inFile, String outFile) {

        readFile.readZippedFile(inFile);

        readFile.fileOutput(outFile);

    }

}
