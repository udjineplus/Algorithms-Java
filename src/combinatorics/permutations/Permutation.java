package combinatorics.permutations;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation implements Iterable<List<Integer>> {

    private final int MAX_ITEMS;
    private final int[] PERMUTE;
    private final int[] PERMUTE_CODE;
    private final Direction[] DIRECTION;

    private int currentPermuteId = 1;
    private final int maxItemsPermute;
    private boolean hasNext = true;

    Permutation(int maxItems) {
        this.MAX_ITEMS = maxItems;
        this.maxItemsPermute = factorial(maxItems);
        this.PERMUTE = new int[MAX_ITEMS];
        this.PERMUTE_CODE = new int[MAX_ITEMS];
        this.DIRECTION = new Direction[MAX_ITEMS];
        init();
    }

    private void init() {
        for (int i = 0; i < MAX_ITEMS; i++) {
            PERMUTE[i] = MAX_ITEMS - i;
            PERMUTE_CODE[i] = 0;
            DIRECTION[i] = Direction.UP;
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation(4);
        int i = 1;
        for (List<Integer> item : permutation) {
            System.out.println(Arrays.toString(item.toArray()));
            i++;
        }
        System.out.println(i);
    }

    @Override
    public Iterator<List<Integer>> iterator() {
        return new Iterator<List<Integer>>() {
            @Override
            public boolean hasNext() {
                return maxItemsPermute != currentPermuteId;
            }

            @Override
            public List<Integer> next() {
                if (hasNext && currentPermuteId != 1) {
                    hasNext = solve();
                    if (hasNext) {
                        currentPermuteId++;
                    }
                } else {
                    currentPermuteId++;
                }
                List<Integer> result = Arrays.stream(PERMUTE).boxed().collect(Collectors.toList());
                return result;
            }
        };
    }

    private int ok() {
        int i = MAX_ITEMS - 1;
        while (i > 0 &&
                (((DIRECTION[i] == Direction.UP) && (PERMUTE_CODE[i] == i)) ||
                        ((DIRECTION[i] == Direction.DOWN) && (PERMUTE_CODE[i] == 0)))) {
            i--;
        }
        return i;
    }

    private int whoI(int i) {
        int j = MAX_ITEMS - 1;
        while ((j > 0) && (PERMUTE[j] != i)) {
            j--;
        }
        return j;
    }

    private boolean solve() {
        int i = ok();
        boolean q = (i > 0);

        if (i > 0) {
            PERMUTE_CODE[i] = PERMUTE_CODE[i] + DIRECTION[i].getValue();
            for (int j = i + 1; j < MAX_ITEMS; j++) {
                DIRECTION[j] = Direction.inverse(DIRECTION[j]);
            }
            int j = whoI(i + 1);
            int dj = j + DIRECTION[i].getValue();
            swap(j, dj);
        }
        return q;
    }

    private void swap(int i, int j) {
        int temp = PERMUTE[i];
        PERMUTE[i] = PERMUTE[j];
        PERMUTE[j] = temp;
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private enum Direction {
        UP(1), DOWN(-1);

        private int value;

        Direction(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }

        public static Direction inverse(Direction direction) {
            if (direction == UP)
                return DOWN;
            else
                return UP;
        }

        @Override
        public String toString() {
            if (this.value == 1) {
                return "˄";
            } else {
                return "˅";
            }
        }
    }

}

