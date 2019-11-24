import java.util.ArrayList;
import java.util.List;

public class State {

    private int state[] = new int[3];
    private  State parentState;

    public State(int misOnWest, int canOnWest, int boat)
    {
        state[0] = misOnWest;
        state[1] = canOnWest;
        state[2] = boat;
    }

    public boolean isGoal(){
        if(state[0] == 0 && state[1] == 0)
            return true;
        return false;
    }
    public boolean isValid(){
        if( state[0] >= 0 && state[0] <= 6 && state[1] >= 0 && state[1] <= 6
                && ( state[0] == 0 || state[0] == 6 || state[0] == state[1] ))
            return true;
        else
            return false;
    }

    private void checkAndAdd(List<State> successors, State newState){
        if( newState.isValid()){
            newState.setParent(this);
            successors.add(newState);
        }
    }

    public List<State> createMove(){
        List<State> successors = new ArrayList<State>();
        if(state[2] == 1){ //if boat is at west
            checkAndAdd(successors, new State(state[0] - 5, state[1] - 0, 0 ));
            checkAndAdd(successors, new State(state[0] - 4, state[1] - 1, 0 ));
            checkAndAdd(successors, new State(state[0] - 3, state[1] - 2, 0 ));
            checkAndAdd(successors, new State(state[0] - 0, state[1] - 5, 0 ));
            checkAndAdd(successors, new State(state[0] - 4, state[1] - 0, 0 ));
            checkAndAdd(successors, new State(state[0] - 3, state[1] - 1, 0 ));
            checkAndAdd(successors, new State(state[0] - 2, state[1] - 2, 0 ));
            checkAndAdd(successors, new State(state[0] - 0, state[1] - 4, 0 ));
            checkAndAdd(successors, new State(state[0] - 3, state[1] - 0, 0 ));
            checkAndAdd(successors, new State(state[0] - 2, state[1] - 1, 0 ));
            checkAndAdd(successors, new State(state[0] - 0, state[1] - 3, 0 ));
            checkAndAdd(successors, new State(state[0] - 2, state[1] - 0, 0 ));
            checkAndAdd(successors, new State(state[0] - 1, state[1] - 1, 0 ));
            checkAndAdd(successors, new State(state[0] - 0, state[1] - 2, 0 ));
            checkAndAdd(successors, new State(state[0] - 1, state[1] - 0, 0 ));
            checkAndAdd(successors, new State(state[0] - 0, state[1] - 1, 0 ));



        }
        else{
            checkAndAdd(successors, new State(state[0] + 5, state[1] + 0, 1 ));
            checkAndAdd(successors, new State(state[0] + 4, state[1] + 1, 1 ));
            checkAndAdd(successors, new State(state[0] + 3, state[1] + 2, 1 ));
            checkAndAdd(successors, new State(state[0] + 0, state[1] + 5, 1 ));
            checkAndAdd(successors, new State(state[0] + 4, state[1] + 0, 1 ));
            checkAndAdd(successors, new State(state[0] + 3, state[1] + 1, 1 ));
            checkAndAdd(successors, new State(state[0] + 2, state[1] + 2, 1 ));
            checkAndAdd(successors, new State(state[0] + 0, state[1] + 4, 1 ));
            checkAndAdd(successors, new State(state[0] + 3, state[1] + 0, 1 ));
            checkAndAdd(successors, new State(state[0] + 2, state[1] + 1, 1 ));
            checkAndAdd(successors, new State(state[0] + 0, state[1] + 3, 1 ));
            checkAndAdd(successors, new State(state[0] + 2, state[1] + 0, 1 ));
            checkAndAdd(successors, new State(state[0] + 1, state[1] + 1, 1 ));
            checkAndAdd(successors, new State(state[0] + 0, state[1] + 2, 1 ));
            checkAndAdd(successors, new State(state[0] + 1, state[1] + 0, 1 ));
            checkAndAdd(successors, new State(state[0] + 0, state[1] + 1, 1 ));
        }
        return successors;
    }

    public void setParent(State parentState) {
        this.parentState = parentState;
    }

    public State getParent(){
        return parentState;
    }

    public void setState(int[] state){
        this.state = state;
    }

    public int[] getState(){
        return state;
    }

    @Override
    public String toString(){
        return "(" + state[0] + "M" + state[1] + "C" + state[2] + ")";
    }

    @Override
    public boolean equals(Object state0){
        if(!(state0 instanceof State))
            return false;
        State state1 = (State) state0;
        return(state1.state[0] == state[0] && state1.state[1] == state[1] && state1.state[2] == state[2]);
    }

    @Override
    public int hashCode(){
        return ( (state[0] * 10) + (state[1] * 100) + (state[2] * 2000));
    }

}
