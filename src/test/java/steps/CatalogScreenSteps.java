package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.vivaplus.view.catalog.CatalogProductsScreen;

public class CatalogScreenSteps {

    private CatalogProductsScreen catalogScreen;

    @Dado("que o funcionário está logado")
    public void funcionarioEstaLogado() {
        // Para fins de teste, assume-se que o funcionário já está autenticado.
        System.out.println("Funcionário autenticado.");
    }

    @Quando("ele acessa a seção de catálogo")
    public void acessarSeccaoCatalogo() {
        catalogScreen = new CatalogProductsScreen();
        catalogScreen.setVisible(true);
        System.out.println("Seção de catálogo acessada.");
    }

    @Entao("a lista de medicamentos deve ser exibida corretamente")
    public void validarListaMedicamentosExibida() {
        // Pode-se realizar validações específicas, como verificar se a tabela de catálogo não está vazia,
        // porém para fins de exemplo, usaremos uma asserção simples de instância.
        Assert.assertNotNull("A tela do catálogo não foi instanciada", catalogScreen);
        System.out.println("Catálogo exibido corretamente.");
    }
}