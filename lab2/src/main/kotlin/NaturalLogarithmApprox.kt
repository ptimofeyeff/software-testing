import kotlin.math.abs
import kotlin.math.pow

interface INaturalLogarithmApprox {
    fun ln(x: Double, precision: Double): Double
}

object NaturalLogarithmApprox : INaturalLogarithmApprox {

    override fun ln(x: Double, precision: Double): Double {
        if (x <= 0 || x <= precision || !x.isFinite() || !precision.isFinite())
            throw UnsupportedValueException()
        if (x < 1) {
            val z = x - 1
            var term = z
            var sum = z
            var i = 2
            while (abs(term) >= precision) {
                term *= -z
                sum += term / i
                i++
            }
            return sum
        } else {
            val z = x / (x - 1.0)
            var term = z
            var sum = 0.0
            var i = 1
            while (abs(term) > precision) {
                term = 1.0 / (i * z.pow(i))
                sum += term
                i++
            }
            return sum
        }
    }

}