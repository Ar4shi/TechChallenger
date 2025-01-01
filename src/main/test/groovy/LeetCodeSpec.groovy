import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.spockframework.runtime.Sputnik
import spock.lang.Specification
import structure.A
import structure.B

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Sputnik.class)
@PrepareForTest([Calendar.class, A.class, B.class, GregorianCalendar.class])
@SuppressStaticInitializationFor(["java.util.Calendar","java.util.GregorianCalendar"])
class LeetCodeSpec extends Specification {

    def "test Calendar.getInstance"() {
        given:
        // 创建一个 mock 的 Calendar 对象
        Calendar mockCalendar = PowerMockito.mock(Calendar.class)

        // 设置 mockCalendar 的 get 方法返回值
        PowerMockito.when(mockCalendar.get(Calendar.YEAR)).thenReturn(2023)

        // mock Calendar.getInstance() 方法，使其返回 mockCalendar
        PowerMockito.mockStatic(Calendar.class)
        PowerMockito.when(Calendar.getInstance()).thenReturn(mockCalendar)

        when:
        // 调用 Calendar.getInstance() 方法
        Calendar calendar = Calendar.getInstance()

        then:
        // 验证结果
        calendar != null
        calendar.get(Calendar.YEAR) == 2023
    }

    def "test static getName"() {
        given:
        B mockB = PowerMockito.mock(B)
        PowerMockito.mockStatic(A)
        PowerMockito.when(A.getInstance()).thenReturn(mockB)
        when:
        def testA = A.getInstance()
        then:
        testA != null
    }

}
