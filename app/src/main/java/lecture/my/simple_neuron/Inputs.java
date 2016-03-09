package lecture.my.simple_neuron;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

/**
 * Created by asd on 09/03/16.
 */
public class Inputs implements Button.OnClickListener {
    Button[][] buttons;

    public Inputs(MainActivity mainActivity) {
        TableLayout tableLayout = (TableLayout) mainActivity.findViewById(R.id.tableLayout);
        TableRow row;
        buttons = new Button[mainActivity.getResources().
                getInteger(R.integer.heightInput)][mainActivity.getResources().getInteger(R.integer.
                lenghtInput)];
        for (int i = 0; i < mainActivity.getResources().getInteger(R.integer.heightInput); i++)
        {
            row = (TableRow)tableLayout.getChildAt(i);
            for (int j = 0; j < mainActivity.getResources().getInteger(R.integer.lenghtInput); j++) {
                buttons[i][j] = (Button) row.getChildAt(j);
                buttons[i][j].setOnClickListener(this);
            }
        }
    }

    public void resetButtons() {
        for (int i = 0; i < buttons.length; i++)
            for (int j = 0; j < buttons[0].length; ++j) {
                buttons[i][j].setBackgroundColor(Color.GRAY);
                buttons[i][j].setTag(R.string.key, new Boolean(false));
            }
    }

    public boolean[][] getInputs() {
        boolean[][] inputs = new boolean[buttons.length][buttons[0].length];
        for (int i = 0; i < buttons.length; i++)
            for (int j = 0; j < buttons[0].length; ++j) {
                inputs[i][j] = ((Boolean) buttons[i][j].getTag(R.string.key)) ? true : false;
            }
        return inputs;
    }


    @Override
    public void onClick(View v) {
        if (v.getTag(R.string.key) == null || (Boolean) v.getTag(R.string.key) == false) {
            v.setBackgroundColor(Color.BLACK);
            v.setTag(R.string.key, new Boolean(true));
        } else {
            v.setBackgroundColor(Color.GRAY);
            v.setTag(R.string.key, new Boolean(false));
        }
    }
}
