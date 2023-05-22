package JavaAdvance.Streams_Files_And_Directories_Lab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Sort_Lines_06_again {
    public static void main(String[] args) throws IOException {
        String yes = "SoftUni/JavaAdvance/Streams_Files_And_Directories_Lab/input.txt";
        String out = "SoftUni/JavaAdvance/Streams_Files_And_Directories_Lab/NewOutInput.txt";
        Path path = Paths.get(yes);
        Path outPath  = Paths.get(out);

        List <String> lines = Files.readAllLines(path);
        lines = lines.stream().filter(l ->!l.isBlank()).collect(Collectors.toList());
        Collections.sort(lines);
        Files.write(outPath , lines);

    }
}
