package com.infosupport.demo02executearound;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

import static org.assertj.core.api.Assertions.assertThat;

public class ExecuteAroundTests {
    
    @Test
    @DisplayName("""
    Execute Around Pattern
    """)
    void executeAroundDemo(){
        //Arrange
        try(
            final var fileReader = new FileReader("maxverstappen.txt");
            final var bufferedReader = new BufferedReader(fileReader);){


        }catch (Exception e){
            //log
            //throw exception after enriching it with context
        }

    }
}
