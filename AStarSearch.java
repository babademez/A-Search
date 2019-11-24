import java.util.*;

public class AStarSearch {
    public State search(State root) {
        Set<State> visited = new HashSet<>();
        LinkedList<State> list = new LinkedList<State>();

        list.add(root);

        int level = 0;
        int side = 0; // 0->east 1->west
        int tempMis = 0;
        int tempCan = 0;
        while (true) {

            if (list.isEmpty()) {
                System.out.println("GOAL STATE (0M0C0) HASN'T BEEN REACHED (null)");
                return null;
            }

            // ADMISSIBLE HEURISTIC START
            Collections.sort(list, new Comparator<State>() {
                @Override
                public int compare(State s1, State s2) {
                    int s1Condition = s1.getState()[0] + s1.getState()[1];
                    int s2Condition = s2.getState()[0] + s2.getState()[1];
                    return s1Condition - s2Condition;

                }
            });
            State currState = list.poll();
            visited.add(currState);
            if (side != currState.getState()[2]) {
                //System.out.println("------Level " + level + "--------");
                side = currState.getState()[2];
                level++;


                /// PRINTING PART STARTS ///////
                if(level - 1 == 0)
                {
                    for(int i = 0; i < currState.getState()[0]; i++)
                        System.out.print("M");
                    System.out.println();
                    for(int i = 0; i < currState.getState()[1]; i++)
                        System.out.print("C");
                    System.out.println("\n");
                }
                else {
                    if (side == 1) System.out.print("RETURN\t");
                    else System.out.print("SEND\t");
                    System.out.print(Math.abs(currState.getState()[0] - tempMis) + " MISSIONARIES ");
                    System.out.print(Math.abs(currState.getState()[1] - tempCan) + " CANNIBALS ");
                    System.out.println();
                    for(int i = 0; i < currState.getState()[0]; i++)
                        System.out.print("M");
                    System.out.print("\t\t");
                    for(int i = 0; i < 6 - currState.getState()[0]; i++)
                        System.out.print("M");
                    System.out.println();
                    for(int i = 0; i < currState.getState()[1]; i++)
                        System.out.print("C");
                    System.out.print("\t\t");
                    for(int i = 0; i < 6 - currState.getState()[1]; i++)
                        System.out.print("C");
                    System.out.println("\n");
                } /// PRINTING PART ENDS HERE ///////

                // If goal is found, no need to search more.
                if (currState.isGoal()) {
                    return currState;
                }

                // These temps are kept to show the transfer number of cannibals and missionaries on the next state.
                tempMis = currState.getState()[0];
                tempCan = currState.getState()[1];

                list.clear(); // After the best state found (heuristically), we clear the other states
                              // on the same level of the B&B tree.

            }

            List<State> succs = currState.createMove();
            for (State st : succs) {
                if (!list.contains(st) || !visited.contains(st)) {
                    if (!visited.contains(st))
                        list.add(st);
                }
            }
        }


    }

}
