package alg.weissma.collections;

import sun.misc.ASCIICaseInsensitiveComparator;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by feng on 2016/10/11.
 *
 */
public class SetTest {

    public static void main(String[] args) {
        new SetTest().treesetTest();
    }

    /**
     * {@link TreeSet}继承自 {@link SortedSet},自动排序
     */
    private void treesetTest(){
        Set<String> treeSet = new TreeSet<>(new ASCIICaseInsensitiveComparator());
        treeSet.add("test2");
        treeSet.add("test1");
        Iterator<String> iterator = treeSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
