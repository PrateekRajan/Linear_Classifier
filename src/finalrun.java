import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

//This is the class that would be run for recognition purpose

public class finalrun
{
	public static int max_index;

	public static void recognize()
	{
		
		classifier newobj= new classifier();
		double [][]tempFV= newobj.feature_vector();
//		System.out.println("Matrix"+Arrays.deepToString(tempFV));
		double[] feature_vector=MatrixMaths.getVector(tempFV);
//		System.out.print("INPUT"+Arrays.toString(feature_vector));
//		System.out.println(Arrays.deepToString(feature_vector));
		
		int numberOfClasses=10;
		
		double [] compare = new double[10];
		for (int x = 0; x <= numberOfClasses-1; x++)
		{
			double base = 0;
			double []weight = new double[5];
			weight =getWeightMatrix(x);
			int i=0;
			int j=0;
			try
			{
				
				FileInputStream fstream = new FileInputStream("class "+ x +"\\base_weight_matrix.txt");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String input;
				
				while((input=br.readLine())!= null )
				{ 
					if (input.length()>0 )
					{
					//System.out.print(j+"Column"+x+" ");
				    String [] temp=input.split(",");
				    //System.out.println(input.split(",").length);
				    base= new Double(temp[0]);
				    
				    
					}
				}
				
				br.close();
				in.close();
				fstream.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//We need to do all the calculation inside this FOR LOOP for recognition upto array creation
			double  weightxfeature= MatrixMaths.getDotProduct(weight,feature_vector);
		
//			if(base + weightxfeature>Vc)
//			{				
//				Vc =base + weightxfeature;
//				System.out.print(x);
//			}
			
			double Vc =weightxfeature+base;
			compare[x]=Vc;
			//System.out.println(compare[x]);
			
//			System.out.println(Arrays.deepToString(Vc));
			
			
//			System.out.println(det);
			
			
		}//end of FOR LOOP
		double max=compare[0];
		max_index=0;
		
		for(int i=0;i<=compare.length-1;i++)
		{
			if(compare[i]>max)
			{
				max=compare[i];
				max_index=i;
			}
		}
//		System.out.println(max_index);

	}
	
	
	public static double [] getWeightMatrix(int s)
	{
		double [] weightMatrix = new double [5];
		try
		{
			
			FileInputStream fstream = new FileInputStream("class " + s
				+ "\\weight_matrix.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String input;
			int j = 0;
			while ((input = br.readLine()) != null) {
				if (input.length() > 0 & j<5 ) {
					// System.out.print(j+"Column"+x+" ");
					String[] temp = input.split(" ");
					// System.out.println(input.split(",").length);
					weightMatrix[j] = Double.parseDouble(temp[0]);
					j++;

				}
				
				
			}
//			System.out.print(Arrays.toString(weightMatrix)+"NEXT");
			br.close();
			in.close();
			fstream.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return weightMatrix;
	}
	
	public static void main(String args[])
	{
		finalrun obj= new finalrun();
		obj.recognize();
	}
}
