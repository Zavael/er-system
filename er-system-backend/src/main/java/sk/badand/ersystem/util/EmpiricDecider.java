package sk.badand.ersystem.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by abadinka on 22. 9. 2016.
 */
public class EmpiricDecider<V> {
    private final Randomizer randomizer = new Randomizer();

    private final Map<V, Double> optionsWithOdds;

    public EmpiricDecider(Map<V, Double> optionsWithOdds) {
        this.optionsWithOdds = optionsWithOdds;
    }

    public V getSuccessfulOption(double chance){
        double totalOdds = 0;
        LinkedHashMap<V, Double> optionRanges = new LinkedHashMap<>(optionsWithOdds.size());
        for (V option : optionsWithOdds.keySet()) {
            totalOdds += optionsWithOdds.get(option);
            optionRanges.put(option, totalOdds);
        }
        double realChance = chance * totalOdds;
        for (V option : optionRanges.keySet()) {
            if (realChance < optionRanges.get(option)) {
                return option;
            }
        }

        throw new IllegalArgumentException("Argument 'chance' is out of universe 1.0");
    }

    public V getSuccessfulOption(){
        return getSuccessfulOption(randomizer.nextDouble());
    }
}
