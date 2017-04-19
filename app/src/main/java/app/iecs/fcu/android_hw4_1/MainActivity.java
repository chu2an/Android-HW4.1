package app.iecs.fcu.android_hw4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //物件宣告
    EditText theName;
    Button theButton;
    //public static final String BROADCAST_ACTION = "fcu.iecs.app.broadcast.55688";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theName = (EditText)findViewById(R.id.edittext_name);
        theButton = (Button)findViewById(R.id.button_send);
        theButton.setOnClickListener(theButton_Listener);

    }

    private OnClickListener theButton_Listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String message = theName.getText().toString();
            Intent intent = new Intent();
            intent.setAction("fcu.iecs.app.broadcast.55688");
            intent.putExtra("KEY_message",message);
            sendBroadcast(intent);
            Toast.makeText(MainActivity.this, "HW4.1\n廣播已發送 : "+message, Toast.LENGTH_SHORT).show();
        }
    };
}
