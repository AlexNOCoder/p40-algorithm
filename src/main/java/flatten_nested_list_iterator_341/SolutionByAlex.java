package flatten_nested_list_iterator_341;

import common.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolutionByAlex implements Iterator<Integer> {

    private List<Integer> vals;
    private Iterator<Integer> cur;

    public SolutionByAlex(List<NestedInteger> nestedList) {
        vals = new ArrayList<>();
        dfs(nestedList);
        cur = vals.iterator();
    }

    @Override
    public Integer next() {

        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    public void dfs(List<NestedInteger> nestedIntegers){
        for(NestedInteger nest:nestedIntegers){
            if(nest.isInteger()){
                vals.add(nest.getInteger());
            }else {
                dfs(nest.getList());
            }
        }
    }
}


