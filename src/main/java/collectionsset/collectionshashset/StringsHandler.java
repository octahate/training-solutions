package collectionsset.collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {

    public Set<String> filterUniqueStrings(Collection<String> stringCollection){
        Set<String> result= new HashSet<>();
        result.addAll(stringCollection);
        return result;
    }

    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB){
        Set<String> result = new HashSet<>();
        for (String currentString :setA){
            if (setB.contains(currentString)){
                result.add(currentString);
            }
        }
        return result;
    }


}
