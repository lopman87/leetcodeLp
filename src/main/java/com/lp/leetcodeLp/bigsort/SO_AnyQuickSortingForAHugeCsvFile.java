package com.lp.leetcodeLp.bigsort;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import com.github.davidmoten.bigsorter.Serializer;
import com.github.davidmoten.bigsorter.Sorter;
import org.apache.commons.csv.CSVFormat;
public class SO_AnyQuickSortingForAHugeCsvFile {
    public static void main(String[] args) throws IOException {
        System.out.println("creating input data");
        long t = System.currentTimeMillis();
        File input = new File("target/input.csv");
        try (PrintStream p = new PrintStream(
                new BufferedOutputStream(new FileOutputStream(input)))) {
            Random r = new Random();
            for (int i = 0; i < 12_000_000; i++) {
                for (int j = 0; j < 37; j++) {
                    if (j > 0) {
                        p.print(",");
                    }
                    p.print(r.nextInt() % 100000);
                }
                p.println();
            }
        }
        System.out.println("created input file in " + (System.currentTimeMillis() - t) / 1000.0 + "s");
        Sorter.serializer(Serializer.csv(CSVFormat.DEFAULT.withRecordSeparator('\n'), //
                StandardCharsets.UTF_8)) //
                .comparator((x, y) -> Integer.compare(Integer.parseInt(x.get(10)),
                        Integer.parseInt(y.get(10)))) //
                .input(input) //
                .output(new File("target/output.txt")) //
                .maxItemsPerFile(20000) //
                .loggerStdOut() //
                .sort();
    }
}
