package org.example;

import lesson4.Triangle;
import lesson4.MyException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {

    @Test
    void test() {
        Triangle exampleTriangle = new Triangle();
        Assertions.assertEquals(30,exampleTriangle.someMethod(10,20,5));
        Assertions.assertThrows(MyException.class,()-> exampleTriangle.someMethod(-10,20,5));
    }

    @ParameterizedTest
    @CsvSource({ "10,20,30","100, 200,300","1,2,3"})
    void testWithCsvSource(int a, int b, int c, int result) throws MyException {
        Triangle testClass = new Triangle();
        Assertions.assertEquals(result, testClass.someMethod(a,b,c));

    }

    @ParameterizedTest
    @CsvSource(value = {"-10,20,0", "-100, 200,0,1", "1,-2,-1000"})
    void testWithCsvSourceN(int a, int b, int c) throws MyException {
        Triangle exampleClass = new Triangle();
        Assertions.assertThrows(MyException.class,()-> exampleClass.someMethod(a,b,c));

    }
}