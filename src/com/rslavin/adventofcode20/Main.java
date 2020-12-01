package com.rslavin.adventofcode20;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        long start;
        long end;
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
        start = System.nanoTime();
        day.run();
        end = System.nanoTime();

        System.out.printf("Execution time: %dms\n", TimeUnit.NANOSECONDS.toMillis(end - start));

    }

    private static Day selectDayPart(String[] args){
        return switch (args[0]) {
            case "1" -> new Day1(args[1], args[2]);
            default -> null;
        };

    }
}
