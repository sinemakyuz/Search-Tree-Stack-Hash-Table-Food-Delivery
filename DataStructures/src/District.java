import java.util.ArrayList;
import java.util.List;

public class District {
    public String name;
    List<List<Food>> orderList;

    // constructor
    public District(){
        orderList = new ArrayList<>();
    }

    public void showName(){
        System.out.println("Mahalle Adı: " + name);
    }

    public  void showFoods(){
        for (List<Food> foods : orderList) {
            System.out.println("\n" + name + " Mahallesinin " + (orderList.indexOf(foods) + 1) + ". Siparişinin Bilgileri\n");
            for (Food food : foods) {
                food.show();
            }
        }
    }
}
