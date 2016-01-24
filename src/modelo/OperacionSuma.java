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
public class OperacionSuma extends Operacion{

    public OperacionSuma(float n1, float n2) {
        super(n1, n2);
    }
    
    @Override
    public void calcular() {
        this.setNombre("Suma");
        this.setResultado(0.0f);
        this.setResultado(this.getN1()+this.getN2());
    }
}
