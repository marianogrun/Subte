package subte;

import java.awt.event.*;

public class Controlador {

    private Modelo m;
    private Vista v;
    private String sentido;

    public Controlador(Modelo m, Vista v) {
        this.m = m;
        this.v = v;
        sentido = "Siguiente";
    }

    public void ejecutar() {
        v.mostrar();
        v.addBotonAvanzarListener(new AvanzarListener());
    }

    private class AvanzarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            m.consultar(v.obtenerTextFieldEstacion(), sentido);
            if (m.getResultadoEstacionConsulta().equals("No hay")) {
                if (sentido.equals("Siguiente"))
                    sentido = "Anterior";
                else
                    sentido = "Siguiente";
            m.consultar(v.obtenerTextFieldEstacion(), sentido);
            }
            v.mostrarTextFieldEstacion(m.getResultadoEstacionConsulta());
            v.mostrarTextAreaComentario(m.getResultadoComentarioConsulta());
        }
    }

}