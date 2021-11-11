
class Modulo(var numeroDeAlumnos:Int=15, maxAlumnos:Int=20){
    var matriculados = arrayOfNulls<Alumno>(numeroDeAlumnos) // numero de alumnos matriculados
    //todo ordenar el array por la id de alumno

    companion object {
        const val EV_PRI='0'
        const val EV_SEG='1'
        const val EV_TER='2'
        const val EV_FIN='3'
    }
    private var notas = Array(4)
    {FloatArray(numeroDeAlumnos){-1.0F} }



    fun establecerNota(idAlumno:String, evaluacion:String, nota:Float) {
        if (evaluacion in EV_PRI..EV_FIN)
        {
            var pos = matriculados.indexOfFirst { it?.id.equals(idAlumno) }
            if (pos>0)
            {
                notas[evaluacion.toInt()][pos] =  nota
            }
        }
    }
/*

    fun calculaEvaluacionFinal(){}
    fun listaNotas(evaluacion:String): List<Pair>{}
    fun numeroAprobados(evaluacion:String): Int{}
    fun notaMasBaja(evaluacion:String): Float{}
    fun notaMasAlta(evaluacion:String): Float{}
    fun notaMedia(evaluacion:String): Float{}
    fun hayAlumnosConDiez(evaluacion:String): Boolean{}
    fun hayAlumnosAprobados(evaluacion:String): Boolean{}
    fun primeraNotaNoAprobada(evaluacion:String): Float{}
    fun listaNotasOrdenados(evaluacion:String): List<Pair>{}
    fun matricularAlumno(alumno:Alumno): Boolean{}
  fun bajaAlumno(idAlumno:String): Boolean{}
    }
*/
}

data class Alumno(val id:String="", val nombre:String = " ", var ap1:String="", var ap2:String="" ){
// se pone data class porque no tiene ningún método
}



fun main(args: Array<String>) {

   var m:Modulo = Modulo(15)
    m.establecerNotas("12",Modulo.EV_PRI,2.3)


}