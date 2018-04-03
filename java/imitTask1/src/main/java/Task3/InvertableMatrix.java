package Task3;

import java.io.Serializable;
import java.util.Arrays;

public class InvertableMatrix extends Matrix implements IInvertableMatrix, Serializable {
//    private Matrix matrix;
//    private double[] m;

//    public double getElement(int x, int y) throws OutOfBorderException {
//        return matrix.getElement(x, y);
//    }

//????
//    public void changeElement(int x, int y, double newElem) throws OutOfBorderException, ZeroDeterminantException {
//        double temp = super.getElement(x,y);
//        super.changeElement(x, y, newElem);
//        if(Math.abs(super.determenant()) == 0){
//            super.changeElement(x,y,temp);
//            throw new ZeroDeterminantException();
//        }
//    }

//    public double determenant() {
//
//        return matrix.determenant();
//    }

    public InvertableMatrix(int N) throws ErrorSizeException, OutOfBorderException {
        super(N);
        for(int i = 0; i<N; i++){
            super.changeElement(i,i,1.0);
        }

    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        InvertableMatrix that = (InvertableMatrix) o;
//
//        if (matrix != null ? !matrix.equals(that.matrix) : that.matrix != null) return false;
//        return Arrays.equals(m, that.m);
//    }

//    @Override
//    public int hashCode() {
//        int result = matrix != null ? matrix.hashCode() : 0;
//        result = 31 * result + Arrays.hashCode(m);
//        return result;
//    }


    public InvertableMatrix(Matrix copy) throws ZeroDeterminantException {
        super(copy);
        if(Math.abs(this.determenant()) == 0){
            throw new ZeroDeterminantException();
        }

      }
//    public void swapLines(int ind1, int ind2) throws OutOfBorderException{
//        matrix.swapLines(ind1, ind2);
//
//    }
//    public void addLine(int subInd, int resInd, double coef) throws OutOfBorderException {
//        matrix.addLine(subInd,resInd,coef);
//    }
//    public void multLine(int ind, double coef) throws OutOfBorderException {
//
//        matrix.multLine(ind, coef);
//    }
//    public InvertableMatrix(Matrix matrix) throws NonSingularException, ErrorSizeException, OutOfBorderException {
//        if (matrix.determenant() == 0) {
//            throw new NonSingularException();
//        }
//        int size = matrix.getSize();
//        this.matrix = new Matrix(matrix.getSize());
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                this.matrix[], j, matrix.getElement(i, j));
//            }
//        }
//    }

public IMatrix getInvertableMatrix() throws MyMatrixException {
    double coef, coef2;
    InvertableMatrix res = new InvertableMatrix(this.getSize());
    InvertableMatrix buf = new InvertableMatrix(this);
    for (int i = 0; i < this.getSize(); i++) {
        if (buf.getElement(i, i) == 0.0) {
            for (int j = i + 1; j < this.getSize(); j++) {
                if (buf.getElement(j, i) != 0.0) {
                    for (int k = i; k < this.getSize(); k++) {
                        buf.swapLines(i,j);
                    }
                    break;
                }
            }
        }
        res.multLine(i, 1/buf.getElement(i,i));
        buf.multLine(i, 1/buf.getElement(i,i));
        for(int j=i+1; j<this.getSize(); j++){
            res.addLine(i, j, -buf.getElement(j, i));
            buf.addLine(i, j, -buf.getElement(j, i));
        }
    }
    for(int i=this.getSize()-1; i>=0; i--){
        for(int j=i-1; j>=0; j--){
            res.addLine(i, j, -buf.getElement(j, i));
            buf.addLine(i, j, -buf.getElement(j, i));
        }
    }
    return res;
}
//    public void changeString(int stringOne, int stringTwo) {
//       .changeString(stringOne, stringTwo);
//    }

//    @Override
//    public String toString() {
//        return "InvertableMatrix{" +
//                "matrix = " + matrix.toString() +
//                ", m = " + Arrays.toString(m) +
//                '}';
//    }

//    public int getSize() {
//        return matrix.getSize();
//    }

}
