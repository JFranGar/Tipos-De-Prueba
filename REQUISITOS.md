# Base de prueba - TiendaLab

## R1 - Descuento Premium
Un cliente Premium recibe un descuento del 10 % cuando el subtotal de la compra es **superior a USD 100.00**.

## R2 - Límite exacto
Una compra de **USD 100.00** no recibe descuento, incluso si el cliente es Premium.

## R3 - Cliente no Premium
Un cliente no Premium no recibe descuento, independientemente del subtotal.

## R4 - Datos inválidos
Un subtotal negativo debe ser rechazado mediante una excepción.

## R5 - Envío
- Si el subtotal es igual o superior a USD 200.00, el envío es gratuito.
- En compras menores a USD 200.00, el envío estándar cuesta USD 4.99.
- En compras menores a USD 200.00, el envío express cuesta USD 9.99.

## RNF1 - Rendimiento (smoke pedagógico)
Una búsqueda en un catálogo de aproximadamente 100 000 productos debe completarse en menos de 2 segundos en el equipo de laboratorio.

> RNF1 solo sirve para ilustrar el tipo no funcional. Una evaluación profesional de rendimiento requiere un entorno controlado, carga representativa, métricas y herramientas especializadas.
