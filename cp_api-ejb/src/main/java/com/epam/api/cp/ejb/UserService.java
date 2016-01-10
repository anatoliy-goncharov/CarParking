package com.epam.api.cp.ejb;

import com.epam.api.cp.entities.User;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.epam.com/wsapi/types")
public interface UserService {

    User getUser(@WebParam(name = "userId")Long userId) throws Exception;
}
