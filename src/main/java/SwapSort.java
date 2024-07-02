public class SwapSort<T extends Comparable<T>> {


    public void bubbleSort(T[] arr) {
        int n = arr.length;
        // 最多只需要冒泡n-1次
        for (int i = 0; i < n - 1; i++) {
            boolean mark = true;
            for (int j = n - 1; j > i; j--) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    // 如果出现逆序，则交换
                    T temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    mark = false;
                }
            }
            if (mark) {
                return;
            }
        }
    }


    public void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivotPos = partition(arr, low, high);
            quickSort(arr, low, pivotPos - 1);
            quickSort(arr, pivotPos + 1, high);
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[low];  // 选择当前子数组的第一个元素作为枢轴
        while (low < high) {
            while (low < high && arr[high].compareTo(pivot) >= 0) {
                high--;
            }
            arr[low] = arr[high];  // 将比枢轴小的元素移到左边
            while (low < high && arr[low].compareTo(pivot) <= 0) {
                low++;
            }
            arr[high] = arr[low];  // 将比枢轴大的元素移到右边
        }
        arr[low] = pivot;  // 将枢轴元素放到正确的位置
        return low;
    }

}
