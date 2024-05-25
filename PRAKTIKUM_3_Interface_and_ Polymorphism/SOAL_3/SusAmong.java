import java.util.Scanner;

public class SusAmong{
    public static void main(String args[]){
        int taskCompleted = 0;
        int playersFrozen = 0;
        int emergencyMeetingCalled = 0;

        Scanner input = new Scanner(System.in);

        int kru = Integer.parseInt(input.nextLine());
        int impostor = Integer.parseInt(input.nextLine());

        for(int i = 1; i <= (impostor); i++){
            RedAstronaut test = new RedAstronaut("Impostor " + i);
        }

        for(int i = 1; i <= (kru-impostor); i++){
            BlueAstronaut test = new BlueAstronaut("Crewmate " + i);
        }

        while(true){
            int masukan = Integer.parseInt(input.nextLine());
            if(masukan == 1){
                masukan = Integer.parseInt(input.nextLine());

                if(Player.getPlayers()[masukan] instanceof BlueAstronaut){
                    BlueAstronaut temp1 = (BlueAstronaut) (Player.getPlayers()[masukan]);
                    temp1.completeTask();
                    taskCompleted ++;
                }

            }

            else if (masukan == 2){
                masukan = Integer.parseInt(input.nextLine());

                if(Player.getPlayers()[masukan] instanceof RedAstronaut){
                    RedAstronaut temp2 = (RedAstronaut) (Player.getPlayers()[masukan]);
                    masukan = Integer.parseInt(input.nextLine());
                    playersFrozen ++;
                    temp2.freeze(Player.getPlayers()[masukan]);
                }

            }

            else if (masukan == 3){
                for(int i = 0; i < kru; i++){
                    Player.getPlayers()[i].emergencyMeeting();
                }
                emergencyMeetingCalled ++;
            }

            else if (masukan == 4){
                break;
            }

            if(Player.getPlayers()[masukan].gameOver()){
                break;
            }

            
        }
        
        System.out.println("Task completed: " + taskCompleted);
        System.out.println("Players frozen: " + playersFrozen);
        System.out.println("Emergency meetings called: " + emergencyMeetingCalled);
        System.out.println("Game Over. Thanks for playing!");

        input.close();
    }
}