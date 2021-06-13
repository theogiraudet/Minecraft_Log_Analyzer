package fr.theogiraudet.log_analyzer;

import fr.theogiraudet.log_analyzer.datas.Data;
import fr.theogiraudet.log_analyzer.datas.DataManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String... args) throws IOException {
        final List<File> files = new LinkedList<>();

        for(var arg: args) {
            if(arg.endsWith(".log")) {
                final var file = FileSystems.getDefault().getPath(arg).normalize().toFile();
                if(file.exists())
                    files.add(file);
            }
        }

        for(var line: Files.readAllLines(files.get(0).toPath()))
            DataManager.apply(line);

        Data data = DataManager.get();
        System.out.println(data);
    }


}
