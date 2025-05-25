Feature: Cadastro Funcionario

  Scenario: Cadastrar Funcionario
    Given que o usuário acessa a página de cadastro
    When ele informa os dados: nome "Felipe Couto", cip "8090008", senha "@felipe" e confirmação "@felipe"
    And clica no botão de registro "Registrar"
    Then deve ser exibida mensagem "Usuário registrado com sucesso!"
    And ele deve ser direcionado à página de login