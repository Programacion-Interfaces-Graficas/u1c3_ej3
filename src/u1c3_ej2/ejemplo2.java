package u1c3_ej2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ejemplo2 implements ActionListener{
	//Declaracion de variable globales 
	private JLabel etiqueta;
	private JTextField campo;
	private JButton button;
	private JLabel etiquetaSalida;

	public ejemplo2() {
		//Crear un nuevo contenedor JFrame
		JFrame ventana=new JFrame("Ejemplo 3");
		//Especificar FlowLayout como administrador de dise;o
		ventana.getContentPane().setLayout(new FlowLayout());
		//Asignar el tamaño inicial de la ventana
		ventana.setSize(400,150);
		//Terminar el programa cuando el usuario cierre la ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Crear las etiquetas
		etiqueta=new JLabel("Ingrese el texto:");
		etiquetaSalida=new JLabel("");//Etiqueta para mostrar el texto del campo
		//Crear un campo de texto
		campo=new JTextField(10);//10 columnas de ancho
		//Establecer los comandos de accion para el campo de texto
		campo.setActionCommand("myTF");
		//Crear un boton usando el componente JButton
        button = new JButton("REVERTIR"); 
        //Agregar escuchadores de accion
        campo.addActionListener(this);
        button.addActionListener(this); 
		//Añadir los componentes al panel de contenido
        ventana.getContentPane().add(etiqueta);
        ventana.getContentPane().add(campo);
        ventana.getContentPane().add(button);
        ventana.getContentPane().add(etiquetaSalida);
		//Mostrar la ventana
		ventana.setVisible(true);
		
	} 

	public static void main(String[] args) {
		//Crea la ventana en el subproceso de entrega de eventos
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ejemplo2();
			}
			
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("REVERTIR")) {
			//Se ha pulsado el boto revetir
			//Cargar el texto del campo en un variable tipo String
			String oriTexto=campo.getText();
			//Crear una variable paara contener la palabra invertida
			String desTexto="";
			//Invertir la cadena en la variable desTexto
			for(int i=oriTexto.length()-1;i>=0;i--) {
				desTexto+=oriTexto.charAt(i);
			}
			//Almacenar la cadena invertida en el label etiquetaSalida
			etiquetaSalida.setText("Texto invertido:"+desTexto);
		}else if(e.getActionCommand().equals("myTF")) {
			//Se a pulsado Enter y permite ejecutar este evento en el campo de texto
			etiquetaSalida.setText("Texto ingresado:"+campo.getText());
		}
		
	}
}
