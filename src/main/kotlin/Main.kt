import Modulo.Companion.EV_PRI
import jdk.nashorn.internal.runtime.Debug.id

class Modulo(var numeroDeAlumnos: Int = 15, maxAlumnos: Int = 20) {

    //array de nulos de tipo clase Alumno y se mete la var numero de Alumnos
    var matriculados = arrayOfNulls<Alumno>(numeroDeAlumnos) // numero de alumnos matriculados
    //todo ordenar el array por la id de alumno

    companion object {
        const val EV_PRI = "0"
        const val EV_SEG = "1"
        const val EV_TER = "2"
        const val EV_FIN = "3"
    }

    var notas = Array(4)
    { FloatArray(numeroDeAlumnos) { -1.0F } }


    fun establecerNota(idAlumno: String, evaluacion: String, nota: Float) {
        if (evaluacion in EV_PRI..EV_FIN) {
            var pos = matriculados.indexOfFirst { it?.id.equals(idAlumno) }
            //la pos es igual a la var matriculados y por cada $indice desde el primero
            //predicado: it ? de id de la clase alumno es igual a la var idAlumno de esta clase
            if (pos > 0) {
                //de la variable privada notas evaluación y pos = a la variable nota
                notas[evaluacion.toInt()][pos] = nota
                //eva es la colum y pos es la fila
            }
        }
    }

    fun calculaEvaluacionFinal(idAlumno: String) {
        var notasDelAlumno = matriculados.indexOfFirst { it?.id.equals(idAlumno) }
        // la variable es igual a matriculados por el índice empezando el primero
        // el predicado es it donde la id de la clase alumno sea igual al idAlumno de esta clase


        var ev1 = notas[notasDelAlumno][0]
        var ev2 = notas[notasDelAlumno][1]
        var ev3 = notas[notasDelAlumno][2]
        var ev_final = (ev1 + ev2 + ev3) / 3
        ev_final = notas[notasDelAlumno][3]
    }

    fun listaNotas(evaluacion: String) {

        var evaluacion = arrayListOf(notas).forEach { it }
        return evaluacion
    }

    fun numeroAprobados(evaluacion: String): Int {

        var evaluacion = notas[evaluacion.toInt()].count { it >= 5.0f }
        return evaluacion
    }

    fun notaMasBaja(evaluacion: String): Float {
        var evaluacion = notas.minOf { it[evaluacion.toInt()] }
        return (evaluacion)
    }

    fun notaMasAlta(evaluacion: String): Float {

        var evaluacion = notas.maxOf { it[evaluacion.toInt()] }
        return (evaluacion)
    }

    fun notaMedia(evaluacion: String): Float {

        var evaluacion = notas[evaluacion.toInt()].average().toFloat()
        return evaluacion
    }

    fun hayAlumnosConDiez(evaluacion: String): Boolean {
        var evaluacion = notas[evaluacion.toInt()].count { it == 10.0f }
        return true
    }

    fun hayAlumnosAprobados(evaluacion: String): Boolean {
        var evaluacion = notas[evaluacion.toInt()].count { it == 5.0f }
        return true
    }

    fun primeraNotaNoAprobada(evaluacion: String): Float {
        var evaluacion = notas[evaluacion.toInt()].first { it < 5.0f }
        return evaluacion
    }
/*
    fun listaNotasOrdenados(evaluacion: String): List<Pair<String, Float>> {
        var evaluacion = notas.sort().toString()
    }
*/
    fun matricularAlumno(alumno: Alumno): Boolean {

        var pos = 0
        var matriculado = false

        //Buscar la posicion en la que insertar el alumno
        while ((pos < matriculados.size - 1) && (matriculados[pos] != null)) {
            pos++
        }

        if (pos < matriculados.size - 1) {
            matriculados.set(pos, alumno)
            // matriculados[pos] =alumno // Es igual
            matriculado = true
        }

        return matriculado
    }

    fun bajaAlumno(idAlumno: String): Boolean {
        var pos = 0
        var baja = false
        var borrado = false

        while (pos < matriculados.size && !borrado) {
            pos++
            if (matriculados[pos]?.id == idAlumno) {
                matriculados[pos] = null
                borrado = true
            }
        }
        return borrado
    }


}


data class Alumno(val id: String = "", val nombre: String = " ", var ap1: String = "", var ap2: String = "") {
// se pone data class porque no tiene ningún método
}


fun main(args: Array<String>) {
    var m: Modulo = Modulo(15)
    val lista = listOf(
        Alumno("0", "Juan", "Cuesta", "Gil"),
        Alumno("1", "Belén", "López", "Vazquez"),
        Alumno("2", "Vicenta", "Benito", "Gil"),
        Alumno("3", "Marisa", "Benito", "Navarro"),
        Alumno("4", "Natalia", "Cuesta", "Hurtado"),
        Alumno("5", "Fernando", "Tejero", "Delgado"),
        Alumno("6", "Andrés", "Guerra", "Romero"),
        Alumno("7", "Isabel", "Ruíz", "Ordaz"),
        Alumno("8", "Roberto", "Alonso", "Castillo"),
        Alumno("9", "Fernando", "Navarro", "Collado")
    ).forEach { m.matricularAlumno(it) }




    m.establecerNota("0", Modulo.EV_PRI, 6.0f)
    m.establecerNota("1", Modulo.EV_PRI, 7.3f)
    m.establecerNota("2", Modulo.EV_PRI, 5.7f)
    m.establecerNota("3", Modulo.EV_PRI, 10.0f)
    m.establecerNota("4", Modulo.EV_PRI, 8.56F)
    m.establecerNota("5", Modulo.EV_PRI, 6.4f)
    m.establecerNota("6", Modulo.EV_PRI, 4.9F)
    m.establecerNota("7", Modulo.EV_PRI, 5.7F)
    m.establecerNota("8", Modulo.EV_PRI, 4.8F)
    m.establecerNota("9", Modulo.EV_PRI, 5.8F)

    m.establecerNota("0", Modulo.EV_SEG, 5.0f)
    m.establecerNota("1", Modulo.EV_SEG, 8.3f)
    m.establecerNota("2", Modulo.EV_SEG, 9.7f)
    m.establecerNota("3", Modulo.EV_SEG, 10.0f)
    m.establecerNota("4", Modulo.EV_SEG, 2.56F)
    m.establecerNota("5", Modulo.EV_SEG, 1.4f)
    m.establecerNota("6", Modulo.EV_SEG, 0.9F)
    m.establecerNota("7", Modulo.EV_SEG, 7.7F)
    m.establecerNota("8", Modulo.EV_SEG, 5.8F)
    m.establecerNota("9", Modulo.EV_SEG, 5.8F)

    m.establecerNota("0", Modulo.EV_TER, 9.0f)
    m.establecerNota("1", Modulo.EV_TER, 8.3f)
    m.establecerNota("2", Modulo.EV_TER, 7.7f)
    m.establecerNota("3", Modulo.EV_TER, 6.0f)
    m.establecerNota("4", Modulo.EV_TER, 5.56F)
    m.establecerNota("5", Modulo.EV_TER, 4.4f)
    m.establecerNota("6", Modulo.EV_TER, 3.9F)
    m.establecerNota("7", Modulo.EV_TER, 2.7F)
    m.establecerNota("8", Modulo.EV_TER, 1.8F)
    m.establecerNota("9", Modulo.EV_TER, 0.8F)


    m.listaNotas("")

}
