# 排序算法

本文主要是对常见的插入排序，交换排序和选择排序的介绍。主要是用于学习，作者水平有限，如果文章出现错误，感谢大家批评指正。

## 1.插入排序

插入排序的基本思想是每次将一个待排序的记录按照其关键字的大小插入前面已经排好序的子序列中，直到全部记录插入完成。

### 1.1 直接插入排序

直接插入排序是最简单也是最直接的一种排序方式。假设有待排序列 1~n 中，某一时刻时，位置 i 前面的序列已经有序，而位置 i 后面的序列暂时无序。

为了将位置 i 对应的元素插入到前面已经有序的序列中，需要：

1. 查找出位置 i 对应的元素在 1~i-1 中的插入位置 k
2. 将 k~i-1 中的所有元素依次后移一个单位
3. 将位置 i 的元素复制到位置 k

为了实现序列 1~n 的排序，我们可以将初始时候第一个位置的元素视为一个已经排好序的长度为 1 的序列。然后，将 2~n 的元素依次插入到已经有序的序列中，上述操作执行 n-1 次就能得到一个有序的序列。

```java
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
```

### 1.2 折半插入排序

在直接插入算法中，总是边比较边移动元素。折半插入排序就是将比较和移动操作分离，即先折半查找出元素的待插入位置，然后统一地移动带传入位置之后所有的元素。

```java
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
```

## 2. 交换排序

所谓交换，是指根据序列中两个元素关键字的比较结果来对换这两个记录在序列中的位置。

### 2.1 冒泡排序

冒泡排序的基本思想就是：首先，从后往前或者从前往后地两两比较相邻元素的值，如果为逆序，则交换他们，直到序列比较完。以上这个操作称之为第一趟冒泡，这样会使得元素中最小的元素在第一个位置（或者元素中最大的元素在最后一个位置）。下一趟冒泡时，前一趟确定的最小元素不再参与比较。每一趟冒泡结束之后，都会有一个元素放在了最终位置。当我们检查到最后一趟冒泡没有元素位置发生改变，那么就可以证明此序列已经有序。

值得一提的是，因为每一次冒泡都会有一个元素到它的最终位置，那么我们其实最多只需要冒泡 n-1 次就可以实现序列的排序。（这是 n 是序列中元素的个数）

```java
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
```

### 2.2 快速排序

快速排序的思想是基于分治法。首先，在待排序列中，任取一个元素 pivot 作为基准，通常来说是取首个元素。通过一次排序可以将序列分为两个部分，第一个部分的元素全部都是小于 pivot 的，第二个部分的元素全部都是大于或等于 pivot 的。这个 pivot 元素经过一次排序之后就放在了最终位置上。然后我们就可以递归地得到的两个子序列重复上述步骤，直到每部分只有一个元素或空为止，这样所有的元素都放在了其最终位置上。

```java
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
```
