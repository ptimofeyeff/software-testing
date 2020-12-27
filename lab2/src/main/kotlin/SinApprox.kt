import kotlin.math.abs

interface ISinApprox {
    fun sin(x: Double, precision: Double): Double
}

object SinApprox : ISinApprox {

    override fun sin(x: Double, precision: Double): Double {
        if (!(x.isFinite() && precision.isFinite())) throw UnsupportedValueException()

        var result = 0.0
        var current = x
        var n = 1

        while (abs(current) > precision) {
            result += current
            current *= -(x * x) / (2 * n * (2 * n + 1))
            n++
        }
        return result
    }

}