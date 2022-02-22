package com.infosupport.methodrefrences;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MethorReferencesTests {

    @Test
    @DisplayName("""
            Can we get rid of even more syntactical rubish?
            """)
    void getRidOfSyntacticalRubish() {
        //Arrange
        Callable callable1 = () -> {
            return 42;
        };
        Callable callable2 = () -> 42;

        UnaryOperator<Integer> unaryOperator =  i -> 42;
    }


    @Test
    @DisplayName("""
    There is more repetition to get rid of!
    """)
    void examplesOfMethodReferences(){
        //Arrange
        Runnable runnable1 = () -> System.gc();
        //Act
        Runnable runnable2 = System::gc;

        Consumer<String> stringConsumer1 = ( s) ->System.clearProperty(s);

        Consumer<String> stringConsumer2 = System::clearProperty;

        Function<Integer,String> toString1MethodReference =(i) -> String.valueOf(i);

        Function<Integer,String> toString2MethodReference = String::valueOf;
    }
}

