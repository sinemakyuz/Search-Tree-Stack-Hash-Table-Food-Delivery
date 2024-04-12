import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HeapX {
    private List<SimpleDistrict> items;

    public HeapX() {
        items = new ArrayList<>();
    }

    private void siftUp() {
        int k = items.size() - 1;
        while (k > 0) {
            int p = (k-1)/2;
            SimpleDistrict item = items.get(k);
            SimpleDistrict parent = items.get(p);
            if (item.population > parent.population) {
                // swap
                items.set(k, parent);
                items.set(p, item);

                // move up one level
                k = p;
            } else {
                break;
            }
        }
    }

    public void insert(SimpleDistrict item) {
        items.add(item);
        siftUp();
    }

    private void siftDown() {
        int k = 0;
        int l = (2 * k) + 1;
        while (l < items.size()) {
            int max=l, r=l+1;
            if (r < items.size()) { // there is a right child
                if (items.get(r).population > items.get(l).population) {
                    max++;
                }
            }
            if (items.get(k).population < items.get(max).population) {
                // switch
                SimpleDistrict temp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, temp);
                k = max;
                l = (2 * k) + 1;
            } else {
                break;
            }
        }
    }

    public SimpleDistrict delete()
            throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        SimpleDistrict hold = items.get(0);
        items.set(0, items.remove(items.size()-1));
        siftDown();
        return hold;
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();

    }
}
