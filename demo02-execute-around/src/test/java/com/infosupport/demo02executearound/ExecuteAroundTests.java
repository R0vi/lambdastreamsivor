package com.infosupport.demo02executearound;

import org.jooq.lambda.Unchecked;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class ExecuteAroundTests {
    
    @Test
    @DisplayName("""
    Execute Around Pattern
    """)
    void executeAroundDemoWithThrowingConsumer(){
        //Arrange
        readFileWithThrowingConsumer((bfr) -> {


            final var line = bfr.readLine();
            System.out.println(line);

        });

    }
    @FunctionalInterface
    interface ThrowingConsumer<T>{
        void accept(T t) throws IOException;
    }
    private void readFileWithThrowingConsumer(ThrowingConsumer<BufferedReader> consumer) {
        try(
            final var fileReader = new FileReader("maxverstappen.txt");
            final var bufferedReader = new BufferedReader(fileReader);){

            consumer.accept(bufferedReader);
        }catch (Exception e){
            //log
            //throw exception after enriching it with context
        }
    }

    private void readFileWithConsumer(Consumer<BufferedReader> consumer) {
        try(
                final var fileReader = new FileReader("maxverstappen.txt");
                final var bufferedReader = new BufferedReader(fileReader);){

            consumer.accept(bufferedReader);
        }catch (Exception e){
            //log
            //throw exception after enriching it with context
        }
    }

    @Test
    @DisplayName("""
    Execute Around Pattern
    """)
    void executeAroundDemoWithMyCheckedConsumer(){
        //Arrange
        readFileWithConsumer(MyUnchecked.consumer((bfr) -> {

//            final var line = bfr.readLine();
//            System.out.println(line);
            throw new Exception("How is this handled?");

        }));

    }

    interface CheckedConsumer<T>{
        void accept(T t) throws Exception;
    }

    class MyUnchecked<T> {
        static <T> Consumer<T> consumer(CheckedConsumer<T> checkedConsumer) {
            return t -> {
                try {
                    checkedConsumer.accept(t);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            };
        }
    }


    @Test
    @DisplayName("""
    Execute Around Pattern
    """)
    void executeAroundDemoWithJool(){
        //Arrange
        readFileWithConsumer(Unchecked.consumer((bfr) -> {



//            final var line = bfr.readLine();
//            System.out.println(line);
            throw new Exception("How is this handled?");

        }));

    }
}
