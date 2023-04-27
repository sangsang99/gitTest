package com.example.demo.service;

import java.util.List;

import org.springframework.ui.Model;

import com.example.demo.repo.TblUser;

public interface Service {
    public void getAllData(Model model);
    public int insertData(TblUser tblUser);
    public int updateData(List<TblUser> users);
    public int deleteData(TblUser tblUser);
}
