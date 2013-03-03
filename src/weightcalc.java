import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class weightcalc 
{
    public static double[][]feature_matrix()
    {
    	double[][]feature_matrix= new double[10][5];
    	int x=9;
		int i=0;
		int j=0;
		try
		{
			
			FileInputStream fstream = new FileInputStream("class "+ x +"\\feature_vector.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String input;
			
			while((input=br.readLine())!= null )
			{ 
				if (input.length()>0 & j<10)
				{
				//System.out.print(j+"Column"+x+" ");
			    String [] temp=input.split(",");
			    //System.out.println(input.split(",").length);
			    feature_matrix[j][i]= new Double(temp[0]);
			    feature_matrix[j][i+1]=new Double(temp[1]);
			    feature_matrix[j][i+2]=new Double(temp[2]);
			    feature_matrix[j][i+3]=new Double(temp[3]);
			    feature_matrix[j][i+4]=new Double(temp[4]);
			    
			    j++;
			    
				}
			}
			
			br.close();
			in.close();
			fstream.close();
		return feature_matrix;
	
    }
		catch(Exception e)
		{
			
		}
		return feature_matrix;
    }
    public static double[] mean_feature_vector(double[][]matrix)
    {
    	MatrixMaths obj= new MatrixMaths();
    	double [] mean_feature_vector=obj.meanFeatureVector(matrix);
    	return mean_feature_vector;
    }
    
    public static double[][] transpose_mean_feature_vector(double [] matrix)
    {
    	MatrixMaths obj= new MatrixMaths();
    	double [][]transpose = obj.transpose(matrix);
    	//System.out.print(Arrays.deepToString(transpose));
		return transpose;
    	
    }
    public static double[][] weighto_calc(double []temp,double[]feature)
    {
//    	double[][] trans = new double[1][5];
//		for(int i=0;i<=feature.length-1;i++)
//		{
//			trans[0][i]=feature[i];
//		}
////         System.out.println(Arrays.deepToString(trans));
		double mult= MatrixMaths.getDotProduct(temp,feature);
		mult=mult/-2;
		write_base_weight(mult);// this would be a single value i.e a scalar..
    	
		return null;
    	
    }
    
    public static double [][]weightcal(double[][] inverse)
    {
    	
    	weightcalc obj1 = new weightcalc();
    	double feature_matrix[][]=obj1.feature_matrix();
    	double[] mean_feature=obj1.mean_feature_vector(feature_matrix);
    	//System.out.println("I am mean feature"+Arrays.toString(mean_feature)+"end");
    	
    	double[][] transpose_mean_feature=obj1.transpose_mean_feature_vector(mean_feature);
//System.out.println("I am transpose"+Arrays.deepToString(inverse));
    	double [][] temp =MatrixMaths.multiply(inverse, transpose_mean_feature);
    	
    	//
    	//System.out.println(Arrays.deepToString(temp));
    	write_weight_matrix(temp);
//    	System.out.println(Arrays.deepToString(temp));
    	double[]temp_vector=MatrixMaths.getVector(temp);
    	//System.out.println(Arrays.toString(temp_vector));
    	//Convert the temp matrix to a vector//
    	
    	weighto_calc(temp_vector,mean_feature);
    	return temp;
    	
		    	
    }
    public static double[][]write_base_weight(double  base_weight)
    {
//    	System.out.println(Arrays.deepToString(base_weight));
    	PrintWriter out = null;
		try 
		{
			boolean append = true;
			FileWriter outFile = new FileWriter("class 9/base_weight_matrix.txt", append);
			out = new PrintWriter(outFile);
//			out.println(Arrays.deepToString(matrix));
			out.print(base_weight);
		 } 
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally 
		{
			out.close();
		}
    	return null;
    	
    }
    
    public static double[][] write_weight_matrix(double [][] matrix)
    {
    	
    	PrintWriter out = null;
		try 
		{
			boolean append = true;
			FileWriter outFile = new FileWriter("class 9/weight_matrix.txt", append);
			out = new PrintWriter(outFile);
//			out.println(Arrays.deepToString(matrix));
			for(int i =0; i<= matrix.length-1;i++)
			{
				for(int j=0;j<=matrix[0].length-1;j++)
				{
					out.println(matrix[i][j]);
				}
			}
			
		 } 
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally 
		{
			out.close();
		}
    	return null;
    }
    public static void main(String args[])
    {
    	
    	weightcalc obj1 = new weightcalc();
    	covariance obj= new covariance();
    	double[][] inver= obj.inverse();
    	obj1.weightcal(inver);
    	
    	
    }
}
