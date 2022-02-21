package com.infosupport.lambdastreamsivor.demo01passingcode;

import com.infosupport.lambdastreamsivor.demo01passingcode.domain.Apple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class PassingCodeTests {

    List<Apple> appleStock = List.of(new Apple("RED", 250),
            new Apple("GREEN", 150),
            new Apple("RED", 200),
            new Apple("RED", 350));
    @Test
    @DisplayName("""
    We have a stock of apples and we have sort the apples on the color RED
    """)
    void sortRedApples(){
        //Arrange
        //Act

        List<Apple> resultList = getApplesBy(new RedCondition());
        //Assert
        assertThat(resultList.size()).isEqualTo(3);
        //Cleanup
    }



    @Test
    @DisplayName("""
    Sort all green apples
    """)
    void sortGreenApples(){
        //Arrange

        //Act
        List<Apple> resultList = getApplesBy((Apple apple) -> "Green".equalsIgnoreCase(apple.getColor()));

        //Assert
        assertThat(resultList.size()).isEqualTo(1);
        //Cleanup
    }

    @Test
    @DisplayName("""
    get all apples that are heavier then 200 grams
    """)
    void getApplesAbove200Grams(){
        //Arrange
        var resultList = getApplesBy(new Above200GramsPredicate());

        assertThat(resultList.size()).isEqualTo(2);
        //Cleanup
    }

    @Test
    @DisplayName("""
    get apples above 200 grams and with color RED
    """)
    void getApplesByWeightAndColor(){
        //Arrange
        var resultList = getApplesBy(new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 200 && "RED".equalsIgnoreCase(apple.getColor());
            }
        });
        //Act

        //Assert
        assertThat(resultList.size()).isEqualTo(2);
        //Cleanup
    }



    @Test
    @DisplayName("""
    get apples below 200 grams and with color RED
    """)
    void getApplesBelow200GramsAndColor(){
        //Arrange
        Predicate<Apple> condition = (Apple apple) -> {
            return apple.getWeight() <= 200 && "RED".equalsIgnoreCase(apple.getColor());
        };
        var resultList = getApplesBy(condition );
        //Act

        //Assert
        assertThat(resultList.size()).isEqualTo(1);
        //Cleanup
    }

    private List<Apple> getApplesBy(Predicate<Apple> condition) {
        List<Apple> resultList = new ArrayList<>();
        for (Apple apple : appleStock) {
            if (condition.test(apple)) {
                resultList.add(apple);
            }
        }
        return resultList;
    }


    class RedCondition implements Predicate<Apple> {

        @Override
        public boolean test(Apple apple) {
            return "RED".equalsIgnoreCase(apple.getColor());
        }
    }

    class GreenCondition implements Predicate<Apple> {

        @Override
        public boolean test(Apple apple) {
            return "GREEN".equalsIgnoreCase(apple.getColor());
        }
    }

    class Above200GramsPredicate implements Predicate<Apple> {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 200;
        }
    }
}
