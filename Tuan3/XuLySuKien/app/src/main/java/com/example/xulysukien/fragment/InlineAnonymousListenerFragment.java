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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InlineAnonymousListenerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@SuppressLint("SetTextI18n")
public class InlineAnonymousListenerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InlineAnonymousListenerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InlineAnonymousListenerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InlineAnonymousListenerFragment newInstance(String param1, String param2) {
        InlineAnonymousListenerFragment fragment = new InlineAnonymousListenerFragment();
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

    TextView txtkq_IAL;
    EditText edNamDuong_IAL;
    Button btnDoi_IAL;

    String thienCan = "";
    String diaChi = "";
    int duThienCan = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inline_anonymous_listener, container, false);
        txtkq_IAL = view.findViewById(R.id.txtkq_IAL);
        edNamDuong_IAL = view.findViewById(R.id.edNamDuong_IAL);
        btnDoi_IAL = view.findViewById(R.id.btnDoi_IAL);

        btnDoi_IAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int namDuong = Integer.parseInt(edNamDuong_IAL.getText().toString().trim() + "");
                    switch (namDuong % 10) {
                        case 0:
                            thienCan = "Canh";
                            break;
                        case 1:
                            thienCan = "Tân";
                            break;
                        case 2:
                            thienCan = "Nhâm";
                            break;
                        case 3:
                            thienCan = "Quý";
                            break;
                        case 4:
                            thienCan = "Giáp";
                            break;
                        case 5:
                            thienCan = "Ất";
                            break;
                        case 6:
                            thienCan = "Bính";
                            break;
                        case 7:
                            thienCan = "Đinh";
                            break;
                        case 8:
                            thienCan = "Mậu";
                            break;
                        case 9:
                            thienCan = "Kỷ";
                            break;
                    }
                    switch (namDuong % 12) {
                        case 0:
                            diaChi = "Thân";
                            break;
                        case 1:
                            diaChi = "Dậu";
                            break;
                        case 2:
                            diaChi = "Tuất";
                            break;
                        case 3:
                            diaChi = "Hợi";
                            break;
                        case 4:
                            diaChi = "Tý";
                            break;
                        case 5:
                            diaChi = "Sửu";
                            break;
                        case 6:
                            diaChi = "Dần";
                            break;
                        case 7:
                            diaChi = "Mẹo";
                            break;
                        case 8:
                            diaChi = "Thìn";
                            break;
                        case 9:
                            diaChi = "Tỵ";
                            break;
                        case 10:
                            diaChi = "Ngọ";
                            break;
                        case 11:
                            diaChi = "Mùi";
                            break;
                    }

                    if (edNamDuong_IAL.getText().toString().trim().length() > 0 && namDuong > 100) {
                        txtkq_IAL.setText(thienCan + " " + diaChi);
                    } else {
                        Toast.makeText(getActivity(), "Nhập Năm Dương Lịch > 100!", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Nhập Chính xác Năm!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
}
