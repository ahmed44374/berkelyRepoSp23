import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
public class ArrayDequeTest {
    @Test
    /** In this test, we have three different assert statements that verify that addFirst works correctly. */
    public void addFirstTestBasic() {
        Deque<String> lld1 = new ArrayDeque<>();

        lld1.addFirst("back"); // after this call we expect: ["back"]
        assertThat(lld1.toList()).containsExactly("back").inOrder();

        lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
        assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

        lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
          */
    }

    @Test
    /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
     *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
    public void addLastTestBasic() {
        Deque<String> lld1 = new ArrayDeque<>();

        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    /** This test performs interspersed addFirst and addLast calls. */
    public void addFirstAndAddLastTest() {
        Deque<Integer> lld1 = new ArrayDeque<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
    }

    @Test
    public void SizeTest() {
        Deque<Integer> lld = new ArrayDeque<>();
        assertThat(lld.size()).isEqualTo(0);
        lld.addLast(45);
        lld.addLast(45);
        lld.addLast(45);
        lld.addFirst(56);
        lld.addFirst(56);
        lld.addFirst(56);
        assertThat(lld.size()).isEqualTo(6);
    }
    @Test
    public void IsEmptyTest() {
        Deque<Integer> lld = new ArrayDeque<>();
        assertThat(lld.isEmpty()).isTrue();
        lld.addFirst(4);
        assertThat(lld.isEmpty()).isFalse();
        lld.addFirst(6);
        assertThat(lld.isEmpty()).isFalse();
    }
//    @Test
//    public void getTest() {
//        Deque<Integer> lld = new ArrayDeque<>();
//        assertThat(lld.get(0)).isNull();
//        lld.addLast(1);
//        lld.addLast(2);
//        lld.addLast(3);
//        lld.addLast(4);
//        assertThat(lld.get(0)).isEqualTo(1);
//        assertThat(lld.get(1)).isEqualTo(2);
//        assertThat(lld.get(2)).isEqualTo(3);
//        assertThat(lld.get(3)).isEqualTo(4);
//        lld.addFirst(6);
//        assertThat(lld.get(0)).isEqualTo(6);
//    }
//
//    @Test
//    public void removeFirstTestBasic() {
//        Deque<Integer> lld = new ArrayDeque<>();
//        lld.addFirst(5);
//        lld.addFirst(4);
//        lld.addFirst(3);
//        lld.removeFirst();
//        assertThat(lld.get(0)).isEqualTo(4);
//        lld.removeFirst();
//        assertThat(lld.get(0)).isEqualTo(5);
//        lld.removeFirst();
//        assertThat(lld.get(0)).isEqualTo(null);
//    }
//    @Test
//    public void removeLastTestBasic() {
//        Deque<String> lld1 = new ArrayDeque<>();
//        lld1.addFirst("back");
//        assertThat(lld1.toList()).containsExactly("back").inOrder();
//        lld1.addFirst("red");
//        lld1.addFirst("blue");
//        lld1.addFirst("white");
//        assertThat(lld1.toList()).containsExactly("white","blue","red","back").inOrder();
//        lld1.removeLast();
//        assertThat(lld1.toList()).containsExactly("white","blue","red").inOrder();
//        lld1.removeLast();
//        assertThat(lld1.toList()).containsExactly("white","blue").inOrder();
//        lld1.addFirst("hunter");
//        assertThat(lld1.toList()).containsExactly("hunter","white","blue").inOrder();
//        assertThat(lld1.removeLast()).isEqualTo("blue");
//    }

}
