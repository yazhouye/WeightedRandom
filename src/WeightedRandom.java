import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;


public class WeightedRandom {

    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<Integer>();
        //weights:
        weights.add(1);
        weights.add(2);
        weights.add(2);
        weights.add(3);
        weights.add(6);
        weights.add(14);

        int[] indexCount = new int[weights.size()];

        for (int i = 0; i < 1000; i++) {
            int index = getWeightedRandom(weights);
            indexCount[index]++;
            System.out.println(index);
        }

        System.out.println("indexCount: ");
        for (int i = 0; i < weights.size(); i++) {
            System.out.println(i + ": " + indexCount[i]);
        }
    }

    private static int getWeightedRandom(List<Integer> weights) {
        List<Integer> weightsDistribution = new ArrayList<Integer>();
        for (int i = 0; i < weights.size(); i++) {
            for (int j = 0; j < weights.get(i); j++) {
                weightsDistribution.add(i);
            }
        }

        int randomNum = ThreadLocalRandom.current().nextInt(0, weightsDistribution.size());
        return weightsDistribution.get(randomNum);
    }
}
