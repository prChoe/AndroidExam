
package com.prchoe.androidexam.calendar;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.prchoe.androidexam.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by massivCode on 2015-09-08.
 */
public class CalendarAdapter extends BaseAdapter {

    private List<Calendar> mList;
    private Context mContext;
    private Calendar mCalendar;

    public CalendarAdapter(Context context) {
        mContext = context;

        // 오늘
        mCalendar = Calendar.getInstance();
        createCalendar(mCalendar);
    }

    private void createCalendar(Calendar calendar) {
        mList = new ArrayList<>();


        // 오늘
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        // 이달의 첫번째 날
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firtstDay = calendar.get(Calendar.DAY_OF_WEEK);

        for (int i = 1; i < firtstDay; i++) {
            mList.add(null);
        }

        // 마지막 날
        int lastDay = calendar.getActualMaximum(Calendar.DATE);

        // 이번달 달력 데이터
        for (int i = 1; i <= lastDay; i++) {
            mList.add(new GregorianCalendar(year, month, i));
        }
    }

    private void changeMonth(int month) {
        mCalendar.add(Calendar.MONTH, month);
        createCalendar(mCalendar);

        // 어댑터에 바뀐 데이터를 반영하도록 알려 줌
        notifyDataSetChanged();

    }

    public void prevMonth() {
        changeMonth(-1);
    }

    public void nextMonth() {
        changeMonth(1);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // item이 화면에 보일 때 호출됨
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        // Layout을 완성하고 ViewHolder와 연결
        // findViewById를 한번만 하려고
        if (convertView == null) {
            viewHolder = new ViewHolder();

            // 처음 로드
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_calendar, parent,
                    false);

            viewHolder.dateTextView = (TextView) convertView.findViewById(R.id.tv_date);

            convertView.setTag(viewHolder);

        } else {
            // 재사용
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Data를 Layout에 설정
        Calendar calendar = mList.get(position);

        if (calendar != null) {



            viewHolder.dateTextView.setText("" + calendar.get(Calendar.DATE));

            if(position % 7 == 0) {
                viewHolder.dateTextView.setTextColor(Color.RED);
            } else if(position % 6 == 0) {
                viewHolder.dateTextView.setTextColor(Color.BLUE);
            }

        } else {
            viewHolder.dateTextView.setText("");
        }

        return convertView;
    }

    static class ViewHolder {
        TextView dateTextView;
    }

    public Calendar getCalendar() {
        return mCalendar;
    }

}