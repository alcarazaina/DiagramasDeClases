package colegio;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {

    //Generamos los constructores a excepción del id como indica el diagrama UML.
    //Botón derecho - generate - constructor - quitamos la selección de id y los generamos.
    public Estudiante(String nombre, String apellido, String fechaNacimiento, String direccion, String telefono, String email, Colegio colegio) { //Añadimos también al constructor el colegio al que pertenece el estudiante.
        super();
        this.nombre = nombre; //nombre
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.colegio=colegio; //Añadimos el constructor para Colegio.
    }

    public void inscribirCurso(String curso){ //Como tiene que ser público y no devuelve nada pues public void y le pasamos por parámetro curso en el que vamos a inscribir al alumno que va a ser de tipo String.

        if(colegio.obtenerCursos().contains(curso)){ //tenemos que llamar al método de la clase Colegio obtenerCurso que nos va a devolver la lista de cursos y comprobar si el curso al que quiero incribir al estudiante está en el Colegio para ello utilizamos el método contains.
            cursosInscritos.add(curso); //Si si existe en el colegio añadimos el curso.
        } else {
            System.out.println("El curso no se imparte en el colegio"); //Si no imprimimos por pantalla un mensaje avisando de que el curso no existe.
        }

    }

    public void abandonarCurso(){ //Tiene que ser de tipo void porque no nos va a devolver ningun valor no necesita un return.


    }

    public int obtenerEdad(){ //Aqui como si nos va a devolver un valor tenemos que poner el tipo de dato que nos va a devolver y dentro del método un return.

      return 0;
    }

    public List<String> obtenerCursosInscritos (){ //Como nos va a devolver no solo un valor, si no que almacena todos los cursos pues le tenemos que declarar una lista y dentro del métedo un return con la lista.


        return cursosInscritos;
    }



    public void setDatosContacto(String direccion,String telefono, String email){ //Como indica en el diagrama el setter debe recibir por parámmetro las variables de tipo String; direccion, telefono y email.
        //Como queremos que el setter nos establezca los tres campos a la vez no vamos a utilizar la herramienta que nos da el entorno de desarrollo, porque los genera uno a uno, asi que los vamos a crear a mano.

        this.direccion=direccion;
        this.telefono=telefono;
        this.email=email;

    }


    public String getDatosEstudiante(){ //Vamos a hacer también esto de forma manual, concatenando los datos que queremos que nos devuelva, usamos String porque los datos que nos va a devolver son de tipo String.

        return "ID: " + id + "Nombre: " + nombre + apellido + "Fecha de nacimiento: " + fechaNacimiento + "Dirección: " + direccion + "Teléfono: " + telefono + "Email: " + email;

    }

    //Vamos crear las propiedades que son privadas.
    private String id, nombre, apellido, fechaNacimiento, direccion, telefono, email; //Los declaramos todos en una línea porque todos estos son de tipo String. Podríamos crear la fecha como tipo date pero como no vamos a hacer ninguna operación pues lo declaramos como String.
    private Colegio colegio; //Creamos un campo encapsulado de clase Colegio.
    private List<String> cursosInscritos=new ArrayList<>(); //Como vamos a necesitar una lista con los cursos pues creamos un ArrayList con una lista de todos los cursos inscritos.

}
