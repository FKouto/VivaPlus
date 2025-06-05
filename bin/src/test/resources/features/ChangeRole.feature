@ChangeRole
Feature: Alterar a role de um usuário
  Como administrador,
  Eu quero alterar a role de um usuário,
  Para conceder ou restringir permissões.

  Scenario: Alterar a role com sucesso
    Given que o administrador esteja logado
    And que o usuário "8090008" exista
    When o administrador altera a role do usuário para "MANAGER"
    Then a role do usuário deve ser atualizada para "MANAGER"