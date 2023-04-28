package com.example.demo.repo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor //빌드시 컴파일 에러 방지
//@NoArgsConstructor(access = AccessLevel.PROTECTED) //빌드시 컴파일 에러 방지
@Getter
@Setter //gettersetter외에 다양한 어노테이션을 일괄 포함
@Entity(name = "tbl_user") //여기에 테이블명 명시해도 작동함
//@Table(name = "TBL_USER") //db에 동일한 테이블명(대소문자 등 구분해서)이 있으면 소문자 먼저 인식하고, 그외의 경우에는 대소문자 섞어서 작성해도 무방!
public class TblUser{  

    @Id // 키값(primary)
    private String userId; 
    @Column(name = "USER_nAME") //대소문자,카멜-스네이크 표기법은 혼용해서 인식하지만 useriiid 식으로 작성하면 인지 못함 @column 어노테이션 사용
    private String userNmmm;
    private Integer age;
    private Integer auth; // int로 하면 nullPointError 발생 위험
    private Timestamp createDate;
    private Timestamp updateDate; //not Date
    @ElementCollection //이거 선언해두면 html에서 tblUsers[*]으로 name 선언시 여기에 값 담아옴, controller에서는 @Modelattribute사용 해서받아옴
    private List<String> tblUsers;
}
