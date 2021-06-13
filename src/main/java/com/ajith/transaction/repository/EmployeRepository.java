package com.ajith.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ajith.transaction.domain.Employee;

@Repository
public interface EmployeRepository extends JpaRepository<Employee, Long> {

}
