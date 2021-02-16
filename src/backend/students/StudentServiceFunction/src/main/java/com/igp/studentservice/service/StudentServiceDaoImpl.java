package com.igp.studentservice.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.igp.studentservice.model.Student;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserCrudDaoImpl {
        //implements UserCrudDao {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public UserCrudDaoImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public Student createUser(Student user) {
        dynamoDBMapper.save(user);
        return user;
    }

    @Override
    public Student readUser(String studentId) {
        return dynamoDBMapper.load(Student.class, studentId);
    }

    @Override
    public Student updateUser(Student user) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("userId", new ExpectedAttributeValue(new AttributeValue().withS(user.getStudentId())));
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);
        dynamoDBMapper.save(user, saveExpression);
        return user;
    }

    @Override
    public void deleteUser(String userId) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("userId", new ExpectedAttributeValue(new AttributeValue().withS(userId)));
        DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression().withExpected(expectedAttributeValueMap);
        User user = User.builder()
                .userId(userId)
                .build();
        dynamoDBMapper.delete(user, deleteExpression);
    }
}
