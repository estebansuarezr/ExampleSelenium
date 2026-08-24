Feature: Comprar articulos

  Background:
    Given el usuario se encuentra en la pagina de inicio
    When el usuario inicie sesion con sus credenciales
    Then el sistema debe mostrar la pagina SwagLabs

@ComprarArticulos
  Scenario Outline: Comprar articulos seleccionados
    Given el usuario selecciona los articulos del catalogo "<articulos>"
    When el usuario ingresa al carrito
    And el usuario realiza el checkout "<nombre>" "<apellido>" "<codigoZip>"
    Then el sistema debe mostrar la confirmación de compra

    Examples:
      | articulos | nombre | apellido | codigoZip |
      | Sauce Labs Bike Light,Sauce Labs Backpack,Sauce Labs Bolt T-Shirt | Juan | Suarez | 044444|