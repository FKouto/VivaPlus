@UpdateProduct
Feature: Atualização de Produto

  Scenario: Atualizar produto
    Given o funcionário está logado
    And carrega a tela de cadastro de produto
    When selecione o produto de id 2
    And altera o campo "Quantidade" para 0
    Then o estoque deve ser atualizado conforme a ação realizada
    And o funcionário deve ver a mensagem: "Produto atualizado com sucesso!"