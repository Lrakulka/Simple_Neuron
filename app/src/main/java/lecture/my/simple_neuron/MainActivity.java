package lecture.my.simple_neuron;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Neuron neuron;
    private Inputs inputs;
    private TextView textView;
    private boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        neuron = new Neuron(getResources().getInteger(R.integer.heightInput),
                getResources().getInteger(R.integer.lenghtInput));
        inputs = new Inputs(this);
        inputs.resetButtons();
    }

    public void onStart(View v) {
        status = true;
        int sum = neuron.getSum(inputs.getInputs());
        String str = neuron.getWeights() + "sum=" + sum + System.getProperty("line.separator") +
                "Predict=" + neuron.activationFunction(sum);
        textView.setText(str);
        inputs.resetButtons();
    }

    public void onReset(View v) {
        neuron.resetNeuron();
        int sum = neuron.getSum(inputs.getInputs());
        String str = neuron.getWeights() + "sum=" + sum + System.getProperty("line.separator") +
                "Predict=" + neuron.activationFunction(sum);
        textView.setText(str);
    }

    public void onAward(View v) {
        if (status) {
            neuron.awardWeights();
            status = false;
            textView.setText(neuron.getWeights());
        } else {
            Toast.makeText(this, "First press Start", Toast.LENGTH_SHORT).show();
        }
    }

    public void onPunish(View v) {
        if (status) {
            neuron.punishWeights();
            status = false;
            textView.setText(neuron.getWeights());
        } else {
            Toast.makeText(this, "First press Start", Toast.LENGTH_SHORT).show();
        }
    }
}
