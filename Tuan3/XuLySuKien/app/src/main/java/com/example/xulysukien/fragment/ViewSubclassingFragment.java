package com.example.xulysukien.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.xulysukien.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewSubclassingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@SuppressLint("SetTextI18n")
public class ViewSubclassingFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ViewSubclassingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewSubclassingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewSubclassingFragment newInstance(String param1, String param2) {
        ViewSubclassingFragment fragment = new ViewSubclassingFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_subclassing, container, false);
        //layout
        ConstraintLayout myLayout = view.findViewById(R.id.lll);
        myLayout.setBackgroundColor(Color.YELLOW);
        myLayout.setId(R.id.myLayoutId);

        //Button
        Button myButton = new androidx.appcompat.widget.AppCompatButton(view.getContext()) {
            @Override
            public boolean performClick() {
                Toast.makeText(getActivity(), "Hello World", Toast.LENGTH_SHORT).show();
                return super.performClick();
            }
        };

        myButton.setBackgroundColor(Color.GREEN);
        myButton.setText("My Button");
        myButton.setId(R.id.myButtonId);
        myLayout.addView(myButton);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(myLayout);

//        constraintSet.connect(myButton.getId(), ConstraintSet.TOP, myLayout.getId(), ConstraintSet.TOP, 120);
//        constraintSet.connect(myButton.getId(), ConstraintSet.LEFT, myLayout.getId(), ConstraintSet.LEFT, 120);

        constraintSet.centerHorizontally(myButton.getId(), myLayout.getId());
        constraintSet.centerVertically(myButton.getId(), myLayout.getId());

        constraintSet.applyTo(myLayout);

//        setContentView(myLayout);

        return view;
    }
}
