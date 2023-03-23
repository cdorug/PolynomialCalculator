package ro.tu.pt2022_30423_chete_doru_assignment_1.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {
    Translator translator = new Translator();
    @Test
    void stringToPolynomial() throws Exception {
        Polynomial polynomial = new Polynomial(translator.stringToPolynomial("3x^2+6x^1+x^2"));
        assertEquals("3x^2+6x^1+x^2", polynomial.translateIntoString());
    }
}