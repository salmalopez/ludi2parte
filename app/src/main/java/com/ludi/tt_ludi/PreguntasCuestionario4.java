package com.ludi.tt_ludi;

/**
 * Created by Josh on 12/04/16.
 * Actividad: Plato del bien comer.
 */
public class PreguntasCuestionario4 {
    int correcta;
    String  pregunta;
    String[] respuesta = new String[3];
    public static int contador = 0;

    public PreguntasCuestionario4[] getPreguntas(){

        PreguntasCuestionario4 preguntas[] = new PreguntasCuestionario4[10];

        //Pregunta no. 1
        PreguntasCuestionario4 p1 = new PreguntasCuestionario4();
        p1.pregunta = "¿Cuál es el objetivo principal del plato del bien comer?";
        p1.correcta = 1;
        p1.respuesta[0] = "Indicar a la comunidad los alimentos deben comer a fuerza.";
        p1.respuesta[1] = "Informar a la comunidad sobre los tipos de alimentos que deben incluir en su alimentación diaria para tener una mejor salud.";
        p1.respuesta[2] = "Poner a las personas a dieta.";
        preguntas[0] = p1;

        //Pregunta no. 2
        PreguntasCuestionario4 p2 = new PreguntasCuestionario4();
        p2.pregunta = "¿Cuantos grupos de alimentos existen en el plato del buen comer?";
        p2.correcta = 0;
        p2.respuesta[0] = "3 grupos.";
        p2.respuesta[1] = "4 grupos.";
        p2.respuesta[2] = "5 grupos.";
        preguntas[1] = p2;

        //Pregunta no. 3
        PreguntasCuestionario4 p3 = new PreguntasCuestionario4();
        p3.pregunta = "¿Cuáles son los colores utilizados en el Plato del Buen comer?";
        p3.correcta = 1;
        p3.respuesta[0] = "Verde, amarillo y azul.";
        p3.respuesta[1] = "Verde, amarillo y rojo.";
        p3.respuesta[2] = "Verde, amarillo y naranja.";
        preguntas[2] = p3;

        //Pregunta no. 4
        PreguntasCuestionario4 p4 = new PreguntasCuestionario4();
        p4.pregunta = "Dentro del Plato del bien comer, se indica que los cereales y los alimentos de origen animal deben combinarse en la alimentación.";
        p4.correcta = 1;
        p4.respuesta[0] = "Verdadero.";
        p4.respuesta[1] = "Falso.";
        preguntas[3] = p4;

        //Pregunta no. 5
        PreguntasCuestionario4 p5 = new PreguntasCuestionario4();
        p5.pregunta = "¿Cuáles son los alimentos que más se deben incluir en la alimentación?";
        p5.correcta = 2;
        p5.respuesta[0] = "Cereales y tubérculos.";
        p5.respuesta[1] = "Leguminosas y alimentos de origen animal.";
        p5.respuesta[2] = "Frutas y verduras.";
        preguntas[4] = p5;

        //Pregunta no. 6
        PreguntasCuestionario4 p6 = new PreguntasCuestionario4();
        p6.pregunta = "Si los alimentos de cada grupo guardan una correcta proporción entre sí, tu alimentación será:";
        p6.correcta = 1;
        p6.respuesta[0] = "Variada.";
        p6.respuesta[1] = "Suficiente.";
        p6.respuesta[2] = "Inocua.";
        preguntas[5] = p6;

        //Pregunta no. 7
        PreguntasCuestionario4 p7 = new PreguntasCuestionario4();
        p7.pregunta = "Al incluir un alimento de cada grupo dentro de las 3 comidas se lograra que estas sean completas.";
        p7.correcta = 0;
        p7.respuesta[0] = "Verdadero.";
        p7.respuesta[1] = "Falso.";
        preguntas[6] = p7;

        //Pregunta no. 8
        PreguntasCuestionario4 p8 = new PreguntasCuestionario4();
        p8.pregunta = "Dentro de tu plato, el 50% de el debe estar contenido de:";
        p8.correcta = 0;
        p8.respuesta[0] = "Frutas y verduras.";
        p8.respuesta[1] = "Cereales y tubérculos.";
        p8.respuesta[2] = "Alimentos de origen animal.";
        preguntas[7] = p8;


        //Pregunta no. 9
        PreguntasCuestionario4 p9 = new PreguntasCuestionario4();
        p9.pregunta = "¿Qué significa que tu alimentación debe ser inocua?";
        p9.correcta = 2;
        p9.respuesta[0] = "Que contenga al menos 1 elemento de cada grupo nutrimental.";
        p9.respuesta[1] = "Que los alimentos estén en proporción.";
        p9.respuesta[2] = "Que los alimentos estén debidamente lavados y desinfectados.";
        preguntas[8] = p9;

        //Pregunta no. 10
        PreguntasCuestionario4 p10 = new PreguntasCuestionario4();
        p10.pregunta = "Dentro de tu plato, el 25% debe estar incluido de leguminosas y alimentos de origen animal.";
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
