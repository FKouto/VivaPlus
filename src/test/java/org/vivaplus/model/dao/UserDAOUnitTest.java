package org.vivaplus.model.dao;

import org.junit.Before;
import org.junit.Test;
import org.vivaplus.model.bean.User;
import org.vivaplus.model.enums.Roles;

import java.util.Random;

import static org.junit.Assert.*;

public class UserDAOUnitTest {

    private UserDAO userDAO;
    private User userTest;
    private Random random = new Random();

    @Before
    public void setUp() {
        userDAO = new UserDAO();

        userTest = new User();
        // Gera um id único dentro do range de Integer
        int generatedId = (int) (System.nanoTime() % 1000000);
        userTest.setId(String.valueOf(generatedId));
        userTest.setName("Teste Unitario");
        // Utiliza os últimos 7 dígitos do System.nanoTime() para garantir a singularidade do CIP
        String fullTime = String.valueOf(System.nanoTime());
        userTest.setCip(fullTime.substring(Math.max(0, fullTime.length() - 7)));
        userTest.setPassword("senha");
        userTest.setRole(Roles.BASIC);
    }

    @Test
    public void testRegister() {
        boolean registered = userDAO.register(userTest);
        assertTrue("Falha ao registrar o usuário.", registered);
    }

    @Test
    public void testGetAllUsers() {
        userDAO.register(userTest);
        assertFalse("A lista de usuários não deve estar vazia.", userDAO.getAllUsers().isEmpty());
    }

    @Test
    public void testUpdateUserRole() {
        userDAO.register(userTest);
        int id = Integer.parseInt(userTest.getId());
        boolean updated = userDAO.updateUserRole(id, Roles.ADMIN);
        assertTrue("Falha ao atualizar o role do usuário.", updated);
    }

    @Test
    public void testGetUserById() {
        userDAO.register(userTest);
        int id = Integer.parseInt(userTest.getId());
        User foundUser = userDAO.getUserById(id);
        assertNotNull("Usuário não encontrado.", foundUser);
        assertEquals("Nome do usuário incorreto.", "Teste Unitario", foundUser.getName());
    }

    @Test
    public void testDeleteUser() {
        userDAO.register(userTest);
        int id = Integer.parseInt(userTest.getId());
        boolean deleted = userDAO.deleteUser(id);
        assertTrue("Falha ao deletar o usuário.", deleted);
    }
}