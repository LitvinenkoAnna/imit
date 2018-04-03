package Task3;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class DemoMatrix {
    public static void writeStream(Matrix matrix, Writer file) throws IOException, OutOfBorderException {
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                file.write(matrix.getElement(i, j) + " ");
            }
            file.write("\n");
        }
        file.close();
    }

    public static void readStream(IMatrix matrix, Scanner file) throws IOException, ZeroDeterminantException, OutOfBorderException {
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                matrix.changeElement(i, j, file.nextDouble());
            }
        }
    }

    public static double calculateTheAmount(Matrix matrix) throws OutOfBorderException {
        double sum = 0;
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                sum += matrix.getElement(i, j);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ZeroDeterminantException, OutOfBorderException {
        BufferedWriter file = null;
        Matrix matrix = null;
        try {
            matrix = new Matrix(3);
            for (int i = 0; i < 3; i++) {
                matrix.changeElement(i, i, i + 1);
            }
        } catch (ErrorSizeException e) {
            System.err.println("Размер должен быть положительный!");
        }
        InvertableMatrix invertableMatrix = null;
        invertableMatrix = new InvertableMatrix(matrix);
//        try {
//            invertableMatrix = new InvertableMatrix(matrix);
//        } catch (NonSingularException e) {
//            System.err.println("Матрица не обращается!");
//        } catch (ErrorSizeException e) {
//            System.err.println("Размер должен быть положительный!");
//        } catch (OutOfBorderException e) {
//            System.err.println("Выход за границу матрицы!");
//        }
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter("C:\\Users\\Student\\Desktop\\55.txt"));
            writeStream(matrix, write);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OutOfBorderException e) {
            e.printStackTrace();
        }
        Scanner s = null;
        try {
            s = new Scanner(new FileInputStream("C:\\Users\\Student\\Desktop\\1.txt"));
            s.useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            readStream(matrix, s);
            s = new Scanner(new FileInputStream("C:\\Users\\Student\\Desktop\\1.txt"));
            readStream(invertableMatrix, s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Size: " + matrix.getSize());//выполняем методы классов
        System.out.println("Determinant :" + invertableMatrix.determenant());
        try {
            System.out.println("Get Element : " + invertableMatrix.getElement(1, 4));
        } catch (OutOfBorderException e) {
            System.err.println("Выход за границу матрицы!");
        }
        System.out.println(matrix.toString());
        System.out.println(invertableMatrix.toString());
        //cериализация
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("C:\\Users\\Student\\Desktop\\3.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // ObjectOutputStream oos = null;
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(matrix);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //десериализация
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\Student\\Desktop\\3.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matrix newMatrix;
        try {
            newMatrix = (Matrix) ois.readObject();
            System.out.println(newMatrix.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Add : " + calculateTheAmount(matrix));
        } catch (OutOfBorderException e) {
            e.printStackTrace();
        }
    }
}