package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.vivaplus.view.LoginScreen;

import javax.swing.*;
import java.lang.reflect.Field;

public class LoginScreenSteps {

    private LoginScreen loginScreen;

    @Given("que o usuário acessa a página de login")
    public void acessarPaginaDeLogin() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            loginScreen = new LoginScreen();
            loginScreen.setVisible(true);
        });
        // Aguarda a inicializa\\u00e7\\u00e3o
        Thread.sleep(500);
    }

    @When("ele informa os dados: cip {string}, senha {string}")
    public void informarDados(String cip, String senha) throws Exception {
        Field cipField = loginScreen.getClass().getDeclaredField("txtCip");
        cipField.setAccessible(true);
        JTextField txtCip = (JTextField) cipField.get(loginScreen);

        Field passwordField = loginScreen.getClass().getDeclaredField("txtPassword");
        passwordField.setAccessible(true);
        JPasswordField txtPassword = (JPasswordField) passwordField.get(loginScreen);

        SwingUtilities.invokeAndWait(() -> {
            txtCip.setText(cip);
            txtPassword.setText(senha);
        });
        Thread.sleep(500);
    }

    @When("clica no botão de login {string}")
    public void clicarNoBotao(String botao) throws Exception {
        if ("Login".equals(botao)) {
            Field btnLoginField = loginScreen.getClass().getDeclaredField("btnLogin");
            btnLoginField.setAccessible(true);
            JButton btnLogin = (JButton) btnLoginField.get(loginScreen);

            SwingUtilities.invokeAndWait(btnLogin::doClick);
            Thread.sleep(1000);
        }
    }

    @Then("ele deve ser direcionado à página de catálogo")
    public void validarDirecionamentoCatalogo() throws Exception {
        // Se o login for bem-sucedido, a tela de login deve ser descartada.
        Assert.assertFalse("Tela de login ainda visível", loginScreen.isDisplayable());
    }
}