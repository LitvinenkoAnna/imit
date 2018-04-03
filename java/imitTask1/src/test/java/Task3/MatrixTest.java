package Task3;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MatrixTest {
    @DataProvider
    public Object[][] testDeterminantData() {
        return new Object[][]{
                {new double[]{0, 0, 0, 0}, 0},
                {new double[]{1, 2, 3, 4}, -2},
                {new double[]{0, 1, 2, 15}, -2},
                {new double[]{1, 2, 2, 4}, 0},
                {new double[]{1,5,7,8,7,8,7,0,1}, -96},
        };
    }

    @Test
    public static void testConstructor() throws ErrorSizeException {

        Matrix obj = new Matrix(10);
        Assert.assertNotNull(obj);
    }

    @Test
    public static void testGetSize() throws ErrorSizeException {
        Matrix obj = new Matrix(10);
        Assert.assertEquals(obj.getSize(), 10);
    }

    @Test
    public void testGetElem() throws ErrorSizeException, OutOfBorderException, ZeroDeterminantException {
        Matrix obj = new Matrix(2);
        obj.changeElement(0, 0, 1);
        obj.changeElement(0, 1, 0);
        obj.changeElement(1, 0, 12);
        obj.changeElement(1, 1, 4);
        Assert.assertNotEquals(obj.getElement(0, 0), 1);
        Assert.assertNotEquals(obj.getElement(0, 1), 0);
        Assert.assertNotEquals(obj.getElement(1, 0), 12);
        Assert.assertNotEquals(obj.getElement(1, 1), 4);

    }


    @Test(dataProvider = "testDeterminantData")
    public static void testGetDeterminant(double[] a, double x) throws OutOfBorderException, ErrorSizeException, ZeroDeterminantException {
        Matrix obj = new Matrix((int) Math.sqrt(a.length));
        for (int i = 0; i < Math.sqrt(a.length); i++) {
            for (int j = 0; j < Math.sqrt(a.length); j++) {
                obj.changeElement(i, j, a[i * (int) Math.sqrt(a.length) + j]);
            }
        }
        Assert.assertEquals(obj.determenant(), x, 0.000001);
    }
}
