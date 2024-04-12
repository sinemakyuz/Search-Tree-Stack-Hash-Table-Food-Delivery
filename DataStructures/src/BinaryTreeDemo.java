import java.util.*;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        String[] districtArr = {"Evka 3", "Özkanlar", "Atatürk", "Erzene", "Kazımdirik"};
        String[] foodArr = {"Türlü", "Pizza", "Kızartma", "Pilav", "Börek", "Simit", "Hamburger", "Sandviç", "Çorba"};
        double[] unitPriceArr = {10, 12, 15, 8, 9, 2, 20, 15, 13};

        // binary tree
        Tree binaryTree = new Tree();

        // creating binary search tree
        for (String s : districtArr) {
            District district = new District();
            district.name = s;

            for (int j = 0; j < getRandomNumber(5, 10); j++) {
                List<Food> foodList = new ArrayList<>();

                for (int k = 0; k < getRandomNumber(3, 5); k++) {
                    // creating food class variables and object
                    int randomNumber = getRandomNumber(0, foodArr.length);
                    String foodName = foodArr[randomNumber];
                    int number = getRandomNumber(1, 8);
                    double unitPrice = unitPriceArr[randomNumber];
                    Food food = new Food(foodName, number, unitPrice);
                    foodList.add(food);
                }
                district.orderList.add(foodList);
            }
            binaryTree.insert(district);
        }
        // maximum depth of the tree
        System.out.println("Maximum depth of tree: " + maxDepth(binaryTree.root));
        System.out.println();
        // traversing tree preorder
        binaryTree.preOrder(binaryTree.root);
        // find above 150 Tl orders in given district name
        findDistrictInfInTree("Erzene", binaryTree.root);
        // find number of food that wished in tree
        System.out.println("\nİstenilen Yemeğin Ağaçtaki Toplam Adedi: " + findNumberOfFoodInTree("simit", binaryTree.root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {return -1;}

        int left = maxDepth(root.leftChild);
        int right = maxDepth(root.rightChild);
        return Math.max(left, right) + 1;
    }

    public static void findDistrictInfInTree(String districtName, TreeNode localRoot){
        if (localRoot != null) {
            if (localRoot.district.name.equalsIgnoreCase(districtName)){
                System.out.println(districtName + " Mahallesindeki 150 TL üstü siparişlerin bilgileri:");

                for (int i = 0; i < localRoot.district.orderList.size(); i++){
                    double totalOrderPrice = 0; // total price
                    for (int j = 0; j <localRoot.district.orderList.get(i).size(); j++){
                        Food food = localRoot.district.orderList.get(i).get(j);
                        totalOrderPrice += food.unitPrice * food.number;
                    }
                    // if total order price above 150 TL prints infos of that order
                    if (totalOrderPrice > 150){
                        System.out.println("\n150 TL üstündeki " + (i + 1) + ". siparişin bilgileri");
                        // iterate all orders in that order
                        for (int k = 0; k <localRoot.district.orderList.get(i).size(); k++){
                           localRoot.district.orderList.get(i).get(k).show();
                        }
                    }
                }
            }
            findDistrictInfInTree(districtName, localRoot.leftChild);
            findDistrictInfInTree(districtName, localRoot.rightChild);
        }
    }
    public static int findNumberOfFoodInTree(String foodName, TreeNode localRoot){
        int totalNumberOfFood = 0;
        if (localRoot != null) {
            District district = localRoot.district;
            for (int i = 0; i < district.orderList.size(); i++) {
                for (int j = 0; j < district.orderList.get(i).size(); j++) {
                    if (district.orderList.get(i).get(j).foodName.equalsIgnoreCase(foodName)) { // ıf names are equal
                        totalNumberOfFood += district.orderList.get(i).get(j).number;
                        district.orderList.get(i).get(j).unitPrice -= district.orderList.get(i).get(j).unitPrice * 0.1; // %10 discount
                    }
                }
            }
            return (totalNumberOfFood + findNumberOfFoodInTree(foodName, localRoot.leftChild) +
                    findNumberOfFoodInTree(foodName, localRoot.rightChild));
        }
        return 0;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
