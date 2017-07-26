package stories.cs2800;

import stories.cs2800.AggregateItem;
import stories.cs2800.ItemVisitor;
import stories.cs2800.SingleItem;

public class DetailsVisitor implements ItemVisitor<String> {
    private StringBuilder result = new StringBuilder();
    private Boolean firstNode = Boolean.valueOf(true);


    public final boolean shouldRecurse() {
        boolean recResult = firstNode.booleanValue();
        firstNode = Boolean.valueOf(false);
        return recResult;
    }

    public final void add(AggregateItem aggregateItemToAdd) {
        if(!firstNode.booleanValue()) {
            if(result.length() > 0) {
                result.append("");
            }

            result.append(aggregateItemToAdd.getName());
        }

    }

    public final void add(SingleItem singleItemToAdd) {
        if(!firstNode.booleanValue()) {
            if(result.length() > 0) {
                result.append("");
            }

            result.append(singleItemToAdd.getChild().getName());
        }

    }

    public final String getResult() {
        return result.toString();
    }
}
