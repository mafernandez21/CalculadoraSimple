/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import vista.VistaCalculadora;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class Calculadora implements ActionListener {

    VistaCalculadora miCalculadora;

    public VistaCalculadora getMiCalculadora() {
        return miCalculadora;
    }

    public void setMiCalculadora(VistaCalculadora miCalculadora) {
        this.miCalculadora = miCalculadora;
    }

    /**
     * Metodo que inicializa la calculadora, creando el controlador y la vista
     * @param args argumentos de la linea de comandos en este caso no utilizados
     */
    public static void main(String[] args) {
        //Se crea un nuevo controlador y una nueva vista
        //Tambien se establecen los enlaces Controlador <-> Vista
        Calculadora miControlador = new Calculadora();
        VistaCalculadora miGui = new VistaCalculadora(miControlador);
        miControlador.setMiCalculadora(miGui);

        //Se establecen parametros para la visualización de la 
        //Interface de Usuario Gráfica (en inglés GUI)
        miGui.setTitle("Calculadora Simple (Tutorial)");
        miGui.setLocationRelativeTo(null);
        miGui.pack();
        miGui.setVisible(true);
    }

    /**
     * Este metodo captura los eventos de la GUI, toma los metadatos y los 
     * precesa de acuerdo con el Modelo.
     * 1-Captura el evento y si este es "CALCULAR" continúa sino descarta.
     * 2-Recoge los metadatos desde la vista (N1,OPERACION,y N2), dentro de un 
     * try/catch porque existe la posibilidad de excepciones 
     * (NullPointerException o NumberFormatException).
     * 3-Crea una nueva Operacion correspondiente con lo que solicitó el usuario.
     * 4-Realiza el Calculo de la Operación.
     * 5-Envia el Resultado hacia la vista (GUI).
     * @param e Evento producido por algún componente de la GUI
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CALCULAR")) {
            try {
                //Captura de MetaDatos
                float n1 = Float.parseFloat(String.valueOf(this.getMiCalculadora().getMetaDatos().get("N1")));
                float n2 = Float.parseFloat(String.valueOf(this.getMiCalculadora().getMetaDatos().get("N2")));
                String codOp = String.valueOf(miCalculadora.getMetaDatos().get("OPERACION"));
                
                //Creacion de nueva Operacion
                Operacion op = null;
                switch (codOp) {
                    case "Suma":
                        op = new OperacionSuma(n1, n2);
                        break;
                    case "Diferencia":
                        n2 = n2 * (-1.0f);
                        op = new OperacionSuma(n1, n2);
                        break;
                    case "Producto":
                        op = new OperacionProducto(n1, n2);
                        break;
                    case "Cociente":
                        op = new OperacionCociente(n1, n2);
                        break;
                    default:
                        break;
                }
                op.calcular();
                this.getMiCalculadora().setDisplay(op.toString());
            } catch (NullPointerException | NumberFormatException ex) {
            }//Multicatch captura dos excepciones en un solo catch pero sin accion
        }
    }
}