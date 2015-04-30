package com.prediction.RecommenderApp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println("My first recommender");

        try {

            // Loading test dataset
        	// DataModel model = new FileDataModel(new File("data/data.csv"));
            DataModel model = new FileDataModel(new File("data/data.csv"));

            // Creating recommender
            // My first recommender object
            MyFirstRecommender myFirstRecommender = new MyFirstRecommender();
            
            // Casting to user based
            UserBasedRecommender recommender = (UserBasedRecommender) myFirstRecommender.buildRecommender(model);

            // Getting recommendations
            List <RecommendedItem> recommendations = (List<RecommendedItem>) recommender.recommend(2, 3);

            // Printing recommendations
            for (RecommendedItem recommendation : recommendations) {
                System.out.println(recommendation);
            }

        } catch (IOException e) {
        	
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } catch (TasteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
