package LTree;

import java.util.List;

public class Category {
    private String id;
    private String path;
    private List<Category> childs;

    public Category(String id, String path, List<Category> childs) {
        this.id = id;
        this.path = path;
        this.childs = childs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Category> getChilds() {
        return childs;
    }

    public void setChilds(List<Category> childs) {
        this.childs = childs;
    }
}
