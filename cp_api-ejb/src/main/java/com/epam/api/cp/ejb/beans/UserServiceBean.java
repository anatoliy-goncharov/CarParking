package com.epam.api.cp.ejb.beans;

import com.epam.api.cp.ejb.UserService;
import com.epam.api.cp.ejb.UserServiceLocal;
import com.epam.api.cp.entities.User;
import org.jboss.ws.api.annotation.WebContext;

import javax.ejb.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@WebService(name = "UserServicePort", serviceName = "UserService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@TransactionAttribute
@WebContext(urlPattern = "UserService")
@Local(UserServiceLocal.class)
@Remote(UserService.class)
@Stateless
public class UserServiceBean implements UserService, UserServiceLocal {


    @PersistenceContext(unitName="carparking")
    private EntityManager entityManager;

    @WebMethod()
    public User getUser(@WebParam(name = "userId")Long userId) throws Exception{
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = builder.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.select(userRoot).where(builder.equal(userRoot.get("userId"), userId));
        User user = (User) entityManager.createQuery(cq).getSingleResult();
        return entityManager.find(User.class, userId);
    }


}
