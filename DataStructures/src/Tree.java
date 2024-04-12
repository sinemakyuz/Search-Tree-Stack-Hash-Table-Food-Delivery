public class Tree {
    TreeNode root;

    // constructor
    public Tree(){root = null;}

    // traversing preorder
    public void preOrder(TreeNode localRoot){
        if (localRoot != null){
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    public void insert(District district){
        TreeNode newNode = new TreeNode(district);

        if (root == null){
            root = newNode;
        }else {
            TreeNode current = root;
            TreeNode parent;

            // insertion
            while (true){
                parent = current;

                if (district.name.compareTo(current.district.name) < 0){
                    current = current.leftChild;

                    if(current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else{
                    current = current.rightChild;

                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
}
