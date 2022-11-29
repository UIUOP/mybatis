package com.kh.mybatis;


import lombok.Data;

import java.util.List;

// DB Table과 매핑할 객체 company 생성
// @Data : @Getter , @Setter , @Constrictor , @ToString.. 다 포함 객체 생성과 관련된 포함
// 충돌없을때 사용하기 편한
@Data
public class Company {
private int id;
private String name;
private String address;
private List<Employee> employeeList;
}
