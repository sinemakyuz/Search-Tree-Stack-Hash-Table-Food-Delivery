public class HeapDemo {
    public static void main(String[] args) {
        String[] districtNameArr = {"Evka 3", "Atatürk", "Erzene", "Kazımdirik", "Yeşilova", "İnönü", "Mevlana", "Doğanlar", "Rafet Paşa", "Kızılay"};
        Integer[] populationArr = {20445, 28912, 35135, 33934, 31008, 25778, 25492, 21461, 19476, 15795};

        // create heap
        HeapX heap = new HeapX();
        // adding elements to the heap
        for (int i = 0; i < populationArr.length; i++){
            SimpleDistrict simpleDistrict = new SimpleDistrict(districtNameArr[i], populationArr[i]);
            heap.insert(simpleDistrict);
        }
        // deleting elements from max heap
        System.out.println("\nEn Fazla Nüfusa Sahip 3 Mahalle");
        System.out.println("--------------------------------");
        deleteElemenToThIndex(3, heap);
    }

    public static void deleteElemenToThIndex(int index, HeapX heap){
        for (int i = 0; i < index; i++){
            heap.delete().display();
        }
    }
}
