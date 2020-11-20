import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

class NaturalLogApproxTest {

    @ParameterizedTest
    @CsvFileSource(resources = ["/ln.csv"], numLinesToSkip = 1)
    fun `it approximates natural logarithm`(x: Double, ln: Double, precision: Double) {
        Assertions.assertEquals(ln, NaturalLogarithmApprox.ln(x, precision), precision)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/log-invalid.csv"], numLinesToSkip = 1)
    fun `UnsupportedValueException for invalid parameters`(x: Double, ln: Double, precision: Double) {
        Assertions.assertThrows(UnsupportedValueException::class.java) {
            NaturalLogarithmApprox.ln(x, precision)
        }
    }
}