package Task3;

public interface IMatrix {
    public double getElement(int x, int y) throws OutOfBorderException;
    public void changeElement(int x, int y, double newElem) throws OutOfBorderException, ZeroDeterminantException;
    public double determenant();
    public int getSize();
}
