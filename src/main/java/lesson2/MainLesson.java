package lesson2;

import java.util.Arrays;

public class MainLesson {
    public static void main(String[] args) {
        int[] array1 = {1,0,1,1,0,0,1};
        int[] array2 = {1,5,3,2,11,4,5,2,4,8,9,1};
        int[] array3 = {1,5,3,2,11,4,5,2,4,8,9,1};
        int[] array4 = {1, 1, 1, 2, 1};
        int[] array5 = {1, 1, 1, 2, 2};
        int[] array6 = {2, 2, 2, 1, 2, 2, 10, 1};

        System.out.println("Array "+ Arrays.toString(array1) + " after invert: " + Arrays.toString(invertElements(array1)));

        System.out.println("Array (exercise 2): " + Arrays.toString(fillArray()));
        System.out.println("Array (exercise 3): " + Arrays.toString(multiplyUnderTheCondition(array2)));

        System.out.println("Matrix with units on the diagonals: ");
        printMatrix(fillMatrixDiagonal(6));

        System.out.println("In the array " + Arrays.toString(array3) + " maximum element: " + maxElement(array3));
        System.out.println("In the array " + Arrays.toString(array3) + " minimum element: " + minElement(array3));

        System.out.println("In the array " + Arrays.toString(array4) + " presence of a balance: " + checkBalance(array4));
        System.out.println("In the array " + Arrays.toString(array5) + " presence of a balance: " + checkBalance(array5));
        System.out.println("In the array " + Arrays.toString(array6) + " presence of a balance: " + checkBalance(array6));

    }

    public static int[] invertElements(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 0)
                arr[i] = 1;
            else if (arr[i] == 1)
                arr[i] = 0;
            else {
                System.out.println("incorrect array element №" + (i+1));
                return arr;
            }
        //arr[i] = (arr[i]==0) ? 1 : 0; - better
        }
        return arr;
    }

    public static int[] fillArray(){
        int[] arr = new int [8];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i*3;
        }
        return arr;
    }

    public static int[] multiplyUnderTheCondition(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 6)
                arr[i] *= 2;
        }
        return arr;
    }

    public static int[][] fillMatrixDiagonal(int dimension){
        int[][] matrix = new int[dimension][dimension];
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                if(i == j || (i + j + 1) == dimension){
                    matrix[i][j] = 1;
                }
                else
                    matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    public static int[][] matrixDiagonal(int[][] matrix){
    	for(int i = 0; i < matrix.length; i++){
    		matrix[i][i] = 1;
    		matrix[i][(matrix.length - 1)-i] = 1;
    	}
    	return matrix;
    }

    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int maxElement(int[] arr){
        int result = arr[0];
        for (int i = 0; i < arr.length; i++){
            if(result <= arr[i])
                result = arr[i];
        }
        return result;
    }

    public static int minElement(int[] arr){
        int result = arr[0];
        for (int i = 0; i < arr.length; i++){
            if(result > arr[i])
                result = arr[i];
        }
        return result;
    }

    public static boolean checkBalance(int[] arr){
        boolean result = false;
        for(int i = 0; i < arr.length; i++){
            if(sumOfSubArr(arr, 0, i) == sumOfSubArr(arr, (i+1), (arr.length-1))){
                result = true;
                return result;
            }
        }
        return result;
    }

    public static int sumOfSubArr(int[] arr, int start, int end){
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum +=arr[i];
        }
        return sum;
    }
}