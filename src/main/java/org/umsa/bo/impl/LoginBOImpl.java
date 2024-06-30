package org.umsa.bo.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.umsa.bo.LoginBO;
import org.umsa.dao.LoginDAO;
import org.umsa.dto.LoginDTO;
import org.umsa.model.Socio;

@ApplicationScoped
public class LoginBOImpl implements LoginBO {

    @Inject
    LoginDAO loginDAO;


    @Override
    public LoginDTO login(String email, String contrasenia) {

        Socio usuario = loginDAO.login(email,contrasenia);
        LoginDTO loginDTO = new LoginDTO();

        if (usuario != null) {
            loginDTO.setIdUsuario(usuario.id);
            loginDTO.setNombreUsuario(usuario.getNombre());
            loginDTO.setRol(usuario.getRol());

        } else {
            loginDTO=null;
        }


        return loginDTO;
    }
}
