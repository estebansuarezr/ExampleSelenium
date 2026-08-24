Feature: Validar articulo

  Background:
    Given el usuario se encuentra en la pagina de inicio
    When el usuario inicie sesion con sus credenciales
    Then el sistema debe mostrar la pagina SwagLabs

@ValidarArticulo
  Scenario Outline: Validar el precio y descripcion de un articulo
    When el usuario ingresa al detalle del articulo "<articulo>"
    Then el sistema debe mostrar el precio y la descripcion del articulo "<precio>" "<descripcion>"

    Examples:
      | articulo | precio | descripcion |
      | Sauce Labs Bike Light | $9.99 | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.|