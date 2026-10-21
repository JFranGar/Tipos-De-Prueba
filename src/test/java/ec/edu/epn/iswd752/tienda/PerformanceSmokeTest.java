package ec.edu.epn.iswd752.tienda;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PARTE D - Smoke test no funcional de eficiencia de desempeño.
 * Es didactico: NO sustituye un benchmark ni una prueba de carga con JMeter/k6.
 */
class PerformanceSmokeTest {

    @Test
    void buscarEnCienMilProductosDebeCompletarEnMenosDeDosSegundos() {
        CatalogSearch search = new CatalogSearch();
        List<String> catalog = new ArrayList<>(100_000);
        for (int i = 0; i < 100_000; i++) {
            catalog.add("Producto-" + i);
        }
        catalog.add("Laptop-Premium-EPN");

        assertTimeout(Duration.ofSeconds(2), () -> {
            List<String> found = search.search(catalog, "premium");
            assertEquals(1, found.size());
        });
    }
}
