package com.ludi.tt_ludi;

/**
 * Created by Josh on 12/04/16.
 * Actividad: Jarra del buen beber.
 */
public class PreguntasCuestionario5 {
    int correcta;
    String  pregunta;
    String[] respuesta = new String[3];
    public static int contador = 0;

    public PreguntasCuestionario5[] getPreguntas(){

        PreguntasCuestionario5 preguntas[] = new PreguntasCuestionario5[10];

        //Pregunta no. 1
        PreguntasCuestionario5 p1 = new PreguntasCuestionario5();
        p1.pregunta = "1) ¿Cuál es el propósito principal de la jarra del buen beber?";
        p1.correcta = 0;
        p1.respuesta[0] = "Sugiere la cantidad de bebidas que debemos tomar al día.";
        p1.respuesta[1] = "Sugiere la cantidad de bebidas que debemos tomar cada mes.";
        p1.respuesta[2] = "Proporciona información de los alimentos que debemos consumir al día.";
        preguntas[0] = p1;

        //Pregunta no. 2
        PreguntasCuestionario5 p2 = new PreguntasCuestionario5();
        p2.pregunta = "2) ¿Cuántas tazas de café o se pueden consumir al día?";
        p2.correcta = 1;
        p2.respuesta[0] = "Ningún vaso.";
        p2.respuesta[1] = "Máximo 2 tazas al día.";
        p2.respuesta[2] = "Máximo 5 tazas al día.";
        preguntas[1] = p2;

        //Pregunta no. 3
        PreguntasCuestionario5 p3 = new PreguntasCuestionario5();
        p3.pregunta = "3) De todas las bebidas explicadas en la jarra del buen beber, ¿Cuál es la bebida que menos debemos consumir?";
        p3.correcta = 1;
        p3.respuesta[0] = "Agua.";
        p3.respuesta[1] = "Bebidas con azúcar.";
        p3.respuesta[2] = "Leche semidescremada.";
        preguntas[2] = p3;

        //Pregunta no. 4
        PreguntasCuestionario5 p4 = new PreguntasCuestionario5();
        p4.pregunta = "4) La leche semidescremada y descremada aportan calcio, vitamina D y fibra.";
        p4.correcta = 1;
        p4.respuesta[0] = "Verdadero.";
        p4.respuesta[1] = "Falso.";
        preguntas[3] = p4;

        //Pregunta no. 5
        PreguntasCuestionario5 p5 = new PreguntasCuestionario5();
        p5.pregunta = "5) ¿Por qué el agua es el líquido más importante para la salud?";
        p5.correcta = 0;
        p5.respuesta[0] = "Nos ayuda a mantener la piel sana, es esencial para la digestión y previene el estreñimiento.";
        p5.respuesta[1] = "Previene las enfermedades respiratorias.";
        p5.respuesta[2] = "Nos ayuda a combatir las enfermedades del corazón y regula la frecuencia cardiaca.";
        preguntas[4] = p5;

        //Pregunta no. 6
        PreguntasCuestionario5 p6 = new PreguntasCuestionario5();
        p6.pregunta = "6) ¿En cuántos niveles se divide la jarra del buen beber?";
        p6.correcta = 1;
        p6.respuesta[0] = "5 niveles.";
        p6.respuesta[1] = "6 niveles.";
        p6.respuesta[2] = " 7 niveles.";
        preguntas[5] = p6;

        //Pregunta no. 7
        PreguntasCuestionario5 p7 = new PreguntasCuestionario5();
        p7.pregunta = "7) El hidratarse adecuadamente nos brinda beneficios como activar órganos internos, bajar la presión sanguínea, etc.";
        p7.correcta = 0;
        p7.respuesta[0] = "Verdadero.";
        p7.respuesta[1] = "Falso.";
        preguntas[6] = p7;

        //Pregunta no. 8
        PreguntasCuestionario5 p8 = new PreguntasCuestionario5();
        p8.pregunta = "8) ¿Cuál es el nivel más grande dentro de la jarra del buen beber?";
        p8.correcta = 2;
        p8.respuesta[0] = "Café y té sin azúcar.";
        p8.respuesta[1] = "Bebidas con azúcar.";
        p8.respuesta[2] = "Agua.";
        preguntas[7] = p8;


        //Pregunta no. 9
        PreguntasCuestionario5 p9 = new PreguntasCuestionario5();
        p9.pregunta = "9) Si se consume demasiado esta bebida puede complicar nuestra digestión.";
        p9.correcta = 1;
        p9.respuesta[0] = "Agua.";
        p9.respuesta[1] = "Café y té sin azúcar.";
        p9.respuesta[2] = "Leche semi-descremada y descremada.";
        preguntas[8] = p9;

        //Pregunta no. 10
        PreguntasCuestionario5 p10 = new PreguntasCuestionario5();
        p10.pregunta = "10) El consumo de leche semi-descremada y descremada se asocia con caries dental y obesidad.";
        p10.correcta = 1;
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
