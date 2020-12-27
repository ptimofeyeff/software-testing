import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

class SinApproxTest {

    @ParameterizedTest
    @CsvFileSource(resources = ["trig.csv"], numLinesToSkip = 1)
    fun `it approximates sinus`(
        x: Double,
        sin: Double,
        cos: Double,
        tan: Double,
        cot: Double,
        precision: Double
    ) {
        Assertions.assertEquals(sin, SinApprox.sin(x, precision), precision)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["trig-invalid.csv"], numLinesToSkip = 1)
    fun `UnsupportedValueException for invalid parameters`(
        x: Double,
        sin: Double,
        cos: Double,
        tan: Double,
        cot: Double,
        precision: Double
    ) {
        Assertions.assertThrows(UnsupportedValueException::class.java) {
            SinApprox.sin(x, precision)
        }
    }

}