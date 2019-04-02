package week_2

import org.junit.Assert.*
import org.junit.Test

class MoneyTest {
    @Test
    fun `$5는 $5와 같다`() {
        assertTrue(Money.dollar(5) == Money.dollar(5))
    }

    @Test
    fun `$5를 원화로 환전하면 ￦5,000과 같다`() {
        val money1 = Money.dollar(5).exchange(Currency.KRW)
        val money2 = Money.krw(5000)

        assertTrue(money1 == money2)
    }

    @Test
    fun `$10를 원화로 환전하면 ￦10,000과 같다`() {
        val money1 = Money.dollar(10).exchange(Currency.KRW)
        val money2 = Money.krw(10000)

        assertTrue(money1 == money2)
    }

    @Test
    fun `$5와 $5를 연산한 결과는 $10이다`() {
        val money1 = Money.dollar(5)
        val money2 = Money.dollar(5)
        val sum = money1.plus(money2, Currency.USD)

        assertTrue(Money.dollar(10) == sum)
    }

    @Test
    fun `￦5,000와 ￦5,000를 연산한 결과는 ￦10,000이다`() {
        val money1 = Money.krw(5000)
        val money2 = Money.krw(5000)
        val sum = money1.plus(money2, Currency.KRW)

        assertTrue(Money.krw(10000) == sum)
    }

    @Test
    fun `$5와 ￦5,000을 USD로 연산한 결과는 $10이다`() {
        val money1 = Money.dollar(5)
        val money2 = Money.krw(5000)
        val sum = money1.plus(money2, Currency.USD)

        assertTrue(Money.dollar(10) == sum)
    }

    @Test
    fun `$5와 ￦5,000을 KRW로 연산한 결과는 ￦10,000이다`() {
        val money1 = Money.dollar(5)
        val money2 = Money.krw(5000)
        val sum = money1.plus(money2, Currency.KRW)

        assertTrue(Money.krw(10000) == sum)
    }
}
