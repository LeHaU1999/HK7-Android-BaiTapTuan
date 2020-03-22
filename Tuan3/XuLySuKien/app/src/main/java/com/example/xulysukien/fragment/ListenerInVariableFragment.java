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
 * Use the {@link ListenerInVariableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListenerInVariableFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View.OnClickListener myOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                if (v == btnChuyenDoC_LIV) {
                    double doC;
                    double doF;
                    doF = Double.parseDouble(editTextDoF_LIV.getText().toString().trim());
                    doC = (doF - 32) * 5 / 9;
                    DecimalFormat dcf = new DecimalFormat("#.00");
                    editTextDoC_LIV.setText(dcf.format(doC));
                } else if (v == btnChuyenDoF_LIV) {
                    double doC;
                    double doF;
                    doC = Double.parseDouble(editTextDoC_LIV.getText().toString().trim());
                    doF = (doC * 1.8) + 32;
                    DecimalFormat dcf = new DecimalFormat("#.00");
                    editTextDoF_LIV.setText(dcf.format(doF));
                } else if (v == btnXoa_LIV) {
                    editTextDoC_LIV.setText("");
                    editTextDoF_LIV.setText("");
                    editTextDoC_LIV.requestFocus();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(getActivity(), "Nhập sai giá trị!", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public ListenerInVariableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListenerInVariableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListenerInVariableFragment newInstance(String param1, String param2) {
        ListenerInVariableFragment fragment = new ListenerInVariableFragment();
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

    EditText editTextDoC_LIV, editTextDoF_LIV;
    Button btnChuyenDoC_LIV, btnChuyenDoF_LIV, btnXoa_LIV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listener_in_variable, container, false);
        editTextDoC_LIV = view.findViewById(R.id.editTextDoC_LIV);
        editTextDoF_LIV = view.findViewById(R.id.editTextDoF_LIV);
        btnChuyenDoC_LIV = view.findViewById(R.id.btnChuyenDoC_LIV);
        btnChuyenDoF_LIV = view.findViewById(R.id.btnChuyenDoF_LIV);
        btnXoa_LIV = view.findViewById(R.id.btnXoa_LIV);

        btnChuyenDoC_LIV.setOnClickListener(myOnclickListener);
        btnChuyenDoF_LIV.setOnClickListener(myOnclickListener);
        btnXoa_LIV.setOnClickListener(myOnclickListener);

        return view;
    }
}
