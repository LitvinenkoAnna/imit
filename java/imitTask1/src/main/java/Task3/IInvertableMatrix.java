package Task3;

public interface IInvertableMatrix extends IMatrix {
    public IMatrix getInvertableMatrix() throws ErrorSizeException, OutOfBorderException,
            NonSingularException, OutOfBorderException, ZeroDeterminantException, MyMatrixException;
}
