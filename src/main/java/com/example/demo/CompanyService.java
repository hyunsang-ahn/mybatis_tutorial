package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//매퍼에서 따로 안하고 서비스로 하는방법임.
public class CompanyService {
    @Autowired
    private  CompanyMapper companyMapper;
    @Autowired
    private  EmployeeMapper employeeMapper;

    public List<Company> getAll(){
    List<Company> companyList = companyMapper.getAll();
    if(companyList != null && companyList.size() > 0){
        for(Company company : companyList){
            company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));

        }
    }
    return companyList;
    }


    @Transactional
    //오류가 날시, 수정 삭제 생성에 대해서 롤백해주는 어노테이션임;
    public Company add(Company company){
        companyMapper.insert((company));
        //add company into legacy system
        if(true){
            throw new RuntimeException("Legacy Exception");
        }
        return company;
    }
}
