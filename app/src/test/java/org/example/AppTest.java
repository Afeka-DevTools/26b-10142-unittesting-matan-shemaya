package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class AppTest {

    // Verifies that the method returns the sum of two positive integers.
    @Test
    void add_twoPositiveNumbers_returnsSum() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = App.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    // Verifies that the method handles a positive value combined with a negative value.
    @Test
    void add_positiveAndNegativeNumber_returnsSignedSum() {
        // Arrange
        int a = 5;
        int b = -4;

        // Act
        int result = App.add(a, b);

        // Assert
        assertEquals(1, result);
    }

    // Verifies that the method returns the sum of two negative integers.
    @Test
    void add_twoNegativeNumbers_returnsSum() {
        // Arrange
        int a = -3;
        int b = -5;

        // Act
        int result = App.add(a, b);

        // Assert
        assertEquals(-8, result);
    }

    // Verifies that adding zero leaves the other operand unchanged.
    @Test
    void add_zeroInvolved_returnsOtherOperand() {
        // Arrange
        int a = 0;
        int b = 7;

        // Act
        int result = App.add(a, b);

        // Assert
        assertEquals(7, result);
    }

    // Verifies that integer overflow wraps around in Java for the add method.
    @Test
    void add_integerOverflow_wrapsAround() {
        // Arrange
        int a = Integer.MAX_VALUE;
        int b = 1;

        // Act
        int result = App.add(a, b);

        // Assert
        assertEquals(Integer.MIN_VALUE, result);
    }

    // Verifies that numbers below 2 are not considered prime.
    @Test
    void isPrime_numbersBelowTwo_returnFalse() {
        // Arrange
        int negative = -2;
        int zero = 0;
        int one = 1;

        // Act & Assert
        assertFalse(App.isPrime(negative));
        assertFalse(App.isPrime(zero));
        assertFalse(App.isPrime(one));
    }

    // Verifies that the smallest prime number is recognized as prime.
    @Test
    void isPrime_two_returnsTrue() {
        // Arrange
        int input = 2;

        // Act
        boolean result = App.isPrime(input);

        // Assert
        assertTrue(result);
    }

    // Verifies that several known prime numbers are accepted.
    @Test
    void isPrime_primeNumbers_returnTrue() {
        // Arrange
        int first = 3;
        int second = 17;
        int third = 97;

        // Act & Assert
        assertTrue(App.isPrime(first));
        assertTrue(App.isPrime(second));
        assertTrue(App.isPrime(third));
    }

    // Verifies that several composite numbers are rejected.
    @Test
    void isPrime_compositeNumbers_returnFalse() {
        // Arrange
        int first = 4;
        int second = 12;
        int third = 18;

        // Act & Assert
        assertFalse(App.isPrime(first));
        assertFalse(App.isPrime(second));
        assertFalse(App.isPrime(third));
    }

    // Verifies that perfect squares are not treated as prime.
    @Test
    void isPrime_perfectSquare_returnsFalse() {
        // Arrange
        int input = 49;

        // Act
        boolean result = App.isPrime(input);

        // Assert
        assertFalse(result);
    }

    // Verifies that a relatively large prime number is recognized as prime.
    @Test
    void isPrime_largePrimeNumber_returnsTrue() {
        // Arrange
        int input = 1_000_000_007;

        // Act
        boolean result = App.isPrime(input);

        // Assert
        assertTrue(result);
    }

    // Verifies that the method reverses a normal string.
    @Test
    void reverse_normalString_reversesCharacters() {
        // Arrange
        String input = "world";

        // Act
        String result = App.reverse(input);

        // Assert
        assertEquals("dlrow", result);
    }

    // Verifies that an empty string remains empty after reversal.
    @Test
    void reverse_emptyString_returnsEmptyString() {
        // Arrange
        String input = "";

        // Act
        String result = App.reverse(input);

        // Assert
        assertEquals("", result);
    }

    // Verifies that a single-character string remains unchanged.
    @Test
    void reverse_singleCharacterString_returnsSameCharacter() {
        // Arrange
        String input = "a";

        // Act
        String result = App.reverse(input);

        // Assert
        assertEquals("a", result);
    }

    // Verifies that spaces are reversed along with the other characters.
    @Test
    void reverse_stringWithSpaces_reversesSpaces() {
        // Arrange
        String input = "hello world";

        // Act
        String result = App.reverse(input);

        // Assert
        assertEquals("dlrow olleh", result);
    }

    // Verifies that numbers and symbols are reversed as ordinary characters.
    @Test
    void reverse_stringWithNumbersAndSymbols_reversesCharacters() {
        // Arrange
        String input = "abc123!";

        // Act
        String result = App.reverse(input);

        // Assert
        assertEquals("!321cba", result);
    }

    // Verifies that the current implementation throws a null-pointer exception for a null input.
    @Test
    void reverse_nullArgument_throwsNullPointerException() {
        // Arrange
        String input = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> App.reverse(input));
    }

    // Verifies that factorial of zero returns one.
    @Test
    void factorial_zero_returnsOne() {
        // Arrange
        int input = 0;

        // Act
        int result = App.factorial(input);

        // Assert
        assertEquals(1, result);
    }

    // Verifies that factorial of one returns one.
    @Test
    void factorial_one_returnsOne() {
        // Arrange
        int input = 1;

        // Act
        int result = App.factorial(input);

        // Assert
        assertEquals(1, result);
    }

    // Verifies that factorial of a normal value returns its product.
    @Test
    void factorial_normalValue_returnsExpectedProduct() {
        // Arrange
        int input = 5;

        // Act
        int result = App.factorial(input);

        // Assert
        assertEquals(120, result);
    }

    // Verifies that a negative input throws an IllegalArgumentException.
    @Test
    void factorial_negativeValue_throwsIllegalArgumentException() {
        // Arrange
        int input = -1;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> App.factorial(input));
    }

    // Verifies that factorial overflows for a large value when stored as an int.
    @Test
    void factorial_largeValue_overflows() {
        // Arrange
        int input = 13;

        // Act
        int result = App.factorial(input);

        // Assert
        assertEquals(1932053504, result);
    }

    // Verifies that a simple palindrome is recognized as such.
    @Test
    void isPalindrome_simplePalindrome_returnsTrue() {
        // Arrange
        String input = "racecar";

        // Act
        boolean result = App.isPalindrome(input);

        // Assert
        assertTrue(result);
    }

    // Verifies that a non-palindrome returns false.
    @Test
    void isPalindrome_nonPalindrome_returnsFalse() {
        // Arrange
        String input = "hello";

        // Act
        boolean result = App.isPalindrome(input);

        // Assert
        assertFalse(result);
    }

    // Verifies that mixed-case input is normalized before evaluation.
    @Test
    void isPalindrome_mixedCase_returnsTrue() {
        // Arrange
        String input = "Aa";

        // Act
        boolean result = App.isPalindrome(input);

        // Assert
        assertTrue(result);
    }

    // Verifies that a phrase with spaces and punctuation is treated as a palindrome.
    @Test
    void isPalindrome_phraseWithSpacesAndPunctuation_returnsTrue() {
        // Arrange
        String input = "A man, a plan, a canal: Panama";

        // Act
        boolean result = App.isPalindrome(input);

        // Assert
        assertTrue(result);
    }

    // Verifies that an empty string is considered a palindrome.
    @Test
    void isPalindrome_emptyString_returnsTrue() {
        // Arrange
        String input = "";

        // Act
        boolean result = App.isPalindrome(input);

        // Assert
        assertTrue(result);
    }

    // Verifies that punctuation-only input is treated as a palindrome.
    @Test
    void isPalindrome_punctuationOnly_returnsTrue() {
        // Arrange
        String input = "!!!";

        // Act
        boolean result = App.isPalindrome(input);

        // Assert
        assertTrue(result);
    }

    // Verifies that the current implementation throws a null-pointer exception for a null input.
    @Test
    void isPalindrome_nullArgument_throwsNullPointerException() {
        // Arrange
        String input = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> App.isPalindrome(input));
    }

    // Verifies that the method returns the Fibonacci sequence up to the requested limit.
    @Test
    void fibonacciUpTo_zeroLimit_returnsSingleZero() {
        // Arrange
        int limit = 0;

        // Act
        List<Integer> result = App.fibonacciUpTo(limit);

        // Assert
        assertIterableEquals(List.of(0), result);
    }

    // Verifies that the method includes the initial one for a limit of one.
    @Test
    void fibonacciUpTo_oneLimit_returnsZeroAndOneAndOne() {
        // Arrange
        int limit = 1;

        // Act
        List<Integer> result = App.fibonacciUpTo(limit);

        // Assert
        assertIterableEquals(List.of(0, 1, 1), result);
    }

    // Verifies that a normal limit returns the expected Fibonacci sequence.
    @Test
    void fibonacciUpTo_normalLimit_returnsExpectedSequence() {
        // Arrange
        int limit = 10;

        // Act
        List<Integer> result = App.fibonacciUpTo(limit);

        // Assert
        assertIterableEquals(List.of(0, 1, 1, 2, 3, 5, 8), result);
    }

    // Verifies that a limit that is itself a Fibonacci number is included in the result.
    @Test
    void fibonacciUpTo_fibonacciLimit_includesLimitValue() {
        // Arrange
        int limit = 8;

        // Act
        List<Integer> result = App.fibonacciUpTo(limit);

        // Assert
        assertIterableEquals(List.of(0, 1, 1, 2, 3, 5, 8), result);
    }

    // Verifies that a negative limit throws an IllegalArgumentException.
    @Test
    void fibonacciUpTo_negativeLimit_throwsIllegalArgumentException() {
        // Arrange
        int limit = -1;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> App.fibonacciUpTo(limit));
    }

    // Verifies that every returned Fibonacci number is not greater than the requested limit.
    @Test
    void fibonacciUpTo_limitValue_keepsAllValuesWithinLimit() {
        // Arrange
        int limit = 10;

        // Act
        List<Integer> result = App.fibonacciUpTo(limit);

        // Assert
        for (int value : result) {
            assertTrue(value <= limit);
        }
    }

    // Verifies that the method counts repeated characters in a normal word.
    @Test
    void charFrequency_normalWord_countsCharacters() {
        // Arrange
        String input = "banana";

        // Act
        Map<Character, Integer> result = App.charFrequency(input);

        // Assert
        assertEquals(3, result.get('a'));
        assertEquals(2, result.get('n'));
        assertEquals(1, result.get('b'));
    }

    // Verifies that an empty string produces an empty frequency map.
    @Test
    void charFrequency_emptyString_returnsEmptyMap() {
        // Arrange
        String input = "";

        // Act
        Map<Character, Integer> result = App.charFrequency(input);

        // Assert
        assertTrue(result.isEmpty());
    }

    // Verifies that spaces are counted as characters in the frequency map.
    @Test
    void charFrequency_stringWithSpaces_countsSpaces() {
        // Arrange
        String input = "a b a";

        // Act
        Map<Character, Integer> result = App.charFrequency(input);

        // Assert
        assertEquals(2, result.get('a'));
        assertEquals(1, result.get('b'));
        assertEquals(2, result.get(' '));
    }

    // Verifies that uppercase and lowercase letters are counted separately.
    @Test
    void charFrequency_mixedCase_countsUpperAndLowerSeparately() {
        // Arrange
        String input = "AaAa";

        // Act
        Map<Character, Integer> result = App.charFrequency(input);

        // Assert
        assertEquals(2, result.get('A'));
        assertEquals(2, result.get('a'));
    }

    // Verifies that the current implementation throws a null-pointer exception for a null input.
    @Test
    void charFrequency_nullArgument_throwsNullPointerException() {
        // Arrange
        String input = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> App.charFrequency(input));
    }

    // Verifies that basic anagrams are recognized as anagrams.
    @Test
    void isAnagram_basicAnagrams_returnsTrue() {
        // Arrange
        String first = "listen";
        String second = "silent";

        // Act
        boolean result = App.isAnagram(first, second);

        // Assert
        assertTrue(result);
    }

    // Verifies that differing letter casing is ignored.
    @Test
    void isAnagram_differentLetterCasing_returnsTrue() {
        // Arrange
        String first = "Astronomer";
        String second = "Moonstarer";

        // Act
        boolean result = App.isAnagram(first, second);

        // Assert
        assertTrue(result);
    }

    // Verifies that spaces are ignored when checking for anagrams.
    @Test
    void isAnagram_stringsWithSpaces_returnsTrue() {
        // Arrange
        String first = "a gentleman";
        String second = "elegant man";

        // Act
        boolean result = App.isAnagram(first, second);

        // Assert
        assertTrue(result);
    }

    // Verifies that non-anagrams return false.
    @Test
    void isAnagram_nonAnagrams_returnsFalse() {
        // Arrange
        String first = "hello";
        String second = "world";

        // Act
        boolean result = App.isAnagram(first, second);

        // Assert
        assertFalse(result);
    }

    // Verifies that empty strings are considered anagrams.
    @Test
    void isAnagram_emptyStrings_returnsTrue() {
        // Arrange
        String first = "";
        String second = "";

        // Act
        boolean result = App.isAnagram(first, second);

        // Assert
        assertTrue(result);
    }

    // Verifies that repeated letters still produce a valid anagram result.
    @Test
    void isAnagram_repeatedLetters_returnsTrue() {
        // Arrange
        String first = "letter";
        String second = "tretel";

        // Act
        boolean result = App.isAnagram(first, second);

        // Assert
        assertTrue(result);
    }

    // Verifies that the current implementation throws a null-pointer exception for either null argument.
    @Test
    void isAnagram_nullArguments_throwsNullPointerException() {
        // Arrange
        String first = null;
        String second = "abc";

        // Act & Assert
        assertThrows(NullPointerException.class, () -> App.isAnagram(first, second));
        assertThrows(NullPointerException.class, () -> App.isAnagram("abc", null));
    }

    // Verifies that the method calculates the average of several positive integers.
    @Test
    void average_positiveIntegers_returnsAverage() {
        // Arrange
        int[] input = {1, 2, 3, 4, 5};

        // Act
        double result = App.average(input);

        // Assert
        assertEquals(3.0, result, 0.0001);
    }

    // Verifies that the method calculates the average of negative integers.
    @Test
    void average_negativeIntegers_returnsAverage() {
        // Arrange
        int[] input = {-1, -2, -3};

        // Act
        double result = App.average(input);

        // Assert
        assertEquals(-2.0, result, 0.0001);
    }

    // Verifies that the method averages a mix of positive and negative integers.
    @Test
    void average_mixedIntegers_returnsAverage() {
        // Arrange
        int[] input = {-2, 5};

        // Act
        double result = App.average(input);

        // Assert
        assertEquals(1.5, result, 0.0001);
    }

    // Verifies that a single-element array returns that element as the average.
    @Test
    void average_singleElementArray_returnsElement() {
        // Arrange
        int[] input = {7};

        // Act
        double result = App.average(input);

        // Assert
        assertEquals(7.0, result, 0.0001);
    }

    // Verifies that non-integer averages are returned as fractional values.
    @Test
    void average_nonIntegerAverage_returnsFraction() {
        // Arrange
        int[] input = {1, 2, 3, 4};

        // Act
        double result = App.average(input);

        // Assert
        assertEquals(2.5, result, 0.0001);
    }

    // Verifies that an empty array throws an IllegalArgumentException.
    @Test
    void average_emptyArray_throwsIllegalArgumentException() {
        // Arrange
        int[] input = {};

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> App.average(input));
    }

    // Verifies that the current implementation throws a null-pointer exception for a null array.
    @Test
    void average_nullArray_throwsNullPointerException() {
        // Arrange
        int[] input = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> App.average(input));
    }

    // Verifies that the method returns only the even numbers from a mixed list.
    @Test
    void filterEvens_mixedList_returnsOnlyEvenNumbers() {
        // Arrange
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

        // Act
        List<Integer> result = App.filterEvens(input);

        // Assert
        assertIterableEquals(List.of(2, 4, 6), result);
    }

    // Verifies that a list containing only odd numbers returns an empty list.
    @Test
    void filterEvens_onlyOddNumbers_returnsEmptyList() {
        // Arrange
        List<Integer> input = List.of(1, 3, 5);

        // Act
        List<Integer> result = App.filterEvens(input);

        // Assert
        assertIterableEquals(List.of(), result);
    }

    // Verifies that a list containing only even numbers returns the same values.
    @Test
    void filterEvens_onlyEvenNumbers_returnsSameValues() {
        // Arrange
        List<Integer> input = List.of(2, 4, 6);

        // Act
        List<Integer> result = App.filterEvens(input);

        // Assert
        assertIterableEquals(List.of(2, 4, 6), result);
    }

    // Verifies that an empty list returns an empty result.
    @Test
    void filterEvens_emptyList_returnsEmptyList() {
        // Arrange
        List<Integer> input = List.of();

        // Act
        List<Integer> result = App.filterEvens(input);

        // Assert
        assertTrue(result.isEmpty());
    }

    // Verifies that negative even numbers are preserved.
    @Test
    void filterEvens_negativeEvenNumbers_returnsNegativeValues() {
        // Arrange
        List<Integer> input = List.of(-3, -4, -2, 5);

        // Act
        List<Integer> result = App.filterEvens(input);

        // Assert
        assertIterableEquals(List.of(-4, -2), result);
    }

    // Verifies that duplicate even values are preserved in the result.
    @Test
    void filterEvens_duplicateValues_preservesDuplicates() {
        // Arrange
        List<Integer> input = List.of(1, 2, 2, 3, 4);

        // Act
        List<Integer> result = App.filterEvens(input);

        // Assert
        assertIterableEquals(List.of(2, 2, 4), result);
    }

    // Verifies that the original input list remains unchanged.
    @Test
    void filterEvens_inputList_notModified() {
        // Arrange
        List<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4));

        // Act
        List<Integer> result = App.filterEvens(input);

        // Assert
        assertIterableEquals(List.of(2, 4), result);
        assertEquals(List.of(1, 2, 3, 4), input);
    }

    // Verifies that a null list currently throws a null-pointer exception.
    @Test
    void filterEvens_nullList_throwsNullPointerException() {
        // Arrange
        List<Integer> input = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> App.filterEvens(input));
    }

    // Verifies that a list containing a null element causes the current implementation to throw.
    @Test
    void filterEvens_listWithNullElement_throwsNullPointerException() {
        // Arrange
        List<Integer> input = new ArrayList<>(List.of(1, 2, 3));
        input.add(null);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> App.filterEvens(input));
    }

    // Verifies that the method returns the most common word in a clear sentence.
    @Test
    void mostCommonWord_normalSentence_returnsMostCommonWord() {
        // Arrange
        String input = "apple banana banana cherry";

        // Act
        String result = App.mostCommonWord(input);

        // Assert
        assertEquals("banana", result);
    }

    // Verifies that word counting is case-insensitive.
    @Test
    void mostCommonWord_caseInsensitiveWordCounting_returnsLowercaseWord() {
        // Arrange
        String input = "Apple banana apple";

        // Act
        String result = App.mostCommonWord(input);

        // Assert
        assertEquals("apple", result);
    }

    // Verifies that punctuation is ignored when counting words.
    @Test
    void mostCommonWord_textWithPunctuation_returnsMostCommonWord() {
        // Arrange
        String input = "Hello, hello! world? hello.";

        // Act
        String result = App.mostCommonWord(input);

        // Assert
        assertEquals("hello", result);
    }

    // Verifies that a single-word input returns that word.
    @Test
    void mostCommonWord_singleWordInput_returnsWord() {
        // Arrange
        String input = "hello";

        // Act
        String result = App.mostCommonWord(input);

        // Assert
        assertEquals("hello", result);
    }

    // Verifies that the returned word is lowercased.
    @Test
    void mostCommonWord_uppercaseInput_returnsLowercaseWord() {
        // Arrange
        String input = "HELLO";

        // Act
        String result = App.mostCommonWord(input);

        // Assert
        assertEquals("hello", result);
    }

    // Verifies that an empty string currently maps to an empty-string word.
    @Test
    void mostCommonWord_emptyString_returnsEmptyString() {
        // Arrange
        String input = "";

        // Act
        String result = App.mostCommonWord(input);

        // Assert
        assertEquals("", result);
    }

    // Verifies that punctuation-only input currently throws NoSuchElementException because no words are produced.
    @Test
    void mostCommonWord_punctuationOnlyText_throwsNoSuchElementException() {
        // Arrange
        String input = "!!!";

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> App.mostCommonWord(input));
    }

    // Verifies that the current implementation throws a null-pointer exception for a null input.
    @Test
    void mostCommonWord_nullArgument_throwsNullPointerException() {
        // Arrange
        String input = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> App.mostCommonWord(input));
    }
}
