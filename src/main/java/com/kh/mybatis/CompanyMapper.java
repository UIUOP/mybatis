package com.kh.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {
    @Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name} ,#{company.address})")
    @Options(useGeneratedKeys = true , keyProperty = "id") // id는 자동생성하겠다
    // 쿼리문 values 안에있는 company.name 은 자바에서 나온 객체
    int insert(@Param("company") Company company);

    // 조회
    @Select("SELECT * FROM company")
    @Results({
            @Result(property = "name",column = "company_name"),
            @Result(property = "address",column = "company_address")
    })
    List<Company> getAll();
}
