package com.rslavin.adventofcode20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Day1 implements Day{
    private int part;
    private String inputPath;

    public Day1(String part, String inputPath) {
        this.part = Integer.parseInt(part);
        this.inputPath = inputPath;
    }

    public int run(){
        // parse input file
        List<Integer> input = parseInput(this.inputPath);

        if (input.size() == 0){
            System.err.println("No input parsed.");
            return 2;
        }

        for (int i = 0; i < input.size(); i++){
            for (int j = i + 1; j < input.size(); j++){
                if (this.part == 2){
                    for (int k = j + 1; k < input.size(); k++){
                        if (input.get(i) + input.get(j) + input.get(k) == 2020){
                            System.out.println(input.get(i) * input.get(j) * input.get(k));
                            return 0;
                        }
                    }
                } else if (input.get(j) + input.get(i) == 2020){
                    System.out.println(input.get(j) * input.get(i));
                    return 0;
                }
            }
        }
        System.err.println("No matches.");
        return 1;
    }

    private static List<Integer> parseInput(String path){
        List<Integer> input = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File(path));
            while (s.hasNext()){
                input.add(Integer.parseInt(s.next()));
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open " + path);
        }
        return input;
    }
}
