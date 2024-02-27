package com.daniel.estrada.globantalgorithmschallenge.challenges.challenge_1

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class AlphanumericStringSortTest {

    private lateinit var alphanumericStringSort: AlphanumericStringSort

    @Before
    fun setup() {
        alphanumericStringSort = AlphanumericStringSort()
    }

    @Test
    fun `Basic test`() {
        val input = "®45DCeba"
        val expectedResult = "abeCD54®"
        val result = alphanumericStringSort.sort(input)
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Sort a camel case word, lower case letters must go first`() {
        val input = "camelCase"
        val expectedResult = "aaceelmsC"
        val result = alphanumericStringSort.sort(input)
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Sort string with upper and lower case letters, numbers and special characters`() {
        val input = "#4321BasiC"
        val expectedResult = "aisBC1324#"
        val result = alphanumericStringSort.sort(input)
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Sort ascending numbers, odd numbers must be sorted first`() {
        val input = "0123456789"
        val expectedResult = "1357902468"
        val result = alphanumericStringSort.sort(input)
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Sort descending numbers, odd numbers must be sorted first`() {
        val input = "9876543210"
        val expectedResult = "1357902468"
        val result = alphanumericStringSort.sort(input)
        assertEquals(expectedResult, result)
    }
}