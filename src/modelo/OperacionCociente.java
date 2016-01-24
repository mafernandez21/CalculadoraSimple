/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package modelo;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class OperacionCociente extends Operacion {

    public OperacionCociente(float n1, float n2) {
        super(n1, n2);
    }

    @Override
    public void calcular() {
        this.setNombre("Cociente");
        this.setResultado(0.0f);

        try {
            this.calcularConControl(this.getN1(), this.getN2());
        } catch (UnsupportedOperationException e) {
            System.err.println("No se puede dividir por cero");
        }
    }

    public void calcularConControl(float n1, float n2) {
        if (n2 != 0.0f) {
            this.setResultado(n1 / n2);
        } else {
            throw new UnsupportedOperationException("Division por cero");
        }
    }

}
