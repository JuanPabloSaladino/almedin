package org.umsa.bo;

import org.umsa.dto.LoginDTO;

public interface LoginBO {

    public LoginDTO login(String email, String password);

}
