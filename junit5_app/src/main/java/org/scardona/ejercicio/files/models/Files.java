package org.scardona.ejercicio.files.models;

import java.util.*;

public class Files {

    public static List<String> fixFiles(List<String> files){
        Map<String, Integer> values = new HashMap<>();
        return files.stream().map(file ->{

            int count = values.get(file) == null? 0: values.get(file)+1;

            values.put(file,count);

            return count > 0? file +"("+count+")": file;

        }).toList();

    }
}
