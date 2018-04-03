package Task3;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IMatrixTest {
    @DataProvider
    public Object[][] testDeterminantData() {
        return new Object[][]{
                {new double[]{1, 2, 3, 4}, -2},
                {new double[]{0, 1, 2, 15}, -2}
//                {new double[]{1, 2, 2, 4}, 0},
        };
    }
    @DataProvider
    public Object[][] testInvertableMatrix(){
        return new Object[][]{
                {new double[]{1,2,3,4}, new double[] {-2,1,1.5,-0.5}},
             //   {new double[]{0,1,2,15}},
               // {new double[]{1,2,2,4} }//тут должно упасть))00))
        };
    }

    @Test
    public static void testConstructor() throws ErrorSizeException, NonSingularException, OutOfBorderException, ZeroDeterminantException {
        Matrix matrix = new Matrix(2);
        for(int i = 0; i<2; i++){
            matrix.changeElement(i,i,i+3);

        }
        InvertableMatrix obj = new InvertableMatrix(matrix);
        Assert.assertNotNull(obj);
    }

    @Test
    public static void testGetSize() throws ErrorSizeException, NonSingularException, OutOfBorderException, ZeroDeterminantException {
        Matrix matrix = new Matrix(10);
        for(int i = 0; i<10; i++){
            matrix.changeElement(i,i,i+3);

        }
        InvertableMatrix obj = new InvertableMatrix(matrix);

        Assert.assertEquals(obj.getSize(), 10);
    }

    @Test
    public void testGetElem() throws ErrorSizeException, OutOfBorderException, NonSingularException, ZeroDeterminantException {
        Matrix matrix = new Matrix(2);
        for(int i = 0; i<2; i++){
            matrix.changeElement(i,i,i+3);
        }
        InvertableMatrix obj = new InvertableMatrix(matrix);
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
    public static void testGetDeterminant(double[] a, double x) throws MyMatrixException {
        Matrix matrix = new Matrix((int) Math.sqrt(a.length));
        for(int i = 0; i<(int) Math.sqrt(a.length); i++){
            matrix.changeElement(i,i,i+3);
        }
        InvertableMatrix obj = new InvertableMatrix(matrix);
        for (int i = 0; i < Math.sqrt(a.length); i++) {
            for (int j = 0; j < Math.sqrt(a.length); j++) {
                obj.changeElement(i, j, a[i * (int) Math.sqrt(a.length) + j]);
            }
        }
        Assert.assertEquals(x, obj.determenant());

    }
    @Test(dataProvider = "testInvertableMatrix")
    public static void testGetInvertableMatrix(double[] a, double[] x) throws MyMatrixException {
        Matrix matrix = new Matrix((int)Math.sqrt(a.length));
        Matrix matrixOne = new Matrix((int)Math.sqrt(a.length));
        for(int i = 0; i <(int)Math.sqrt(a.length); i++){
            for(int j = 0; j<(int)Math.sqrt(a.length); j++){
                matrix.changeElement(i, j, a[i * (int) Math.sqrt(a.length) + j]);
            }
        }
        for(int i = 0; i <(int)Math.sqrt(a.length); i++){
            for(int j = 0; j<(int)Math.sqrt(a.length); j++){
                matrixOne.changeElement(i, j, x[i * (int) Math.sqrt(a.length) + j]);
            }
        }
        InvertableMatrix obj = new InvertableMatrix(matrix);
        InvertableMatrix objOne = new InvertableMatrix(matrixOne);
    Assert.assertEquals(obj.getInvertableMatrix(),objOne );
    }
}