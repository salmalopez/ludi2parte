package com.ludi.tt_ludi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ActividadesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ActividadesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActividadesFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button btn_act1, btn_act2, btn_act3,btn_act4,btn_act5;

    private OnFragmentInteractionListener mListener;

    public ActividadesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActividadesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActividadesFragment newInstance(String param1, String param2) {
        ActividadesFragment fragment = new ActividadesFragment();
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

        View view = inflater.inflate(R.layout.fragment_actividades, container, false);

        Typeface myTypeFace2 = Typeface.createFromAsset(getContext().getAssets(),"DK.ttf");

        btn_act1 = (Button) view.findViewById(R.id.btn_act1);
        btn_act1.setTypeface(myTypeFace2);
        btn_act1.setOnClickListener(this);


        btn_act2 = (Button) view.findViewById(R.id.btn_act2);
        btn_act2.setTypeface(myTypeFace2);
        btn_act2.setOnClickListener(this);


        btn_act3 = (Button) view.findViewById(R.id.btn_act3);
        btn_act3.setTypeface(myTypeFace2);
        btn_act3.setOnClickListener(this);


        btn_act4 = (Button) view.findViewById(R.id.btn_act4);
        btn_act4.setTypeface(myTypeFace2);
        btn_act4.setOnClickListener(this);

        btn_act5 = (Button) view.findViewById(R.id.btn_act5);
        btn_act5.setTypeface(myTypeFace2);
        btn_act5.setOnClickListener(this);

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


    public void callParentMethod(){
        getActivity().onBackPressed();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case (R.id.btn_act1):
                Intent intentAct1  = new Intent(getContext(), InstruccionesAct4.class);
                startActivity(intentAct1);
                break;

            case (R.id.btn_act2):
                Intent intentAct2  = new Intent(getContext(), InstruccionesAct5.class);
                startActivity(intentAct2);
                break;

            case (R.id.btn_act3):
                Intent intentAct3  = new Intent(getContext(), InstruccionesAct2.class);
                startActivity(intentAct3);
                break;

            case (R.id.btn_act4):
                Intent intentAct4 = new Intent(getContext(), InstruccionesAct3.class);
                startActivity(intentAct4);
                break;

            case (R.id.btn_act5):
                Intent intentAct5 = new Intent(getContext(), InstruccionesAct1.class);
                startActivity(intentAct5);
                break;
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
