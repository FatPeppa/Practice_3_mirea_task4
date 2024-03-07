package com.example.practice_3_mirea_task4;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    private static class Item {
        private String text_field;
        public Item(String text_field) {
            this.text_field = text_field;
        }

        public String getText_field() {
            return text_field;
        }

        public void setText_field(String text_field) {
            this.text_field = text_field;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            items.add(new Item("ListView item " + i));
        }

        ListView itemsList = getActivity().findViewById(R.id.first_fragment_list_view);

        FistFragmentListViewAdapter adapter = new FistFragmentListViewAdapter(this.getContext(),
                R.layout.list_view_item, items);
        itemsList.setAdapter(adapter);

    }

    public class FistFragmentListViewAdapter extends ArrayAdapter<Item> {
        private LayoutInflater inflater;
        private int layout;
        private List<Item> items;
        public FistFragmentListViewAdapter(Context context, int resource,
                                     List<Item> items) {
            super(context, resource, items);
            this.items = items;
            this.layout = resource;
            this.inflater = LayoutInflater.from(context);
        }
        public View getView(int position, View convertView,
                            ViewGroup parent) {

            View view = inflater.inflate(this.layout, parent, false);

            TextView textView = view.findViewById(R.id.first_fragment_list_view_item);
            Item item = items.get(position);
            textView.setText(item.getText_field());
            return view;
        }
    }
}
