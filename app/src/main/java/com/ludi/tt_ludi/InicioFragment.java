package com.ludi.tt_ludi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ludi.tt_ludi.qr.IntentIntegrator;
import com.ludi.tt_ludi.qr.IntentResult;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InicioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    IntentIntegrator integrator;
    private OnFragmentInteractionListener mListener;

    Button btnActividades, btnNoticias,btnAvance;

    MediaPlayer botonsonido;


    boolean fragmentTransaction = false;


    public InicioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
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
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);


        botonsonido = MediaPlayer.create(getContext(), R.raw.inicio);


        btnActividades = (Button) view.findViewById(R.id.btnActividades);
        btnNoticias = (Button) view.findViewById(R.id.btnNoticias);
        btnAvance = (Button) view.findViewById(R.id.btnAvance);




        Typeface myTypeFace2 = Typeface.createFromAsset(getContext().getAssets(),"DK.ttf");
        btnActividades.setTypeface(myTypeFace2);
        btnActividades.setOnClickListener(this);
        btnNoticias.setTypeface(myTypeFace2);
        btnNoticias.setOnClickListener(this);
        btnAvance.setTypeface(myTypeFace2);
        btnAvance.setOnClickListener(this);


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
        switch (v.getId()) {
            case (R.id.btnActividades):
                botonsonido.start();
                /*ActividadesFragment fragment2 = new ActividadesFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_nav_drawer, fragment2);
                fragmentTransaction.commit();*/
                integrator = new IntentIntegrator(this.getActivity());
                integrator.initiateScan();
                break;

            case (R.id.btnNoticias):
                botonsonido.start();
                NoticiasFragment fragment3 = new NoticiasFragment();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.content_nav_drawer, fragment3);
                fragmentTransaction2.commit();
                break;
            case (R.id.btnAvance):
                botonsonido.start();
                Intent av = new Intent(getContext(), Avance.class);
                startActivity(av);

                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        System.out.println("resultCode: "+resultCode);
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        Class destino = null;

        if (scanResult != null) {
            String resultado = scanResult.getContents();

            switch (resultado){
                case "verduras":
                    destino = InstruccionesAct4.class;
                    break;
                /*case "cereales":
                    destino = Actividad2.class;
                    break;*/
                case "carne":
                    destino = InstruccionesAct2.class;
                    break;
                case "bebidas":
                    destino = InstruccionesAct1.class;
                    break;
                case "plato":
                    destino = InstruccionesAct3.class;
                    break;

            }
            Intent siguiente = new Intent(getContext(), destino);
            startActivity(siguiente);
        }
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
