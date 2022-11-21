import java.util.Scanner;
public class Assignment7A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command ;
        int state;
        System.out.println("[Finite State Automata]");
        System.out.print("What state do you want start at ? ");
        state = Integer.parseInt(sc.nextLine());
        FSA fsa = new FSA(state);
        while (true) {
            System.out.println("\nWhat will you do ?");
            System.out.println("-Go to next state");
            System.out.println("-End");
            command = sc.nextLine();
            if(command.equalsIgnoreCase("Go to next state")){
                state = fsa.goToNextState();
                System.out.println("\nYou are now at state "+state);
            }else if(command.equalsIgnoreCase("End")){
                if(fsa.end()){
                    System.out.println("\nThe machine has shut down");
                    break;
                }else{
                    System.out.println("\nYou can't stop here; you can only stop at state 3");
                }
            }else{
                System.out.println("\nInvalid Command");
            }
        }
    }
}