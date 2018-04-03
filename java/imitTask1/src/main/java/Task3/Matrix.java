package Task3;

import java.io.Serializable;
import java.util.Arrays;

public class Matrix implements IMatrix, Serializable{
    private int N;
    private double[] matrix;
    private double determinant;
    private boolean flag;

    public Matrix(int N)throws ErrorSizeException{


        if(N<0) {
            throw new ErrorSizeException();
        }
        this.N=N;
        matrix = new double[N*N];
    }

    public Matrix(Matrix copy) {
        this.N = copy.N;
        matrix = new double[N*N];
        for (int i=0; i<N*N; i++) {
            this.matrix[i] = copy.matrix[i];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix1 = (Matrix) o;

        if (N != matrix1.N) return false;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = N;
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    public double getElement(int x, int y)throws OutOfBorderException{
        if((x>N-1)&&(y>N-1)&&(x<0)&&(y<0)){
            throw new OutOfBorderException();
        }
        return matrix[x * N + y];
    }


    public void changeElement(int x, int y, double newElem) throws OutOfBorderException {
         matrix[x  * N + y] = newElem;
         flag = false;
    }

    public double determenant() {
        double det=determinant;
        if(!flag) {
            det=1;
            int h = 0;
            double buf2;
            double[] buf = new double[N*N];
            for(int i=0; i<N*N; i++){
                buf[i]=matrix[i];
            }
            for (int i = 1; i < N; i++) {
                if (buf[h] == 0.0) {
                    for(int k=0; k<N; k++){
                        if(buf[k*N+h]!=0){
                            for(int t=0; t<N; t++){
                                buf[h+t]=buf[h+t]+buf[k*N+h+t];
                            }
                            break;
                        }
                        if(k==N-1){
                            det=0;
                        }
                    }
                }
                if (det == 0) {
                    break;
                }
                for (int q = i; q < N; q++) {
                    buf2 = buf[h + (q - i + 1) * N];
                    for (int j = 0; j < N; j++) {
                        buf[j + N * q] = buf[j + N * q] - (buf[j + (i - 1) * N] / buf[h] * buf2);
                    }
                }
                det *= buf[h];
                h += (N + 1);
            }
            det *= buf[h];
        }
        this.determinant = det;
        flag = true;
        return determinant;
    }
    public int getSize(){
        return N;

    }

    @Override
    public String toString() {
        return "Matrix{" +
                "N = " + N +
                ", matrix = " + Arrays.toString(matrix) +
                '}';
    }
    public void changeString(int stringOne, int stringTwo){
        double[] tempString = new double[N];
        for(int i = 0; i<N; i++){
            tempString[i] = matrix[stringTwo*N+i];
        }
        for(int i = 0; i<N; i++){
            matrix[stringTwo*N+i] = matrix[stringOne*N+i];
        }
        for(int i = 0; i<N; i++){
            matrix[stringOne*N+i] = tempString[i];
        }
    }
    public void swapLines(int ind1, int ind2) throws OutOfBorderException{
        if (ind1 >= N || ind2 >= N) {
            throw new OutOfBorderException();
        }
        double temp;
        for (int i = 0; i < N; i++) {
            temp = matrix[ind1 * N + i];
            matrix[ind1 * N + i] = matrix[ind2 * N + i];
            matrix[ind2 * N + i] = temp;
        }
    }
    public void addLine(int subInd, int resInd, double coef) throws OutOfBorderException {
        if (subInd >= N || resInd >= N) {
            throw new OutOfBorderException();
        }
        for (int i = 0; i < N; i++) {
            matrix[resInd * N + i] += matrix[subInd * N + i]*coef;
        }
    }
    public void multLine(int ind, double coef) throws OutOfBorderException {
        if (ind >= N) {
            throw new OutOfBorderException();
        }
        for (int i = 0; i < N; i++) {
            matrix[ind * N + i] *= coef;
        }
    }

}
