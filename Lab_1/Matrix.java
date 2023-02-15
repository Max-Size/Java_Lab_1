/**
 * This is class which describe
 * a new data type - Matrix
 * @author Maxim Seleznev
 */
public class Matrix {
    /**
     * Class field of amount of rows in matrix
     */
    private final int row;
    /**
     * Class field of amount of columns in matrix
     */
    private final int column;
    /**
     * Class field of matrix
     */
    private ComplexNumber[][] matrix;
    /**
     * Constructor for empty matrix
     */
    Matrix(){
        this(0,0);
    }
    /**
     * Constructor for matrix
     * @param row amount of rows
     * @param column amount of columns
     */
    Matrix(int row,int column){
        this.row=row;
        this.column=column;
        matrix = new ComplexNumber[row][column];
    }
    /**
     * Method that can get amount of row
     * @return amount of row
     */
    int get_row(){
        return row;
    }
    /**
     * Method that can get amount of columns
     * @return amount of columns
     */
    int get_column(){
        return column;
    }
    /**
     * Method that is setting the particular element on
     * the specific position in matrix
     * @param num number, that you want to set
     * @param row number of row where you want to set it
     * @param column number of column where you want to set it
     */
    void set_element(ComplexNumber num,int row,int column){
        matrix[row][column] = num;
    }
    /**
     * Method that could give an element from the certain position
     * @param row number of element's row
     * @param column number of element's column
     * @return element on [row][column] position from this matrix
     */
    ComplexNumber get_element(int row,int column){
        return matrix[row][column];
    }
    /**
     * This method adding up current matrix and another one
     * @param matrix1 second summand
     * @return result of addition
     */
    Matrix add_up(Matrix matrix1){
        Matrix sum = new Matrix(matrix1.get_row(), matrix1.get_column());
        for(int i=0;i<matrix1.get_row();i++){
            for(int j=0;j< matrix1.get_column();j++){
                ComplexNumber num = matrix1.get_element(i,j).plus(get_element(i,j));
                sum.set_element(num,i,j);
            }
        }
        return sum;
    }
    /**
     * The method which calculates element
     * in result of multiplying certain matrix on another one for
     * specific position
     * @param matrix  second multiplier
     * @param row number of row of new element which should be created by multiplying
     * @param column  number of column of new element which should be created by multiplying
     * @return the result of multiplying
     */
    ComplexNumber get_multiplying_element(Matrix matrix,int row,int column){
        ComplexNumber element = new ComplexNumber();
        int row_m1 = row;
        int column_m1 = 0;
        int row_m2 = 0;
        int column_m2 = column;
        while (column_m1<get_column() && row_m2< matrix.get_row()){
            ComplexNumber temp = get_element(row_m1,column_m1).multiply(matrix.get_element(row_m2,column_m2));
            element = element.plus(temp);
            column_m1++; row_m2++;
        }
        return element;
    }
    /**
     * This method multiply current matrix
     * on another one
     * @param matrix second multiplier
     * @return the product of multiplication
     */
    Matrix multiply_matrices(Matrix matrix){
        Matrix temp = new Matrix(get_row(), matrix.get_column());
        for(int i=0;i<get_row();i++){
            for(int j=0;j< matrix.get_column();j++){
                ComplexNumber num = this.get_multiplying_element(matrix,i,j);
                temp.set_element(num,i,j);
            }
        }
        return  temp;
    }
    /**
     * This method transpose the current matrix
     * @return new object - transposed matrix
     */
    Matrix transpose(){
        Matrix temp = new Matrix(get_column(),get_row());
        for(int i=0;i<get_row();i++){
            for(int j=0;j<get_column();j++){
                temp.set_element(get_element(i,j),j,i);
            }
        }
        return temp;
    }
}
