class QuestionTest4 {

    fun combinedLet(value1: T?, value2: T?, action: (T, T) -> Unit) {
        if (value1 != null && value2 != null) {
            action(value1, value2)
        }
        
    }


    @Test
    fun `when call combined let with two vaules execute lambda with values`(){
        val value1 = 3
        val value2 = 7
        val called = false
        var sum : Int? = null

        combinedLet(value1, value2){ a, b ->
            called = true
            sum = a + b
        }

        assertTrue(called)
        assertEquals(10, sum)

    }

    @Test
    fun `when value1 is null does not execute lambda`() {
        val value2 = 10
        var called = false

        combinedLet(null, value2) { a, b ->
            called = true
        }

        assertFalse(called)
    }

    @Test
    fun `when value2 is null does not execute lambda`() {
        val value1 = 5
        var called = false

        combinedLet(value1, null) { a, b ->
            called = true
        }

        assertFalse(called)
    }

    @Test
    fun `when both values null does not execute lambda`() {
        var called = false

        combinedLet(null, null) { _, _ ->
            called = true
        }

        assertFalse(called)
    }

}