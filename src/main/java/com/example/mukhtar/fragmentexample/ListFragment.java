package com.example.mukhtar.fragmentexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment
{
    public interface ItemClickListener
    {
        void itemClicked(CharSequence message, int background);
    }

    private ItemClickListener mListener;

    public ListFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        mListener = (ItemClickListener) context;
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mListener = (ItemClickListener) activity;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        final TextView tv_top = rootView.findViewById(R.id.tv_top);
        tv_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mListener.itemClicked(tv_top.getText(), R.color.volite_100);
            }
        });

        final TextView tv_middle = rootView.findViewById(R.id.tv_middle);
        tv_middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mListener.itemClicked(tv_middle.getText(), R.color.blue_100);
            }
        });

        final TextView tv_bottom = rootView.findViewById(R.id.tv_bottom);
        tv_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mListener.itemClicked(tv_bottom.getText(), R.color.green_100);
            }
        });

        return rootView;
    }

}// ListFragment
