package com.igp.studentservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@DynamoDBTable(tableName = "studentBasic-table")
public class StudentBasic {

    @DynamoDBHashKey(attributeName = "studentId")
    @DynamoDBAutoGeneratedKey
    private String studentId;

    @DynamoDBAttribute(attributeName = "username")
    private String username;

    @DynamoDBAttribute(attributeName = "realName")
    @SerializedName("realname")
    private String realName;

    @DynamoDBAttribute(attributeName = "age")
    private int age;

    @DynamoDBAttribute(attributeName = "gender")
    private String gender;

    public StudentBasic(String username, String realName, int age, String gender) {
        this.username = username;
        this.realName = realName;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
