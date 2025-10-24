import javax.swing.JOptionPane;
/**
 * Determines if a given whole number is greater than 2 is prime or not.
 * Reporting if this is prime or not.
 * 
 * @author Layipaun Wang
 * @version v1.0
 * @since 10/23/25
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        boolean isPrime;
        int number;
        String playAgain;

        do {
            String inputStr = JOptionPane.showInputDialog(null,
                    "Enter a whole number >2 (ie 19) to test if prime: ",
                    JOptionPane.QUESTION_MESSAGE);

            if (inputStr == null) {
                break;
            }

            number = Integer.parseInt(inputStr);
            isPrime = testForPrime(number);

            if (isPrime)
                JOptionPane.showMessageDialog(null, number + " is prime");
            else
                JOptionPane.showMessageDialog(null, number + " is not prime");

            playAgain = JOptionPane.showInputDialog(null,
                    "Enter yes to test another number, no to quit.",
                    JOptionPane.QUESTION_MESSAGE);

        } while (playAgain != null && playAgain.equalsIgnoreCase("yes"));
    }

    public static boolean testForPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        int sqrtNum = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrtNum; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}