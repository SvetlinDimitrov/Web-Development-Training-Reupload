package JavaAdvance.Streams_Files_And_Directories_Lab;

import java.io.*;

public class Copy_Bytes_03 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\4orapa\\IdeaProjects\\First step in coding\\SoftUni\\JavaAdvance\\Streams_Files_And_Directories_Lab\\input.txt";
        String pathOut = "C:\\Users\\4orapa\\IdeaProjects\\First step in coding\\SoftUni\\JavaAdvance\\Streams_Files_And_Directories_Lab\\03.CopyBytesOutput.txt";
        FileInputStream input = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream(pathOut);
        PrintWriter writer = new PrintWriter(out);
        int byteOne = input.read();

        while (byteOne != -1) {
            if (byteOne == ' ') {
                writer.print(" ");
            } else if (byteOne == 10) {
                writer.println();
            } else {
                writer.print(byteOne);
            }
            byteOne = input.read();
        }
        writer.close();
    }
}
