import java.util.Scanner;
/**
 * Calculates and displays the distance for up to 10 seconds.Uses d = 0.5 * g * t^2, g = 9.8
 *
 * @author Layipaun Wang
 * @version v1.0
 * @since 10/23/25
 */
public class FallingDistance {
   public static final double ACCELERATION = 9.8;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double distance;
        int numOfSecs;
        
        System.out.print("Enter how many seconds to compute: ");
        numOfSecs = input.nextInt();
        
        System.out.println("\nTime (sec)\tDistance (m)");
        System.out.println("=========\t===========");
        
        for (int time = 1; time <=numOfSecs; time++) {
            distance = getDistance(time);
        System.out.printf("%-9d\t%-12.1f\n", time, distance);
    
        input.close();
   }
}
/**
 * 
 */
public static double getDistance(int time) {
    return 0.5 * ACCELERATION * time * time;
}
}