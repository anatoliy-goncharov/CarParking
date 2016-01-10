package com.epam.api.cp.ejb.beans;

import com.epam.api.cp.ejb.AdditionalInfoService;
import com.epam.api.cp.ejb.AdditionalInfoServiceLocal;
import com.epam.api.cp.entities.AdditionalInfo;
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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@WebService(name = "AdditionalInfoServicePort", serviceName = "AdditionalInfoService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@TransactionAttribute
@WebContext(urlPattern = "AdditionalInfoService")
@Local(AdditionalInfoServiceLocal.class)
@Remote(AdditionalInfoService.class)
@Stateless
public class AdditionalInfoServiceBean implements AdditionalInfoServiceLocal, AdditionalInfoService{

    @PersistenceContext(unitName="carparking")
    private EntityManager entityManager;

    @WebMethod()
    public AdditionalInfo getAddInfoByUserId(@WebParam(name = "userId")Long userId) throws Exception {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AdditionalInfo> cq = builder.createQuery(AdditionalInfo.class);
        Root<AdditionalInfo> addInfo = cq.from(AdditionalInfo.class);
        cq.select(addInfo).where(builder.equal(addInfo.get("user"), userId),
                                    builder.equal(addInfo.get("expiredInfo"),(Boolean.FALSE)));
        AdditionalInfo user = entityManager.createQuery(cq).getSingleResult();

        return user;
    }

    public List<AdditionalInfo> getFullList() throws Exception {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = builder.createQuery(AdditionalInfo.class);
        Root<AdditionalInfo> addInfo = cq.from(AdditionalInfo.class);
        cq.select(cq.from(AdditionalInfo.class)).where(builder.equal(addInfo.get("expiredInfo"),(Boolean.FALSE)));

        return entityManager.createQuery(cq).getResultList();
    }

    public void modifyAddInfo(AdditionalInfo addInfo) throws Exception {
        entityManager.persist(addInfo);
    }
}
