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

        var ordenado = arrayListOf(notas)

        ordenado.forEach { it }
        println(ordenado)
    }


    fun numeroAprobados(evaluacion: String): Int {

        var evaluacion = notas[evaluacion.toInt()]
        var aprobados = evaluacion.count {it >=5.0f}
        return (aprobados)
    }

    fun notaMasBaja(evaluacion: String): Float {
        var minimo = notas.minOf { it[evaluacion.toInt()] }
        return (minimo)
    }

    fun notaMasAlta(evaluacion: String): Float {

        var maximo = notas.maxOf { it[evaluacion.toInt()] }
        return (maximo)
    }

    fun notaMedia(evaluacion: String): Float {

        var notaMedia = notas[evaluacion.toInt()].average().toFloat()

        return notaMedia

    }

    fun hayAlumnosConDiez(evaluacion: String): Boolean {
        var evaluacion = notas[evaluacion.toInt()]
        var aprobados = evaluacion.count { it == 10.0f }
        return true
    }
    fun hayAlumnosAprobados(evaluacion: String): Boolean {
        var evaluacion = notas[evaluacion.toInt()]
        var aprobados = evaluacion.count {it ==5.0f}
        return true
    }
    fun primeraNotaNoAprobada(evaluacion: String): Float {
        var evaluacion = notas[evaluacion.toInt()]
        var aprobados = evaluacion.first {it ==5.0f}
        return aprobados
    }
    fun listaNotasOrdenados(evaluacion: String): List<Pair<String,Float>> {

        var ordenado =notas.sort()
        return (matriculado)
    }
    fun matricularAlumno(alumno: Alumno): Boolean {

        matriculados[0]=Alumno()
     var i = 0
        while ((i < matriculados.size - 1) && (matriculados[i] !=null)){
        i ++}
        return false
    }

    fun bajaAlumno(idAlumno: String): Boolean {

        matriculados[0]=Alumno()
        var i = 0
        while ((i < matriculados.size - 1) && (matriculados[i] !=null)){
            i --}
        return false
    }


}


data class Alumno(val id: String = "", val nombre: String = " ", var ap1: String = "", var ap2: String = "") {
// se pone data class porque no tiene ningún método
}


fun main(args: Array<String>) {


    var alumno1 = Alumno("0", "Juan", "Cuesta", "Gil")
    var alumno2 = Alumno("1", "Belén", "López", "Vazquez")
    var alumno3 = Alumno("2", "Vicenta", "Benito", "Gil")
    var alumno4 = Alumno("3", "Marisa", "Benito", "Navarro")
    var alumno5 = Alumno("4", "Natalia", "Cuesta", "Hurtado")
    var alumno6 = Alumno("5", "Fernando", "Tejero", "Delgado")
    var alumno7 = Alumno("6", "Andrés", "Guerra", "Romero")
    var alumno8 = Alumno("7", "Isabel", "Ruíz", "Ordaz")
    var alumno9 = Alumno("8", "Roberto", "Alonso", "Castillo")
    var alumno10 = Alumno("9", "Fernando", "Navarro", "Collado")



    var m: Modulo = Modulo(15)
    m.establecerNota("0", Modulo.EV_PRI, 6.0f )
    m.establecerNota("1", Modulo.EV_PRI,  7.3f)
    m.establecerNota("2", Modulo.EV_PRI,  5.7f)
    m.establecerNota("3", Modulo.EV_PRI,  10.0f)
    m.establecerNota("4", Modulo.EV_PRI,  8.56F)
    m.establecerNota("5", Modulo.EV_PRI,  6.4f)
    m.establecerNota("6", Modulo.EV_PRI, 4.9F)
    m.establecerNota("7", Modulo.EV_PRI,  5.7F)
    m.establecerNota("8", Modulo.EV_PRI,  4.8F)
    m.establecerNota("9", Modulo.EV_PRI,  5.8F)



    m.matricularAlumno(alumno10)
    m.matricularAlumno(alumno1)
    m.matricularAlumno(alumno2)
    m.matricularAlumno(alumno3)
    m.matricularAlumno(alumno4)
    m.matricularAlumno(alumno5)
    m.matricularAlumno(alumno6)
    m.matricularAlumno(alumno7)
    m.matricularAlumno(alumno8)
    m.matricularAlumno(alumno9)

    m.notaMasAlta()
}
