import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class VoiceInputActivity extends Activity {
    private EditText inputField;
    private Button voiceInputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_input);

        inputField = findViewById(R.id.input_field);
        voiceInputButton = findViewById(R.id.voice_input_button);

        voiceInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String spokenText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0);
            inputField.setText(spokenText);
            Toast.makeText(this, "You said: " + spokenText, Toast.LENGTH_SHORT).show();
        }}}
