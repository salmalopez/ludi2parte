package com.ludi.tt_ludi;

/**
 * Created by Salma on 10/04/16.
 * Actividad: Frutas y Verduras
 */

public class PreguntasCuestionario1 {
    int correcta;
    String  pregunta;
    String[] respuesta = new String[3];
    public static int contador = 0;

    public PreguntasCuestionario1[] getPreguntas(){

        PreguntasCuestionario1 preguntas[] = new PreguntasCuestionario1[10];

        //Pregunta no. 1
        PreguntasCuestionario1 p1 = new PreguntasCuestionario1();
        p1.pregunta = "¿Por qué los niños deben consumir frutas y verduras?";
        p1.correcta = 1;
        p1.respuesta[0] = "Porque nuestra mama nos lo indica.";
        p1.respuesta[1] = "Porque contienen los nutrientes necesarios para que nuestro organismo funcione.";
        p1.respuesta[2] = "Porque tienen muchas calorías.";
        preguntas[0] = p1;

        //Pregunta no. 2
        PreguntasCuestionario1 p2 = new PreguntasCuestionario1();
        p2.pregunta = "Tienen un alto contenido de agua:";
        p2.correcta = 2;
        p2.respuesta[0] = "Frutas.";
        p2.respuesta[1] = "Verduras.";
        p2.respuesta[2] = "Las dos anteriores.";
        preguntas[1] = p2;

        //Pregunta no. 3
        PreguntasCuestionario1 p3 = new PreguntasCuestionario1();
        p3.pregunta = "Las frutas amarillas destacan en alto contenido de:";
        p3.correcta = 0;
        p3.respuesta[0] = "Vitamina A";
        p3.respuesta[1] = "Vitamina B";
        p3.respuesta[2] = "Vitamina C";
        preguntas[2] = p3;

        //Pregunta no. 4
        PreguntasCuestionario1 p4 = new PreguntasCuestionario1();
        p4.pregunta = "Las frutas y verduras son alimentos que carecen de grasas.";
        p4.correcta = 0;
        p4.respuesta[0] = "Verdadero.";
        p4.respuesta[1] = "Falso.";
        preguntas[3] = p4;

        //Pregunta no. 5
        PreguntasCuestionario1 p5 = new PreguntasCuestionario1();
        p5.pregunta = "¿Cuáles de las siguientes opciones contienen únicamente frutas?";
        p5.correcta = 0;
        p5.respuesta[0] = "Naranja, plátano, melón, aguacate, manzana.";
        p5.respuesta[1] = "Naranja, manzana, brócoli, chayote, jitomate.";
        p5.respuesta[2] = "Manzana, melón, chayote, papa, zanahoria.";
        preguntas[4] = p5;

        //Pregunta no. 6
        PreguntasCuestionario1 p6 = new PreguntasCuestionario1();
        p6.pregunta = "¿Para qué nos ayuda la Vitamina C?";
        p6.correcta = 2;
        p6.respuesta[0] = "Aumenta la posibilidad de enfermarnos.";
        p6.respuesta[1] = "No nos ayuda en nada.";
        p6.respuesta[2] = "Previene enfermedades respiratorias.";
        preguntas[5] = p6;

        //Pregunta no. 7
        PreguntasCuestionario1 p7 = new PreguntasCuestionario1();
        p7.pregunta = "Las frutas y verduras no contienen vitaminas y minerales.";
        p7.correcta = 1;
        p7.respuesta[0] = "Verdadero.";
        p7.respuesta[1] = "Falso.";
        preguntas[6] = p7;

        //Pregunta no. 8
        PreguntasCuestionario1 p8 = new PreguntasCuestionario1();
        p8.pregunta = "¿Cuáles de los siguientes alimentos son ricos en Vitamina C?";
        p8.correcta = 1;
        p8.respuesta[0] = "Plátano, manzana, acelgas.";
        p8.respuesta[1] = "Ciruela, naranja, guayaba.";
        p8.respuesta[2] = "Zanahoria, lechuga, piña.";
        preguntas[7] = p8;


        //Pregunta no. 9
        PreguntasCuestionario1 p9 = new PreguntasCuestionario1();
        p9.pregunta = "¿Cuántas piezas de frutas y verduras se recomiendan consumir al día?";
        p9.correcta = 1;
        p9.respuesta[0] = "2 piezas.";
        p9.respuesta[1] = "5 piezas.";
        p9.respuesta[2] = "9 piezas.";
        preguntas[8] = p9;

        //Pregunta no. 10
        PreguntasCuestionario1 p10 = new PreguntasCuestionario1();
        p10.pregunta = "Las frutas y verduras proporcionan fibra.";
        p10.correcta = 0;
        p10.respuesta[0] = "Verdadero.";
        p10.respuesta[1] = "Falso.";
        preguntas[9] = p10;


        return preguntas;
    }

    public String[] getRespuesta(){
        return respuesta;
    }

    public int getIdRespuestaCorrecta(){
        return correcta;
    }

}
