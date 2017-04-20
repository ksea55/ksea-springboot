package org.ksea.springboot.service;

import org.ksea.springboot.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mexican on 2017/4/19.
 */
@Service
public interface StudentService {

    Student loadById(Integer id);

    Student getByName(String name);

    Student readById(Integer id);

    List<Student> getById(Integer id);

    Student findById(Integer id);

}
