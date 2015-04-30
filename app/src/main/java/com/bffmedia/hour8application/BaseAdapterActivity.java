package com.bffmedia.hour8application;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class BaseAdapterActivity extends Activity {
    ListView pieListView;
    String[] pies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resources = getResources();
        pies = resources.getStringArray(R.array.pie_array);
        pieListView = (ListView) findViewById(R.id.listView);
        PieAdapter adapter = new PieAdapter(this, pies);
        pieListView.setAdapter(adapter);

        pieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        pies[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
    public class PieAdapter extends BaseAdapter {
        Context mContext;
        String mPies[];
        LayoutInflater mInflater;
        public PieAdapter(Context c, String[] pies) {
            mContext = c;
            mPies = pies;
            mInflater = (LayoutInflater) mContext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

        }
        public int getCount() {
            return  mPies.length;
        }
        public Object getItem(int position) {
            return mPies[position];
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = (TextView) mInflater.inflate(R.layout.text_view_item, null);
            textView.setText(mPies[position]);
        	return textView;
        }
    }

}
