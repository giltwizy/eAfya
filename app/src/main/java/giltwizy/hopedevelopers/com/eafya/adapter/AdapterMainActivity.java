package giltwizy.hopedevelopers.com.eafya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import giltwizy.hopedevelopers.com.eafya.R;
import giltwizy.hopedevelopers.com.eafya.afyaspot.KablaYaUjauzito;
import giltwizy.hopedevelopers.com.eafya.dataModel.DataModelMainActivity;

import java.util.ArrayList;


public class AdapterMainActivity extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<DataModelMainActivity> items;
    private KablaYaUjauzito mActivity;

    public AdapterMainActivity(ArrayList<DataModelMainActivity> data, KablaYaUjauzito activity) {
        this.items = data;
        this.mActivity = activity;
        this.mInflater = LayoutInflater.from(mActivity);
    }

    public void addItem(DataModelMainActivity result) {
        items.add(result);
    }

    public void setInflater(LayoutInflater layoutInflater){
        this.mInflater =layoutInflater;
    }

    public void replaceItems(ArrayList<DataModelMainActivity> newItems) {
        this.items.clear();
        for(DataModelMainActivity item: newItems)
            this.items.add(item);
    }

    public void insertItem(DataModelMainActivity item) {
        items.add(0, item);
    }

    public void clearItems(){
        items.clear();
    }

    public void AddResults(ArrayList<DataModelMainActivity> result) {
        items.addAll(result);
    }

    public DataModelMainActivity getItemsAt(int position){
        return  items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DataModelMainActivity model = items.get(position);
        MessageViewHolder messageViewHolder = (MessageViewHolder) holder;
        messageViewHolder.imageViewIcon.setBackgroundResource(model.getImage());
        messageViewHolder.textViewName.setText(model.getName());
        messageViewHolder.textViewStatus.setText(model.getStatus());
        messageViewHolder.textViewMobile.setText(model.getMobile());
    }

    @Override
    public int getItemViewType(int position) {
        return  super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootCategoryView = mInflater.inflate(R.layout.row_item, parent, false);
        return new MessageViewHolder(rootCategoryView, this);
    }

    private class MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageViewIcon;
        private TextView textViewName;
        private TextView textViewStatus;
        private TextView textViewMobile;
        private CardView cardView;

        private MessageViewHolder(View itemView, AdapterMainActivity adapter) {
            super(itemView);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.imageViewIcon);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewStatus = (TextView) itemView.findViewById(R.id.textViewStatus);
            textViewMobile = (TextView) itemView.findViewById(R.id.textViewMobile);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final int pos = getAdapterPosition();
            if (pos >= 0) {
                Toast.makeText(mActivity, "Selected Item Position "+pos, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
