package GameCore;

public class GameStack {
    List<GameObject> stack;

    public static class Iterator {
        int pos;
        GameStack stk;

        private Iterator () {};

        private Iterator(GameStack stack) {
            pos = 0;
            this.stk = stack;
        }

        boolean	hasNext() {
            return pos <= this.stk.stack.size();
        }

        GameObject next() {
            pos++;
            return stk.stack.get(pos - 1);
        }

        boolean hasPrev() {
            return pos > 1;
        }

        GameObject prev() {
            pos--;
            return stk.stack.get(pos - 1);
        }

        GameObject object() {
            return stk.stack.get(pos);
        }
    }

    public GameStack() {
        this.stack = new ArrayList<GameObject>();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public void push(GameObject object) {
        this.stack.add(object);
    }

    // Warning: May invalidate iterator (if iterator points to last element)
    // Always check for hasNext()
    public GameObject pop() {
        GameObject ret = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return ret;
    }

    public GameObject popFromPos(GameStack.Iterator it) {
        GameObject ret = stack.get(it.pos - 1);
        stack.remove(it.pos - 1);
        it.pos--;
        return ret;
    }

    public Iterator getIterator() {
        return new Iterator(this);
    }
}