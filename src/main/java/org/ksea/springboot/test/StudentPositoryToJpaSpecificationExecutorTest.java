package org.ksea.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ksea.springboot.HomeApplication;
import org.ksea.springboot.model.Student;
import org.ksea.springboot.repository.StudentPositoryToJpaSpecificationExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by mexican on 2017/5/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HomeApplication.class)
public class StudentPositoryToJpaSpecificationExecutorTest {
    @Autowired
    private StudentPositoryToJpaSpecificationExecutor studentPositoryToJpaSpecificationExecutor;


    @Test
    public void testSpecificationToMany() {
        Specification<Student> specification1 = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                Predicate predicate = criteriaBuilder.like(root.get("address"), "%四川%");

                return predicate;
            }
        };


        Specification<Student> specification2 = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                Predicate predicateAge = criteriaBuilder.equal(root.get("age"), 23);
                Predicate predicateName = criteriaBuilder.like(root.get("name"), "%k%");

                return criteriaBuilder.and(predicateAge, predicateName);
            }
        };


        List<Student> students = studentPositoryToJpaSpecificationExecutor.findAll(Specifications.where(specification1).and(specification2));
        System.out.println(students);

    }

    @Test
    public void testSpecification() {
        List<Student> students = studentPositoryToJpaSpecificationExecutor.findAll(new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                /**
                 * root.get("age") 获取要查询的字段
                 * 23 表示该值
                 * criteriaBuilder.equal(root.get("age"), 23); 创建 age=23的表达式条件
                 */
                Predicate predicateAge = criteriaBuilder.equal(root.get("age"), 23);
                Predicate predicateName = criteriaBuilder.like(root.get("name"), "%k%");

                //将以上条件合并成一个条件,也就是 where age=23 and name like "%k%"
                Predicate predicate = criteriaBuilder.and(predicateAge, predicateName);
                //使用Specification的要点就是CriteriaBuilder，通过这个对象来创建条件，之后返回一个Predicate对象。

                return predicate;
            }
        });

        System.out.println(students);
    }
}
