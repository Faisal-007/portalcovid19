package com.example.portalcovid_19;

import java.util.ArrayList;

public class RumahSakitData {
    private static String[] namaRS = {
            "RSUD Undata Palu",
            "RSUD Kab. Banggai Luwuk",
            "RSU Mokopido Toli-Toli",
            "RSUD Kolonedale",
            "RSU Anutapura Palu"
    };

    private static String[] alamatRS = {
            "Jl. R. E. Martadinata, Tondo Kecamatan Mantikulore 94119",
            "Jl. Imam Bonjol KM 3 No. 14 Luwuk",
            "Jl. Lanoni No.37 Kel Baru Kec Baolan kab Toli-Toli, Sulteng",
            "Jl. W Monginsidi 2 Kolonedale",
            "Jl. Kangkung No. 1 Palu"
    };

    private static String[] koordinatRS = {
            "-0.8577984,119.8829524",
            "-0.9340878,122.8200077",
            "1.0358848,120.8205882",
            "-1.9723993,121.3346957",
            "-0.9000607,119.8469916"
    };

    private static String[] nomorRS = {
            "0451421370",
            "046121820",
            "045321301",
            "046521010",
            "0451460570"
    };

    private static int[] fotoRS = {
            R.drawable.rsudundata,
            R.drawable.rsudluwuk,
            R.drawable.rsumoko,
            R.drawable.rsukolo,
            R.drawable.rsuanutapura
    };

    static ArrayList<RumahSakit> getListData(){
        ArrayList<RumahSakit> list= new ArrayList<>();
        for (int posisi=0;posisi < namaRS.length;posisi++){
            RumahSakit rumahsakit = new RumahSakit();
            rumahsakit.setNamaRS(namaRS[posisi]);
            rumahsakit.setAlamatRS(alamatRS[posisi]);
            rumahsakit.setKoordinatRS(koordinatRS[posisi]);
            rumahsakit.setNomorRS(nomorRS[posisi]);
            rumahsakit.setFotoRS(fotoRS[posisi]);
            list.add(rumahsakit);
        }
        return list;
    }
}
