package com.example.xulysukien.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xulysukien.R;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExplicitListenerClassFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@SuppressLint("SetTextI18n")
public class ExplicitListenerClassFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExplicitListenerClassFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExplicitListenerClassFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExplicitListenerClassFragment newInstance(String param1, String param2) {
        ExplicitListenerClassFragment fragment = new ExplicitListenerClassFragment();
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

    EditText edita_ELC, editb_ELC, editc_ELC;
    Button btnTiepTuc_ELC, btnGiai_ELC, btnThoat_ELC;
    TextView txtkq_ELC;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explicit_listener_class, container, false);
        edita_ELC = view.findViewById(R.id.edita_ELC);
        editb_ELC = view.findViewById(R.id.editb_ELC);
        editc_ELC = view.findViewById(R.id.editc_ELC);
        btnTiepTuc_ELC = view.findViewById(R.id.btnTiepTuc_ELC);
        btnGiai_ELC = view.findViewById(R.id.btnGiai_ELC);
        btnThoat_ELC = view.findViewById(R.id.btnThoat_ELC);
        txtkq_ELC = view.findViewById(R.id.txtkq_ELC);

        btnTiepTuc_ELC.setOnClickListener(new MyEvent());
        btnGiai_ELC.setOnClickListener(new MyEvent());
        btnThoat_ELC.setOnClickListener(new MyEvent());

        return view;
    }

    private class MyEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == btnTiepTuc_ELC) {
                edita_ELC.setText("");
                editb_ELC.setText("");
                editc_ELC.setText("");
                edita_ELC.requestFocus();
            } else if (v == btnGiai_ELC) {
                try {
                    double a = Double.parseDouble(edita_ELC.getText().toString().trim());
                    double b = Double.parseDouble(editb_ELC.getText().toString().trim());
                    double c = Double.parseDouble(editc_ELC.getText().toString().trim());
                    giaiPtb2(a, b, c);
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Lưu ý là số!", Toast.LENGTH_SHORT).show();
                }
            } else if (v == btnThoat_ELC) {
                System.exit(1);
            }
        }

        private void giaiPtb2(double a, double b, double c) {
            if (a != 0) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                double d, x1, x2;
                d = Math.pow(b, 2) - 4 * a * c;
                if (d == 0) {
                    txtkq_ELC.setText("Phương trình có 1 nghiệm kép x1 = x2 = " + dcf.format(-b / (2.0 * a)));
                } else if (d > 0) {
                    x1 = (-b - Math.sqrt(d)) / (2 * a);
                    x2 = (-b + Math.sqrt(d)) / (2 * a);

                    txtkq_ELC.setText("x1 = " + dcf.format(x1) + "; x2 = " + dcf.format(x2));
                } else
                    txtkq_ELC.setText("Phương trình vô nghiệm.");
            } else {
                Toast.makeText(getActivity(), "Đây không phải là PTB2!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
