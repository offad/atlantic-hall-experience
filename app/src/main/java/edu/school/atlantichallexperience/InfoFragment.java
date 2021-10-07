package edu.school.atlantichallexperience;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by FEMI on 19/01/2018.
 */

public class InfoFragment extends Fragment {
    public static String TAG = "Info";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_info, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) getActivity().findViewById(R.id.info_list);
        ArrayList<InfoItem> categories = new ArrayList<>();
        categories.add(new InfoItem("Life at atlantic", "http://atlantic-hall.net/life-at-atlantic/pastoral-welfare-dev/", R.drawable.chair_school));
        categories.add(new InfoItem("Admissions", "http://atlantic-hall.net/admissions-aids/college-admissions/",R.drawable.school));
        categories.add(new InfoItem("Medical care", "http://atlantic-hall.net/life-at-atlantic/medical-care/", R.drawable.medical_bag));
        categories.add(new InfoItem("Calendar", "http://atlantic-hall.net/academics/academic-overview/term-dates-academic-calendar/", R.drawable.calendar_check));
        categories.add(new InfoItem("E-Learning", "http://atlantic-hall.net/e-learning/", R.drawable.laptop));
        ArrayAdapter<InfoItem> infoAdapter = new InfoAdapter(getActivity(), categories);
        listView.setAdapter(infoAdapter);
        super.onActivityCreated(savedInstanceState);
    }
}
