
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 產生 20 個隨機整數的陣列
        int[] data = new int[20];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100) + 1;
        }

        // 使用氣泡排序
        bubbleSort(data);

        // 列印氣泡排序後的陣列元素
        System.out.println("氣泡排序後的結果：");
        for (int element : data) {
            System.out.println(element);
        }

        // 重新產生 20 個隨機整數的陣列
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100) + 1;
        }

        // 使用堆排序
        heapSort(data);

        // 列印堆排序後的陣列元素
        System.out.println("堆排序後的結果：");
        for (int element : data) {
            System.out.println(element);
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int a = n - 1; a >= 1; a--) {
            for (int b = 0; b < a; b++) {
                if (arr[b] > arr[b + 1]) {
                    int temp = arr[b];
                    arr[b] = arr[b + 1];
                    arr[b + 1] = temp;
                }
            }
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 建立最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 依序取出最大值並調整堆
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }p
}





