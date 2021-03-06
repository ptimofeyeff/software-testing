import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BTreeTest {

    private lateinit var bTree: BTree<Int>

    @BeforeEach
    fun initTree() {
        bTree = BTree(4)
    }

    @Test
    fun testAddConsistently() {
        for (i in 1..1000) { bTree.add(i) }
        for (i in 1..100) { Assertions.assertTrue(bTree.contains(i)) }
        Assertions.assertEquals(1000, bTree.size())
    }

    @Test
    fun testAddInMiddle() {
        for (i in 1..1000) { bTree.add(i) }
        for (i in 500..1500) { bTree.add(i) }
        for (i in 1..100) { Assertions.assertTrue(bTree.contains(i)) }
        Assertions.assertEquals(2001, bTree.size())
    }


    @Test
    fun testContains() {
        Assertions.assertFalse(bTree.contains(2))
        bTree.add(2)
        Assertions.assertTrue(bTree.contains(2))

        Assertions.assertFalse(bTree.contains(7))
        bTree.add(7)
        Assertions.assertTrue(bTree.contains(7))

        Assertions.assertFalse(bTree.contains(3))
    }

    @Test
    fun testRemoveConsistently() {
        for (i in 1..1000) { bTree.add(i) }
        for (i in 1..100) { Assertions.assertTrue(bTree.contains(i)) }
        for (i in 1000 downTo 1) { bTree.remove(i) }
        for (i in 1..1000) { Assertions.assertFalse(bTree.contains(i)) }
    }


    @Test
    fun testRemoveFromParentNode() {
        for (i in 1..1000) { bTree.add(i) }
        for (i in 1..100) { Assertions.assertTrue(bTree.contains(i)) }
        bTree.remove(125)
        for (i in 1000 downTo 1) { bTree.remove(i) }
        for (i in 1..1000) { Assertions.assertFalse(bTree.contains(i)) }
    }

    @Test
    fun testSize() {
        Assertions.assertEquals(0, bTree.size())
        bTree.add(1)
        Assertions.assertEquals(1, bTree.size())
        bTree.add(2)
        Assertions.assertEquals(2, bTree.size())
        bTree.remove(1)
        Assertions.assertEquals(1, bTree.size())
    }

    @Test
    fun testClear() {
        bTree.add(3)
        bTree.add(6)
        bTree.add(1)
        bTree.add(7)
        bTree.add(4)
        bTree.add(5)
        Assertions.assertNotEquals(0, bTree.size())
        bTree.clear()
        Assertions.assertEquals(0, bTree.size())
        bTree.clear()
        Assertions.assertEquals(0, bTree.size())
    }

    @Test
    fun `tree can contain multiple equal values`() {
        Assertions.assertEquals(0, bTree.size())
        bTree.add(2)
        bTree.add(2)
        Assertions.assertEquals(2, bTree.size())
    }

    @Test
    fun `remove nonexistent value should return null`() {
        Assertions.assertEquals(0, bTree.size())
        Assertions.assertNull(bTree.remove(9))
        Assertions.assertEquals(0, bTree.size())
    }

    @Test
    fun `UnsupportedValueException for null-value in argument`() {
        Assertions.assertThrows(UnsupportedValueException::class.java) { bTree.add(null) }
        Assertions.assertThrows(UnsupportedValueException::class.java) { bTree.contains(null) }
    }
}