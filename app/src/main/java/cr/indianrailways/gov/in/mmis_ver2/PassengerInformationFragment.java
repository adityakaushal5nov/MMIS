package cr.indianrailways.gov.in.mmis_ver2;


import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class PassengerInformationFragment extends Fragment
{

    static boolean net;

    public PassengerInformationFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_tender_and_supplier, container, false);
        WebView browser;

        browser = (WebView) view.findViewById(R.id.webview);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());

        ConnectivityManager cManager = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cManager.getActiveNetworkInfo();
        if (nInfo != null && (nInfo.isConnected()))
        {
            net = true;
            browser.loadUrl("http://www.cr.indianrailways.gov.in/view_section.jsp?lang=0&id=0,5");
        }
        else
        {
            net = false;
            Toast.makeText(getActivity(), "Check your Internet Connection", Toast.LENGTH_SHORT).show();
        }

        browser.setBackgroundColor(Color.TRANSPARENT);
        Toast.makeText(getActivity(), "Please Wait...", Toast.LENGTH_SHORT);
        return view;
    }

}
