package khaled.geoguessswipe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by khaled on 02-10-18.
 */

public class GeoObjectAdapter extends RecyclerView.Adapter<GeoObjectAdapter.MyViewHolder> {
    private final List<GeoObject> geoObjectList;

    public GeoObjectAdapter(final List<GeoObject> geoObjectList) {
        this.geoObjectList = geoObjectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.geo_list_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final GeoObject geoObject = geoObjectList.get(position);
        holder.geoImage.setImageResource(geoObject.getmGeoImageName());
    }

    @Override
    public int getItemCount() {
        return geoObjectList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView geoImage;

        public MyViewHolder(View view) {
            super(view);
            geoImage = view.findViewById(R.id.geoImageView);
        }
    }
}
