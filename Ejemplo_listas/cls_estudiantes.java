public class cls_estudiantes{
    private String str_nombre;
    private String str_id;
    private String str_contacto;
    private String str_correo;

    public cls_estudiantes(String nombre, String id, String contacto, String correo) {
        this.str_contacto = contacto;
        this.str_correo = correo;
        this.str_nombre = nombre;
        this.str_id = id;
    }
    //Funciones getters
    public String getNombre(){return str_nombre;}
    public String getId(){return str_id;}
    public String getContacto(){return str_contacto;}
    public String getCorreo(){return str_correo;}
    //Funciones setters
    public void setNombre(String nombre) {this.str_nombre = nombre;}
    public void setId(String id) {this.str_id = id;}
    public void setContacto(String contacto) {this.str_contacto = contacto;}
    public void setCorreo(String correo) {this.str_correo = correo;}
}