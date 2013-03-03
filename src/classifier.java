//BETA 1.0

//This is the class that actually classifies the number entered by the user to classes in between 0-9

import java.io.*;
public class classifier 
{
	static double[][] feature_vector= new double[1][5];
	public static double[][] feature_vector()
	{
		 int i=0 ;
		float NDDE=0;
		NDDE ndde= new NDDE();
		NDDE=ndde.NDDE_calculator();
//		System.out.println("NDDE"+" "+NDDE);
		
		Theta tfeature= new Theta();
		Intersection_feature ifeature=new Intersection_feature();
		double distance_feature=0,theta_feature=0,intersection_feature=0;
		Distance_Feature dfeature= new Distance_Feature();
		distance_feature=dfeature.Distance_calculator();
//		System.out.println("Distance Feature is"+" "+distance_feature);
		theta_feature= tfeature.calculateThetaSum();
//		System.out.println("Cos Feature is "+" "+cos_feature);
		intersection_feature= ifeature.intersection();
//		System.out.println("Sin feature is"+ " "+ sin_feature);
		
		
//		System.out.println("This is DCR"+DCR.calculateDCR());
		
		
		feature_vector[0][0]= NDDE;
		feature_vector[0][1]= distance_feature;
		//feature_vector[0][2]=cos_feature;
		//feature_vector[0][3]=sin_feature;
		feature_vector[0][2]= (float) DCR.calculateDCR();
		feature_vector[0][3]=theta_feature;
		feature_vector[0][4]=intersection_feature;
		//PrintWriter out = null;
		//try {
			//boolean append = true;
			//FileWriter outFile = new FileWriter("class 1/feature1.txt", append);
			//out = new PrintWriter(outFile);
			//for(i=0; i<=feature_vector.length;i++)
			//{
			//	out.println(" "+feature_vector[i]+ " ");
			//}
		    //}
		//catch(Exception e)
		//{
		//	e.printStackTrace();
		//}
		//finally {
		//	out.close();
	//	}
		
		float ndde_mean[]= new float[10];
		float distance_mean[]= new float[10];
		float cos_mean[]=new float[10];
		float sin_mean[]= new float[10];
		float dcr_mean[]=new float[10];
		
//		PrintWriter out = null;
//		try 
//		{
//			boolean append = true;
//			FileWriter outFile = new FileWriter("class 9/feature_vector.txt", append);
//			out = new PrintWriter(outFile);
//			out.println(NDDE+","+distance_feature+","+DCR.calculateDCR()+","+theta_feature+","+intersection_feature+"\n");
//		 } 
//		catch (IOException ex)
//		{
//			ex.printStackTrace();
//		}
//		finally 
//		{
//			out.close();
//		}
//		
	
			
		return feature_vector;
	
	}
	
	
	
	
	public static void main(String args [])
	{
		classifier obj = new classifier();
		obj.feature_vector();
	}

}
