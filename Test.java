public class Test {
    public static void main(String[] args){
        AStarSearch aStar = new AStarSearch();
        State startState = new State(6, 6, 1);
        aStar.search(startState);
    }
}
