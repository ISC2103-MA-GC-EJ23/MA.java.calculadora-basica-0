/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class AppTest {
    Calculadora c;
    @BeforeEach void setup() {
        c = new Calculadora();
    }
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test void sumar() {
        assertEquals(5, c.sumar(2, 3));
    }
}