Feature: Probar el Inicio de Sesion

Scenario: Ingresar a la pagina mediante URL
    Given navego a xpo
    When  login con sso 
    Then obtengo la pagina de Agreements