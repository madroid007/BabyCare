package com.myapp.madroid.babycare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AttentionActivity extends AppCompatActivity {

    Typeface ssssss ;
    TextView txt_attention ;
    SharedPreferences shrd ;
    String lang ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);


        shrd = PreferenceManager.getDefaultSharedPreferences(this);
        lang = shrd.getString("language","ara");

        ssssss = Typeface.createFromAsset(getAssets(),"shahd.ttf");
        txt_attention = (TextView)findViewById(R.id.txt_attention);
        txt_attention.setTypeface(ssssss);



        if (lang.equals("ara")){
            txt_attention.setText("المعلومات الواردة في هذا التطبيق ليست بديلا عن المشورة الطبية و ارشادات الطبيب أو مقدم الرعاية الصحية حيث كل الظروف المحيطة والصحية معروفة. إذا كنتي قلقة بشأن صحتك أو صحة طفلك، اطلبي المشورة الطبية الفورية. يجب عليكي ألا تتأخري أبدا ، أو تجاهل المشورة الطبية، أو التوقف عن العلاج الطبي بسبب المعلومات الموجودة في هذا التطبيق . نحن نعمل علي جعل المعلومات الموجودة في هذا التطبيق لتكون محدثة و دقيقة , ولكن إلى الحد الذي يسمح به القانون، لا نقبل أي مسؤولية عن الأخطاء أو الإغفالات.");

        }else if (lang.equals("eng")){
            txt_attention.setText("The information contained in this application is not an alternative for specific, individual medical advice and guidance from your doctor or health care provider, where all surrounding conditions and circumstances are known. If you are worried about your own health, or your child’s well being, seek immediate medical advice. You should never delay seeking medical advice, disregard medical advice, or discontinue medical treatment because of information on this application. We intend for the information on this application to be up to date, timely and accurate but, to the extent that we are permitted by law, do not accept any liability or responsibility for claims, errors or omissions.");
        }


        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();


    }
}
