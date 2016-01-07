package com.epam.api.cp.ejb.beans;

import com.epam.api.cp.ejb.RegistrationService;
import com.epam.api.cp.ejb.RegistrationServiceLocal;
import com.epam.api.cp.entities.User;
import org.jboss.ws.api.annotation.WebContext;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@WebService(name = "RegistrationServicePort", serviceName = "RegistrationService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@TransactionAttribute
@WebContext(urlPattern = "RegistrationService")
@Local(RegistrationServiceLocal.class)
@Remote(RegistrationService.class)
@Stateless
public class RegistrationServiceBean implements RegistrationService, RegistrationServiceLocal{

    @PersistenceContext(unitName="carparking")
    private EntityManager entityManager;

    @WebMethod()
    public User getUser(@WebParam(name = "userId")Long userId) {
        return entityManager.find(User.class, userId);
    }


}
