package com.ludi.tt_ludi;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AvanceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AvanceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AvanceFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String WS_ESTATUS = "http://ludi.mx/api/estatus";
    private static final String KEY_USUARIO = "idusuario";
    private String id;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView estatusAct1, estatusAct2, estatusAct3, estatusAct4, estatusAct5;
    private OnFragmentInteractionListener mListener;

    public AvanceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AvanceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AvanceFragment newInstance(String param1, String param2) {
        AvanceFragment fragment = new AvanceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_avance, container, false);

        this.id = (getActivity().getApplicationContext().getSharedPreferences("ludi", 0)).getString("id",null);
        estatusAct1 = (TextView) getView().findViewById(R.id.btn_act1);
        estatusAct2 = (TextView) getView().findViewById(R.id.btn_act2);
        estatusAct3 = (TextView) getView().findViewById(R.id.btn_act3);
        estatusAct4 = (TextView) getView().findViewById(R.id.btn_act4);
        estatusAct5 = (TextView) getView().findViewById(R.id.btn_act5);

        getEstatus();

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // Inflate the layout for this fragment
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
            //throw new RuntimeException(context.toString()
                  //  + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

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



    private void getEstatus(){


        StringRequest stringRequest = new StringRequest(Request.Method.POST, WS_ESTATUS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        actualizarEstatus(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("No se pudo obtener el estatus del usuario "+id);
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USUARIO,id);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    private void actualizarEstatus(String json){

        Drawable tache = getResources().getDrawable(R.drawable.tache);
        Drawable paloma = getResources().getDrawable(R.drawable.paloma);
        String estatus1, estatus2, estatus3, estatus4, estatus5;

        try {
            JSONObject jsonObject = new JSONObject(json);

            estatus1 = jsonObject.getString("1");
            estatus2 = jsonObject.getString("2");
            estatus3 = jsonObject.getString("3");
            estatus4 = jsonObject.getString("4");
            estatus5 = jsonObject.getString("5");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        estatusAct1.setBackground(paloma);
        estatusAct1.setBackground(tache);
        estatusAct1.setBackground(tache);
        estatusAct1.setBackground(tache);
        estatusAct1.setBackground(tache);

    }


}
