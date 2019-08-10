package ru.ncedu.lebedev.testingCI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest {

    private static Object helloWorld;
    private static Method method = null;

    @BeforeAll
    public static void setBeforeClass() {
        try {
            Class<?> clazz = Class.forName("ru.ncedu.lebedev.testingCI.Main");
            method = clazz.getMethod("printHelloWorld");
            helloWorld = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            fail("Class was not found!");
        } catch (NoSuchMethodException e) {
            fail("Method was not found!");
        } catch (IllegalAccessException e) {
            fail("Illegal access!");
        } catch (InstantiationException e) {
            fail("Instantiation exception!");
        }
    }

    @Test
    public void test() {
        try {
            String result = (String) method.invoke(helloWorld);
            assertEquals("Hello world!", result);
        } catch (Exception e) {
            fail("Printing hello world error!");
        }
    }
}
