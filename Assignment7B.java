import java.util.Random;
import java.util.Scanner;
public class Assignment7B {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        FSA machines[] = new FSA[3];
        System.out.println("[Array of Finite State Automata]");
        for (int i = 0; i < 3; i++) {
            machines[i] = new FSA(rand.nextInt(4));
            System.out.println("Machine #" + i + " is starting at state " + machines[i].showCurrentState());
        }
        System.out.println();
        while(true) {
            System.out.println("What will you do?\nCheck the current status\n-Go to next state\n-End");
            String opt = sc.nextLine().strip();
            if(opt.equalsIgnoreCase("Check the current status")) {
                System.out.print("What machine will you look at? ");
                int index = sc.nextInt();
                sc.nextLine();
                if(index >= 0 && index <= 2) {
                    System.out.println("\nMachine #" + index + " is " + (machines[index].isActive() ? "active": "deactivated") + " and at state " + machines[index].showCurrentState() + "\n");
                }
                else {
                    System.out.println("Invalid machine number");
                }
            }
            else if(opt.equalsIgnoreCase("Go to next state")) {
                System.out.print("What machine will you advance? ");
                int index = sc.nextInt();
                sc.nextLine();
                if(index >= 0 && index <= 2) {
                    if(machines[index].isActive()) {
                        System.out.println("\nMachine #" + index + " is now at state " + machines[index].goToNextState() + "\n");
                    }
                    else {
                        System.out.println("\nMachine #" + index + " is not active");
                    }
                }
                else {
                    System.out.println("Invalid machine number");
                }
            }
            else if(opt.equalsIgnoreCase("End")) {
                System.out.print("What machine will you stop? ");
                int index = sc.nextInt();
                sc.nextLine();
                if(index >= 0 && index <= 2) {
                    if(machines[index].end()) {
                        machines[index].setActive(false);
                        System.out.println("\nMachine #" + index + " is now deactivated" + "\n");
                    }
                    else {
                        System.out.println("\nyou can't  stop here, you can only stop at state 3.\n");
                    }
                }
                else {
                    System.out.println("Invalid machine number");
                }
            }
            else {
                System.out.println("\nInvalid command");
            }
            if(!machines[0].isActive() && !machines[1].isActive() && !machines[2].isActive()) {
                break;
            }
        }
    }
}
