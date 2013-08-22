//BETA 1.0

//This is the class that actually classifies the number entered by the user to classes in between 0-9

import java.io.*;
public class classifier 
{
	static double[][] feature_vector= new double[1][5];
	public double[][] feature_vector()
	{
		 int i=0 ;
		float NDDE=0;
		NDDE ndde= new NDDE();
		NDDE=ndde.NDDE_calculator();

		Theta tfeature= new Theta();
		Intersection_feature ifeature=new Intersection_feature();
		double distance_feature=0,theta_feature=0,intersection_feature=0;
		Distance_Feature dfeature= new Distance_Feature();
		distance_feature=dfeature.Distance_calculator();
		theta_feature= tfeature.calculateThetaSum();
		intersection_feature= ifeature.intersection();
		
		
		feature_vector[0][0]= NDDE;
		feature_vector[0][1]= distance_feature;
		feature_vector[0][2]= (float) DCR.calculateDCR();
		feature_vector[0][3]=theta_feature;
		feature_vector[0][4]=intersection_feature;out.close();

		float ndde_mean[]= new float[10];
		float distance_mean[]= new float[10];
		float cos_mean[]=new float[10];
		float sin_mean[]= new float[10];
		float dcr_mean[]=new float[10];
			
		return feature_vector;
	
	}
	
	
	
	
	public static void main(String args [])
	{
		classifier obj = new classifier();
		obj.feature_vector();
	}

}
