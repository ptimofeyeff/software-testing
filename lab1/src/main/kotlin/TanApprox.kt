import org.apache.commons.math3.fraction.BigFraction
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import kotlin.math.abs
import kotlin.math.pow

object TanApprox {

    fun tanExpansion(x: Double, precision: Double): Double {
        if (abs(x) >= Math.PI / 2 || x.isNaN()) throw UnsupportedValueException("\"x\" should be in (-Pi/2; Pi/2)")
        if (!precision.isFinite()) throw UnsupportedValueException("precision should be finite")

        var result = 0.0
        var current = x
        var n = 1

        while (abs(current) >= precision / 10) {
            result += current
            val denominator = (1 - 4.0.pow(n + 1)) * x * x * (-4)
            val numerator = (2*n + 1) * (2*n + 2) * (1 - 4.0.pow(n))
            current *= (denominator / numerator) * bernoulli((2*n + 2), (2*n))
            n++
        }
        return result
    }

    fun BigInteger.factorial(): BigInteger {
        if (this == BigInteger.ZERO) return BigInteger.ONE
        return this.multiply(this.minus(BigInteger.ONE).factorial())
    }

    fun bernoulli(denominator: Int, nominator: Int): Double =
        denominator.bernoulli().divide(nominator.bernoulli(), 16, RoundingMode.HALF_UP.ordinal).toDouble()

    // O(n!/((2 * Pi) ^ n)
    fun Int.bernoulli(): BigDecimal {
        val a = Array(this + 1) { BigFraction(1, (it + 1)) }
        for (m in 0..this) {
            for (j in m downTo 1) {
                a[j - 1] = (a[j - 1].subtract(a[j])).multiply(BigFraction(j))
            }
        }
        return a[0].bigDecimalValue(16, RoundingMode.HALF_UP.ordinal)
    }
}