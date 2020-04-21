package com.example.universityrank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.universityrank.Adapter.PtnAdapter;
import com.example.universityrank.Data.PtnData;
import com.example.universityrank.Model.Ptn;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recPtn;
    CircleImageView imageAbout;

    private ArrayList<Ptn> list = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageAbout = findViewById(R.id.imageAbout);
        imageAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });


        recPtn = findViewById(R.id.rec_ptn);
        recPtn.setHasFixedSize(true);

        list.addAll(PtnData.getPtn());
        showPtn();

    }

    private void showPtn() {
        recPtn.setLayoutManager(new LinearLayoutManager(this));
        PtnAdapter ptnAdapter = new PtnAdapter(list);
        recPtn.setAdapter(ptnAdapter);

        ptnAdapter.setOnItemClickCallback(new PtnAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Ptn ptn) {
                moveDetail(ptn);
            }
        });
    }

    private void moveDetail(Ptn ptn) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_NAME, ptn.getName());
        intent.putExtra(DetailActivity.EXTRA_RANK, ptn.getRank());
        intent.putExtra(DetailActivity.EXTRA_DETAIL, ptn.getDetail());
        intent.putExtra(DetailActivity.EXTRA_WEB, ptn.getWeb());
        intent.putExtra(DetailActivity.EXTRA_ADDRESS, ptn.getAddress());
        intent.putExtra(DetailActivity.EXTRA_TELP, ptn.getTelp());
        intent.putExtra(DetailActivity.EXTRA_PHOTO, ptn.getPhoto());
        startActivity(intent);
    }
}
