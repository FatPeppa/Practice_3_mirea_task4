package com.example.practice_3_mirea_task4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {
    public SecondFragment() {
        super(R.layout.fragment_second);
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

    public class FirstFragmentRecyclerViewAdapter extends
            RecyclerView.Adapter <FirstFragmentRecyclerViewAdapter.ViewHolder>{
        private final LayoutInflater inflater;
        private final List<Item> items;
        FirstFragmentRecyclerViewAdapter(Context context, List<Item>
                items) {
            this.items = items;
            this.inflater = LayoutInflater.from(context);
        }
        @Override
        public FirstFragmentRecyclerViewAdapter.ViewHolder
        onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.recycler_view_item, parent,
                    false);
            return new ViewHolder(view);
        }
        @Override
        public void
        onBindViewHolder(FirstFragmentRecyclerViewAdapter.ViewHolder
                                 holder, int position) {
            Item item = items.get(position);
            holder.textView.setText(item.getText_field());
        }
        @Override
        public int getItemCount() {
            return items.size();
        }
        public class ViewHolder extends
                RecyclerView.ViewHolder {
            final TextView textView;
            ViewHolder(View view){
                super(view);
                textView = view.findViewById(R.id.second_fragment_recycler_view_item);
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView itemsList = getActivity().findViewById(R.id.second_fragment_recycler_view);
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            items.add(new Item("RecyclerView item " + i));
        }

        FirstFragmentRecyclerViewAdapter adapter = new FirstFragmentRecyclerViewAdapter(this.getContext(), items);
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(this.getContext().getApplicationContext());
        itemsList.setLayoutManager(layoutManager);
        itemsList.setAdapter(adapter);
    }
}
