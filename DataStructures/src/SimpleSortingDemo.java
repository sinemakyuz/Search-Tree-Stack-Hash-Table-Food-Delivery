import java.util.Arrays;

public class SimpleSortingDemo {
    public static void main(String[] args) {
        int [] arr = {1, 8, 5, 2, 3, 4, 9};
        sortWithInsertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int [] sortWithInsertion(int [] arr){
        for (int i = 0; i < arr.length; i++){
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        return arr;
    }
}
