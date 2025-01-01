import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Calendar.class)
public class LeetCodeTest {

    @Test
    public void testCalendarGetInstance() {
        // 创建一个 mock 的 Calendar 对象
        Calendar mockCalendar = PowerMockito.mock(Calendar.class);

        // 设置 mockCalendar 的 get 方法返回值
        PowerMockito.when(mockCalendar.get(Calendar.YEAR)).thenReturn(2023);

        // mock Calendar.getInstance() 方法，使其返回 mockCalendar
        PowerMockito.mockStatic(Calendar.class);
        PowerMockito.when(Calendar.getInstance()).thenReturn(mockCalendar);

        // 调用 Calendar.getInstance() 方法
        Calendar calendar = Calendar.getInstance();

        // 验证结果
        assertEquals(2023, calendar.get(Calendar.YEAR));
    }

}