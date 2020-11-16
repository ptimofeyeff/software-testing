import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.*

class FunctionsTest {
    private val trigonometricFunction = TrigonometricFunction(SinApprox)

    private val logarithmicFunctions = LogarithmicFunctions(NaturalLogarithmApprox)

    @Test
    fun sinTest() {
        Assertions.assertEquals(sin(Math.PI / 4), trigonometricFunction.sin(Math.PI / 4, 1E-6), 1E-6)
        Assertions.assertEquals(sin(Math.PI / 2), trigonometricFunction.sin(Math.PI / 2, 1E-6), 1E-6)
        Assertions.assertEquals(sin(Math.PI / 6), trigonometricFunction.sin(Math.PI / 6, 1E-6), 1E-6)
    }

    @Test
    fun cosTest() {
        Assertions.assertEquals(cos(Math.PI / 4), trigonometricFunction.cos(Math.PI / 4, 1E-6), 1E-6)
        Assertions.assertEquals(cos(Math.PI / 2), trigonometricFunction.cos(Math.PI / 2, 1E-6), 1E-6)
        Assertions.assertEquals(cos(Math.PI / 6), trigonometricFunction.cos(Math.PI / 6, 1E-6), 1E-6)
    }

    @Test
    fun tanTest() {
        Assertions.assertEquals(tan(Math.PI / 4), trigonometricFunction.tan(Math.PI / 4, 1E-6), 1E-6)
        Assertions.assertEquals(tan(Math.PI / 8), trigonometricFunction.tan(Math.PI / 8, 1E-6), 1E-6)
        Assertions.assertEquals(tan(Math.PI / 6), trigonometricFunction.tan(Math.PI / 6, 1E-6), 1E-6)
    }

    @Test
    fun cotTest() {
        Assertions.assertEquals(1 / tan(Math.PI / 4), trigonometricFunction.cot(Math.PI / 4, 1E-8), 1E-8)
        Assertions.assertEquals(1 / tan(Math.PI / 8), trigonometricFunction.cot(Math.PI / 8, 1E-8), 1E-8)
        Assertions.assertEquals(1 / tan(Math.PI / 6), trigonometricFunction.cot(Math.PI / 6, 1E-8), 1E-8)
    }

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


