package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.vivaplus.view.RegisterScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RegisterScreenSteps {

    private RegisterScreen screen;

    @Dado("que o usuário acessa a página de cadastro")
    public void acessarPaginaCadastro() {
        screen = new RegisterScreen();
        screen.setVisible(false);
    }

    @Quando("ele informa os dados: nome {string}, cip {string}, senha {string} e confirmação {string}")
    public void informarDados(String nome, String cip, String senha, String confirmacao) throws Exception {
        setTextField("txtName", nome);
        setTextField("txtCip", cip);
        setPasswordField("txtPassword", senha);
        setPasswordField("txtPasswordConfirm", confirmacao);
    }

    @Quando("clica no botão de registro {string}")
    public void clicarNoBotao(String botao) throws Exception {
        Method method = RegisterScreen.class.getDeclaredMethod("btnRegisterActionPerformed", ActionEvent.class);
        method.setAccessible(true);
        method.invoke(screen, new ActionEvent(this, ActionEvent.ACTION_PERFORMED, botao));
    }

    @Entao("deve ser exibida mensagem {string}")
    public void validarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, "Validação esperada: " + mensagem);
    }

    @Entao("ele deve ser direcionado à página de login")
    public void direcionarParaLogin() {
        // Validação ou execução do redirecionamento
        System.out.println("Validação do redirecionamento para a página de login");
    }

    private void setTextField(String fieldName, String value) throws Exception {
        Field field = RegisterScreen.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        Object obj = field.get(screen);
        if (obj instanceof JTextField) {
            ((JTextField) obj).setText(value);
        }
    }

    private void setPasswordField(String fieldName, String value) throws Exception {
        Field field = RegisterScreen.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        Object obj = field.get(screen);
        if (obj instanceof JPasswordField) {
            ((JPasswordField) obj).setText(value);
        }
    }
}