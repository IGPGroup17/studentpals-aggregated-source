package com.igp.studentservice.config;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

public class DynamoDBConfig {

    public static AmazonDynamoDB dynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new EnvironmentVariableCredentialsProvider())
                .withRegion(Regions.EU_WEST_1)
                .build();
    }
    public static DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(dynamoDB(), DynamoDBMapperConfig.DEFAULT);
    }
}
