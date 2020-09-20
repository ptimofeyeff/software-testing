import TanApprox.bernoulli
import TanApprox.factorial
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.PI
import kotlin.math.tan

class TanApproxTest {

    @Test
    fun factorialTest() {
        assertEquals(1.toBigInteger(), 0.toBigInteger().factorial())
        assertEquals(120.toBigInteger(), 5.toBigInteger().factorial())
        assertEquals(3628800.toBigInteger(), 10.toBigInteger().factorial())
    }

    @Test
    fun bernoulliTest() {
        assertEquals(1.0, 0.bernoulli().toDouble())
        assertEquals(-691.0/2730, 12.bernoulli().toDouble())
        assertEquals(0.0, 25.bernoulli().toDouble())
    }

    @Test
    fun `positive arguments have correct tangent values`() {
        assertEquals(tan(PI/4), TanApprox.tanExpansion(PI/4, 1E-6), 1E-6)
        assertEquals(tan(PI/8), TanApprox.tanExpansion(PI/8, 1E-6), 1E-6)
        assertEquals(tan(3*PI/8), TanApprox.tanExpansion(3*PI/8, 1E-6), 1E-6)
    }

    @Test
    fun `negative arguments have correct tangent values`() {
        assertEquals(tan(-PI/4), TanApprox.tanExpansion(-PI/4, 1E-6), 1E-6)
        assertEquals(tan(-PI/8), TanApprox.tanExpansion(-PI/8, 1E-6), 1E-6)
        assertEquals(tan(-3*PI/8), TanApprox.tanExpansion(-3*PI/8, 1E-6), 1E-6)
    }

    @Test
    fun `tangent matches expected values at inflection points`() {
        assertEquals(tan(0.0), TanApprox.tanExpansion(0.0, 1E-6), 1E-6)
    }

    @Test
    fun `tangent approximation meets requested precision`() {
        assertEquals(tan(PI/4), TanApprox.tanExpansion(PI/4, 1.0), 1.0)
        assertEquals(tan(PI/4), TanApprox.tanExpansion(PI/4, 1E-8), 1E-8)
        assertEquals(tan(PI/4), TanApprox.tanExpansion(PI/4, 1E-15), 1E-15)
    }

    @Test
    fun `UnsupportedValueException for x values not in series domain`() {
        Assertions.assertThrows(UnsupportedValueException::class.java) { TanApprox.tanExpansion(PI/2, 1E-6) }
        Assertions.assertThrows(UnsupportedValueException::class.java) { TanApprox.tanExpansion(-PI/2, 1E-6) }
        Assertions.assertThrows(UnsupportedValueException::class.java) { TanApprox.tanExpansion(Double.NaN, 1E-6) }
    }

    @Test
    fun `UnsupportedValueException for invalid precision`() {
        Assertions.assertThrows(UnsupportedValueException::class.java) {
            assertEquals(tan(PI/4), TanApprox.tanExpansion(PI/4, Double.NaN), 1E-6)
        }
        Assertions.assertThrows(UnsupportedValueException::class.java) {
            assertEquals(tan(PI/4), TanApprox.tanExpansion(PI/4, Double.NEGATIVE_INFINITY), 1E-6)
        }
        Assertions.assertThrows(UnsupportedValueException::class.java) {
            assertEquals(tan(PI/4), TanApprox.tanExpansion(PI/4, Double.POSITIVE_INFINITY), 1E-6)
        }
    }
}