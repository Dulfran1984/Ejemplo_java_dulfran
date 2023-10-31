import java.util.LinkedList;
import javax.swing.JOptionPane;

public class app_registro {
    static LinkedList<cls_estudiantes> obj_estudiantes = new LinkedList<>();
    static int posicion = 0;
    static boolean bln_sw;

    public static void main(String[] args) {
        fnt_menu(true);
    }

    private static void fnt_registrar(String id, String nombre, String contacto, String correo) {
        if (id.equals("") || nombre.equals("") || contacto.equals("") || correo.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar toda la información solicitada", "Registrar",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            obj_estudiantes.add(new cls_estudiantes(nombre, id, contacto, correo));
            JOptionPane.showMessageDialog(null, "Estudiante registrado con exito", "Registro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void fnt_consultar(String id) {
        for (int i = 0; i < obj_estudiantes.size(); i++) {
            if (id.equals(obj_estudiantes.get(i).getId())) {
                posicion = i;
                bln_sw = true;
            }
        }
        if (bln_sw == false) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos registrados", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Nombre: " + obj_estudiantes.get(posicion).getNombre() + "\nContacto: "
                            + obj_estudiantes.get(posicion).getContacto() + "\nCorreo: "
                            + obj_estudiantes.get(posicion).getCorreo());
        }
    }

    private static void fnt_actualizar(String id) {
        for (int i = 0; i < obj_estudiantes.size(); i++) {
            if (id.equals(obj_estudiantes.get(i).getId())) {
                posicion = i;
                bln_sw = true;
            }
        }
        if (bln_sw == false) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos registrados", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String actualizar = JOptionPane.showInputDialog(null,
                    "¿Que desea actualizar?\n\n1.Nombre\n2. Contacto\n3. Correo");
            if (actualizar.equals("1")) {
                String nombre = JOptionPane.showInputDialog(null, "Nombre");
                obj_estudiantes.get(posicion).setNombre(nombre);
            }
            if (actualizar.equals("2")) {
                String contacto = JOptionPane.showInputDialog(null, "Contacto");
                obj_estudiantes.get(posicion).setContacto(contacto);
            }
            if (actualizar.equals("3")) {
                String correo = JOptionPane.showInputDialog(null, "Correo");
                obj_estudiantes.get(posicion).setCorreo(correo);
            }
            JOptionPane.showMessageDialog(null, "Datos actualizados con éxito", "Actualizar",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void fnt_selector(String opcion) {
        if (opcion.equals("1")) {
            String id = JOptionPane.showInputDialog(null, "Identificación");
            String nombre = JOptionPane.showInputDialog(null, "Nombre");
            String contacto = JOptionPane.showInputDialog(null, "Contacto");
            String correo = JOptionPane.showInputDialog(null, "Correo");
            fnt_registrar(id, nombre, contacto, correo);
        }
        if (opcion.equals("2")) {
            String id = JOptionPane.showInputDialog(null, "Identificación");
            fnt_consultar(id);
        }
        if (opcion.equals("3")) {
            String id = JOptionPane.showInputDialog(null, "Identificación");
            fnt_actualizar(id);
        }
    }

    private static void fnt_menu(boolean menu) {
        while (menu == true) {
            String op = JOptionPane.showInputDialog(null,
                    "<<< MENU PRINCIPAL >>>\n\n1. Registrar\n2. Consultar\n3. Actualizar\n4. Salir");
            fnt_selector(op);
        }
    }
}