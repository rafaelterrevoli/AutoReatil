Feature: Pruebas del sitio Retail

  @prueba
  Scenario:
    Given El usuario ingreso al sitio web
    When Realizo la busqueda de los productos desde el archivo productos
    Then Almaceno el detalle de los productos en el archivo detalles_productos
