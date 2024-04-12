public class Food {
    String foodName;
    int number;
    double unitPrice;

    // constructor
    public Food(String foodName, int number, double unitPrice){
        this.foodName = foodName;
        this.number = number;
        this.unitPrice = unitPrice;
    }

    public void show() {
        System.out.println("Yemek Adı: " + foodName + " Adedi: " + number + " Birim Fiyatı: " + unitPrice + " TL");
    }
}
