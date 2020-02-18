/*
    ElevatorDemo.java Class
    TODO implement a priority queue for the orders of the buttons that are presssed
    this is where the randomizing process takes place, all the work is in the other classes

 */

import java.util.Random;
import java.util.Scanner;
//import java.util.ArrayList;



public class ElevatorDemo{
    public static void main(String[] args ){
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        //ArrayList<Integer> listRequest = new ArrayList<Integer>(); //help us handle multiple clients with ease
        //ArrayList<Integer> listFinal = new ArrayList<Integer>();
        int tick = 0;
        boolean hasInitallyMoved = false;
        boolean randomIdleState;
        int randomNumberGenerator = 0;
        //int secondNumberGenerator = 0;
        //int anotherPerson = 0;
        //int secondNumberGeneratorLocation = 0;
        int randomNumberGeneratorLocation = 0;
        int elevatorBackCounter = 0;
        //We initialize our elevator with the standard
        Elevator elevator = new Elevator();


    //while loop that goes about 50 ticks
    //Use randomizer to go about floors
        while (tick < 50){
            //idle initially, if destine to go somewhere, skip randomization
            //create idle state just in case to test out
            if (elevator.isDestine() == false && elevator.isElevatorCollect() == false) //if its idle, generate if want to move
                randomIdleState = rand.nextBoolean();
            else
                randomIdleState = false;

                //This if-else clause runs whether the simulation of the elevator is going to be active or not
                if (randomIdleState == true){
                    //elevator stays idle
                    System.out.println("No one has requested to enter the elevator");
                    elevatorBackCounter++;
                    if (elevatorBackCounter == 5){
                        if (elevator.getElevatorDirection() == 1){
                            elevator.setElevatorState(0);
                            elevatorBackCounter = 0;
                        } else {
                            elevator.moveDown(elevator.getElevatorDirection());
                        }
                    }
                    tick++;
                } else {
                    //for the first instance
                    //elevator moves
                    //if statement if it is already going somewhere
                        if (hasInitallyMoved == false && elevator.isElevatorCollect() == false){
                            System.out.println("Elevator at Level " + elevator.getElevatorDirection() + " State: " + elevator.elevatorStateDisplay());
                            randomNumberGenerator = 1 + rand.nextInt(4); //Generates number from 1-4 to where the person is on which floor
                            //listRequest.add(randomNumberGenerator);
                            System.out.println("Someone From Floor " + randomNumberGenerator + " is requesting the elevator");
                            //we now have a random floor of request, where does it want to go?
                            do { //it can't be the same floor
                                randomNumberGeneratorLocation = 1 + rand.nextInt(4);
                            } while (randomNumberGenerator == randomNumberGeneratorLocation);
                            //listFinal.add(randomNumberGeneratorLocation);
                            System.out.println("Request From Floor " + randomNumberGenerator + " to floor " + randomNumberGeneratorLocation);
                            elevator.move(randomNumberGenerator);
                            System.out.println("Elevator at level " + elevator.getElevatorDirection() + " State: " + elevator.elevatorStateDisplay());
                            hasInitallyMoved = true;
                            if (randomNumberGenerator == elevator.getElevatorDirection()){
                                System.out.println("The elevator has arrived on floor " + elevator.getElevatorDirection());
                                elevator.setElevatorCollect(true);
                            }
                            tick++;
                        } else {
                            //another if else clause maybe incorperate the rnadomizer here for someone on another level
                            //Checks to see if the floor they request is on the way, therefore
                            /*anotherPerson = rand.nextInt(100);
                            if (anotherPerson > 49 && anotherPerson < 60){
                                secondNumberGenerator = 1 + rand.nextInt(4);
                                listRequest.add(secondNumberGenerator);
                                System.out.println("Another Person has requested to go somewhere");
                                do{
                                    secondNumberGeneratorLocation = 1 + rand.nextInt(4);
                                } while (secondNumberGenerator == secondNumberGeneratorLocation);
                                listFinal.add(secondNumberGeneratorLocation);
                                System.out.println("Someone from Floor " + secondNumberGenerator + " wants to go to " + secondNumberGeneratorLocation);
                                if (listRequest.)
                            }*/

                            if (elevator.isElevatorCollect() == false){
                                elevator.move(randomNumberGenerator);
                                System.out.println("Elevator at level " + elevator.getElevatorDirection() + " State: " + elevator.elevatorStateDisplay());
                                tick++;
                            } else {
                                elevator.move(randomNumberGeneratorLocation);
                                System.out.println("Elevator at level " + elevator.getElevatorDirection() + " State: " + elevator.elevatorStateDisplay());
                                tick++;
                            }
                            //problem, isDestine is affecting the earliest command
                            //we hae the person, need to move him now
                            if (elevator.isDestine() == false && elevator.isElevatorCollect() == false){ //check to see if it is idle b/c we arrived
                                System.out.println("The elevator has arrived on Floor: " + elevator.getElevatorDirection());
                                elevator.setElevatorCollect(true);
                            } else if (elevator.isDestine() == false && elevator.isElevatorCollect() == true){
                                System.out.println("Person has arrived at their destination");
                                elevator.setElevatorCollect(false);
                                hasInitallyMoved = false;
                            }
                        }

                }


        }


    }
}

