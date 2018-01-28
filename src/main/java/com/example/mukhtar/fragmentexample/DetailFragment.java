package com.example.mukhtar.fragmentexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment
{
    private static final String ARG_MESSAGE = "arg_message";
    private static final String ARG_BACKGROUND = "arg_background";

    public DetailFragment()
    {
        // Required empty public constructor
    }

    public static DetailFragment newFragment(CharSequence message, int background)
    {
        DetailFragment fragment = new DetailFragment();

        Bundle args = new Bundle();
        args.putCharSequence(ARG_MESSAGE, message);
        args.putInt(ARG_BACKGROUND, background);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView tv_message = rootView.findViewById(R.id.tv_message);
        Bundle args = getArguments();
        CharSequence message = args.getCharSequence(ARG_MESSAGE);
        int background = args.getInt(ARG_BACKGROUND);
        tv_message.setText(message);
        tv_message.setBackgroundColor(background);

        return  rootView;
    }

}// DetailFragment
