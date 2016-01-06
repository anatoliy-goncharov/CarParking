package com.epam.api.cp.ejb.beans;

import com.epam.api.cp.ejb.RegistrationService;
import com.epam.api.cp.ejb.RegistrationServiceLocal;
import com.epam.api.cp.entities.User;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "RegistrationServicePort", serviceName = "RegistrationService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@Local(RegistrationServiceLocal.class)
@Remote(RegistrationService.class)
@Stateless
public class RegistrationServiceBean implements RegistrationService{
/*
    @PersistenceContext(unitName = "PostgreDataSource")
    private EntityManager entityManager;*/

    public User getUser(Long userId){
        return null;
    }
}
