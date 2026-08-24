Feature: Remover articulo del carrito

  Background:
    Given el usuario se encuentra en la pagina de inicio
    When el usuario inicie sesion con sus credenciales
    Then el sistema debe mostrar la pagina SwagLabs

@RemoverArticulo
  Scenario Outline: Remover un articulo agregado al carrito
    Given el usuario selecciona un articulo del catalogo "<articulo>"
    When el usuario ingresa al carrito
    And el usuario remueve el articulo "<articulo>" del carrito
    Then el sistema debe mostrar el carrito vacio "<articulo>"

    Examples:
      | articulo |
      | Sauce Labs Bike Light |