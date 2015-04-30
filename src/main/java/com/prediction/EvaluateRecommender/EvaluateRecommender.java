package com.prediction.EvaluateRecommender;

import com.prediction.RecommenderApp.MyFirstRecommender;
import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

public class EvaluateRecommender {

	public static void main(String[] args) 
	{	
		DataModel model;
		try {
			
			// Data model
			// model = new FileDataModel(new File("data/data.csv"));
			model = new FileDataModel(new File("data/data.csv"));
			
			// Selecting evaluator
			RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
			
			// Getting recommender object for test
			RecommenderBuilder builder = new MyFirstRecommender();
			
			// Running test
			double result = evaluator.evaluate(builder, null, model, 0.9, 1.0);

			// Printing out the tests
			System.out.println(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
