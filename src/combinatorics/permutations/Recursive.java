package combinatorics.permutations;

import java.util.*;

public class Recursive implements Iterable<List<Integer>> {

    private final int MAX_ITEMS;
    private final int MAX_PERMUTE;
    private static final List<Integer> P = new ArrayList<>();

    private int permuteId;
    private List<Deque<Integer>> result;

    Recursive(int maxItems) {
        this.MAX_ITEMS = maxItems;
        this.MAX_PERMUTE = factorial(maxItems);
        init();
    }

    private void init() {
        permuteId = 0;
        for (int i = 0; i < MAX_ITEMS; i++) {
            P.add(i + 1);
        }
        result = permute(P);
    }

    public static void main(String[] args) {
        Recursive recursive = new Recursive(10);
        int i = 0;
        for (List<Integer> item : recursive) {
            System.out.println(Arrays.toString(item.toArray()));
            i++;
        }
        System.out.println(i);
    }

    private List<Deque<Integer>> permute(List<Integer> array) {

        if(array.size() == 2) {
            List<Deque<Integer>> res = new ArrayList<Deque<Integer>>();
            Deque<Integer> list = new ArrayDeque<>();
            list.add(array.get(0));
            list.add(array.get(1));
            res.add(list);

            Deque<Integer> reverse = new ArrayDeque<>();
            reverse.add(array.get(1));
            reverse.add(array.get(0));
            res.add(reverse);
            return res;
        } else {
            List<Deque<Integer>> res = new ArrayList<Deque<Integer>>();
            for (Integer item : array) {
                List<Integer> arrayWithOutItem = new ArrayList<Integer>(array);
                arrayWithOutItem.remove(item);
                List<Deque<Integer>> permuted = permute(arrayWithOutItem);
                for (Deque<Integer> permute : permuted) {
                    permute.push(item);
                    res.add(permute);
                }
            }
            return res;
        }
    }

    @Override
    public Iterator<List<Integer>> iterator() {
        return new Iterator<List<Integer>>() {
            @Override
            public boolean hasNext() {
                return permuteId != MAX_PERMUTE;
            }

            @Override
            public List<Integer> next() {
                List<Integer> res = new ArrayList<>();
                for (Integer item : result.get(permuteId)) {
                    res.add(item);
                }
                permuteId++;
                return res;
            }
        };
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

}
