package com.igp.studentservice.config;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

public class DynamoDBConfig {

    public static DynamoDBMapper dynamoDBMapper() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new EnvironmentVariableCredentialsProvider())
                .withRegion(Regions.EU_WEST_2)
                .build();
        return new DynamoDBMapper(client, DynamoDBMapperConfig.DEFAULT);
    }
}
