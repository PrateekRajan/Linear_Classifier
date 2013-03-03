import java.io.*;

public class DCR {

	public static void main(String args[]) {
		System.out.println(calculateDCR());
	}

	public static double calculateDCR() {
		int i = 0, j = 0, k = 0;
		double[][] arr = new double[3][];
		arr[0] = new double[1000];// Use dynamic arrays in other programs
		arr[1] = new double[1000];
		arr[2] = new double[1000];

		try {
			FileInputStream fstream = new FileInputStream("C:\\Documents and Settings\\Pankaj\\workspace\\NumericalRecognizer\\Test_Data\\Text.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String input;
			while ((input = br.readLine()) != null) {
				String[] str = input.split(",");
				Double x1 = new Double(str[0]);
				Double y1 = new Double(str[1]);
				Double z1 = new Double(str[2]);

				arr[0][i] = x1;
				arr[1][j] = y1;
				arr[2][k] = z1;
				i++;
				j++;
				k++;
			}
			br.close();
			in.close();
			fstream.close();

		} catch (Exception e) {
			System.out.print(e.getLocalizedMessage());
		}

		int length = k;
		int fivePercent = length / 20;
		int lowerBound = fivePercent;
		int upperBound = length - fivePercent;
		int totalStrokeLength = 0;
		double d_current = 0, d_previous = 0, x_current = 0, y_current = 0, x_previous = 0, 
			y_previous = 0, d_change = 0, d_changeTotal = 0, d_changeMax = 0;
		x_previous = arr[0][lowerBound];
		x_current = arr[0][lowerBound + 1];
		y_previous = arr[1][lowerBound];
		y_current = arr[1][lowerBound + 1];
		d_current = calculateDirection(x_current, y_current, x_previous, y_previous);
		
		for (i = lowerBound + 2, j = lowerBound + 2; i < upperBound; i++, j++) {
			d_previous = d_current;
			x_previous = x_current;
			y_previous = y_current;
			x_current = arr[0][i];
			y_current = arr[1][j];
			d_current = calculateDirection(x_current, y_current, x_previous, y_previous);
			d_change = Math.abs(d_current - d_previous);
			d_changeTotal = d_changeTotal + d_change;
			if (d_change > d_changeMax) {
				d_changeMax = d_change;
			}
			totalStrokeLength++;
		}
		
		double d_changeAverage = d_changeTotal / totalStrokeLength;
//		System.out.println("This is the max change in direction " + d_changeMax);
//		System.out.println("This is the average change in direction " + d_changeAverage);
		return d_changeMax / d_changeAverage;
		
	}

	public static double calculateDirection(double x_current, double y_current,
			double x_previous, double y_previous) {
		return Math.atan((y_current - y_previous) / (x_current / x_previous));
	}
}
