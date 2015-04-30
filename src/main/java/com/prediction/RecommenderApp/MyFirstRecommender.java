package com.prediction.RecommenderApp;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class MyFirstRecommender implements RecommenderBuilder
{
    public Recommender buildRecommender (DataModel dataModel) throws TasteException
    {
        // Using Pearson correlation to calculate user similarity
        UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);

        // Defining user neighborhood boundaries
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, dataModel);

        // Building recommender
        return new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
    }
}