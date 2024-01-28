package colegio;

import java.util.*;

// Creamos una clase colegio y una clase estudiante.
public class Colegio {

    //Vamos a crear el método constructor sin las listas (Estudiante, profesor y curso).
    //Generamos el constructor seleccionando todos a excepción de lo nombrado.

    public Colegio(String nombre, String direccion, String telefono, String director, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.director = director;
        this.capacidad = capacidad;
    }

    // Creamos un método para matricular estudiantes.
    //Como tiene que ser public y no devolvernos nada vamos a utilizar public void.
    //Le pasamos una clase Estudiante.
    public void matricularEstudiante(Estudiante estudiante){

    // El programa no debería permitir matricular estudiantes si la capacidad ha llegado al límite.
        //Para controlar eso vamos a utilizar un if, si la capacidad es mayor que el número de estudiantes entonces matriculamos al estudiante y lo añadimos a la lista.
        if(estudiantes.size()<capacidad){
            estudiantes.add(estudiante);
        }else{
            // Si no, imprimimos por pantalla un aviso de que no hay más plazas.
            System.out.println("Capacidad máxima alcanzada");
        }
    }

    //Creamos también otro método public que no devuelve nada para expulsar estudiantes.
    public void expulsarEstudiante(Estudiante estudiante){

        estudiantes.remove(estudiante); //Utilizamos el método remove de la clase ArrayList. Eliminamos al estudiante que pasamos por parámetro.
    }

    //Usamos de nuevo public void porque no queremos que devuelva nada.
    //Le tenemos que pasar un parámetro String profesor.
    //Si tuviese una clase profesor pues tendría que ser un objeto de tipo profesor pero como no es el caso lo vamos a hacer así.
    public void contratarProfesor(String profesor){

        profesores.add(profesor); //Agregamos a la lista profesores este profesor.

    }

    //En este método hacemos lo mismo para eliminar profesor.
    public void despedirProfesor(String profesor){

        profesores.remove(profesor); //Borramos al profesor que pasamos por parámetro de la lista.
    }

    //Creamos el método para agregar cursos.
    public void agregarCurso(String curso){

        cursos.add(curso); //Agreganos el curso a la lista

    }

    //Creamos otro método para eliminar cursos.
    public void eliminarCurso(String curso){

        cursos.remove(curso); // Y eliminamos el curso recibido por parámetro de la lista de cursos.

    }

    //Necesitamos un método que nos permita obtener los datos del colegio y otro para cambiarlos.

    //Con el método get obtenemos la información y con el método set la modificamos. Por eso se llaman getters and setters.
    //Podemos generarlos desde el entorno de desarrollo y luego modificarlos para que se ajusten a lo que queremos.
    //En este caso no nos genera lo que queremos porque no necesitamos toodo asi que lo vamos a crear a mano.

    //Vamos primero con los getter y como nos va a devolver un String utilizamos public String.
    public String getDatosColegio(){
        return "Nombre: " + nombre + "Direcion: " + direccion + "Teléfono: " + telefono + "Capacidad: " + capacidad + "Director: " + director; //Concatenamos los datos que queremos que nos devuelva.
    }

    //Ahora necesitanos los setters que nos permitan modificar los datos y como no queremos que nos devuelva nada pues usaremos void.
    public void setDatosColegio(String nombre, String direccion, String telefono, int capacidad,String director){ //Aqui especificamos los valores que queremos que sea capaz de modificar.

        // Aquí especificamos que el campo de clase nombre tiene que ser igual a valor que le pasamos por parametro al método setDatosColegio, nombre.
        //Para diferenciar el campo de clase de lo que le pasamos por parámetro en java se utiliza la palabra this en el campo de clase.
        this.nombre=nombre;
        this.direccion=direccion;
        this.telefono=telefono;
        this.capacidad=capacidad;
        this.director=director;

    }

    // Método para matricular a un estudiante

    public void matricularEstudiante(Estudiante estudiante, String curso){ //Pasamos por parámetro un objeto de tipo estudiante y también que reciba también el curso donde lo queremos matricular.

        if(estudiantes.size()<capacidad){ //Comprobamos que todavía hay capacidad para inscribir más estudiantes. Si la capacidad es mayor de el tamaño de la lista de alumnos entonces si podemos matricular aunque antes tenemos que comprobar que el curso exista.
            if (cursos.contains(curso)){ //Con un if anidado hacemos la comprobación.
                estudiante.inscribirCurso(curso); //Inscribimos al alumno en el curso

                estudiantes.add(estudiante); // Y lo agregamos a la lista de estudiantes.
            }else {
                System.out.println("El curso no se imparte en el colegio."); //Si el curso no existe avisamos de que el curso no se imparte en el colegio.
            }
        } else {
            System.out.println("Capacidad máxima alcanzada"); //Si la capacidad esta llena avisamos de que no caben más alumnos en la clase.
        }

    }

    // Método para obtener la lista de cursos.
    public List<String> obtenerCursos(){ //Tiene que ser de tipo List. Este método no lo tenemos en el diagrama pero lo vamos a agregar. Porque cuando queramos inscribir a un alumno en un curso podamos ver los cursos disponibles.

        return cursos;
    }

    // Vamos a ir creando las propiedades encapsuladas que están reflejadas en el diagrama UML.
    private String nombre, direccion, telefono, director; // Como todas van a ser de tipo String añadimos todas aquí y utilizamos private porque va a ir encapsulada.
    private int capacidad;

    private List<Estudiante> estudiantes = new ArrayList<>(); //Como la relación es de uno a varios vamos a necesitar una estructura que permita guardar varios estudiantes asi que vamos a usar un ArrayList.
    private List<String> profesores = new ArrayList<>(); // Utilizamos también una lista aqui porque necesitamos guardar varios profesores.
    private List<String> cursos = new ArrayList<>(); // Otra lista para guardar cursos.
}
