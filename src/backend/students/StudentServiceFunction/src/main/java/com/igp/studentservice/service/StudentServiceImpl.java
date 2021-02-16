package com.igp.studentservice.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.studentservice.dao.StudentCrudDao;
import com.igp.studentservice.dao.StudentServiceDaoImpl;
import com.igp.studentservice.model.*;
import com.igp.studentservice.util.RequestBodyReader;
import com.igp.studentservice.util.ResponseEntity;
import com.igp.studentservice.util.path.PathParameters;

public class StudentServiceImpl implements StudentService {

    private StudentCrudDao studentCrudDao;

    public StudentServiceImpl() {
        this.studentCrudDao = new StudentServiceDaoImpl();
    }

    @Override
    public ResponseEntity<Student> createStudent(APIGatewayProxyRequestEvent event, Context context) {
        Student student = RequestBodyReader.getAsObject(event.getBody(),Student.class);
        return ResponseEntity.ok(studentCrudDao.createStudent(student));
    }

    @Override
    public ResponseEntity<Student> readStudent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(studentCrudDao.readStudent(PathParameters.getPathParameter(event,"id")));
    }

    @Override
    public ResponseEntity<Student> updateStudent(APIGatewayProxyRequestEvent event, Context context) {
        Student student = RequestBodyReader.getAsObject(event.getBody(),Student.class);
        return ResponseEntity.ok(studentCrudDao.updateStudent(student));
    }

    @Override
    public ResponseEntity<Student> deleteStudent(APIGatewayProxyRequestEvent event, Context context) {
        studentCrudDao.deleteStudent((PathParameters.getPathParameter(event,"id")));
        return null;
    }
}
