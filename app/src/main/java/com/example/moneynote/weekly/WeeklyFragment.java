package com.example.moneynote.weekly;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.NumberPicker;

import androidx.fragment.app.Fragment;

import com.example.moneynote.R;

import java.util.ArrayList;
import java.util.Calendar;

public class WeeklyFragment extends Fragment {

    private NumberPicker year, month;
    private Button btn_button_ym;
    private ListView list;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weekly, container, false);
        Calendar calendar = Calendar.getInstance();
        int cYear = calendar.get(Calendar.YEAR);
        year = (NumberPicker)view.findViewById(R.id.picker_year);
        month = (NumberPicker)view.findViewById(R.id.picker_month);
        year.setMinValue(2010);
        year.setMaxValue(cYear+10);
        month.setMinValue(1);
        month.setMaxValue(12);
        list = (ListView)view.findViewById(R.id.weeklist);

        btn_button_ym = view.findViewById(R.id.button_ym);
        buttonListner btn1 = new buttonListner();
        btn_button_ym.setOnClickListener(btn1);

        return view;
    }

    class buttonListner implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            int yearNum = year.getValue();
            int monthNum = month.getValue();
            int count = getWeekNum(yearNum,monthNum);
            ArrayList<String> li = new ArrayList<String>();
            for(int i = 1; i<=count; i++){
                li.add(Integer.toString(i)+"주차");
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, li);
            list.setAdapter(adapter);
        }

        public int getWeekNum(int yyyy,int mm){

            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy.MM.dd");
            Calendar c = Calendar.getInstance();

            c.set(yyyy,mm-1,1);

            int startNum = c.get(Calendar.DAY_OF_WEEK);
            int lastNum = c.getActualMaximum(Calendar.DATE);
            c.set(Calendar.DATE, lastNum);
            int weekNum = c.get(Calendar.WEEK_OF_MONTH);

            return weekNum;

        }

    }
}
