import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.math3.stat.correlation.*;
import org.apache.commons.math3.linear.*;


public class MatrixMaths {

	public static void main(String args[]) {

		double[] v1 = new double[3];
		v1[0] = 1;
		v1[1] = 3;
		v1[2] = 2;
		double[] v2 = new double[3];
		v2[0] = 4;
		v2[1] = 1;
		v2[2] = 7;
		//System.out.println(getDotProduct(v1,v2));
	}
	
	public static double getDotProduct(double[] vector1, double[] vector2)
	{
//		System.out.println("dot vector 1 length = " + vector1.length);
//			System.out.println("dot vector 2 length = " + vector2.length);
		ArrayRealVector v1 = new ArrayRealVector(vector1);
		ArrayRealVector v2 = new ArrayRealVector(vector2);
		double dotProduct = v1.dotProduct(v2);
		return dotProduct;
	}
	public static double[] getVector(double [][] matrix)
	{
		int length= matrix.length;
		//System.out.println(Arrays.deepToString(matrix));
		Array2DRowRealMatrix myMatrix = new Array2DRowRealMatrix(matrix);
		double [] temp_vector = null;
		//System.out.println("row = " + myMatrix.getRowDimension());
		//System.out.println("column = " + myMatrix.getColumnDimension());
		if(myMatrix.getColumnDimension() == 1)
		{
			temp_vector = myMatrix.getColumn(0);
		} else if (myMatrix.getRowDimension() == 1)
		{
			temp_vector = myMatrix.getRow(0);
		}
		
//		double [] temp_vector= new double[5];
//		for(int i=0; i<=length-1;i++)
//		{
//			temp_vector[i]=matrix[0][i];
//			System.out.println(temp_vector[i]);
//		}
//		temp_vector[0]=matrix[0][0];
//		temp_vector[1]=matrix[1][0];
//		temp_vector[2]=matrix[2][0];
//		temp_vector[3]=matrix[3][0];
//		temp_vector[4]=matrix[4][0];
//		
		return temp_vector;
	}

	public static double[][] calculateCovarianceMatrix(double[][] matrix) {
		Covariance mat = new Covariance(matrix);
		RealMatrix covMatrix = mat.getCovarianceMatrix();
		return covMatrix.getData();
	}

	public static double[][] calculateMatrixInverse(double[][] matrix) {
		RealMatrix m = new Array2DRowRealMatrix(matrix);
		RealMatrix pInverse = new LUDecomposition(m).getSolver().getInverse();

		return pInverse.getData();
	}

	public static int getMaxIndex(double [] vector) {
		
		int maxIndex = 0;
		double maxValue = vector[0];
		for (int i = 1; i < vector.length; i++) {
			if (vector[i] > maxValue) {
				maxValue = vector[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	

	public static double getDeterminant(double[][] matrix) {
		RealMatrix m = new Array2DRowRealMatrix(matrix);
		double det = new LUDecomposition(m).getDeterminant();
		return det;
	}

	public static double[] meanFeatureVector(double[][] matrix) {
		int column = 0;
		int row = 0;
		double sum = 0;
		double returnMatrix[] = new double[matrix[0].length];
		for (column = 0; column < matrix[0].length; column++) {
			sum = 0;
			for (row = 0; row < matrix.length; row++) {
				sum = sum + matrix[row][column];
			}
			returnMatrix[column] = sum / (double) matrix.length;
		}
		return returnMatrix;
	}

	public static double[][] matrixSum(double[][] matrix1, double[][] matrix2) {
		RealMatrix m1 = new Array2DRowRealMatrix(matrix1);
		RealMatrix m2 = new Array2DRowRealMatrix(matrix2);
		RealMatrix mSum = m1.add(m2);
		return mSum.getData();
	}

	public static double[][] commonCovariance(
			ArrayList<double[][]> covarianceList) {
		double[][] common = new double[covarianceList.get(0).length][covarianceList
				.get(0)[0].length];
		for (double[][] matrix : covarianceList) {
			matrix = matrix;
			common = matrixSum(common, matrix);
		}
		// System.out.println(Arrays.deepToString(common));
		return division(common, 90.0);
	}

	// public static double[][] transpose(double[][] matrix)
	// {
	// int len=matrix.length;
	// int c=matrix[len].length;
	// double [][]transpose=new double[c][len];
	// for(int i=0;i<len;i++)
	// {
	// for(int j=0;j<c;j++)
	// {
	// transpose[j][i]=matrix[i][j];
	// }
	// }
	// return transpose;
	// }
	public static double[][] transpose(double[] matrix) {
		double[][] trans = new double[5][1];
		for (int i = 0; i <= matrix.length - 1; i++) {
			trans[i][0] = matrix[i];
		}
		// System.out.println(Arrays.deepToString(trans));
		return trans;
	}

	public static double[][] multiply(double[][] matrix1, double[][] matrix2) {
		Array2DRowRealMatrix mat1 = new Array2DRowRealMatrix(matrix1);
		Array2DRowRealMatrix mat2 = new Array2DRowRealMatrix(matrix2);
		Array2DRowRealMatrix multiply = mat1.multiply(mat2);
		// double [][]multiply= new double[5][1];
		// int length1=matrix1.length;
		// int length2=matrix2.length;
		// for(int i = 0; i < length1; i++)
		// {
		// for(int j = 0; j < length2-1; j++)
		// {
		// for(int k = 0; k < length2-1; k++)
		// {
		//			  
		// multiply[i][j] += matrix1[i][k]*matrix2[k][j];
		// }
		// }
		// }
		return multiply.getData();
	}

	public static double[][] division(double[][] matrix, double divisor) {
		for (int i = 0; i < matrix.length; i++)
		{
			for(int j =0; j< matrix[0].length;j++)
			{
				matrix[i][j] = matrix[i][j]/ divisor;
			}
		}
		return matrix;
	}
}
