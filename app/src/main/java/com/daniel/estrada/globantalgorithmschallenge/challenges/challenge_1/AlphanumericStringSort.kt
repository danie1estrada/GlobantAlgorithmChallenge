package com.daniel.estrada.globantalgorithmschallenge.challenges.challenge_1

import kotlin.system.measureTimeMillis

/*
Tuesday, Feb 27th 2024
Daily Algorithm Challenge
Title: Alphanumeric String Sort
Description:
Taking a string as input sort the string characters with the following rules:
Numbers go after Letters
Uppercase letters go after Lowercase
Odd numbers go before Even numbers
Any character that is not a letter or number should go after the letters and numbers
i.e.: abeCD4®
*/

class AlphanumericStringSort {

    fun sort(input: String): String {
        val resultBuilder = StringBuilder(input)

        quicksort(resultBuilder, 0, resultBuilder.lastIndex)

        return resultBuilder.toString()
    }

    private fun quicksort(builder: StringBuilder, low: Int, high: Int) {
        var left = low
        var right = high
        val pivot = builder[low].weight

        while (left <= right) {
            while (pivot > builder[left].weight) left++
            while (pivot < builder[right].weight) right--

            if (left <= right) {
                builder.swap(left, right)
                left++
                right--
            }
        }

        if (low < right) quicksort(builder, low, right)
        if (left < high) quicksort(builder, left, high)
    }

    private fun StringBuilder.swap(pos1: Int, pos2: Int) {
        val aux = get(pos1)
        setCharAt(pos1, get(pos2))
        setCharAt(pos2, aux)
    }

    // 33 - 47 -> Special characters
    // 48 - 57 -> Numbers
    // 58 - 64 -> Special characters
    // 65 - 90 -> Upper case letters
    // 91 - 96 -> Special characters
    // 97 - 122 -> Lower case letters
    // 123...   -> Special characters
    private val Char.weight: Int
        get() = when {
            this.isLowerCase() -> this.code - 97
            this.isUpperCase() -> this.code - 39
            // Arithmetic numeric weight assignation (slower)
            // char.isDigit() -> char.code + 4 + char.digitToInt().let {
            //  if (it.isOdd()) { 5 - (it / 2) } else { -((it / 2) + 1) }
            // }
            this.isDigit() -> this.code + 4 + when (this.digitToInt()) {
                0 -> 5
                1 -> -1
                2 -> 4
                3 -> -2
                4 -> 3
                5 -> -3
                6 -> 2
                7 -> -4
                8 -> 1
                else -> -5
            }
            else -> this.code + 62
        }
}

