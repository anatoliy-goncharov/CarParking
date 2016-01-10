package com.epam.api.cp.ejb.beans;

import com.epam.api.cp.ejb.AdditionalInfoService;
import com.epam.api.cp.ejb.SpacerExpiredInfoService;
import com.epam.api.cp.ejb.SpacerExpiredInfoServiceLocal;
import com.epam.api.cp.entities.AdditionalInfo;

import javax.ejb.*;
import java.util.List;

@Stateless
@TransactionAttribute
@Remote(SpacerExpiredInfoService.class)
@Local(SpacerExpiredInfoServiceLocal.class)
public class SpacerExpiredInfoServiceBean implements SpacerExpiredInfoService, SpacerExpiredInfoServiceLocal{

    @EJB
    AdditionalInfoService additionalInfoService;

    public void makeAddInfoexpired() throws Exception {
        List<AdditionalInfo> result = additionalInfoService.getFullList();

        for (AdditionalInfo info : result){
            info.setExpiredInfo(Boolean.TRUE);
            additionalInfoService.modifyAddInfo(info);
        }
    }
}
