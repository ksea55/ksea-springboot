package org.ksea.springboot.service.impl;

import org.ksea.springboot.model.Student;
import org.ksea.springboot.repository.StudentRepository;
import org.ksea.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mexican on 2017/4/19.
 */

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student loadById(Integer id) {
        return studentRepository.loadById(id);
    }

    @Override
    public Student getByName(String name) {
        return studentRepository.getByName(name);
    }

    @Override
    public Student readById(Integer id) {
        return studentRepository.readById(id);
    }

    @Override
    public List<Student> getById(Integer id) {
        return studentRepository.getById(id);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id);
    }
}
