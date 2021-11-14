
class Modulo(var numeroDeAlumnos:Int=15, maxAlumnos:Int=20){

    //array de nulos de tipo clase Alumno y se mete la var numero de Alumnos
    var matriculados = arrayOfNulls<Alumno>(numeroDeAlumnos) // numero de alumnos matriculados
    //todo ordenar el array por la id de alumno

    companion object {
        const val EV_PRI="0"
        const val EV_SEG="1"
        const val EV_TER="2"
        const val EV_FIN="3"
    }
    private var notas = Array(4)
    {FloatArray(numeroDeAlumnos){-1.0F} }



    fun establecerNota(idAlumno:String, evaluacion:String, nota:Float) {
        if (evaluacion in EV_PRI..EV_FIN)
        {
            var pos = matriculados.indexOfFirst { it?.id.equals(idAlumno) }
            //la pos es igual a la var matriculados y por cada $indice desde el primero
            //predicado: it ? de id de la clase alumno es igual a la var idAlumno de esta clase
            if (pos>0)
            {
                //de la variable privada notas evaluación y pos = a la variable nota
                notas[evaluacion.toInt()][pos] =  nota
                //eva es la colum y pos es la fila
            }
        }
    }


    fun calculaEvaluacionFinal(idAlumno:String){
        var notasDelAlumno = matriculados.indexOfFirst { it?.id.equals(idAlumno) }
        // la variable es igual a matriculados por el índice empezando el primero
        // el predicado es it donde la id de la clase alumno sea igual al idAlumno de esta clase


         var ev1 = notas[notasDelAlumno][0]
         var ev2 = notas[notasDelAlumno][1]
         var ev3 = notas[notasDelAlumno][2]
         var ev_final = (ev1 + ev2 + ev3) /3
         ev_final= notas[notasDelAlumno][3]



        }


    fun listaNotas(evaluacion:String): List<notas>{


    }

    fun numeroAprobados(evaluacion:String): Int{


    var evaluacion = notas.filter {it.size <6  }


    }
    fun notaMasBaja(evaluacion:String): Float{

      var evaluacion = notas.minOf { it[evaluacion.Float()] }
      return (evaluacion)


    }
    /*
    fun notaMasAlta(evaluacion:String): Float{


    var evaluacion = notas.maxOf { it[evaluacion.toFloat()] }
    return(evaluacion)
    }
    
    fun notaMedia(evaluacion:String): Float{

         var notaMedia = notas[evaluacion.toInt()].average().toFloat()

        return notaMedia

    }
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
    
    
   var m:Modulo = Modulo(15)
    m.establecerNotas("12",Modulo.EV_PRI,2.3)


}
