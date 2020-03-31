package com.example.toastnotificationalertdialog.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.toastnotificationalertdialog.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToastNotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToastNotificationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ToastNotificationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToastNotificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ToastNotificationFragment newInstance(String param1, String param2) {
        ToastNotificationFragment fragment = new ToastNotificationFragment();
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

    ListView lvMonHoc;
    ArrayList<String> arrayMonHoc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toast_notification, container, false);
        lvMonHoc = view.findViewById(R.id.lvMonHoc);
        arrayMonHoc = new ArrayList<>();
        arrayMonHoc.add("Lập trình thiết bị di động");
        arrayMonHoc.add("Lập trình môi trường trực quan");
        arrayMonHoc.add("Bảo mật thông tin");
        arrayMonHoc.add("Anh văn chuyên ngành");
        arrayMonHoc.add("Quản lý dự án phần mềm");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayMonHoc);
        lvMonHoc.setAdapter(arrayAdapter);

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Toast 2 giây: " + arrayMonHoc.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Toast 3.5 giây: " + arrayMonHoc.get(position), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        return view;
    }
}
