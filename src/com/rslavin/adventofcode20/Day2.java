package com.rslavin.adventofcode20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day2 implements Day{
    private final int part;
    private final List<Matcher> input;

    public Day2(String part, String inputPath) {
        this.part = Integer.parseInt(part);
        this.input = parseInput(inputPath);
    }

    public int run(){
        if (input.size() == 0){
            System.err.println("No input parsed.");
            return 2;
        }

        if (part == 1)
            System.out.println(input.stream().map(Day2::part1).collect(Collectors.toList()).stream().filter(c -> c).count());
        else
            System.out.println(input.stream().map(Day2::part2).collect(Collectors.toList()).stream().filter(c -> c).count());

        return 0;
    }

    private static boolean part1(Matcher line){
        int min = Integer.parseInt(line.group(1));
        int max = Integer.parseInt(line.group(2));
        char c = line.group(3).charAt(0);
        String password = line.group(4);

        long count = password.chars().filter(ch -> ch == c).count();

        return count <= max && count >= min;
    }

    private static boolean part2(Matcher line){
        int min = Integer.parseInt(line.group(1)) - 1;
        int max = Integer.parseInt(line.group(2)) - 1;
        char c = line.group(3).charAt(0);
        String password = line.group(4);

        return password.charAt(min) == c ^ password.charAt(max) == c;
    }

    private static List<Matcher> parseInput(String path){
        List<Matcher> input = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d+)-(\\d+) (.): (.*)");
        try {
            Scanner s = new Scanner(new File(path));
            while (s.hasNext()){
                Matcher m = pattern.matcher(s.nextLine());
                if (m.find()){
                    input.add(m);
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open " + path);
        }
        return input;
    }
}
