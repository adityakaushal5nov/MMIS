package cr.indianrailways.gov.in.mmis_ver2;


import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static cr.indianrailways.gov.in.mmis_ver2.R.id.text;
import static cr.indianrailways.gov.in.mmis_ver2.R.id.text1;


public class AFRES_Fragment extends Fragment
{


    public AFRES_Fragment()
    {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_afres_,
                container, false);
        TextView textView= (TextView) view.findViewById(text1);
        textView.setText(text);
       // return view;
        return inflater.inflate(R.layout.fragment_afres_, container, false);
    }



}
