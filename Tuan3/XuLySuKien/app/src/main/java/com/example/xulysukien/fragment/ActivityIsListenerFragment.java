package com.example.xulysukien.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xulysukien.R;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActivityIsListenerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivityIsListenerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ActivityIsListenerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivityIsListenerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivityIsListenerFragment newInstance(String param1, String param2) {
        ActivityIsListenerFragment fragment = new ActivityIsListenerFragment();
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

    Button btnTinhBMI_AIL;
    EditText editTen_AIL, editChieuCao_AIL, editCanNang_AIL, editChuanDoan_AIL, editChiSoBMI_AIL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity_is_listener, container, false);
        btnTinhBMI_AIL = view.findViewById(R.id.btnTinhBMI_AIL);
        editTen_AIL = view.findViewById(R.id.editTen_AIL);
        editChieuCao_AIL = view.findViewById(R.id.editChieuCao_AIL);
        editCanNang_AIL = view.findViewById(R.id.editCanNang_AIL);
        editChuanDoan_AIL = view.findViewById(R.id.editChuanDoan_AIL);
        editChiSoBMI_AIL = view.findViewById(R.id.editChiSoBMI_AIL);

        btnTinhBMI_AIL.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        try {
            double H = Double.parseDouble(editChieuCao_AIL.getText().toString().trim());
            double W = Double.parseDouble(editCanNang_AIL.getText().toString().trim());

            double BMI = W / Math.pow(H, 2);

            String chuandoan = "";
            if (BMI < 18) {
                chuandoan = "Bạn gầy";
            } else if (BMI <= 24.9) {
                chuandoan = "Bạn bình thường";
            } else if (BMI <= 29.9) {
                chuandoan = "Bạn béo phì độ I";
            } else if (BMI <= 34.9) {
                chuandoan = "Bạn béo phì độ 2";
            } else if (BMI > 35) {
                chuandoan = "Bạn béo phì độ 3";
            }

            DecimalFormat dcf = new DecimalFormat("#.0");
            editChiSoBMI_AIL.setText(dcf.format(BMI));
            editChuanDoan_AIL.setText(chuandoan);
        } catch (NumberFormatException e) {
            Toast.makeText(getActivity(), "Nhập chiều cao và cân nặng!", Toast.LENGTH_SHORT).show();
        }
    }
}
