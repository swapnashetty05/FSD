package com.wellsfargo.fsd.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.wellsfargo.fsd.exception.MyException;
import com.wellsfargo.fsd.service.NumericOperations;

public class NumericOperationsTest {

	NumericOperations nopt;

	@BeforeEach
	void init() {
		nopt = new NumericOperations();
	}

	@AfterEach
	void clean() {
		nopt = null;
	}

	@Test
	@DisplayName("isOdd method is being tested")
	@Disabled
	void isOddTest() {

		assertTrue(nopt.isOdd(9), "9 is expected to be odd but failed");
		assertFalse(nopt.isOdd(18), "8 is expected to be even but failed");

		assertFalse(nopt.isOdd(0), "0 is expected to be even but failed");

		assertTrue(nopt.isOdd(-9), "-9 is expected to be odd but failed");
		assertFalse(nopt.isOdd(-18), "-8 is expected to be even but failed");
	}

	@ParameterizedTest
	@ValueSource(ints = { -9, 9 })
	@DisplayName("isOdd method is being tested for Odd by passing params")
	void isOddTestParam(int testData) {

		assertTrue(nopt.isOdd(testData), testData + " is expected to be odd but failed");
	}

	@ParameterizedTest
	@ValueSource(ints = { -8, 0, 8 })
	@DisplayName("testing isOdd method using params for EVENS")
	void isOddTestEvenParam(int testData) {

		assertFalse(nopt.isOdd(testData), testData + " is expected to be even but failed");
	}
	
	@ParameterizedTest
	@CsvSource(value = { "-9,true", "-9,true", "-8,false", "0,false", "8,false" })
	void isOddTestExpected(int testData , boolean expected) {
		assertEquals(expected, nopt.isOdd(testData));
	}
	
	/*@ParameterizedTest
	@CsvSource(value = { "-9,-9,-9", "-9,0,0", "-9,9,9", "9,-9,9", "0,9,9", "9,0,9" })
	void isOddTestExpected(int testData , boolean expected) {
		assertEquals(expected, nopt.isOdd(testData));
	}*/
	
	
	@ParameterizedTest
	@CsvSource({"1,1,1","8,2,4","7,2,3","0,4,0"})
	void qutTest(int testData, int testData2, int expected) {
		
		try {
			assertEquals(expected, nopt.quot(testData, testData2));
		} catch (MyException e) {
			fail("Exception not expected");
		}
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = { "/qutTestData.csv" })
	void qutTestFile(int testData, int testData2, int expected) {
		
		try {
			assertEquals(expected, nopt.quot(testData, testData2));
		} catch (MyException e) {
			fail("Exception not expected");
		}
		
	}
	
	// here we are testing whether the test case throws myexception, not arithmetic exception
	@Test
	void qutTestForExeception() {
		assertThrows(MyException.class, () -> { nopt.quot(100, 0);});
	}
	
	@ParameterizedTest
	@MethodSource
	void qutTestFunct(int testData, int testData2, int expected) {
		
		try {
			assertEquals(expected, nopt.quot(testData, testData2));
		} catch (MyException e) {
			fail("Exception not expected");
		}
		
	}
	
	static Stream<Arguments> qutTestFunct() {
		return Stream.of(
				
				Arguments.of(1,1,1),
				Arguments.of(8,2,4),
				Arguments.of(-8,2,-4),
				Arguments.of(0,2,-4)
				
				
		);
	}
	
	@ParameterizedTest
	@MethodSource	
	void getFactorsTest(int number, List<Integer> expected) {
		List<Integer> actual = nopt.getFactors(number);
		assertIterableEquals(expected, actual);
	}

	static Stream<Arguments> getFactorsTest() {
		return Stream.of(
				Arguments.of(25, Arrays.asList(new Integer[] { 1, 5, 25 })),
				Arguments.of(0, Arrays.asList(new Integer[] { 1, 0 })),
				Arguments.of(11, Arrays.asList(new Integer[] { 1, 11 }))
		);
	}
	

}
