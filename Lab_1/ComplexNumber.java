/**
 * This is class which describe
 * a new data type - Complex number
 * @author Maxim Seleznev
 */
public class ComplexNumber {
    /**
     * Class field that contains real part of
     * complex number
     */
    private double real;
    /**
     * Class field that contains imaginary part of
     * complex number
     */
    private double imaginary;
    /**
     * Constructor for empty element
     */
    ComplexNumber(){
        this(0,0);
    }
    /**
     * Constructor for element which only consists of real part
     */
    ComplexNumber(double real){
        this(real,0);
    }
    /**
     * Constructor for element which consists of real and imaginary part
     */
    ComplexNumber(double real,double imaginary){
        this.real=real; this.imaginary=imaginary;
    }
    /**
     * Method that set the imaginary part of complex number
     * @param imaginary number that you want to be imaginary part
     */
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
    /**
     * Method that return the imaginary, even it if equal 0
     * @return number - imaginary part
     */
    public double getImaginary() {
        return imaginary;
    }
    /**
     * Method that set the real part of complex number
     * @param real number that you want to be real part
     */
    public void setReal(double real) {
        this.real = real;
    }
    /**
     * Method that return the real, even it if equal 0
     * @return number - real part
     */
    public double getReal() {
        return real;
    }
    /**
     * Method that make adding up current number with another one
     * @param c_n second summand
     * @return result of addition
     */
    ComplexNumber plus(ComplexNumber c_n){
        ComplexNumber temp = new ComplexNumber();
        temp.setReal(getReal()+c_n.getReal());
        temp.setImaginary(getImaginary()+c_n.getImaginary());
        return temp;
    }
    /**
     * Method that make multiplying current number with another one
     * @param c_n second multiplier
     * @return result of multiplying
     */
    ComplexNumber multiply(ComplexNumber c_n){
        ComplexNumber temp = new ComplexNumber();
        temp.setReal(getReal()*c_n.getReal()-getImaginary()*c_n.getImaginary());
        temp.setImaginary(getReal()*c_n.getImaginary()+getImaginary()*c_n.getReal());
        return temp;
    }
    /**
     * Method that displays current number
     */
    void display(){
        if(imaginary==0){
            System.out.print(real+" ");

        } else if(imaginary>0) {
            System.out.print(real + "+" + imaginary + "i  ");
        }
        else{
            System.out.print(real +""+ imaginary + "i  ");
        }
    }
    /**
     * Method that displays current number in trigonometric form
     */
    void display_in_trigonometric(){
        double r=Math.sqrt(real*real+ imaginary*imaginary);
        double fi = 0;
        if(real>0 ) {
            fi = Math.atan(imaginary / real)*57.3;
        } else if(real<0 && imaginary>=0){
            fi = Math.atan(imaginary / real )* 57.3 + Math.PI;
        } else if(real<0 && imaginary<=0){
            fi = Math.atan(imaginary / real )* 57.3 - Math.PI;
        }
        System.out.printf("%.2f ( cos(%.2f°) + i sin(%.2f°))%n",r,fi,fi);
    }
}
