import java.io.*;
import java.util.StringTokenizer;

public class NDDE {
	
	float NDDE_calculator()
	{
		float NDDE=0;
		int i = 0,j = 0,k = 0;
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
	br.close();
	in.close();
	fstream.close();
	//for(i=0,j=0,k=0;i<arr[0].length;i++,j++,k++)
	//{
		//System.out.println(arr[0][i]+","+arr[1][j]+","+arr[2][k]);
	//System.out.println("\n");
	//}
	  
	}
	catch(Exception e)
	{
		System.out.print(e.getLocalizedMessage());
		
	}
	float d_high=0,x_high=0,y_high=0, x_low=0, y_low=0,d_low=0, high=0,low=0,stroke_length=0,total_stroke_length=0;
	//d_high=Math.abs(arr[1][0]-arr[1][1])/Math.abs(arr[0][0]-arr[0][1]);
	//d_low =Math.abs(arr[1][0]-arr[1][1])/Math.abs(arr[0][0]-arr[0][1]);
	for(i=0,j=0;i<arr[0].length-1;i++,j++)
	{
		if(Math.abs(arr[1][j]-arr[1][j+1])/Math.abs(arr[0][i]-arr[0][i+1])>=d_high && arr[0][i]!=arr[0][i+1])
		{
		d_high=Math.abs(arr[1][j]-arr[1][j+1])/Math.abs(arr[0][i]-arr[0][i+1]);
		x_high=arr[0][i+1];
		y_high=arr[1][j+1];
		high=i+1;
		}
		if(Math.abs(arr[1][j]-arr[1][j+1])/Math.abs(arr[0][i]-arr[0][i+1])<=d_low && arr[0][i]!= arr[0][i+1])
		{
		d_low=Math.abs(arr[1][j]-arr[1][j+1])/Math.abs(arr[0][i]-arr[0][i+1]);
		x_low=arr[0][i+1];
		y_low=arr[1][j+1];
		low=j+1;
		}
	}
	//System.out.println(high+" ,"+ low);
	
	//System.out.println(high-low);
	//System.out.println(x_high+" "+ y_high);
	//System.out.println(high);
	//System.out.println(x_low+" "+ y_low);
	//System.out.println(low);
	
     stroke_length= Math.abs(high-low);
     
     
	i=0;
	while(arr[0][i] != 0.0)
	{
		total_stroke_length++;
		i++;
	}
	//System.out.println(total_stroke_length);
	NDDE= stroke_length/total_stroke_length;
	//System.out.println(NDDE);

		return NDDE;
		
	}
	
	public static void main(String args[])
	{
		
	
	
	}
	
	
	

}
