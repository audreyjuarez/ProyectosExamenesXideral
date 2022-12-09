package com.xideral.math.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.xideral.math.Suma;

public class TestSuma {
	Suma suma;
	
	@BeforeEach
	void incializar() {
		suma= new Suma();
	}


	
	@Test
	@DisplayName("Sumatoria de números positivos")
	void testSumaEnteros() {
		Suma suma = new Suma();
		assertEquals(10, suma.sumaEnteros(5, 5) );
	}
	
	
	@Test
	@DisplayName("Sumatoria de números negativos")
	void testSumaUnNegativo() {
		Suma suma = new Suma();
		assertEquals(8, suma.sumaEnteros(-5, 8) );
	}
	
	@Test
	@Disabled
	@DisplayName("Sumatoria de números de punto flotante")
	void testSumaFlotante() {
		Suma suma = new Suma();
		assertEquals(10.5,(suma.sumaEnteros(5.3F, 5.2F)), 0.01 );
	}
	
	@Test
	@DisplayName("Verifica si la sumatoria es positiva")
	void isPositive() {
		Suma suma = new Suma();
		assertTrue(suma.sumaEnteros(3, 4)>0);
	}
}
