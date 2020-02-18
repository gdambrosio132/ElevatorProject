public class Button {
    //Properties of Button
    //private int id;
    private boolean state; //its either on or off
    private int directions;
    //private String name;
    //private Floor floor;

    public Button(boolean state, int directions) {
        this.state = state;
        this.directions = directions;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getDirections() {
        return directions;
    }

    public void setDirections(int directions) {
        this.directions = directions;
    }
}
