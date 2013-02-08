package testcase.function;

import com.jd.dd.glowworm.PBException;
import userJavabean.Person1;
import userJavabean.PersonForDate;
import org.junit.Test;
import testcase.TestBase;
import userJavabean.Food;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

public class NormalTest extends TestBase {

    @Test
     public void testBoolean() throws Exception {
        Boolean flag = true;
        Boolean result = executeBackAndForth(flag, Boolean.class);
        assertEquals(true, result);
    }

    //测试Boolean类型 FALSE
    @Test
    public void testBoolean2() throws Exception {
        Boolean b = executeBackAndForth(false, Boolean.class);
        assertEquals(false, b);
    }

    @Test
    public void testBooleanPrimary() throws Exception {
        boolean flag = true;
        boolean result = executeBackAndForth(flag, Boolean.class);
        assertEquals(true, result);
    }



    //测试Byte类型 MAX_VALUE
    @Test
    public void testByte() throws Exception {
        Byte b = executeBackAndForth(Byte.MAX_VALUE, Byte.class);
        assertEquals(String.valueOf(Byte.MAX_VALUE), b.toString());
    }

    //测试Double类型 正数
    @Test
    public void testDouble1() throws Exception {
        Double d = executeBackAndForth(Double.MAX_VALUE, Double.class);
        assertEquals(String.valueOf(Double.MAX_VALUE), d.toString());
    }

    //测试Double类型 负数
    @Test
    public void testDouble3() throws Exception {
        Double d = executeBackAndForth(Double.MIN_VALUE, Double.class);
        assertEquals(String.valueOf(Double.MIN_VALUE), d.toString());
    }

    //测试Integer类型 正数
    @Test
    public void testInteger1() throws Exception {
        Integer i = executeBackAndForth(Integer.MAX_VALUE, Integer.class);
        assertEquals(String.valueOf(Integer.MAX_VALUE), i.toString());
    }

    //测试Integer类型 负数
    @Test
    public void testInteger2() throws Exception {
        Integer i = executeBackAndForth(Integer.MIN_VALUE, Integer.class);
        assertEquals(String.valueOf(Integer.MIN_VALUE), i.toString());
    }

    //测试Long类型 正数
    @Test
    public void testLong1() throws Exception {
        Long l = executeBackAndForth(Long.MAX_VALUE, Long.class);
        assertEquals(String.valueOf(Long.MAX_VALUE), l.toString());
    }

    //测试Long类型 100亿
    @Test
    public void testLong2() throws Exception {
        Long l = executeBackAndForth(10000000000L, Long.class);
        assertEquals(String.valueOf(10000000000L), l.toString());
    }

    //测试Long类型 10亿
    @Test
    public void testLong3() throws Exception {
        Long l = executeBackAndForth(1000000000L, Long.class);
        assertEquals(String.valueOf(1000000000L), l.toString());
    }

    //测试Long类型 负数
    @Test
    public void testLong4() throws Exception {
        Long l = executeBackAndForth(Long.MIN_VALUE, Long.class);
        assertEquals(String.valueOf(Long.MIN_VALUE), l.toString());
    }

    //测试Character类型
    @Test
    public void testCharacter() throws Exception {
        Character c = executeBackAndForth('A', Character.class);
        assertEquals(String.valueOf('A'), c.toString());
    }



    //测试Float类型
    @Test
    public void testFloat1() throws Exception {
        Float f = executeBackAndForth(Float.MAX_VALUE, Float.class);
        assertEquals(String.valueOf(Float.MAX_VALUE), f.toString());
    }

    //测试Short类型 正数
    @Test
    public void testShort1() throws Exception {
        Short s = executeBackAndForth(Short.MAX_VALUE, Short.class);
        assertEquals(String.valueOf(Short.MAX_VALUE), s.toString());
    }

    //测试Short类型 负数
    @Test
    public void testShort2() throws Exception {
        Short s = executeBackAndForth(Short.MIN_VALUE, Short.class);
        assertEquals(String.valueOf(Short.MIN_VALUE), s.toString());
    }

    //测试String类型
    @Test
    public void testString() throws Exception {
        String result = executeBackAndForth("360buy.com", String.class);
        assertEquals("360buy.com", result.toString());
    }

    //BigDecimal
    @Test
    public void testBigDecimal1() throws Exception {
        BigDecimal bd = executeBackAndForth(new BigDecimal(10001.002), BigDecimal.class);
        assertEquals(String.valueOf(new BigDecimal(10001.002)), bd.toString());
    }

    //BigDecimal
    @Test
    public void testBigDecimal2() throws Exception {
        BigDecimal bd = executeBackAndForth(new BigDecimal("100.021"), BigDecimal.class);
        assertEquals(String.valueOf(new BigDecimal("100.021")), bd.toString());
    }

    //BigInteger
    @Test
    public void testBigInteger() throws Exception {
        BigInteger bd = executeBackAndForth(new BigInteger(String.valueOf(Integer.MIN_VALUE)), BigInteger.class);
        assertEquals(String.valueOf(new BigInteger(String.valueOf(Integer.MIN_VALUE))), bd.toString());
    }

    //测试Enum类型
    @Test
    public void testEnum() throws Exception {
        Object[] objects = {Food.BEEF, Food.PORK};
        Object[] result = executeBackAndForth(objects, Object[].class);
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(Food.BEEF, result[0]);
        assertEquals(Food.PORK, result[1]);
    }

    //IP地址相关
    @Test
    public void testInetAddress() throws Exception {
        InetAddress ia = InetAddress.getLocalHost();
        InetAddress result = executeBackAndForth(ia, Inet4Address.class);
        assertEquals(ia.getHostAddress(), result.getHostAddress());
    }

    //Date
    @Test
    public void testDate() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse("2012-12-21 23:59:59", pos);
        Date result = executeBackAndForth(date, Date.class);
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        assertEquals("2012-12-21 23:59:59", formatter1.format(result));
    }

    //Timestamp
    @Test
    public void testTimestamp() throws Exception {
        long millis = (System.currentTimeMillis() / 1000) * 1000;
        Timestamp timestamp = new Timestamp(millis);
        Timestamp result = executeBackAndForth(timestamp, Timestamp.class);
        assertEquals(timestamp.getTime(), result.getTime());
    }

    //测试一个javabean钟放所有date类型及其他类型
    @Test
    public void testDateAndOther() throws Exception {
        PersonForDate pfd = new PersonForDate();
        long millis = (System.currentTimeMillis() / 1000) * 1000;
        Timestamp timestamp = new Timestamp(millis);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse("2012-12-21 23:59:59", pos);
        Inet4Address ia = (Inet4Address) InetAddress.getLocalHost();
        BigDecimal bd = new BigDecimal(String.valueOf(Double.MIN_VALUE));
        BigInteger bi = new BigInteger(String.valueOf(Integer.MIN_VALUE));

        pfd.setDate(date);
        pfd.setInet4Address(ia);
        pfd.setTimestamp(timestamp);
        pfd.setBd(bd);
        pfd.setBi(bi);

        PersonForDate result = executeBackAndForth(pfd, PersonForDate.class);
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        assertEquals(ia.getHostAddress(), result.getInet4Address().getHostAddress());
        assertEquals("2012-12-21 23:59:59", formatter1.format(result.getDate()));
        assertEquals(timestamp.getTime(), result.getTimestamp().getTime());
        assertEquals(bd, result.getBd());
        assertEquals(bi, result.getBi());
    }

    //AtomicInteger--max
    @Test
    public void testAtomicInteger1() throws Exception {
        AtomicInteger ai = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger result = executeBackAndForth(ai, AtomicInteger.class);
        assertEquals(Integer.MAX_VALUE, result.intValue());
    }

    //AtomicInteger--min
    @Test
    public void testAtomicInteger2() throws Exception {
        AtomicInteger ai = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger result = executeBackAndForth(ai, AtomicInteger.class);
        assertEquals(Integer.MIN_VALUE, result.intValue());
    }

    //AtomicBoolean--true
    @Test
    public void testAtomicBoolean1() throws Exception {
        AtomicBoolean ab = new AtomicBoolean(true);
        AtomicBoolean result = executeBackAndForth(ab, AtomicBoolean.class);
        assertEquals(true, result.get());
    }

    //AtomicBoolean--false
    @Test
    public void testAtomicBoolean2() throws Exception {
        AtomicBoolean ab = new AtomicBoolean(false);
        AtomicBoolean result = executeBackAndForth(ab, AtomicBoolean.class);
        assertEquals(false, result.get());
    }

    //AtomicLong--max
    @Test
    public void testAtomicLong1() throws Exception {
        AtomicLong al = new AtomicLong(Long.MAX_VALUE);
        AtomicLong result = executeBackAndForth(al, AtomicLong.class);
        assertEquals(Long.MAX_VALUE, result.longValue());
    }

    //AtomicLong--min
    @Test
    public void testAtomicLong2() throws Exception {
        AtomicLong al = new AtomicLong(Long.MIN_VALUE);
        AtomicLong result = executeBackAndForth(al, AtomicLong.class);
        assertEquals(Long.MIN_VALUE, result.longValue());
    }

    //测试Null
    @Test
    public void testNull() throws Exception {
        try {
            executeDeserialization(null);
            assertTrue(false);
        } catch (PBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testNewBean() throws Exception {
        Person1 person1 = new Person1();
        Person1 result = executeBackAndForth(person1, Person1.class);
        assertNotNull(result);
        assertNull(result.getId());
    }
}
