package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.LeerEscribirArchivoCSV;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;

public class HomeStep extends BaseTest{

    @Given("^El usuario ingreso al sitio web$")
    public void elUsuarioIngresoAlSitioWeb() {
            assertTrue(homePage.validarHome());
    }

    @When("^Realizo la busqueda de los productos desde el archivo (.+)$")
    public void realizoLaBusquedaDeLosProductosDelArchivoSomething(String nombreArchivoEntradaProductosCSV) throws IOException {
        ArrayList<String> listaProductos = new ArrayList<String>();
        listaProductos = LeerEscribirArchivoCSV.leerDatosCSV(nombreArchivoEntradaProductosCSV);
        for (String producto : listaProductos) {
            homePage.buscarProducto(producto);
        }
    }

    @Then("^Almaceno el detalle de los productos en el archivo (.+)$")
    public void almacenoElDetalleDeLosProductosEnElArchivoSomething(String nombreArchivoSalidaDetallesCSV) throws IOException {
        ArrayList<String> detallesProductos = new ArrayList<String>();
        detallesProductos = homePage.getListaDetallesProductos();
        LeerEscribirArchivoCSV.escribirDatosCSV(nombreArchivoSalidaDetallesCSV,detallesProductos);
    }


}
