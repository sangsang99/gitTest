package com.example.demo.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

//JpaRepository
import com.example.demo.repo.RepoJPA;
import com.example.demo.repo.TblUser;

//lombok
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements com.example.demo.service.Service{

    private final RepoJPA repoJpa;

    @Override
    public void getAllData(Model model) {
   
    List<TblUser> entities;

        try {
            entities = repoJpa.findAll();
    
            if(entities.isEmpty()) 
                System.out.println("값이 없습니다!");
            else {
                System.out.println("뭔가가 있습니다!");
            }
        } catch (Exception e) {
            System.out.println("오류!");
            entities = null;
        }

        model.addAttribute("dtos", entities);
    }

    @Override
    public int insertData(TblUser tblUser) {        
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        tblUser.setCreateDate(timestamp);
        repoJpa.save(tblUser);
        return 0;
    }

    @Override
    public int updateData(List<String> users) {

        repoJpa.save(users);
        //TODO : JpaRepository.savaAll 함수 연구?
        for (TblUser user : users) {
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            user.setUpdateDate(timestamp); 
            repoJpa.save(user);
        }

        return 0;
    }

    @Override
    public int deleteData(TblUser tblUser) {
        repoJpa.delete(tblUser);
        return 0;
    }
    
}
