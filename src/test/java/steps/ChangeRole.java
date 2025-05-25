package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.vivaplus.model.bean.User;
import org.vivaplus.model.dao.UserDAO;
import org.vivaplus.model.enums.Roles;

import static org.junit.Assert.assertEquals;

public class ChangeRole {

    private int userId;
    private Roles newRole;
    private boolean updateSuccess;

    @Dado("que o administrador esteja logado")
    public void que_o_administrador_esteja_logado() {
        // Simulação de login do administrador.
        // Implementação pode ser adicionada se necessário.
    }

    @Dado("que o usuário {string} exista")
    public void que_o_usuario_exista(String username) {
        // Para fins de teste, assume-se que o usuário existe e define seu ID.
        // Se existir um método para buscar por username, ele pode ser utilizado.
        this.userId = 1;
    }

    @Quando("o administrador altera a role do usuário para {string}")
    public void o_administrador_altera_a_role_do_usuario_para(String role) {
        this.newRole = Roles.valueOf(role.toUpperCase());
        UserDAO userDAO = new UserDAO();
        updateSuccess = userDAO.updateUserRole(userId, newRole);
    }

    @Entao("a role do usuário deve ser atualizada para {string}")
    public void a_role_do_usuario_deve_ser_atualizada_para(String role) {
        Roles expectedRole = Roles.valueOf(role.toUpperCase());
        UserDAO userDAO = new UserDAO();
        // Certifique-se de que UserDAO possua o método getUserById para que esse teste funcione.
        User user = userDAO.getUserById(userId);
        assertEquals(expectedRole, user.getRole());
    }
}