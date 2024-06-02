import java.util.Scanner;

public class Chakravyuh {

   public static boolean canCrossChakravyuh(int[] enemyPowers, int p, int a, int b) {
    int currentPower = p;
    int enemiesCount = enemyPowers.length;
    int currentPosition = 0; 
    boolean[] visited = new boolean[enemiesCount];

    while (currentPosition < enemiesCount) {
       
        if (currentPower >= enemyPowers[currentPosition]) {
           
            visited[currentPosition] = true;
            currentPower -= enemyPowers[currentPosition];

            if ((currentPosition == 2 || currentPosition == 6) && currentPosition + 1 < enemiesCount && !visited[currentPosition + 1]) {
                
                currentPower -= enemyPowers[currentPosition] / 2;
                visited[currentPosition + 1] = true; 
            }

            currentPosition++;
        } else {
           
            if (a > 0) {
               
                a--;
                currentPosition++;
            } else {
                
                if (b > 0) {
                   
                    currentPower += b;
                    b--;
                } else {
                    
                    return false;
                }
            }
        }
    }

    return true; 
}



    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of enemies: ");
            int enemiesCount = scanner.nextInt();
            int[] enemyPowers = new int[enemiesCount];

            System.out.println("Enter the powers of each enemy: ");
            for (int i = 0; i < enemiesCount; i++) {
                enemyPowers[i] = scanner.nextInt();
            }

            System.out.println("Enter Abhimanyu's initial power: ");
            int p = scanner.nextInt();

            System.out.println("Enter the number of times Abhimanyu can skip battling: ");
            int a = scanner.nextInt();

            System.out.println("Enter the number of times Abhimanyu can recharge: ");
            int b = scanner.nextInt();

            boolean canCross = canCrossChakravyuh(enemyPowers, p, a, b);
            if (canCross) {
                System.out.println("Abhimanyu can cross the Chakravyuh.");
            } else {
                System.out.println("Abhimanyu cannot cross the Chakravyuh.");
            }
        }
    }
}
