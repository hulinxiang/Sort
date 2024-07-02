public class InsertSort<T extends Comparable<T>> {

    public void directInsert(T[] arr) {
        int len = arr.length;
        // 这里i从1开始是因为把初始第一个位置
        // 的元素视为一个有序的序列
        for (int i = 1; i < len; i++) {
            // temp 代表当前要插入的元素
            T temp = arr[i];
            int j = i - 1;
            // 查找要插入的位置
            while (j >= 0 && arr[j].compareTo(temp) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 退出循环的时候，说明找到了tmp的位置
            arr[j + 1] = temp;
        }
    }

    public void binaryInsertionSort(T[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            // temp 代表当前要插入的元素
            T temp = arr[i];
            int low = 0;
            int high = i - 1;
            // 使用二分查找找到插入位置
            while (low <= high) {
                // 取中间位置
                int mid = (high + low) / 2;
                if (arr[mid].compareTo(temp) > 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i - 1; j >= high + 1; j--) {
                arr[j + 1] = arr[j];
            }
            arr[high + 1] = temp;
        }
    }

    public static void main(String[] args) {
        InsertSort<Integer> sorter = new InsertSort<>();
        Integer[] arr = {1,2,3,2};
        sorter.binaryInsertionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
