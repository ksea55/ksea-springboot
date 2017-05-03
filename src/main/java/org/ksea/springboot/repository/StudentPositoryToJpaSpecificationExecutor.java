package org.ksea.springboot.repository;

import org.ksea.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by mexican on 2017/5/3.
 * Spring Data Jpa同样提供了类似Hibernated 的Criteria的查询方式，要使用这种方式只要继承JpaSpecificationExecutor,该接口提供了如下一些方法
 * T findOne(Specification<T> var1);
 * List<T> findAll(Specification<T> var1);
 * Page<T> findAll(Specification<T> var1, Pageable var2);
 * List<T> findAll(Specification<T> var1, Sort var2);
 * long count(Specification<T> var1);
 */
public interface StudentPositoryToJpaSpecificationExecutor extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {

}
