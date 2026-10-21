package ec.edu.epn.iswd752.tienda;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Objeto de prueba principal del laboratorio.
 * IMPORTANTE: esta versión contiene un defecto deliberado en el límite de USD 100.
 */
public class PricingService {

    public double finalTotal(double subtotal, boolean premium) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("El subtotal no puede ser negativo");
        }

        // Corregido: R1 exige subtotal "superior a" USD 100 (estrictamente mayor).
        if (premium && subtotal > 100.0) {
            return money(subtotal * 0.90);
        }

        return money(subtotal);
    }

    public double shippingCost(double subtotal, boolean express) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("El subtotal no puede ser negativo");
        }
        if (subtotal >= 200.0) {
            return 0.0;
        }
        return express ? 9.99 : 4.99;
    }

    private double money(double value) {
        return BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
