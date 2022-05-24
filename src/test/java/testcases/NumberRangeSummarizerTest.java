package testcases;

import org.junit.Test;
import org.za.numberrangesummarizer.NumberRangeSummarizerImpl;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class NumberRangeSummarizerTest {
    //Creating an object
    NumberRangeSummarizerImpl numberRangeSummarizerImpl;

    /**
     * collectNumbersTest: This is the unit test to test the collected Numbers
     */
    @Test
    public void collectNumbersTest() {
        numberRangeSummarizerImpl = new NumberRangeSummarizerImpl();
        String inputGiven = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> output = numberRangeSummarizerImpl.collect(inputGiven);
        System.out.println("This is the output Expected " + output);
        assertEquals(Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31), output);
    }

    /**
     * testResultOutput: This is the unit test to test the Summarized Collection
     */
    @Test
    public void summarizeCollectionTest() {
        numberRangeSummarizerImpl = new NumberRangeSummarizerImpl();
        Collection<Integer> collectionInputGiven = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String output = numberRangeSummarizerImpl.summarizeCollection(collectionInputGiven);
        System.out.println("This is the output Expected " + output);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", output);
    }
}
