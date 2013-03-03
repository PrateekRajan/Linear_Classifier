//This feature calculates the distance between the first and the last point of sketch

import java.io.*;

public class Distance_Feature
{
	float final_point_x=0,final_point_y=0,cos_feature=0,sin_feature=0;
	float x1=0,y1=0;
	double  Distance_calculator()
	{
		int count=0;
		int i = 0,j = 0,k = 0;
		double temp3=0;
		double temp2=0;
		double temp1 =0;
		double distance_feature=0;
		
		float[][] arr= new float [3][];
		 arr[0]= new float[1000];//Use dynamic arrays in other programs
		 arr[1]= new float[1000];
		 arr[2]= new float[1000];
		
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
		//for(i=0,j=0,k=0;i<arr[0].length;i++,j++,k++)
		//{
		//	System.out.println(arr[0][i]+","+arr[1][j]+","+arr[2][k]);
		//System.out.println("\n");
		//}
		br.close();
		in.close();
		fstream.close(); 
		}
		catch(Exception e)
		{
			System.out.print(e.getLocalizedMessage());
			
		}
		i=0;
		while(arr[0][i] != 0)
		{
			final_point_x= arr[0][i];
			i++;
			count++;
		}
		j=0;
		while(arr[1][j] != 0)
		{
			final_point_y=arr[1][j];
			j++;
		}
		//System.out.println(final_point_x +","+ final_point_y);
		x1=arr[0][0];
		y1=arr[1][0];
		temp1=  Math.pow((final_point_x-arr[0][0]),2);
		temp2=  Math.pow((final_point_y-arr[1][0]),2);
		temp3=temp1+temp2;
		//System.out.print(temp3);
		distance_feature= (Math.pow(Math.abs(temp3), 0.5));
		distance_feature=distance_feature/count;
		
//		System.out.print(distance_feature+"Prior");
//		System.out.println("M COUNT"+count+"M COUNT");
		
		
		
//		if(distance_feature==0.0)
//		{
//			distance_feature=1;
//		}
//		else
			
		
		
		//System.out.println(distance_feature);
		//cos_feature= final_point_x/distance_feature;
		//System.out.println(cos_feature);
		//sin_feature= final_point_y/distance_feature;
		//System.out.println(sin_feature);
		return distance_feature;
	}
	
	float cos_feature_calculator()
	{
		double temp=0;
		float cos_feature=0;
		temp = Distance_calculator();
		//cos_feature= (final_point_x-x1)/temp;
		
		return cos_feature;
		
	}
	float sin_feature_calculator()
	{
		float temp=0,sin_feature=0;
		//temp = Distance_calculator();
		sin_feature= (final_point_y-y1)/temp;
		
		return sin_feature;
		
	}
	public static void main(String args[])
	{
		
	}

}
