package com.example.portalcovid_19;

import android.content.Intent;
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
 * Use the {@link homeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homeFragment extends Fragment {
    private RecyclerView rvArtikel;
    private ArrayList<artikel> list = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        rvArtikel = (RecyclerView) view.findViewById(R.id.rv_artikel);
        rvArtikel.setLayoutManager(new LinearLayoutManager(getContext()));
        artikelAdapter ArtikelAdapter = new artikelAdapter(list);
        rvArtikel.setAdapter(ArtikelAdapter);
        rvArtikel.setHasFixedSize(true);
        list.addAll(artikelData.getListData());
        ArtikelAdapter.setOnItemClickCallback(new artikelAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(artikel data) {
                lihatPilihanArtikel(data);
            }
        });
        return view;
    }

    private void lihatPilihanArtikel(artikel Artikel){
        Intent intent = new Intent(getActivity(),artikelDetail.class);
        intent.putExtra(artikelDetail.JUDUL,Artikel.getJudul());
        intent.putExtra(artikelDetail.ISI,Artikel.getIsi());
        intent.putExtra(artikelDetail.FOTO_ARTIKEL,Artikel.getFotoProfil());
        startActivity(intent);
    }
}
