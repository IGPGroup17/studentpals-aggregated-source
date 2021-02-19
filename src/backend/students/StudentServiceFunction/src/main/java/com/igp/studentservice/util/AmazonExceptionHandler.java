package com.igp.studentservice.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.igp.studentservice.config.DynamoDBConfig;
import lombok.experimental.UtilityClass;

import javax.print.DocFlavor;
import java.util.List;
import java.util.function.Supplier;

@UtilityClass
public class AmazonExceptionHandler {

    public <T> T handle(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (AmazonServiceException ase) {
            System.err.println("Could not complete operation");
            System.err.println("Error Message:  " + ase.getMessage());
            System.err.println("HTTP Status:    " + ase.getStatusCode());
            System.err.println("AWS Error Code: " + ase.getErrorCode());
            System.err.println("Error Type:     " + ase.getErrorType());
            System.err.println("Request ID:     " + ase.getRequestId());

            System.err.println("------- TABLES -------");
            List<String> tables = DynamoDBConfig.dynamoDB().listTables().getTableNames();
            System.err.println("Count:    " + tables.size());
            tables.forEach(System.err::println);
        } catch (AmazonClientException ace) {
            System.err.println("Internal error occurred communicating with DynamoDB");
            System.out.println("Error Message:  " + ace.getMessage());
        }
        return null;
    }
}
