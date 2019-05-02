package com.Chinazhouwy;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
    	LinkedList list = new LinkedList();

        List<String> lines
                =  Files.readAllLines(Paths.get("C:\\Users\\18217\\Desktop\\bbb.txt"),
                Charset.forName("utf8"));

        lines.stream().filter(s -> s.contains("软件")).forEach(
                e -> System.out.println(e)
        );
    }

}
