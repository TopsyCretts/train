package jUnit.calculatorEx;

import jUnit.calculatorEx.CalculatorEx;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorExTest {

    @org.junit.jupiter.api.Test
    void add() {
        CalculatorEx calculatorEx = new CalculatorEx();
        int result = calculatorEx.add(10,50);
        assertEquals(60,result, "Smth wrong in add method");
    }
}