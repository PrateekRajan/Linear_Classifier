import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Intersection_feature 
{
	public static double intersection()
	{
		int i=0;
		int j=0;
		int k=0;
		double intersection=0;
		double r_intersection=0;
		double temp1=0;double temp2=0;double temp3=0;
		double arr[][]=new double[3][];
		arr[0]= new double[1000];
		arr[1]= new double[1000];
		arr[2]= new double[1000];
		int length=0;
		try
		{
			FileInputStream fstream = new FileInputStream("C:\\Documents and Settings\\Pankaj\\workspace\\NumericalRecognizer\\Test_Data\\Text.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String input;
			while((input=br.readLine() )!= null)
			{
				String [] str= input.split(",");
				Float x1 = new Float(str[0]);
				Float y1 = new Float(str[1]);
				Float z1 = new Float(str[2]);
				
				arr[0][i]=x1;
				arr[1][j]=y1;
				arr[2][k]=z1;
				i++;
				j++;
				k++;
				
			}
			br.close();
			in.close();
			fstream.close();
			
		}
		catch(Exception e)
		{
			System.out.print(e.getLocalizedMessage());
		}
		for(i=0;i<arr[0].length-1;i++){
			if(arr[0][i]==0)
			{
				length=i-1;
				break;
			}
		}
		

		for(int p=0;p<length-1;p++)
		{
			for(int q=p+1;q<length-1;q++)
			{
				temp1= Math.pow(arr[1][q]-arr[1][p],2);
				temp2= Math.pow(arr[0][q]-arr[0][p], 2);
				temp3= Math.pow(temp1+temp2, 0.5);
				if(temp3<=2 | (arr[0][p]==arr[0][q] && arr[1][p]==arr[1][q] && arr[2][p]!= arr[2][q]))
				{
					intersection=intersection+0.5;
				}
		
			}
		}
					System.out.println(intersection);

					return intersection;
	}


}
