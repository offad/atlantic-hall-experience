package edu.school.atlantichallexperience;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by FEMI on 21/01/2018.
 */

public class InfoAdapter extends ArrayAdapter<InfoItem> {

    private ArrayList<InfoItem> notes = new ArrayList<>();

    public InfoAdapter(Context context, ArrayList<InfoItem> words) {
        super(context, 0, words);
        notes = words;
    }

    public View getView(int position, View convertView, final ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view

        View listItemView = convertView;
        final InfoItem current = getItem(position);

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        ImageView pic = (ImageView) listItemView.findViewById(R.id.item_pic);
        TextView text = (TextView) listItemView.findViewById(R.id.item_message);

        if (current != null) {
            pic.setImageResource(current.getImageID());
            text.setText(current.getText());
            listItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(current.getUrl()));
                    parent.getContext().startActivity(intent);
                }
            });
        }

        return listItemView;
    }

}
