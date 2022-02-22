package com.infosupport.typeofthisreference;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TypeOfThisReferencesTests {

    @Test
    @DisplayName("""
    Where does this point to?
    """)
    void thisInsideAnonymousClass() {
        System.out.println("From inside test" +this.getClass().getName());
        //Arrange
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("From inside anonymous class" +this.getClass().getName());
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("From inside anonymous class" +this.getClass().getName());
            }
        };
        runnable1.run();
        runnable2.run();
    }

    @Test
    @DisplayName("""
    What is this inside a lambda?
    """)
    void thisInsideLambda(){
        System.out.println("From inside test" +this.getClass().getName());
        //Arrange
        Runnable runnable1 = () ->{
                System.out.println("From inside anonymous class" +this.getClass().getName());
            };
        Runnable runnable2 = ()-> {
                System.out.println("From inside anonymous class" +this.getClass().getName());
        };
        runnable1.run();
        runnable2.run();
    }
}
