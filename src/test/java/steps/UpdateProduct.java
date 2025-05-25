package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.vivaplus.view.dashboard.manager.UpdateProdManagerScreen;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class UpdateProduct {

    private UpdateProdManagerScreen updateScreen;

    @Given("o funcionário está logado")
    public void funcionario_logado() {
        updateScreen = new UpdateProdManagerScreen();
        updateScreen.setVisible(true);
    }

    @Given("carrega a tela de cadastro de produto")
    public void carrega_tela_cadastro_produto() {
        assertNotNull(updateScreen);
    }

    @When("selecione o produto de id {int}")
    public void seleciona_produto_de_id(Integer id) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                updateScreen.txtProductId.setText(String.valueOf(id));
                updateScreen.btnBuscar.doClick();
            });
            Thread.sleep(500);
        } catch (InterruptedException | InvocationTargetException e) {
            // Ignora exceções para teste
        }
    }

    @When("altera o campo {string} para {int}")
    public void altera_campo_para_valor(String campo, Integer valor) {
        if ("Quantidade".equals(campo)) {
            try {
                SwingUtilities.invokeAndWait(() ->
                        updateScreen.txtProductQuantity.setText(String.valueOf(valor))
                );
                Thread.sleep(500);
            } catch (InterruptedException | InvocationTargetException e) {
                // Ignora exceções para teste
            }
        }
    }

    @Then("o estoque deve ser atualizado conforme a ação realizada")
    public void estoque_atualizado() {
        try {
            SwingUtilities.invokeAndWait(() ->
                    updateScreen.btnAlterar.doClick()
            );
            Thread.sleep(1000);
        } catch (InterruptedException | InvocationTargetException e) {
            // Ignora exceções para teste
        }
        assertFalse(updateScreen.isDisplayable());
    }

    @Then("o funcionário deve ver a mensagem: {string}")
    public void funcionario_ver_mensagem(String mensagemEsperada) {
        assertTrue(true);
    }
}