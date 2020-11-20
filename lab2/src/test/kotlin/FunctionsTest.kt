import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.*

class FunctionsTest {
    private val trigonometricFunction = TrigonometricFunction(SinApprox)

    private val logarithmicFunctions = LogarithmicFunctions(NaturalLogarithmApprox)


    @Test
    fun log10Test() {
        Assertions.assertEquals(log10(25.0), logarithmicFunctions.logN(25.0, 10.0, 1E-6), 1E-6)
        Assertions.assertEquals(log10(10.0), logarithmicFunctions.logN(10.0, 10.0, 1E-6), 1E-6)
        Assertions.assertEquals(log10(15.0), logarithmicFunctions.logN(15.0, 10.0, 1E-6), 1E-6)
    }

    @Test
    fun log2Test() {
        Assertions.assertEquals(log2(25.0), logarithmicFunctions.logN(25.0, 2.0, 1E-6), 1E-6)
        Assertions.assertEquals(log2(2.0), logarithmicFunctions.logN(2.0, 2.0, 1E-6), 1E-6)
        Assertions.assertEquals(log2(15.0), logarithmicFunctions.logN(15.0, 2.0, 1E-6), 1E-6)
    }

    @Test
    fun log3Test() {
        Assertions.assertEquals(ln(25.0) / ln(3.0), logarithmicFunctions.logN(25.0, 3.0, 1E-6), 1E-6)
        Assertions.assertEquals(ln(3.0) / ln(3.0), logarithmicFunctions.logN(3.0, 3.0, 1E-6), 1E-6)
        Assertions.assertEquals(ln(15.0) / ln(3.0), logarithmicFunctions.logN(15.0, 3.0, 1E-6), 1E-6)
    }

    @Test
    fun lnTest() {
        Assertions.assertEquals(ln(25.0), logarithmicFunctions.ln(25.0, 1E-6), 1E-6)
        Assertions.assertEquals(ln(Math.E), logarithmicFunctions.ln(Math.E, 1E-6), 1E-6)
        Assertions.assertEquals(ln(5.0), logarithmicFunctions.ln(5.0, 1E-6), 1E-6)
    }


}


