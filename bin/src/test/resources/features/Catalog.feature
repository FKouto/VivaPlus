@Catalog
Feature: Exibir Catálogo de Medicamentos

  Scenario: Exibir Catálogo de Medicamentos
    Given que o funcionário está logado
    When ele acessa a seção de catálogo
    Then a lista de medicamentos deve ser exibida corretamente