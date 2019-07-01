package cr.indianrailways.gov.in.mmis_ver2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static cr.indianrailways.gov.in.mmis_ver2.R.id.fuel;
import static cr.indianrailways.gov.in.mmis_ver2.R.id.text;
import static cr.indianrailways.gov.in.mmis_ver2.R.id.text1;


/**
 * A simple {@link Fragment} subclass.
 */
public class FuelAccountingSystem_Fragment extends Fragment {


    public FuelAccountingSystem_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_fuel_accounting_system_,
                container, false);
        TextView textView= (TextView) view.findViewById(fuel);
        textView.setText(text);
        // return view;
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fuel_accounting_system_, container, false);
    }

}
