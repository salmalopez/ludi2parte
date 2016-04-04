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
        p1.pregunta = "PREGUNTA 1";
        p1.correcta = 0;
        p1.respuesta[p1.correcta] = "RPC1";
        p1.respuesta[1] = "RP1";
        preguntas[0] = p1;

        //Pregunta no. 2
        Pregunta p2 = new Pregunta();
        p2.pregunta = "PREGUNTA 2";
        p2.correcta = 1;
        p2.respuesta[0] = "RP2";
        p2.respuesta[p2.correcta] = "RPC2";
        preguntas[1] = p2;

        //Pregunta no. 3
        Pregunta p3 = new Pregunta();
        p3.pregunta = "PREGUNTA 3";
        p3.correcta = 0;
        p3.respuesta[p3.correcta] = "RPC3";
        p3.respuesta[1] = "RP3";
        preguntas[2] = p3;

        //Pregunta no. 4
        Pregunta p4 = new Pregunta();
        p4.pregunta = "PREGUNTA 4";
        p4.correcta = 1;
        p4.respuesta[0] = "RP4";
        p4.respuesta[p4.correcta] = "RPC4";
        preguntas[3] = p4;

        //Pregunta no. 5
        Pregunta p5 = new Pregunta();
        p5.pregunta = "PREGUNTA 5";
        p5.correcta = 0;
        p5.respuesta[p5.correcta] = "RPC5";
        p5.respuesta[1] = "RP5";
        preguntas[4] = p5;

        //Pregunta no. 6
        Pregunta p6 = new Pregunta();
        p6.pregunta = "PREGUNTA 6";
        p6.correcta = 1;
        p6.respuesta[0] = "RP6";
        p6.respuesta[p6.correcta] = "RPC6";
        preguntas[5] = p6;

        //Pregunta no. 7
        Pregunta p7 = new Pregunta();
        p7.pregunta = "PREGUNTA 7";
        p7.correcta = 1;
        p7.respuesta[0] = "RP7";
        p7.respuesta[p7.correcta] = "RPC7";
        preguntas[6] = p7;

        //Pregunta no. 8
        Pregunta p8 = new Pregunta();
        p8.pregunta = "PREGUNTA 8";
        p8.correcta = 0;
        p8.respuesta[p8.correcta] = "RPC8";
        p8.respuesta[1] = "RP8";
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
