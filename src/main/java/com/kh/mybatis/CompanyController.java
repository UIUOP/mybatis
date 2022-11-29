package com.kh.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 프론트엔드로부터 view를 받겠다
@RequestMapping("/company")  // 전체경로
public class CompanyController {


@Autowired // 의존성 주입
private CompanyMapper companyMapper; // 의존성 주입
    @Autowired
    private CompanyService companyService;


    @PostMapping("/insert")
    public int post(@RequestBody Company company) {
        return companyMapper.insert(company);
    }
//    @GetMapping("/list")
//    public List<Company> getAll() {
//        return companyMapper.getAll();
//    }
@CrossOrigin("*")
    @GetMapping("/list")
    public List<Company> getAll() {
        return companyService.getAll();
    }

}
