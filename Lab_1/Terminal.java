import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This is a class with
 *  functions for user's menu
 * @author Maxim Seleznev
 */
public class Terminal {
    Scanner in = new Scanner(System.in);
    /**
     * Method that create a new one complex number and add it to the respective list
     * @param list list of complex numbers
     */
    void Creating_complex_number(ArrayList<ComplexNumber> list) {
        double real, imaginary;
        System.out.println("Please input the real and imaginary part:");
        try {
            real = in.nextDouble();
            imaginary = in.nextDouble();
            list.add(new ComplexNumber(real, imaginary));
        } catch (InputMismatchException e) {
            System.out.println("You inputted wrong format of number");
            in.nextLine();
        }
    }
    /**
     * Method that show whole list of complex numbers
     * @param list list of complex numbers
     */
    void Show_complex_number(ArrayList<ComplexNumber> list) {
        if (list.size() == 0) {
            System.out.println("There are no numbers");
            return;
        }
        int i = 1;
        for (ComplexNumber num : list) {
            System.out.print(i++ + ") ");
            num.display();
            System.out.println();
        }
    }
    /**
     * Method that make adding up two numbers from the list and then push the result in it
     * @param list list of complex numbers
     */
    void adding_up_complex_numbers(ArrayList<ComplexNumber> list) {
        if (list.size() < 2) {
            System.out.println("There are less than 2 created numbers, for adding up you should create at" +
                    " least 2 numbers");
            return;
        }
        System.out.println("Which numbers do you want to add up?");
        Show_complex_number(list);
        int no_1, no_2;
        try {
            no_1 = in.nextInt();
            no_2 = in.nextInt();
            ComplexNumber temp = (list.get(no_1 - 1).plus(list.get(no_2 - 1)));
            list.add(temp);
            temp.display();
            System.out.println();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You inputted wrong index");
            in.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error! !!!You inputted not a number!!! ");
            in.nextLine();
        }
    }
    /**
     * Method that make multiplying two numbers from the list and then push the result in it
     * @param list list of complex numbers
     */
    void multiply_complex_numbers(ArrayList<ComplexNumber> list) {
        if (list.size() < 2) {
            System.out.println("There are less than 2 created numbers, for adding up you should create at" +
                    " least 2 numbers");
            return;
        }
        System.out.println("Which numbers do you want to multiply?");
        Show_complex_number(list);
        int no_1, no_2;
        try {
            no_1 = in.nextInt();
            no_2 = in.nextInt();
            ComplexNumber temp = (list.get(no_1 - 1).multiply(list.get(no_2 - 1)));
            list.add(temp);
            temp.display();
            System.out.println();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You inputted wrong index");
            in.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error! !!!You inputted not a number!!! ");
            in.nextLine();
        }
    }
    /**
     * Method for filling creating matrix
     * @param matrix the particular matrix for filling
     * @return true - if matrix is successfully created, false - if isn't created because of errors by entering data
     */
    boolean fill_matrix(Matrix matrix) {
        System.out.println("If you wanna create matrix with regular numbers - enter 1, with complex numbers - enter 2");
        int mode;
        try{
            mode = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error! !!!You inputted not a number!!! ");
            in.nextLine();
            return false;
        }
        for (int i = 0; i < matrix.get_row(); i++) {
            for (int j = 0; j < matrix.get_column(); j++) {
                double real, imaginary;
                if(mode==1){
                    System.out.println("Please input the element" +
                            "[" + i + "]" + "[" + j + "]");
                }
                if(mode==2) {
                   System.out.println("Please input the real and imaginary part of element" +
                           "[" + i + "]" + "[" + j + "]");
               }
                try {
                    real = in.nextDouble();
                    if(mode==2) {
                        imaginary = in.nextDouble();
                        matrix.set_element(new ComplexNumber(real, imaginary), i, j);
                    }
                    else{
                        matrix.set_element(new ComplexNumber(real), i, j);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You inputted wrong format of number");
                    in.nextLine();
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Method that display matrix in correct form
     * @param matrix matrix for displaying
     */
    void display_matrix(Matrix matrix) {
        for (int i = 0; i < matrix.get_row(); i++) {
            for (int j = 0; j < matrix.get_column(); j++) {
                matrix.get_element(i,j).display();
            }
            System.out.println();
        }
    }
    /**
     * Method that show a particular number in trigonometric
     * form from the list
     * @param list list of complex numbers
     */
    void show_in_trigonometric(ArrayList<ComplexNumber> list){
        if (list.size() == 0) {
            System.out.println("There are no numbers");
            return;
        }
        System.out.println("What number do you want to see in trigonometric form?");
        Show_complex_number(list);
        int x;
        try {
            x = in.nextInt()-1;
            list.get(x).display_in_trigonometric();
        } catch (IndexOutOfBoundsException e){
            System.out.println("Index out of bounds");
        }
    }
    /**
     * Method that create a new one matrix and the push it to the respective list
     * @param list list of matrices
     */
    void creating_matrix(ArrayList<Matrix> list){
        System.out.println("Input amount of rows and columns:");
        try {
            int row = in.nextInt();
            int columns = in.nextInt();
            Matrix matrix = new Matrix(row, columns);
            if(fill_matrix(matrix)) {
                list.add(matrix);
            }
            else{
                System.out.println("Error in inputting elements");
            }
        }
        catch (InputMismatchException e){
            System.out.println("You inputted wrong format of number");
            in.nextLine();
        } catch (NegativeArraySizeException e){
            System.out.println("The size of array can't be negative");
        }
    }
    /**
     * Method that print list of matrices and their sizes
     * @param list list of matrices
     */
    void show_matrices(ArrayList<Matrix> list){
        if(list.size()==0){
            System.out.println("There are no matrices");
            return;
        }
        for(int i=0;i<list.size();i++){
            System.out.println(i+1+") matrix"+(i+1)+" "+ list.get(i).get_row()+"x"+list.get(i).get_column());
        }
    }

    /**
     * Method that print the certain matrix
     * @param list list of matrices
     */
    void show_a_matrix(ArrayList<Matrix> list){
        if(list.size()==0){
            System.out.println("There are no matrices");
            return;
        }
        System.out.println("What matrix do you want to see?");
        show_matrices(list);
        try {
            int x;
            x = in.nextInt() - 1;
            display_matrix(list.get(x));
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("You inputted wrong index");
        } catch (InputMismatchException e) {
            System.out.println("Error! !!!You inputted not a number!!! ");
            in.nextLine();
        }
    }

    /**
     * Method that adding up two matrices from the list and then push the result to it
     * @param list list of complex numbers
     */
     void add_up_matrices(ArrayList<Matrix> list){
         if (list.size() < 2) {
             System.out.println("There are less than 2 created matrices, for adding up you should create at" +
                     " least 2 matrices");
             return;
         }
        System.out.println("What matrices do you wanna to add up?\n" +
                "You can add up only matrices with the same sizes");
        show_matrices(list);
        try {
            int no_1 = in.nextInt() - 1;
            int no_2 = in.nextInt() - 1;
            if (list.get(no_1).get_row() != list.get(no_2).get_row() || list.get(no_1).get_column() != list.get(no_2).get_column()) {
                System.out.println("You cant add up matrices with different sizes");
            } else {
                Matrix temp = list.get(no_1).add_up(list.get(no_2));
                list.add(temp);
                display_matrix(temp);
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("You inputted wrong index");
        } catch (InputMismatchException e) {
            System.out.println("Error! !!!You inputted not a number!!! ");
            in.nextLine();
        }
     }
    /**
     * Method that multiply two matrices from the list and then push the result to it
     * @param list list of complex numbers
     */
     void multiply_matrices(ArrayList<Matrix> list){
         if (list.size() < 2) {
             System.out.println("There are less than 2 created matrices, for multiplying you should create at" +
                     " least 2 matrices");
             return;
         }
        System.out.println("What matrices do you wanna to add up?\n" +
                 "You can multiply only matrices with sizes N x M, R x L where M=R");
        show_matrices(list);
        try {
            int no_1 = in.nextInt() - 1;
            int no_2 = in.nextInt() - 1;
            if (list.get(no_1).get_column() != list.get(no_2).get_row()) {
                System.out.println("You can't multiply these matrices because amount of columns in matrix1 not equal to amount " +
                        "of rows in matrix2");
            } else {
                 Matrix temp = list.get(no_1).multiply_matrices(list.get(no_2));
                 list.add(temp);
                 display_matrix(temp);
            }
        } catch (IndexOutOfBoundsException e) {
             System.out.println("You inputted wrong index");
        } catch (InputMismatchException e) {
             System.out.println("Error! !!!You inputted not a number!!! ");
             in.nextLine();
        }
     }
    /** It is the method that takes matrix from
     * the list and then transpose particular one
     * with adding to this list
     * @param list - list of matrices
     */
     void transpose_matrix(ArrayList<Matrix> list){
         if(list.size()==0){
             System.out.println("There are no matrices");
             return;
         }
         System.out.println("What matrix do you wanna to transpose?");
         show_matrices(list);
         try {
             int no = in.nextInt() - 1;
             Matrix temp = list.get(no).transpose();
             list.add(temp);
             display_matrix(temp);
         }
         catch (IndexOutOfBoundsException e) {
             System.out.println("You inputted wrong index");
         } catch (InputMismatchException e) {
             System.out.println("Error! !!!You inputted not a number!!! ");
             in.nextLine();
         }
     }
}