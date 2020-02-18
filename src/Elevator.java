public class Elevator {
    //properties of elevator
    private int elevatorState; //0 = idle, 1 = up, 2 = down
    private int elevatorDirection; //1st floor, 2nd floor, ... what floor it is at, initally at 1
    private boolean elevatorCollect;

    public Elevator() {
        this.elevatorDirection = 1;
        this.elevatorState = 0;
        this.elevatorCollect = false;
    }


    public boolean isDestine(){
        if (getElevatorState() == 1 || getElevatorState() == 2) {
            return true;
        } else {
            return false;
        }
    }

    public void move(int endpoint){
        if (endpoint > getElevatorDirection()){ //if 3 is greater than 1 -> go up
            setElevatorState(1);
            setElevatorDirection(getElevatorDirection() + 1);
        } else if (endpoint < getElevatorDirection()){ //if 2 < 4 -> go down
            setElevatorState(2);
            setElevatorDirection(getElevatorDirection() - 1);
        } else {
            setElevatorState(0);
        }
    }

    public void moveDown(int place){
        setElevatorState(2);
        setElevatorDirection(getElevatorDirection() - 1);
    }

    //create an elevator original thing where it moves down 1 level every tick until it reaches level 1

    public int getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    public int getElevatorDirection() {
        return elevatorDirection;
    }

    public void setElevatorDirection(int elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }

    public boolean isElevatorCollect() {
        return elevatorCollect;
    }

    public void setElevatorCollect(boolean elevatorCollect) {
        this.elevatorCollect = elevatorCollect;
    }


    //toString to say the state
    //going up, going down, idle
    //TODO add tick function for the elevator; either here or in the demo, we have to find out later
    public String elevatorStateDisplay(){
        //collect the elevators information on what state it is in and format it into our text
        switch (getElevatorState()){
            case 0:
                return "IDLE";
            case 1:
                return "UP";
            case 2:
                return "DOWN";
            default:
                return "IDLE";
        }
    }

}
