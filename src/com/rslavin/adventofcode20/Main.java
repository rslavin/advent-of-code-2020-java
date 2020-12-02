package com.rslavin.adventofcode20;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Day day;

        // input validation
        if (args.length != 3){
            System.err.println("Usage: <day> <part> <input_file>");
            System.exit(1);
        }

        // construct appropriate Day
        day = selectDayPart(args);
        if (day == null){
            System.err.println("Invalid day");
            System.exit(3);
        }

        // run and profile
        profile(day, 1, true);
        profile(day, 10, false);

    }

    private static void profile(Day day, int iterations, boolean verbose){
        long start;
        long end;
        final PrintStream stdout = System.out;

        // disable prints
        if(!verbose){
            System.setOut(new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                }
            }));
        }

        start = System.nanoTime();
        for (int i = 0; i < iterations; i++){
            day.run();
        }
        end = System.nanoTime();

        // re-enable prints
        if(!verbose){
            System.setOut(stdout);
        }

        System.out.printf("Average execution time over %d iterations: %d microseconds\n", iterations, TimeUnit.NANOSECONDS.toMicros(end - start) / iterations);

    }

    private static Day selectDayPart(String[] args){
        return switch (args[0]) {
            case "1" -> new Day1(args[1], args[2]);
            case "2" -> new Day2(args[1], args[2]);
            default -> null;
        };

    }
}
