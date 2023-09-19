package com.example.testT1rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TestT1restApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testCalculateFrequency() {
		Analyze controller = new Analyze();
		String inputString = "aaaaabccc";

		Map<String, Integer> result = controller.analyze(inputString);

		assertEquals(5, result.get("a"));
		assertEquals(3, result.get("c"));
		assertEquals(1, result.get("b"));

	}

	@Test
	public void testCalculateFrequencyEmptyString() {
		Analyze controller = new Analyze();
		String inputString = "";

		Map<String, Integer> result = controller.analyze(inputString);

		assertTrue(result.isEmpty());
	}

	@Test
	public void testCalculateFrequencyUnicode() {
		Analyze controller = new Analyze();
		String inputString = "������!";

		Map<String, Integer> result = controller.analyze(inputString);

		assertEquals(1, result.get("�"));
		assertEquals(1, result.get("�"));
		assertEquals(1, result.get("�"));
		assertEquals(1, result.get("�"));
		assertEquals(1, result.get("�"));
		assertEquals(1, result.get("�"));
		assertEquals(1, result.get("!"));
		// � ��� ����� ��� ������ ��������
	}
}
