package com.infosupport.targettype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.PrivilegedAction;
import java.util.concurrent.Callable;

public class TargetTypeTests {

    @Test
    @DisplayName("""
    How does the compiler determines what the type of the lambda is?
    """)
    void whatIsTheTargetType(){
        //Arrange
        Runnable runnable = () ->{};
        //Act


    }

    public Runnable doeIets(){
        return () ->{};
    }

    @Test
    @DisplayName("""
    Who am I?
    """)
    void amITheSame(){

        Callable<Integer> callable = () -> 42;


        PrivilegedAction<Integer> privilegedAction= () -> 42;

        if(callable.equals(privilegedAction)){
            System.out.println("Equal");
        }else{
            System.out.println("UnEqual");
        }
    }
}
