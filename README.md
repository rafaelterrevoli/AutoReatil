# Desafio de automatización

## Contexto General 📋

- El framework de automatización está construido con Selenium + Java  + Junit + Cucumber
- Se empleo el patrón de diseño Page Object Model con Page Factory, este patrón ofrece ventajas y 
buenas prácticas para la automatización como: separación del los objetos de página de las 
  pruebas, actualizar y mantener fácilmente las clases objetos de página.
- Se uso Cocumber (Gherkin) para los escenarios de pruebas, esto permite un formato entendible 
  (Gherkin) por personas sin conocimientos técnicos (Product Owners, negocio). 
- Junit para las validaciones (aserciones)
- Se uso maven para gestionar las librerías necsarias para la automatización, el archivo pom.xml 
  contiene el listado de dependencias.
  
  
## Pre-requisitos 📋

- La automatización fue hecha usando el IDE IntelliJ.
- Los datos como url y tipo de navegador para la automatización están en el archivo config.properties en src/test/resources.
- Los datos de estrada están en el archivo productos.csv 
- El chromedrive esta en la ruta: "src/test/resources/driver/chromedriver.exe";
- Contenido del archivo config.properties: 


```
url=https://www.hites.com/
navegador=chrome
```

- Contenido del archivo productos.csv: 


```
productos
Mesa
Silla
Refrigerador
```


## Ejecutando las pruebas ⚙️

- Abrir como proyecto maven.
- Ejecutar desde el fuente TestRunner.java en \src\test\java\runner

```
package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/Prueba.feature",
        glue = {"steps"},
        tags = {"@prueba"}

)
public class TestRunner {

}

```


## Resultados en detalles_productos.csv 📄

- La ubicación del archivos es: /src/test/resources/detalles_productos.csv
- Ejemplo de los resultados:
```
Nombre Producto,SKU,Despacho a Domicilio,Retiro en Tienda
Mesa De Arrimo Universal Market Lisboa,SKU: 860053001,True,False
Juego de Comedor Casaideal Tokio / 8 Sillas,SKU: B839801,True,False
Refrigerador Side By Side Midea MRSBS-5300G689WE / No Frost / 527 Litros,SKU: 753897001,True,False
```
---
Cualquier duda me pueden contactar por: rafaelterrevoli@gmail.com 😊
