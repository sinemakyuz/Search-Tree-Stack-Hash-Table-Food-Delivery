import java.util.Hashtable;
import java.util.Set;

public class HashTableDemo {
    public static void main(String[] args) {
        String[] hashKeyArr = {"Evka 3", "Atatürk", "Erzene", "Kazımdirik", "Yeşilova", "İnönü", "Mevlana", "Doğanlar", "Rafet Paşa", "Kızılay"};
        Integer[] hashValueArr = {20445, 28912, 35135, 33934, 31008, 25778, 25492, 21461, 19476, 15795};
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // creating hashtable
        for (int i = 0; i < hashKeyArr.length; i++) {
            hashtable.put(hashKeyArr[i], hashValueArr[i]);
        }

        char letter = 'E'; // given first letter
        addPersonTo(hashtable, letter);
        displayHashTable(hashtable); // prints the hashtable
    }

    public static Hashtable addPersonTo(Hashtable<String, Integer> hashtable, char letter){
        Set<String> setOfKeys = hashtable.keySet();
        for (String key : setOfKeys) {
            if (key.charAt(0) == letter) {
                hashtable.replace(key, hashtable.get(key) + 1);
            }
        }
        return  hashtable;
    }

    public static void displayHashTable(Hashtable<String, Integer> hashtable){
        Set<String> setOfKeys = hashtable.keySet();
        for (String key : setOfKeys) {
            // Print and display the district name and population
            System.out.println("Key: " + key
                    + "\t\t Value : "
                    + hashtable.get(key));

        }
    }
}
