public class TreeNode {
    District district;
    TreeNode leftChild;
    TreeNode rightChild;

    // constructor
    public TreeNode(District district){
        this.district = district;
    }

    public void displayNode(){
        district.showName();
        district.showFoods();
        System.out.println("=================================================================");
    }
}
