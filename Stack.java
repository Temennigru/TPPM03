public class GameStack {

    public static class Iterator {
        boolean	hasNext();
        GameObject next();
    }

    public void push(GameObject object);
    public void executeNext();
    public void counter(GameStack.Iterator it);
    public void exile(GameStack.Iterator it);
}