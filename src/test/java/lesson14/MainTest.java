package lesson14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @BeforeAll
    static void init() {
        System.out.println("ГЛАВНОЕ НАЧАЛО!");
    }

    @AfterAll
    static void end() {
        System.out.println("ГЛАВНОЕ ОКОНЧАНИЕ!");
    }

    @BeforeEach
    void startUp() {
        System.out.println("Начало теста");
        main = new Main();
    }

    @AfterEach
    void shutDown() {
        System.out.println("Конец теста");
    }

    @DisplayName("Test of method 1")
    @ParameterizedTest
    @MethodSource("data1")
    void testParam1(Integer[] partOfArray, Integer[] array) {
        Assertions.assertArrayEquals(partOfArray, main.method1(array));
    }

    static Stream<Arguments> data1(){
        return Stream.of(
                Arguments.arguments(new Integer[]{8}, new Integer[]{1, 1, 1, 4, 4, 8}),
                Arguments.arguments(new Integer[]{}, new Integer[]{1, 1, 1, 4}),
                Arguments.arguments(new Integer[]{1, 1, 1}, new Integer[]{4, 1, 1, 1})
        );
    }

    @DisplayName("TestException of method 1")
    @Test
    void testException() {
        Integer[] arr = new Integer[]{1, 1, 1, 3};
        Assertions.assertThrows(RuntimeException.class, () -> Assertions.assertEquals(new Integer[]{}, main.method1(arr)));
    }

    @DisplayName("Test of method 2")
    @ParameterizedTest
    @MethodSource("data2")
    void testParam(boolean expectedBool, Integer[] array) {
        Assertions.assertEquals(expectedBool, main.method2(array));
    }

    static Stream<Arguments> data2(){
        return Stream.of(
                Arguments.arguments(false, new Integer[]{1, 1, 1, 4, 4, 8}),
                Arguments.arguments(true, new Integer[]{1, 1, 1, 4, 4, 1}),
                Arguments.arguments(false, new Integer[]{1, 1, 1}),
                Arguments.arguments(false, new Integer[]{2, 3, 5, 7})
        );
    }

}