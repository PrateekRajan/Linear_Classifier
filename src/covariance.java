import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class covariance {
	private ArrayList<double[][]> covarianceList;
	private int numberOfClasses = 10;

	public ArrayList<double[][]> makeList() {

		covarianceList = new ArrayList<double[][]>(10);
		for (int x = 0; x <= numberOfClasses - 1; x++) {
			double[][] covar = new double[10][5];
			int i = 0;
			int j = 0;
			try {

				FileInputStream fstream = new FileInputStream("class " + x
						+ "\\feature_vector.txt");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(
						new InputStreamReader(in));
				String input;

				while ((input = br.readLine()) != null) {
					if (input.length() > 0 & j < 10) {
						// System.out.print(j+"Column"+x+" ");
						String[] temp = input.split(",");
						// System.out.println(input.split(",").length);
						covar[j][i] = new Double(temp[0]);
						covar[j][i + 1] = new Double(temp[1]);
						covar[j][i + 2] = new Double(temp[2]);
						covar[j][i + 3] = new Double(temp[3]);
						covar[j][i + 4] = new Double(temp[4]);
						j++;

					}
				}

				br.close();
				in.close();
				fstream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			covar = MatrixMaths.calculateCovarianceMatrix(covar);
			covarianceList.add(covar);

		}
		return covarianceList;
	}

	public static double[][] inverse() {
		covariance c = new covariance();
		c.makeList();

		// System.out.println(Arrays.deepToString(covar));
		MatrixMaths obj = new MatrixMaths();
		double[][] commoncovar = MatrixMaths.commonCovariance(c.covarianceList);
		double[][] inverse = obj.calculateMatrixInverse(commoncovar);
		// System.out.println(Arrays.deepToString(inverse));
		// System.out.print(inverse.length);
		return inverse;

	}

	public static void main(String args[]) {
		covariance objc = new covariance();
		objc.inverse();

		// System.out.println(Arrays.deepToString(inverse));
		// System.out.println("The length is"+inverse.length);

		// double [][] commoncovar= new double[10][5];

	}

}
