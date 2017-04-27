package LTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeBuilder {

    List<TreeNode> tree = new ArrayList<>();

    TreeBuilder(List<Category> categories) {
        for (Category category : categories) {
            buildTree(category.getPath().split(","), tree);
        }
    }

    public List<TreeNode> getTree() {
        return tree;
    }

    public void showTree(List<TreeNode> treeNodes, int level) {
        for (TreeNode category : treeNodes) {
            System.out.println(String.join("", Collections.nCopies(level, "_")) + category.getId());
            showTree(category.getChildren(), level+4);
        }
    }

    private void buildTree(String[] parts, List<TreeNode> treeNode) {
        if(parts.length == 0) { return; }
        for(int i = 0 ; i < treeNode.size(); i++) {
            if(parts[0].equals(treeNode.get(i).getId())) {
                buildTree(Arrays.copyOfRange(parts, 1, parts.length), treeNode.get(i).getChildren());
                return;
            }
        }
        TreeNode newTreeNode = new TreeNode(parts[0], new ArrayList<>());
        treeNode.add(newTreeNode);
        buildTree(Arrays.copyOfRange(parts, 1, parts.length),newTreeNode.getChildren());
    }
}
