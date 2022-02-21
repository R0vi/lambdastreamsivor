package com.infosupport.lambdastreamsivor.demo01passingcode;

import com.infosupport.lambdastreamsivor.demo01passingcode.domain.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class PassingCodeCarsTests {

    List<Car> carList = List.of(
        new Car("VW", 2000, "Green"),
        new Car("Hyundai", 1300, "White"),
        new Car("Honda", 1500, "Orange"),
        new Car("Audi", 2200, "Black"),
        new Car("VW", 1700, "Red"),
        new Car("BMW", 2600, "Blue"),
        new Car("VW", 1400, "Red"),
        new Car("Ferrari", 900, "Red"),
        new Car("Mercedes", 2550, "Grey")
    );

    @Test
    void sortVWCars() {
        var result = getCars((Car car) -> "VW".equalsIgnoreCase(car.getBrand()));
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void sortRedVWCarsAbove1500Grams() {
        var result = getCars((Car car) -> "VW".equalsIgnoreCase(car.getBrand())
                && "Red".equalsIgnoreCase(car.getColor())
                && car.getWeight() > 1500);
        assertThat(result.size()).isEqualTo(1);
    }

    List<Car> getCars(Predicate<Car> predicate) {
        List<Car> resultList = new ArrayList<>();
        for(Car car : carList) {
            if(predicate.test(car))
                resultList.add(car);
        }
        return resultList;
    }
}


