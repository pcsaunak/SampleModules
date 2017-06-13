package example.learn.com.volleydagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    @Inject
    public SampleDaggerTestClass testClassObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d("Class Name",testClassObj.getMyName());
//        Log.d("Office Name",testClassObj.getMyOffice());

    }
}
