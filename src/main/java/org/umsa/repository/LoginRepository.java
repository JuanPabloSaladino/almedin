package org.umsa.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.umsa.model.Socio;

@ApplicationScoped
public class LoginRepository  implements PanacheRepository<Socio> {


    public Socio login (String email, String contrasenia) {

        String query = "SELECT s FROM Socio s WHERE s.email = :email AND s.contrasenia = :contrasenia";

    try {

        Socio socio = getEntityManager().createQuery(query, Socio.class)
                .setParameter("email",email)
                .setParameter("contrasenia",contrasenia)
                .getSingleResult();

    return socio;

    }catch (Exception e) {
        return null;
    }

    }


}
