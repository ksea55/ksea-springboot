package org.ksea.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ksea.springboot.HomeApplication;
import org.ksea.springboot.model.Student;
import org.ksea.springboot.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by mexican on 2017/4/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HomeApplication.class)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void count() {
        //数量统计
        long count = studentRepository.count();
        System.out.println(count);//统计当前表中的总条数

        long countByAge = studentRepository.countByAge(23);
        System.out.println(countByAge); //根据年龄进行统计
    }


    @Test
    public void delete() {
        //根据id删除
        studentRepository.delete(3);
        //根据某个对象删除
        Student student = studentRepository.findOne(7);
        studentRepository.delete(student);
    }


    @Test
    public void update() {
        //根据id=2查询出该对象
        Student student = studentRepository.findOne(2);
        System.out.println(student); // Student{id=2, name='jacky', address='遂宁射洪', age=23}
        student.setName("张学友");
        student.setAddress("中国香港");
        student.setAge(33);
        //执行更新操作
        student = studentRepository.save(student);
        System.out.println(student); //更新之后，返回更新过后的对象 Student{id=2, name='张学友', address='中国香港', age=33}

    }

    @Test
    public void add() {
        Student student = new Student("jmas", "四川绵阳", 23);
        studentRepository.save(student);
    }

    @Test
    public void testStudentRepositoryToQuery() {
        System.out.println(studentRepository.findById(5));
        System.out.println(studentRepository.getById(1));
        System.out.println(studentRepository.readById(1));
        System.out.println(studentRepository.loadById(1));
        System.out.println(studentRepository.getByName("ksea"));

    }
}
