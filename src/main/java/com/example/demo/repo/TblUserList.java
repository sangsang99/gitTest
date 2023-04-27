package com.example.demo.repo;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Table(name = "TBL_USER") //db에 동일한 테이블명(대소문자 등 구분해서)이 있으면 소문자 먼저 인식하고, 그외의 경우에는 대소문자 섞어서 작성해도 무방!
public class TblUserList{  
    private String userId; 
    private String userNmmm;
    private Integer age;
    private Integer auth; // int로 하면 nullPointError 발생 위험
    private Timestamp createDate;
    private Timestamp updateDate; //not Date

    private List<TblUser> tblUsers;
    //push test 
}
