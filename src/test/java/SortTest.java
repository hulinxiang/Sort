import org.junit.Assert;
import org.junit.Test;

public class SortTest {

    @Test
    public void testBubbleSort() {
        SwapSort<Integer> sorter = new SwapSort<>();
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        sorter.bubbleSort(arr);
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSort() {
        SwapSort<Integer> sorter = new SwapSort<>();
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        sorter.quickSort(arr);
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testDirectInsertSort() {
        InsertSort<Integer> sorter = new InsertSort<>();
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        sorter.directInsert(arr);
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testBinaryInsertionSort() {
        InsertSort<Integer> sorter = new InsertSort<>();
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        sorter.binaryInsertionSort(arr);
        Assert.assertArrayEquals(expected, arr);
    }
}

