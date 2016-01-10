package com.epam.cp.dao.Impl;

import com.epam.api.cp.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao extends GenericDao<User> {

    public UserDao() {
        super(User.class);
    }

    public User getUserByLogin(String login){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("login", login);
        return super.findOneResult("getUserByLogin", parameters);
    }

    public void save(User user){
        super.save(user);
    }

    public User update(User user){
        return super.update(user);
    }

    public void delete(User user){
        super.delete(user);
    }

    public List<User> findAll(){
        return super.findAll();
    }

}
