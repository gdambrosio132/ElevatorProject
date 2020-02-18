/*
    TODO switch case can possible be refractor and srink down if you use 1 and 4 as itself and 2 and 3 as itself
 */

public class Floor {
    //properties of floor
    private int level;

    public Floor(int level) {
        //Switchcase to initialize our floor plan
        //1 <- up and 2 <- down
        switch (level) {
            case 1:
                Button btn1 = new Button(true, 0);
                break;
            case 2:
                Button btn2Up = new Button(false, 1);
                Button btn2Down = new Button(false, 0);
                break;
            case 3:
                Button btn3Up = new Button(false, 1);
                Button btn3Down = new Button(false, 0);
                break;
            case 4:
                Button btn4Down = new Button(false, 0);
                break;
        }

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
