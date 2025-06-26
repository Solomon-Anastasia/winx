fun inc(value: Int): Int = value + 1

class ValueFunctor<T>(val value: T) {
    fun map(function: (T) -> T): ValueFunctor<T> {
	return ValueFunctor(function(value))
    }
}