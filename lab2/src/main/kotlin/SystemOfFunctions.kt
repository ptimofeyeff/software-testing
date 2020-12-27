import kotlin.math.pow

class SystemOfFunctions(
    private val trigFun: ITrigonometricFunctions,
    private val logFun: ILogarithmicFunctions
) {
    fun compute(x: Double, precision: Double) =
        if (x <= 0) {
            val cosX = trigFun.cos(x, precision)
            val tanX = trigFun.tan(x, precision)
            val cotX = trigFun.cot(x, precision)
            (((cosX + tanX + cosX) / cotX) + (cosX.pow(3))) * cotX
        } else {
            val log10x = logFun.logN(x, 10.0, precision)
            val log2x = logFun.logN(x, 2.0, precision)
            val log3x = logFun.logN(x, 3.0, precision)
            val lnX = logFun.ln(x, precision)
            ((log10x / log10x).pow(3).pow(2) / (lnX)) * (((log3x + log3x) + log3x) + log2x)
        }
}