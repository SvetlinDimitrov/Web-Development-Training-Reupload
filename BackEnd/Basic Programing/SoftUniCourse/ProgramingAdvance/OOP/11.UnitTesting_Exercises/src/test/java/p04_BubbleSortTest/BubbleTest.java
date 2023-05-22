package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void TestIfTheSortingIsWorking() {
        int [] arr = {1,3,5,2};
        Bubble.sort(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5}, arr);

    }
}