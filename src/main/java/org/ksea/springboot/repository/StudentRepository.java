package org.ksea.springboot.repository;

import org.ksea.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mexican on 2017/4/19.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //这里的id=?1是使用占位符的方式,占位符方式注意参数顺序
    @Query("select s  from  Student s where s.id=?1")
    Student loadById(Integer id);

    //命名方式,在使用命名方式的情况需要通过参数注解@Param来指明
    @Query("select s  from Student s where s.name=:name")
    Student getByName(@Param("name") String name);

    //根据id获取对象，即可返回对象，也可以返回列表
    Student readById(Integer id);

    //根据id获取列表，这里如果确定只有一个对象，也可以返回对象
    List<Student> getById(Integer id);

    //根据id获取一个对象，同样也可以返回列表
    Student findById(Integer id);

    long countByAge(Integer age);

}
