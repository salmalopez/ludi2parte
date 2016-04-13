package com.ludi.tt_ludi;

/**
 * Created by Josh on 12/04/16.
 * Actividad: Alimentos de origen animal y leguminosas.
 */
public class PreguntasCuestionario3 {
    int correcta;
    String  pregunta;
    String[] respuesta = new String[3];
    public static int contador = 0;

    public PreguntasCuestionario3[] getPreguntas(){

        PreguntasCuestionario3 preguntas[] = new PreguntasCuestionario3[10];

        //Pregunta no. 1
        PreguntasCuestionario3 p1 = new PreguntasCuestionario3();
        p1.pregunta = "¿Cuál es el nutriente principal que aportan las leguminosas y alimentos de origen animal?";
        p1.correcta = 2;
        p1.respuesta[0] = "Grasas.";
        p1.respuesta[1] = "Vitaminas.";
        p1.respuesta[2] = "Proteínas";
        preguntas[0] = p1;

        //Pregunta no. 2
        PreguntasCuestionario3 p2 = new PreguntasCuestionario3();
        p2.pregunta = "¿Con que combinación obtenemos los mismos nutrientes que al consumir carnes?";
        p2.correcta = 1;
        p2.respuesta[0] = "Frutas y cereales.";
        p2.respuesta[1] = "Cereales y leguminosas.";
        p2.respuesta[2] = "Cereales y tubérculos.";
        preguntas[1] = p2;

        //Pregunta no. 3
        PreguntasCuestionario3 p3 = new PreguntasCuestionario3();
        p3.pregunta = "Son ejemplos de leguminosas:";
        p3.correcta = 1;
        p3.respuesta[0] = "Papa, haba, frijol, arroz.";
        p3.respuesta[1] = "Frijol, lentejas, garbanzo, habas.";
        p3.respuesta[2] = "Garbanzo, habas, jícama, frijol.";
        preguntas[2] = p3;

        //Pregunta no. 4
        PreguntasCuestionario3 p4 = new PreguntasCuestionario3();
        p4.pregunta = "El incluir leguminosas y alimentos de origen animal a nuestra alimentación nos ayuda a mejorar la circulación de la sangre.";
        p4.correcta = 1;
        p4.respuesta[0] = "Verdadero.";
        p4.respuesta[1] = "Falso.";
        preguntas[3] = p4;

        //Pregunta no. 5
        PreguntasCuestionario3 p5 = new PreguntasCuestionario3();
        p5.pregunta = "Además de proteínas, las leguminosas y alimentos de origen animal también aportan:";
        p5.correcta = 0;
        p5.respuesta[0] = "Hierro, calcio y zinc.";
        p5.respuesta[1] = "Calcio, hierro y vitamina C.";
        p5.respuesta[2] = "Carbohidratos y fibra.";
        preguntas[4] = p5;

        //Pregunta no. 6
        PreguntasCuestionario3 p6 = new PreguntasCuestionario3();
        p6.pregunta = "Son ejemplos de alimentos de origen animal:";
        p6.correcta = 0;
        p6.respuesta[0] = "Pollo, pescado, mariscos, leche.";
        p6.respuesta[1] = "Huevo, queso, lentejas, soya.";
        p6.respuesta[2] = "Alfalfa, yogurt, queso, pollo.";
        preguntas[5] = p6;

        //Pregunta no. 7
        PreguntasCuestionario3 p7 = new PreguntasCuestionario3();
        p7.pregunta = "El consumo de este grupo de alimentos nos aporta nutrientes para tener un sano crecimiento.";
        p7.correcta = 0;
        p7.respuesta[0] = "Verdadero.";
        p7.respuesta[1] = "Falso.";
        preguntas[6] = p7;

        //Pregunta no. 8
        PreguntasCuestionario3 p8 = new PreguntasCuestionario3();
        p8.pregunta = "¿Para que es importante el consumo de proteínas?";
        p8.correcta = 1;
        p8.respuesta[0] = "Nos ayudan a prevenir enfermedades respiratorias.";
        p8.respuesta[1] = "Sirven como material constructor y reconstructor de los músculos y los tejidos del organismo.";
        p8.respuesta[2] = "Nos ayudan a prevenir la obesidad.";
        preguntas[7] = p8;


        //Pregunta no. 9
        PreguntasCuestionario3 p9 = new PreguntasCuestionario3();
        p9.pregunta = "¿De qué color están representadas las leguminosas y los alimentos de origen animal dentro del plato del bien comer?";
        p9.correcta = 2;
        p9.respuesta[0] = "Amarillo.";
        p9.respuesta[1] = "Verde.";
        p9.respuesta[2] = "Rojo.";
        preguntas[8] = p9;

        //Pregunta no. 10
        PreguntasCuestionario3 p10 = new PreguntasCuestionario3();
        p10.pregunta = "Para crecer adecuadamente, el organismo necesita ciertos elementos como la energía y las proteínas.";
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
