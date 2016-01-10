package com.epam.api.cp.ejb;

import com.epam.api.cp.entities.AdditionalInfo;

import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://www.epam.com/wsapi/types")
public interface AdditionalInfoService {

    AdditionalInfo getAddInfoByUserId(Long userId) throws Exception;

    List<AdditionalInfo> getFullList() throws Exception;

    void modifyAddInfo(AdditionalInfo addInfo) throws Exception;
}
