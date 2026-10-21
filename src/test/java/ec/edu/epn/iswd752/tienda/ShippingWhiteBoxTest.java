package ec.edu.epn.iswd752.tienda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** PARTE C - Punto de partida para observar cobertura estructural con JaCoCo. */
class ShippingWhiteBoxTest {
    private final PricingService pricing = new PricingService();

    @Test
    void envioEstandarMenorA200Cuesta499() {
        assertEquals(4.99, pricing.shippingCost(80.00, false), 0.001);
    }

    // C1a: rama "subtotal >= 200" -> envio gratuito (R5).
    @Test
    void envioGratisConSubtotalMayorOIgualA200() {
        assertEquals(0.0, pricing.shippingCost(200.00, false), 0.001);
    }

    // C1b: rama "express = true" con subtotal < 200 (R5).
    @Test
    void envioExpressMenorA200Cuesta999() {
        assertEquals(9.99, pricing.shippingCost(80.00, true), 0.001);
    }

    // C1c: rama "subtotal < 0" -> excepcion, aun no ejercitada sobre shippingCost.
    @Test
    void subtotalNegativoEnEnvioDebeLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> pricing.shippingCost(-1.00, false));
    }
}
