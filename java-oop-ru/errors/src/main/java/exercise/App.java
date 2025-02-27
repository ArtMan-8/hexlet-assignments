package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.println((int) Math.round(circle.getSquare()) + "\nВычисление окончено");
        } catch (NegativeRadiusException error) {
            System.out.println(error.getMessage() + "\nВычисление окончено");
        }
    }
}
// END
