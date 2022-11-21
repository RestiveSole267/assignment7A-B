public class FSA {
    private int state;
    private boolean active;
    public FSA(int state) {
        this.active = true;
        if(state >= 0 && state <= 3) {
            this.state = state;
        }
        else {
            System.out.println("This is an invalid state, Starting at state 0");
            this.state = 0;
        }
    }
    public int showCurrentState() {
        return state;
    }
    public boolean isActive() {
        return active == true;
    }
    public int goToNextState() {
        if(state == 3) {
            state = 0;
        }
        else {
            state++;
        }
        return state;
    }
    public boolean end() {
        if(state == 3) {
            return true;
        }
        return false;
    }
    public void setActive(boolean status) {
        active = status;
    }
}