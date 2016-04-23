package com.ludi.tt_ludi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class NoticiasFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button start;
    TextView textView;
    static String idNoticia = "1";

    private static final String USER_URL = "http://52.23.175.78/api/noticia/";
    private static final String USER_URL2 = "http://ludi.mx/api/noticia/metodo/longitud";

    public static final String KEY_CONTENIDO = "contenido";

    int longitudNoticia;


    private OnFragmentInteractionListener mListener;

    public NoticiasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoticiasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoticiasFragment newInstance(String param1, String param2) {
        NoticiasFragment fragment = new NoticiasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_noticias, container, false);

        start = (Button)view.findViewById(R.id.btn);
        start.setOnClickListener(this);
        textView = (TextView) view.findViewById(R.id.textViewid);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, USER_URL2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String  contenido= "";
                        longitudNoticia = Integer.parseInt(response);
                        System.out.println("RESPUESTA::" + response);


                        try {

                            JSONArray array = new JSONArray(response);
                            JSONObject reader = array.getJSONObject(0);
                            contenido = reader.getString(KEY_CONTENIDO);


                        } catch (JSONException e) { e.printStackTrace();}
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("No se puso obtener el noticia ");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){

                Map<String,String> params = new HashMap<String, String>();
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        requestQueue.add(stringRequest);

        return view;

    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, USER_URL+idNoticia,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String  contenido= "";
                        System.out.println("RESPUESTA::" + response);


                        try {

                            JSONArray array = new JSONArray(response);
                            JSONObject reader = array.getJSONObject(0);
                            contenido = reader.getString(KEY_CONTENIDO);


                        } catch (JSONException e) { e.printStackTrace();}

                        textView.setText(response);
                        int flag = Integer.parseInt(idNoticia);
                        if(flag<longitudNoticia){
                            flag++;
                            idNoticia =""+flag;
                            System.out.println(idNoticia);
                        }else{
                            flag = 1;
                            idNoticia = ""+flag;
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("No se puso obtener el noticia ");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){

                Map<String,String> params = new HashMap<String, String>();
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        requestQueue.add(stringRequest);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
