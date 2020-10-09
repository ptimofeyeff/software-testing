import domain.model.Contamination
import domain.model.Location
import domain.model.Noisiness
import domain.pubishers.Whisper
import domain.subscribers.acousticDevices.*
import domain.subscribers.stereoSystems.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class DomainTest {

    private val stdout = System.out
    private val fakeStdout = ByteArrayOutputStream()
    private val ln = System.lineSeparator()

    @Test
    fun `subscribe should increment hearables`() {
        val whisper = Whisper(Noisiness.LOUDLY, Location.AIR, true, ArrayList())
        val car = Car()

        Assertions.assertEquals(0, whisper.hearables.size)
        whisper.subscribe(car)
        Assertions.assertEquals(1, whisper.hearables.size)
    }

    @Test
    fun `unsubscribe should decrement hearables`() {
        val whisper = Whisper(Noisiness.LOUDLY, Location.AIR, true, ArrayList())
        val car = Car()

        whisper.subscribe(car)
        Assertions.assertEquals(1, whisper.hearables.size)
        whisper.unsubscribe(car)
        Assertions.assertEquals(0, whisper.hearables.size)
    }

    @Test
    fun `whisper is rang out after rangOut() call`() {
        val whisper = Whisper(Noisiness.LOUDLY, Location.AIR, true, ArrayList())
        System.setOut(PrintStream(fakeStdout))

        whisper.rangOut()
        Assertions.assertEquals(fakeStdout.toString(), "rang out $whisper${ln}")
        System.setOut(stdout)
    }

    @Test
    fun `all frequenceable hear the rang out of comprehensive whisper`() {
        val hearables = listOf(Radio(), TV(), RecordPlayer(), StereoSystem(), LoudSpeaker(), Speaker())
        val whisper = Whisper(Noisiness.LOUDLY, Location.AIR, true, ArrayList(hearables))
        System.setOut(PrintStream(fakeStdout))

        whisper.rangOut()
        hearables.stream()
            .peek { it.toDefaultFrequency() }
            .forEach {
                Assertions.assertTrue(fakeStdout.toString().contains("$ln$it hear $whisper"))
            }

        System.setOut(stdout)
    }

    @Test
    fun `all turnableToAcoustic hear the rang out of comprehensive whisper`() {
        val hearables = listOf(Bin(), Tin(Contamination.PURE), Window(), Car(), Glass())
        val whisper = Whisper(Noisiness.LOUDLY, Location.AIR, true, ArrayList(hearables))
        System.setOut(PrintStream(fakeStdout))

        whisper.rangOut()
        hearables.stream()
            .peek { it.turnToDefault() }
            .forEach {
                Assertions.assertTrue(fakeStdout.toString().contains("$ln$it hear $whisper"))
            }

        System.setOut(stdout)
    }

    @Test
    fun `all frequenceable turn to common frequency after hear the rang out of comprehensive whisper`() {
        val hearables = listOf(Radio(), TV(), RecordPlayer(), StereoSystem(), LoudSpeaker(), Speaker())
        val whisper = Whisper(Noisiness.LOUDLY, Location.AIR, true, ArrayList(hearables))
        System.setOut(PrintStream(fakeStdout))

        whisper.rangOut()
        hearables.stream()
            .forEach {
                Assertions.assertTrue(
                    fakeStdout.toString().contains("$ln$it ${Noisiness.QUITE} turn to frequency $COMMON_FREQUENCY")
                )
            }

        System.setOut(stdout)
    }

    @Test
    fun `all turnableToAcoustic turn to acoustic device after hear the rang out of comprehensive whisper`() {
        val hearables = listOf(Bin(), Tin(Contamination.PURE), Window(), Car(), Glass())
        val whisper = Whisper(Noisiness.LOUDLY, Location.AIR, true, ArrayList(hearables))
        System.setOut(PrintStream(fakeStdout))

        whisper.rangOut()
        hearables.stream()
            .forEach {
                Assertions.assertTrue(
                    fakeStdout.toString().contains("$ln$it turn to acoustic device")
                )
            }

        System.setOut(stdout)
    }


    @Test
    fun `not all frequenceable hear the rang out of not comprehensive whisper`() {
        val hearables = listOf(Radio(), TV(), RecordPlayer(), StereoSystem(), LoudSpeaker(), Speaker())
        val whisper = Whisper(Noisiness.LOUDLY, Location.AIR, false, ArrayList(hearables))
        System.setOut(PrintStream(fakeStdout))

        whisper.rangOut()
        hearables.forEachIndexed { index, it ->
            it.toDefaultFrequency()
            if (index % 2 == 0) {
                Assertions.assertTrue(fakeStdout.toString().contains("$ln$it hear $whisper"))
            } else {
                Assertions.assertFalse(fakeStdout.toString().contains("$ln$it hear $whisper"))
            }
        }

        System.setOut(stdout)
    }

    @Test
    fun `not all turnableToAcoustic hear the rang out of not comprehensive whisper`() {
        val hearables = listOf(Bin(), Tin(Contamination.PURE), Window(), Car(), Glass())
        val whisper = Whisper(Noisiness.LOUDLY, Location.AIR, false, ArrayList(hearables))
        System.setOut(PrintStream(fakeStdout))

        whisper.rangOut()
        hearables.forEachIndexed { index, it ->
            it.turnToDefault()
            if (index % 2 == 0) {
                Assertions.assertTrue(fakeStdout.toString().contains("$ln$it hear $whisper"))
            } else {
                Assertions.assertFalse(fakeStdout.toString().contains("$ln$it hear $whisper"))
            }
        }

        System.setOut(stdout)
    }

}