package com.ludi.tt_ludi;

/**
 * Created by Salma on 15/03/16.
 */
public class Pregunta {
    int correcta;
    String  pregunta;
    String[] respuesta = new String[2];
    public static int contador = 0;

    public Pregunta[] getPreguntas(){

        Pregunta preguntas[] = new Pregunta[10];

        //Pregunta no. 1
        Pregunta p1 = new Pregunta();
        p1.pregunta = "¿Cuántos niveles tiene la jarra del buen beber?";
        p1.correcta = 0;
        p1.respuesta[0] = "    ";
        p1.respuesta[p1.correcta] = "     ";
        preguntas[0] = p1;

        //Pregunta no. 2
        Pregunta p2 = new Pregunta();
        p2.pregunta = "¿Cuántos vasos de agua natural necesitas beber al día?";
        p2.correcta = 1;
        p2.respuesta[p2.correcta] = "";
        p2.respuesta[1] = "";
        preguntas[1] = p2;

        //Pregunta no. 3
        Pregunta p3 = new Pregunta();
        p3.pregunta = "¿Cuántos vasos de leche semidescremada y bebidas de soya sin azúcar debes beber máximo al día ?";
        p3.correcta = 0;
        p3.respuesta[p3.correcta] = "";
        p3.respuesta[1] = "";
        preguntas[2] = p3;

        //Pregunta no. 4
        Pregunta p4 = new Pregunta();
        p4.pregunta = "Se pueden tomar 4 tazas (250 ml por taza) al día de...";
        p4.correcta = 1;
        p4.respuesta[0] = "";
        p4.respuesta[p4.correcta] = "";
        preguntas[3] = p4;

        //Pregunta no. 5
        Pregunta p5 = new Pregunta();
        p5.pregunta = "Se aconsejan de 0 a 2 vasos por día de... ";
        p5.correcta = 0;
        p5.respuesta[p5.correcta] = "";
        p5.respuesta[1] = "";
        preguntas[4] = p5;

        //Pregunta no. 6
        Pregunta p6 = new Pregunta();
        p6.pregunta = "Son bebidas con alto valor calórico y beneficios en salud limitados, por ello se recomienda consumir de 0 a 1/2 vasos al día...";
        p6.correcta = 1;
        p6.respuesta[0] = "";
        p6.respuesta[p6.correcta] = "";
        preguntas[5] = p6;

        //Pregunta no. 7
        Pregunta p7 = new Pregunta();
        p7.pregunta = "Su consumo se asocia con caries dental y obesidad, se recomienda no ingerirlas... ";
        p7.correcta = 1;
        p7.respuesta[0] = "";
        p7.respuesta[p7.correcta] = "";
        preguntas[6] = p7;

        //Pregunta no. 8
        Pregunta p8 = new Pregunta();
        p8.pregunta = "CONCLUISTE LA ACTIVIDAD";
        p8.correcta = 0;
        p8.respuesta[p8.correcta] = "";
        p8.respuesta[1] = "";
        preguntas[7] = p8;


        //Pregunta no. 9
        Pregunta p9 = new Pregunta();
        p9.pregunta = "PREGUNTA 9";
        p9.correcta = 1;
        p9.respuesta[0] = "RP9";
        p9.respuesta[p9.correcta] = "RPC9";
        preguntas[8] = p9;

        //Pregunta no. 10
        Pregunta p10 = new Pregunta();
        p10.pregunta = "PREGUNTA 10";
        p10.correcta = 1;
        p10.respuesta[0] = "RP10";
        p10.respuesta[p10.correcta] = "RPC10";
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
