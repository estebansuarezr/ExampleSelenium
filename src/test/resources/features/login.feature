Feature: Login

  @LogIn
  Scenario: Login exitoso
    Given el usuario se encuentra en la pagina de inicio
    When el usuario inicie sesion con sus credenciales
    Then el sistema debe mostrar la pagina SwagLabs