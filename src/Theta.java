import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;




public class Theta {
	
	public static double getTheta (double x, double xPrevious, double y, double yPrevious)
	{
		double top = x*yPrevious - xPrevious*y;
		double bottom = x*xPrevious + y*yPrevious;
		double theta = Math.atan(top/bottom);
		
		return theta;
	}
	
	public static double calculateThetaSum ()
	{
		int i = 0, j = 0, k = 0;
		double[][] arr = new double[3][];
		arr[0] = new double[1000];// Use dynamic arrays in other programs
		arr[1] = new double[1000];
		arr[2] = new double[1000];

		try {
			FileInputStream fstream = new FileInputStream("Test_Data\\Text.txt");
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
		double sum = 0;
		double xCurrent;
		double xPrevious;
		double yCurrent;
		double yPrevious;
		for(int count = 1; count < j - 1; count++)
		{
			xCurrent = arr[0][count];
			xPrevious = arr[0][count - 1];
			yCurrent = arr[1][count];
			yPrevious = arr[1][count - 1];
			sum = sum + getTheta(xCurrent, xPrevious, yCurrent, yPrevious);
		}
	//	System.out.print(sum);
		return sum;
	}
	public static void main(String args[])
	{
		System.out.println(calculateThetaSum());
	}
}
