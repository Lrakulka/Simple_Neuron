package lecture.my.simple_neuron;

/**
 * Created by asd on 09/03/16.
 */
public class Neuron {
    private int AWARD_PUNISH = 1;
    private int[][] weights;
    private boolean[][] inputs;

    public Neuron(int length, int height) {
        weights = new int[length][height];
    }

    public double activationFunction(int sum) {
        return 1 / (1 + Math.exp(-sum));
    }

    public int getSum(boolean[][] inputs) {
        this.inputs = inputs;
        return getSum();
    }

    public int getSum() {
        int sum = 0;
        for (int i = 0; i < weights.length; i++)
            for (int j = 0; j < weights[0].length; ++j) {
                if (inputs[i][j]) {
                    sum += weights[i][j];
                }
            }
        return sum;
    }

    private void changeWeight(int value) {
        for (int i = 0; i < weights.length; i++)
            for (int j = 0; j < weights[0].length; ++j) {
                if (inputs[i][j]) {
                    weights[i][j] += value;
                }
            }
    }

    public void punishWeights() {
        changeWeight(-AWARD_PUNISH);
    }

    public void awardWeights() {
        changeWeight(AWARD_PUNISH);
    }

    public void resetNeuron() {
        weights = new int[weights.length][weights[0].length];
    }

    public String getWeights() {
        StringBuilder stringBuilder = new StringBuilder("Weights");
        for (int i = 0; i < weights.length; i++) {
            stringBuilder.append(System.getProperty("line.separator"));
            for (int j = 0; j < weights[0].length; ++j) {
                stringBuilder.append(weights[i][j]);
            }
        }
        stringBuilder.append(System.getProperty("line.separator"));
        return stringBuilder.toString();
    }
}
