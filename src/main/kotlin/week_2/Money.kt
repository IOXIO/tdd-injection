package week_2

class Money private constructor(val amount: Int, val currency: Currency) {
    fun plus(other: Money, to: Currency): Money {
        val money1 = this.exchange(to)
        val money2 = other.exchange(to)

        return Money(money1.amount + money2.amount, to)
    }

    fun exchange(to: Currency): Money {
        if (currency == to) return this

        return Money((amount * to.rate).toInt(), to)
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Money) return false

        return amount == other.amount && currency == other.currency
    }

    companion object {
        fun dollar(amount: Int): Money = Money(amount, Currency.USD)

        fun krw(amount: Int): Money = Money(amount, Currency.KRW)
    }
}
