package org.za.numberrangesummarizer;

import java.util.*;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    /**
     * collect: testResultOutput: This is the implementation of the collect interface
     *
     * @param input String
     * @return arrayList
     */
    public Collection<Integer> collect(String input) {
        String[] StringArray = input.split(",");
        int[] integers = new int[StringArray.length];
        for (int i = 0; i < StringArray.length; i++)
            integers[i] = Integer.parseInt(StringArray[i]);

        //Sorting the array
        Arrays.sort(integers);
        List<Integer> arrayList = new ArrayList<>();
        for (int integer : integers) arrayList.add(integer);
        return arrayList;
    }

    /**
     * collect: summarizeCollection: This is the implementation of the summarizeCollection interface
     *
     * @param input String
     * @return ranges.substring(0, ranges.length () - 1);
     */
    public String summarizeCollection(Collection<Integer> input) {
        int count = 0;
        int firstValue, nextValue;
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> inputList = new ArrayList<>(input);

        for (int i = 0; i < inputList.size(); i++) {
            if (i == (inputList.size()) - 1) {
                if (!Objects.equals(inputList.get((inputList.size()) - 2), inputList.get((inputList.size()) - 1))) {
                    stringBuilder.append(inputList.get(i)).append(",");
                }
                break;
            }
            firstValue = inputList.get(i);
            nextValue = inputList.get(i + 1);
            if (nextValue == firstValue + 1) {
                count++;
                int lowest = firstValue;
                for (int j = i + 1; ; j++) {
                    firstValue = inputList.get(j);
                    nextValue = inputList.get(j + 1);
                    if (nextValue == firstValue + 1) {
                        count++;
                    } else {
                        i = j;
                        if (count != 0) {
                            stringBuilder.append(lowest).append("-").append(inputList.get(j)).append(", ");
                        }
                        break;
                    }
                }
                count = 0;
            } else {
                stringBuilder.append(firstValue).append(", ");
            }
        }
        String ranges = stringBuilder.toString();
        return ranges.substring(0, ranges.length() - 1);
    }
}

