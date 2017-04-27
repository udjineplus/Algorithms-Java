package LTree;

import java.util.List;

public class TreeNode {

    private String id;
    private List<TreeNode> children;

    public TreeNode(String id, List<TreeNode> children) {
        this.id = id;
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

}
