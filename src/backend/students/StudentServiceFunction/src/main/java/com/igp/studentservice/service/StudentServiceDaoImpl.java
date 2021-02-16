package com.igp.studentservice.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.igp.studentservice.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentServiceDaoImpl implements StudentCrudDao {

    private DynamoDBMapper dynamoDBMapper;

    public StudentServiceDaoImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public Student createStudent(Student user) {
        dynamoDBMapper.save(user);
        return user;
    }

    @Override
    public Student readStudent(String studentId) {
        return dynamoDBMapper.load(Student.class, studentId);
    }

    @Override
    public Student updateStudent(Student student) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("studentId", new ExpectedAttributeValue(new AttributeValue().withS(student.getStudentId())));
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);
        dynamoDBMapper.save(student, saveExpression);
        return student;
    }

    @Override
    public void deleteStudent(String studentId) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("studentId", new ExpectedAttributeValue(new AttributeValue().withS(studentId)));
        DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression().withExpected(expectedAttributeValueMap);
        Student student = Student.builder()
                .studentId(studentId)
                .build();
        dynamoDBMapper.delete(student, deleteExpression);
    }
}
