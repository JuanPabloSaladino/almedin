package org.umsa.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.dao.LoginDAO;
import org.umsa.model.Socio;
import org.umsa.repository.LoginRepository;

@ApplicationScoped
public class LoginDAOImpl implements LoginDAO {


    @Inject
    LoginRepository loginRepository;

    @Override
    public Socio login(String email, String contrasenia) {
        return loginRepository.login(email,contrasenia);
    }
}
