import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class seperateLines {
    static boolean debug = false;

    public static void showLine(String line) {
        System.out.println(line);
    }

    public static List<List<String>> readBlocks(String fileName) throws IOException {
        List<List<String>> blocks = new ArrayList<>();

        File file = new File(fileName);
        Scanner scnrFile = new Scanner(file);

        while (scnrFile.hasNextLine()) {
            String line = scnrFile.nextLine().trim();

            if (debug) {
                showLine(line);
            }

            if (!line.isEmpty()) {
                List<String> block = new ArrayList<>();
                block.add(line);

                while (scnrFile.hasNextLine()) {
                    line = scnrFile.nextLine().trim();

                    if (line.isEmpty()) {
                        break; // Start a new block when an empty line is encountered
                    }

                    block.add(line);
                }

                blocks.add(block);
            }
        }

        scnrFile.close();
        return blocks;
    }

    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter file name: ");
        List<List<String>> blocks = readBlocks(scnr.next());

        // Process the list of blocks as needed
        for (List<String> block : blocks) {
            for (String line : block) {
                // Your logic here
                System.out.println(line);
            }
            System.out.println("-----"); // Separator between blocks
        }

        scnr.close();
    }
}
