package ie.tudublin;

import processing.core.PApplet;
import java.util.Scanner;

public class Arrays extends PApplet {

    float[] rainfall = {45,37,55,27,38,50,79,48,104,31,100,58};
    Scanner scanner = new Scanner(System.in);
    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    int mode = scanner.nextInt();
    public void settings(){
        size(500,500);
    }

    public void setup(){
        float x = 100;
        int j = 0;
        for(int i = 0; i < rainfall.length;i++){
            if(rainfall[i] < x){
                x = rainfall[i];
                j = i;
            }
        }
        println(months[j] + "Had the least rainfall:" +rainfall[j]);
    }


    public void draw(){
        switch (mode){
            case 0: 
                break;

            case 1:
                background(0);
                float border = width * 0.1f;
                //Draw the axis
                stroke(255);
                line(border,border,border,height - border);
                line(border,height - border, width - border, height - border);
                for(int i = 0;i<=120;i+=10){
                    float y = map(i,0,120,height - border, border);
                    line(border - 5, y, border, y);
                    fill(255);
                    text(i, border / 2, y );
                    textAlign(CENTER, CENTER);
                }
                float w = (width - (border * 2.0f)) / (float)rainfall.length;
                for(int i = 0; i<rainfall.length; i++){
                    float x = map(i, 0, rainfall.length, border, width - border);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    stroke(255);
                    fill(c, 255, 255);
                    colorMode(HSB);
                    float h = map(rainfall[i], 0, 120, 0, -height + (border * 2.0f));
                    rect(x, height-border, w, h);
                    fill(255);
                    text(months[i], x + (w/2),height - (border / 2));
                }
                
                break;
            
            case 2:
                background(0);
                float r = width * 0.3f;
                float cx = width / 2;
                float cy = height / 2;
                circle(cx, cy, r * 2.0f);
                noFill();
                stroke(255);
                //arc();

                break;

            case 3:
                //code
                break;
        }
    }


}
