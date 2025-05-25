@Login
Feature: Login de Funcionário

  Scenario: Login de Funcionário
    Given que o usuário acessa a página de login
    When ele informa os dados: cip "8090008", senha "@felipe"
    And clica no botão de login "Login"
    And ele deve ser direcionado à página de catálogo