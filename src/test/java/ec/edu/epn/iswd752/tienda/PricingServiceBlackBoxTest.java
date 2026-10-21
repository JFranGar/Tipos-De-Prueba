package ec.edu.epn.iswd752.tienda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PARTE A - Pruebas funcionales de caja negra.
 * Trabaje primero SOLO con REQUISITOS.md. No inspeccione PricingService.java hasta la parte C.
 */
class PricingServiceBlackBoxTest {
    private final PricingService pricing = new PricingService();

    @Test
    void premiumCon120DebePagar108() {
        assertEquals(108.00, pricing.finalTotal(120.00, true), 0.001);
    }

    // CP02 - R2: cliente Premium con subtotal exactamente 100.00 no recibe descuento.
    @Test
    void premiumCon100NoDebeTenerDescuento() {
        assertEquals(100.00, pricing.finalTotal(100.00, true), 0.001);
    }

    // CP03 - R3: cliente NO Premium con subtotal 150.00 paga el total sin descuento.
    @Test
    void noPremiumCon150DebePagar150() {
        assertEquals(150.00, pricing.finalTotal(150.00, false), 0.001);
    }

    // CP04 - R4: un subtotal negativo debe ser rechazado mediante una excepcion.
    @Test
    void subtotalNegativoDebeLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> pricing.finalTotal(-1.00, true));
    }
}
