package com.example.demo.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.repo.TblUser;
import com.example.demo.repo.TblUserList;
import com.example.demo.service.Service;

import lombok.RequiredArgsConstructor;

// 명령창 하니깐 됨! || build.gradle 파일에 lombok.jar파일 강제 주입 
@RequiredArgsConstructor
//@... .... .. Controller라고 뜨는 건 java 파일이 이미 Controller라고 되어서 그렇다.
@Controller
public class TestController {
    //기존 spring처럼 mapping: sample -> return : sample 로 작성을 하면, 아래의 경우 "sample"문자만 그대로 브라우저에서 출력됨
	//이를 기존처럼 별도의 prefix등 을 적용하려면 타임리프라는 엔진이 필요함. *maven에서 context.xml 파일 수정하는것과 비슷함
	//타임리프 없이 테스트 하고 싶다면 브라우저에 "http://localhost:8090/sample.html" 처럼 확장자까지 쳐야 sample.html파일이 정상적으로 호출됨 그러나 이는 Mapping이 없어도 가능	
    
    private final Service service;

    @GetMapping("sample")
	public String home(Model model) {
              
        service.getAllData(model);

        return "sample";
	}

    @GetMapping(value="modi_test")
    public String goModiTest(Model model) {
        service.getAllData(model);
 
        return "modi_test";
    }

    @PostMapping(value="modi_test.do")
    public RedirectView doModiTest(TblUser tblUser, TblUserList tblUserList) {

        //TODO : 별도의 List클래스 없이 Entity에 담아올 수 있는지 연구 필요
        List<TblUser> users = tblUserList.getTblUsers();

        /////////////////////////////////////////////////test////////////////////////
        //TODO :tblUserList 불러온게 List가 아니고 무엇인지 궁금함.
        System.out.println("tblUserList.getTblUsers() : " + tblUserList.getTblUsers());
        System.out.println("tblUserList: " + tblUserList);
        System.out.println("tblUserList.getUserNmmm()" + tblUserList.getUserNmmm());
        
        for (TblUser user : users) {
            System.out.println("user.getUserId()" + user.getUserId());
            System.out.println("user.getUserNmmm()" + user.getUserNmmm());
            System.out.println("user.getAge()" + user.getAge());
            System.out.println("user.getAuth() : " + user.getAuth());
            //TODO : timestamp 형태로 값을 제대로 호출하지 못하는 현상 연구 필요
            //System.out.println("user.getUserNmmm()" + user.getCreateDate());
            //System.out.println("user.getUserNmmm()" + user.getUpdateDate());
        }
        /////////////////////////////////////////////////test////////////////////////

        service.updateData(users);
       
        //Boot 2.x.x 부터는 redirect : "" 대신 아래처럼 사용한다고함.
        return new RedirectView("/sample");
    }
    
    @GetMapping(value = "insert_test")
    public String goInsertTest(){
        return "insert_test";
    }

    @PostMapping(value = "insert_test.do")
    public RedirectView doInsertTest(TblUser tblUser){
        service.insertData(tblUser);
        return new RedirectView("/sample"); 
    }
    
    @PostMapping(value = "delete_test.do")
    public RedirectView doDeleteTet(TblUser tblUser){
        service.deleteData(tblUser);
        return new RedirectView("/sample"); 
    }
    
}
