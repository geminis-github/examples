package com.examples.java.streams;

import com.examples.java.common.Department;
import com.examples.java.common.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream流使用示例
 *
 * @author Thinking9527
 * @date 2023-06-13 1:29
 */
public class StreamExample {

    public static void main(String[] args) {

    }

    public static List<Department> buildMenuTree(List<Employee> employeeList) {
        return employeeList.stream()
                .map(employee -> new Department(employee.getName(), employee.getAge() * 5, 5))
                .collect(Collectors.toList());
    }

}
