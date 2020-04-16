package com.example.portalcovid_19;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link rsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class rsFragment extends Fragment {
    private RecyclerView rvRumahSakit;
    private ArrayList<RumahSakit> list = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public rsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment rsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static rsFragment newInstance(String param1, String param2) {
        rsFragment fragment = new rsFragment();
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

        View view = inflater.inflate(R.layout.fragment_rs,container,false);
        rvRumahSakit = (RecyclerView) view.findViewById(R.id.rv_rs);
        rvRumahSakit.setLayoutManager(new LinearLayoutManager(getContext()));
        RumahSakitAdapter rumahSakitAdapter = new RumahSakitAdapter(list);
        rvRumahSakit.setAdapter(rumahSakitAdapter);
        rvRumahSakit.setHasFixedSize(true);
        list.addAll(RumahSakitData.getListData());
        rumahSakitAdapter.setOnItemClickCallback(new RumahSakitAdapter.OnItemClickCallback(){

            @Override
            public void onItemClicked(RumahSakit data) {
                lihatPilihanRS(data);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void lihatPilihanRS(RumahSakit rumahSakit){
        Toast.makeText(getActivity(), "Nama RS" + rumahSakit.getNamaRS(), Toast.LENGTH_SHORT).show();
    }
}
