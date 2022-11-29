package com.kh.mybatis;


import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Insert("INSERT INTO employee(company_id,employee_name,employee_address)  " +
            "VALUES(#{employee.companyId},#{employee.name},#{employee.address})")
@Options(useGeneratedKeys = true , keyProperty = "id")
    int insert(@Param("employee") Employee employee);

    //조회
@Select("SELECT * FROM employee")
    @Results(id="EmployeeMap",value = {
            @Result(property= "name" , column = "employee_name") , //property 는 자바객체쪽
            @Result(property= "address" , column = "employee_address") ,
            @Result(property= "companyId" , column = "company_id")
    })
    List<Employee> getAll(); // return 을 getAll로


    // 컴패니 아이디인애들만 조회
@Select("SELECT*FROM employee WHERE company_id=#{companyId}")
    @ResultMap("EmployeeMap")  // id가 employeeMap인 위쪽 쿼리문을 전부가져온다
   List<Employee> getByCompanyId(@Param("companyId") int companyId);

// id 조회
@Select("SELECT * FROM employee WHERE id=#{id}")
@ResultMap("EmployeeMap")
    Employee getById(@Param("id") int id);
}
