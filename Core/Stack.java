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
            return stack.get(pos - 1);
        }

        boolean hasPrev() {
            return pos > 1;
        }

        GameObject prev() {
            pos--;
            return stack.get(pos - 1);
        }
        GameObject object();
    }

    public void push(GameObject object) {
    }

    // Warning: May invalidate iterator (if iterator points to last element)
    // Always check for hasNext()
    public GameObject pop() {
        GameObject ret = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
    }
    public GameObject popFromPos(GameStack.Iterator it) {
        GameObject ret = stack.get(it.pos - 1);
        stack.remove(it.pos - 1);
        it.pos--;
    }

    public Iterator getIterator() {
        return new Iterator(this);
    }
}