package org.umsa.dao;

import org.umsa.model.Socio;

public interface LoginDAO {

    public Socio login (String email, String contrasenia);

}
