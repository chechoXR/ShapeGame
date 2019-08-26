package com.checho.shapegame;

import androidx.appcompat.app.AppCompatActivity;



import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;


import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int puntaje;
    private TextView Score;
    private TextView Veredicto;

    private Button red;
    private Button green;
    private Button blue;

    private LinearLayout ly;
    private Paint p;
    private ImageView iv;
    private Bitmap bm;
    private Canvas c;
    private int sp;
    private Random rd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        puntaje = 0;
        Score = findViewById(R.id.Score);
        Veredicto = findViewById(R.id.Veredicto);

        red = findViewById(R.id.Rojo);
        green = findViewById(R.id.Verde);
        blue = findViewById(R.id.Azul);


        iv = findViewById(R.id.imageView);


        bm = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        c = new Canvas(bm);

        this.p=new Paint();

        this.rd=new Random(1);
        iv.setImageBitmap(bm);
        rd();







    }


    private void rd(){


        int d = rd.nextInt(6);

        float size=250;

        c = new Canvas(bm);
        if(d==0)
        {
            p.setColor(Color.RED);
            c = new Canvas(bm);
            c.drawCircle(bm.getWidth()/2,bm.getHeight()/2,size,p);
            sp=1;
        }
        if(d==1)
        {
            p.setColor(Color.GREEN);
            c.drawCircle(bm.getWidth()/2,bm.getHeight()/2,size,p);
            sp=1;
        }
        if(d==2)
        {
            p.setColor(Color.BLUE);
            c.drawCircle(bm.getWidth()/2,bm.getHeight()/2,size,p);
            sp=1;
        }
        if(d==3)
        {
            p.setColor(Color.RED);
            c.drawRect(size,size,size,size,p);
            sp=2;
        }
        if(d==4)
        {
            p.setColor(Color.GREEN);
            c.drawRect(size,size,size,size,p);
            sp=2;
        }
        if(d==5)
        {
            p.setColor(Color.BLUE);
            c.drawRect(size,size,size,size,p);
            sp=2;
        }
        if(d==6)
        {
            p.setColor(Color.RED);
            float [] f = {1,2,3};
            c.drawLines(f,p);
            sp=3;
        }
        if(d==7)
        {
            p.setColor(Color.GREEN);
            float [] f = {1,2,3};
            c.drawLines(f,p);
            sp=3;
        }

        if(d==8)
        {
            p.setColor(Color.BLUE);
            float [] f = {1,2,3};
            c.drawLines(f,p);
            sp=3;
        }
    }


    public void rojo(View view){



        int s = Integer.parseInt(this.Score.getText().toString());

        if(p.getColor() == (Color.RED))
            this.Score.setText(""+(s+=10));
        else
            this.Score.setText(""+(s-=10));


        if(s>=100)
        {
            disable();
            this.Veredicto.setText("Ganaste!");
        }
        else if(s<=-50)
        {
         disable();
         this.Veredicto.setText("Perdiste!");
        }

        rd();

    }

    public void verde(View view){
        int s = Integer.parseInt(this.Score.getText().toString());

        if(p.getColor() == (Color.GREEN))
            this.Score.setText(""+(s+=10));
        else
            this.Score.setText(""+(s-=10));
        if(s>=100)
        {
            disable();
            this.Veredicto.setText("Ganaste!");
        }
        else if(s<=-50)
        {
            disable();
            this.Veredicto.setText("Perdiste!");
        }
        else
        {

        }
        rd();
    }

    public void azul(View view){

        int s = Integer.parseInt(this.Score.getText().toString());
        if(p.getColor() == (Color.BLUE))
            this.Score.setText(""+(s+=10));
        else
            this.Score.setText(""+(s-=10));
        if(s>=100)
        {
            disable();
            this.Veredicto.setText("Ganaste!");
        }
        else if(s<=-50)
        {
            disable();
            this.Veredicto.setText("Perdiste!");
        }
        else
        {

        }

        rd();
    }

    private void disable(){

        this.red.setEnabled(false);
        this.green.setEnabled(false);
        this.blue.setEnabled(false);

    }


}
