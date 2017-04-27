package LTree;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Category> categories = new ArrayList<>();

    public static void main(String[] args) {
        categories.add(new Category("#", "#", new ArrayList<Category>()));
        categories.add(new Category("a", "#,a", new ArrayList<Category>()));
        categories.add(new Category("b", "#,a,b", new ArrayList<Category>()));
        categories.add(new Category("c", "#,a,c", new ArrayList<Category>()));
        categories.add(new Category("d", "#,a,d", new ArrayList<Category>()));
        categories.add(new Category("e", "#,a,e", new ArrayList<Category>()));
        categories.add(new Category("f", "#,a,c,f", new ArrayList<Category>()));
        categories.add(new Category("g", "#,a,c,g", new ArrayList<Category>()));
        categories.add(new Category("h", "#,a,d,h", new ArrayList<Category>()));
        categories.add(new Category("j", "#,a,d,j", new ArrayList<Category>()));
        categories.add(new Category("k", "#,a,d,j,k", new ArrayList<Category>()));
        categories.add(new Category("l", "#,a,d,j,l", new ArrayList<Category>()));
        categories.add(new Category("m", "#,a,d,j,k,m", new ArrayList<Category>()));
        categories.add(new Category("n", "#,a,d,j,k,m,n", new ArrayList<Category>()));
        categories.add(new Category("1", "#,1", new ArrayList<Category>()));
        categories.add(new Category("2", "#,1,2", new ArrayList<Category>()));
        categories.add(new Category("3", "#,1,3", new ArrayList<Category>()));
        categories.add(new Category("4", "#,1,3,4", new ArrayList<Category>()));
        categories.add(new Category("5", "#,1,3,5", new ArrayList<Category>()));
        categories.add(new Category("6", "#,1,3,6", new ArrayList<Category>()));
        categories.add(new Category("7", "#,1,3,4,7", new ArrayList<Category>()));
        categories.add(new Category("8", "#,1,3,6,8", new ArrayList<Category>()));
        categories.add(new Category("9", "#,1,3,6,8,9", new ArrayList<Category>()));
        categories.add(new Category("10", "#,1,3,6,8,9,10", new ArrayList<Category>()));

        TreeBuilder treeBuilder = new TreeBuilder(categories);
        treeBuilder.getTree();

        treeBuilder.showTree(treeBuilder.getTree(), 0);
    }
}
