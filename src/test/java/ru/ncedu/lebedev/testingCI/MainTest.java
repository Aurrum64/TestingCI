package ru.ncedu.lebedev.testingCI;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class MainTest {

    private static Object helloWorld;
    private static Method method = null;

    @BeforeClass
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
            assertEquals("This is not hello world!", "Hello world!", result);
        } catch (Exception e) {
            fail("Printing hello world error!");
        }
    }

}
