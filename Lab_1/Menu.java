import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Class that create a menu
 * for interactions with user
 */
public class Menu {
    /**
     * There is only one method that launched a menu for users
     */
    public void launch(){
        System.out.println("""
                Welcome to the complex number and matrix simple calculator
                There are some rules that you need to know
                1. If programme waiting for two numbers, you should input them through the space
                2. After every inputting data you should press the Enter
                3. After every operation with the complex numbers or matrices, the result is added to the respective lists""");
        Scanner in = new Scanner(System.in);
        Terminal terminal= new Terminal();
        ArrayList<ComplexNumber> numbers = new ArrayList<>();
        ArrayList<Matrix> matrices = new ArrayList<>();
        int x;
        do {
            System.out.println("What do you wan to do?");
            System.out.println("1. Create complex number");
            System.out.println("2. Show complex numbers");
            System.out.println("3. Add up the numbers");
            System.out.println("4. Multiply the numbers");
            System.out.println("5. Show complex number in trigonometric form");
            System.out.println("6. Create matrix");
            System.out.println("7. Show list of matrix and their sizes");
            System.out.println("8. Show particular matrix");
            System.out.println("9. Add up the matrices");
            System.out.println("10. Multiply the matrices");
            System.out.println("11. Transpose matrix");
            System.out.println("12. Exit the programme");
            try {
                x = in.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Error! !!!You inputted not a number!!! ");
                in.next();
                x=100;
            }
            switch (x) {
                case 1:
                    terminal.Creating_complex_number(numbers);
                    break;
                case 2:
                    terminal.Show_complex_number(numbers);
                    break;
                case 3:
                    terminal.adding_up_complex_numbers(numbers);
                    break;
                case 4:
                    terminal.multiply_complex_numbers(numbers);
                    break;
                case 5:
                    terminal.show_in_trigonometric(numbers);
                    break;
                case 6:
                    terminal.creating_matrix(matrices);
                    break;
                case 7:
                    terminal.show_matrices(matrices);
                    break;
                case 8:
                    terminal.show_a_matrix(matrices);
                    break;
                case 9:
                    terminal.add_up_matrices(matrices);
                    break;
                case 10:
                    terminal.multiply_matrices(matrices);
                    break;
                case 11:
                    terminal.transpose_matrix(matrices);
                    break;
                case 12:
                    System.out.println("///////////////////////////");
                    System.out.println("///EXITING THE PROGRAMME///");
                    System.out.println("///////////////////////////");
                    break;
                default:
                    System.out.println("You inputted something wrong");
            }
        } while (x != 12);
    }
}
