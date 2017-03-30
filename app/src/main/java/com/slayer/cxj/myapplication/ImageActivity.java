package com.slayer.cxj.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageActivity extends AppCompatActivity {

    private List<String> img_list = new ArrayList<>();
    private ArrayList ids = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        final ImageView imageView = (ImageView) findViewById(R.id.auto_img);


//        String img_path = Environment.DIRECTORY_PICTURES;  // + "/Camera/";
//        File mfile = new File(img_path);
//        File[] images = mfile.listFiles();

        // 将所有的文件存入ArrayList中,并过滤所有图片格式的文件
//        for (int i = 0; i < images.length; i++) {
//            File file = images[i];
//            if (checkIsImageFile(file.getPath())) {
//                img_list.add(file.getPath());
//                Log.i("demo", file.getPath());
//            }
//
//        }

        Field[] fields = R.drawable.class.getDeclaredFields();
        Context context = getBaseContext();
        int resID;
        int len = 0;
        int inital_img_id = 0;

        for (Field field : fields) {
            if ((field.getName()).indexOf("koala") != -1) {
                inital_img_id = context.getResources().getIdentifier(field.getName(), "drawable", context.getPackageName());
            } else if (((field.getName()).indexOf("a1421")) != -1) {
                resID = context.getResources().getIdentifier(field.getName(), "drawable", context.getPackageName());
                ids.add(len, resID);
                len++;

                Log.i("image name is", field.getName());

//
            }

        }


        imageView.setImageResource(inital_img_id);

        final Random random = new Random();

//        try {
//            Thread.sleep(100);
//            imageView.setImageResource((int) ids.get(random.nextInt(ids.size())));
//        } catch (InterruptedException e) {
//
//        }

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setImageResource((int) ids.get(random.nextInt(ids.size())));
//            }
//        });

    }

    private boolean checkIsImageFile(String fName) {
        boolean isImageFile;

        // 获取扩展名
        String FileEnd = fName.substring(fName.lastIndexOf(".") + 1,
                fName.length()).toLowerCase();
        if (FileEnd.equals("jpg") || FileEnd.equals("gif")
                || FileEnd.equals("png") || FileEnd.equals("jpeg")
                || FileEnd.equals("bmp")) {
            isImageFile = true;
        } else {
            isImageFile = false;
        }

        return isImageFile;

    }
}
