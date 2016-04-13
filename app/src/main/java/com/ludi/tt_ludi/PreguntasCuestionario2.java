package com.ludi.tt_ludi;

/**
 * Created by Josh on 12/04/16.
 * Actividad: Cereales y tubérculos
 */
public class PreguntasCuestionario2 {
    int correcta;
    String  pregunta;
    String[] respuesta = new String[3];
    public static int contador = 0;

    public PreguntasCuestionario2[] getPreguntas(){

        PreguntasCuestionario2 preguntas[] = new PreguntasCuestionario2[10];

        //Pregunta no. 1
        PreguntasCuestionario2 p1 = new PreguntasCuestionario2();
        p1.pregunta = "¿Cuál es el principal beneficio de consumir cereales y tubérculos?";
        p1.correcta = 1;
        p1.respuesta[0] = "Son la principal fuente de vitaminas y minerales.";
        p1.respuesta[1] = "Son la principal fuente de energía.";
        p1.respuesta[2] = "Son la principal fuente de proteínas.";
        preguntas[0] = p1;

        //Pregunta no. 2
        PreguntasCuestionario2 p2 = new PreguntasCuestionario2();
        p2.pregunta = "¿Cuál de las siguientes opciones proporciona carbohidratos?";
        p2.correcta = 2;
        p2.respuesta[0] = "Huevo, zanahoria, maíz.";
        p2.respuesta[1] = "Pan, tortilla, gelatina, salchicha.";
        p2.respuesta[2] = "Elote, papa, tortilla, pan.";
        preguntas[1] = p2;

        //Pregunta no. 3
        PreguntasCuestionario2 p3 = new PreguntasCuestionario2();
        p3.pregunta = "Dentro del plato del bien comer, ¿De qué color se encuentran los cereales y tubérculos?";
        p3.correcta = 0;
        p3.respuesta[0] = "Amarillo.";
        p3.respuesta[1] = "Rojo.";
        p3.respuesta[2] = "Verde.";
        preguntas[2] = p3;

        //Pregunta no. 4
        PreguntasCuestionario2 p4 = new PreguntasCuestionario2();
        p4.pregunta = "Los cereales y tubérculos tienen alto contenido de carbohidratos.";
        p4.correcta = 0;
        p4.respuesta[0] = "Verdadero.";
        p4.respuesta[1] = "Falso.";
        preguntas[3] = p4;

        //Pregunta no. 5
        PreguntasCuestionario2 p5 = new PreguntasCuestionario2();
        p5.pregunta = "¿Cuál es el beneficio de aportar fibra a nuestro organismo?";
        p5.correcta = 1;
        p5.respuesta[0] = "Nos ayuda a prevenir enfermedades respiratorias.";
        p5.respuesta[1] = "Regula los procesos digestivos y disminuye las cantidades de colesterol en la sangre.";
        p5.respuesta[2] = "Fortalecen los músculos.";
        preguntas[4] = p5;

        //Pregunta no. 6
        PreguntasCuestionario2 p6 = new PreguntasCuestionario2();
        p6.pregunta = "¿Qué cereal nos aporta más energía?";
        p6.correcta = 2;
        p6.respuesta[0] = "Arroz.";
        p6.respuesta[1] = "Trigo.";
        p6.respuesta[2] = "Cereal integral.";
        preguntas[5] = p6;

        //Pregunta no. 7
        PreguntasCuestionario2 p7 = new PreguntasCuestionario2();
        p7.pregunta = "Los cereales integrales sin cascara tienen mayor contenido de fibra.";
        p7.correcta = 1;
        p7.respuesta[0] = "Verdadero.";
        p7.respuesta[1] = "Falso.";
        preguntas[6] = p7;

        //Pregunta no. 8
        PreguntasCuestionario2 p8 = new PreguntasCuestionario2();
        p8.pregunta = "Son ejemplos de tubérculos.";
        p8.correcta = 0;
        p8.respuesta[0] = "Papa, jícama, ajo.";
        p8.respuesta[1] = "Papa, trigo, maíz.";
        p8.respuesta[2] = "Maíz, jícama, ajo.";
        preguntas[7] = p8;


        //Pregunta no. 9
        PreguntasCuestionario2 p9 = new PreguntasCuestionario2();
        p9.pregunta = "Son ejemplos de cereales.";
        p9.correcta = 1;
        p9.respuesta[0] = "Arroz, trigo, zanahoria.";
        p9.respuesta[1] = "Arroz, trigo, avena.";
        p9.respuesta[2] = "Cebada, trigo, jícama.";
        preguntas[8] = p9;

        //Pregunta no. 10
        PreguntasCuestionario2 p10 = new PreguntasCuestionario2();
        p10.pregunta = "Los cereales son ricos en vitamina C.";
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
