package khaled.geoguessswipe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<GeoObject> geoObjectList;
    private RecyclerView geoRecyclerView;
    private GeoObjectAdapter geoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillList();
        geoRecyclerView = findViewById(R.id.geoObjectRecyclerView);
        geoAdapter = new GeoObjectAdapter(geoObjectList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        geoRecyclerView.setLayoutManager(mLayoutManager);
        geoRecyclerView.setAdapter(geoAdapter);
        geoRecyclerView.getLayoutManager().setMeasurementCacheEnabled(false);


        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                if (direction == ItemTouchHelper.LEFT) {
                    isImageInEurope(true, position);
                    geoObjectList.remove(position);
                    geoAdapter.notifyItemRemoved(position);
                } else if (direction == ItemTouchHelper.RIGHT) {
                    isImageInEurope(false, position);
                    geoObjectList.remove(position);
                    geoAdapter.notifyItemRemoved(position);
                }
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(geoRecyclerView);
    }


    //Checks if the answer is correct based on the swipe of the user
    private void isImageInEurope(boolean swipe, int position) {
        boolean rightAnswer = geoObjectList.get(position).isInEurope();
        if (rightAnswer == swipe) {
            Toast.makeText(this, R.string.right_answer, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, R.string.wrong_answer, Toast.LENGTH_LONG).show();
        }
    }

    //Fills the list with countries and gives them a boolean value to tell if the country is in Europe or not
    private void fillList() {
        geoObjectList = new ArrayList<>();
        for (int i = 0; i < GeoObject.PRE_DEFINED_NAMES.length; i++) {
            int res = getResources().getIdentifier("img" + (i + 1) + "_yes" + GeoObject.PRE_DEFINED_NAMES[i], "drawable", this.getPackageName());
            if (Arrays.asList(GeoObject.PRE_DEFINED_OBJECT_IDS[i]).contains(res)) {
                geoObjectList.add(new GeoObject(GeoObject.PRE_DEFINED_OBJECT_IDS[i], true));
            } else {
                geoObjectList.add(new GeoObject(GeoObject.PRE_DEFINED_OBJECT_IDS[i], false));
            }
        }
    }
}
