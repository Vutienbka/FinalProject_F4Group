package com.codegym.Service;

import com.codegym.Model.UserEntity;
import com.codegym.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements IUserService {
    @Autowired
    IUserRepo userRepo;

    public List<UserEntity> findAll() {
        List<UserEntity> list = (List<UserEntity>) this.userRepo.findAll();
        return list;
    }
}
