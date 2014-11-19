package org.orangesun.textstylechecker;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;


public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private TextView view1;
        private TextView view2;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);

            view1 = (TextView) rootView.findViewById(R.id.text_view1);
            view2 = (TextView) rootView.findViewById(R.id.text_view2);

            EditText e1 = (EditText) rootView.findViewById(R.id.text_size1);
            e1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    EditText textSizeView = (EditText) v;
                    String textSize = textSizeView.getText().toString();
                    int size = 10;
                    if (textSize != null && textSize.length() != 0) {
                        size = Integer.parseInt(textSize);
                    }

                    changeTextStyle(view1, size);
                }
            });

            EditText e2 = (EditText) rootView.findViewById(R.id.text_size2);
            e2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    EditText textSizeView = (EditText) v;
                    String textSize = textSizeView.getText().toString();
                    int size = 10;
                    if (textSize != null && textSize.length() != 0) {
                        size = Integer.parseInt(textSize);
                    }
                    changeTextStyle(view2, size);
                }
            });

            return rootView;
        }

        private void changeTextStyle(TextView view, int size) {
            view.setTextSize(size);
        }
    }
}
