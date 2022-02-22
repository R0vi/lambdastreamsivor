package com.infosupport.demo02executearound;

import org.jooq.lambda.Unchecked;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

public class ExecuteAroundTests {
    
    @Test
    @DisplayName("""
    Execute Around Pattern print one line from file.
    """)
    void executeAroundDemoPrintOneLine(){
        readFile(Unchecked.consumer(bfr -> System.out.println(bfr.readLine())));
    }

    @Test
    @DisplayName("""
    Execute Around Pattern count words in file
    """)
    void executeAroundDemoCountWordsInFile(){
        readFile(Unchecked.consumer(bfr -> {
            int wordCount = 0;
            while (bfr.ready()){
                wordCount += bfr.readLine().split("\\s+").length;
            }
            System.out.println(wordCount);
        }));
    }

    void readFile(Consumer<BufferedReader> consumer) {
        try(
                final var fileReader = new FileReader("maxverstappen.txt");
                final var bufferedReader = new BufferedReader(fileReader);){

            consumer.accept(bufferedReader);


        }catch (Exception e){
            //log
            //throw exception after enriching it with context
        }
    }
}
