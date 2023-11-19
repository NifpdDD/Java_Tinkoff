package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public class OutputStreamComposition {
    private OutputStreamComposition() {

    }

    public static void makeComposition(String filePath) throws IOException {
        try (var file = new FileOutputStream(filePath);
             var checkedOutputStream = new CheckedOutputStream(file, new CRC32());
             var bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             var outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
             var printWriter = new PrintWriter(outputStreamWriter)) {
            printWriter.println("Programming is learned by writing programs. ― Brian Kernighan");
        }
    }
}
