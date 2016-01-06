package com.epam.cp.dao.Impl;

import com.epam.cp.dao.RegistrationDao;

public class RegistrationDaoImpl implements RegistrationDao {

    private static RegistrationDao instance = new RegistrationDaoImpl();

    /**
     *
     * @return RegistrationDao instance
     */
    public static RegistrationDao getInstance() {
        return instance;
    }

}
