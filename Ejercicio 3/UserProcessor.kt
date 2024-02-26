class UserProcessor {

    fun processUser(name:String, cardId:Int):UserLogin{
        val primes = calculatePrimesInRange(1,1000000)
        val randomPrime = primes.random()
        val uid = randomPrime * cardId
        return UserLoginData(name,uid.toString())
    }

    private fun isPrime(number: Int): Boolean {
        if (number <= 1) return false
        for (i in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }

    private fun calculatePrimesInRange(start: Int, end: Int): List<Int> {
        val primes = mutableListOf<Int>()

        for (number in start..end) {
            if (isPrime(number)) {
                primes.add(number)
            }
        }

        return primes
    }
}