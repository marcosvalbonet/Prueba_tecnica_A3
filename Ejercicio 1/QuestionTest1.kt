class Question1Test {

    fun combineOutputs(priorityResult: CustomResult, secondaryResult: CustomResult): CustomResult {
        return when {
            priorityResult is CustomResult.RSuccess && secondaryResult is CustomResult.RSuccess -> {
                if (priorityResult.product.id == secondaryResult.product.id) {
                    priorityResult.apply {
                        product = product.copy(
                            amount = product.amount + secondaryResult.product.amount,
                            providers = product.providers.toMutableList()
                                .apply { addAll(secondaryResult.product.providers) }
                        )
                    }
                } else {
                    priorityResult
                }
            }
            else -> {
                CustomResult.RCriticalError
            }
        }
    }
	
	fun combineOutputsSimplified(priorityResult: CustomResult, secondaryResult: CustomResult): CustomResult {
        if (priorityResult !is CustomResult.RSuccess || secondaryResult !is CustomResult.RSuccess ||
            priorityResult.product.id != secondaryResult.product.id) {
            return CustomResult.RCriticalError
        }

        val combinedProduct = priorityResult.product.copy(
            amount = priorityResult.product.amount + secondaryResult.product.amount,
            providers = priorityResult.product.providers + secondaryResult.product.providers
        )

        return CustomResult.RSuccess(combinedProduct)
    }

    fun combineWith(priorityResult: CustomResult, secondaryResult: CustomResult): CustomResult {
        return if (priorityResult !is CustomResult.RSuccess || secondaryResult !is CustomResult.RSuccess) {
            CustomResult.RCriticalError
        } else if (priorityResult.product.id != secondaryResult.product.id ) {
            priorityResult
        } else {
            val updatedProduct = priorityResult.product.copy(
                amount = priorityResult.product.amount + secondaryResult.product.amount,
                providers = priorityResult.product.providers.toMutableList().apply {
                    addAll(secondaryResult.product.providers)
                }
            )
            CustomResult.RSuccess(updatedProduct)
        }
    }
	

	//val combinedResult = priorityResult combineWith secondaryResult

    @Test
    fun `when both param are RSuccess and the same id return combine Outputs`() {
        val product1 = ProductData(id = "1", amount = 2, providers = listOf("A"))
        val product2 = ProductData(id = "1", amount = 3, providers = listOf("B"))

        val result1 = CustomResult.RSuccess(product1)
        val result2 = CustomResult.RSuccess(product2)

        val combined = question1Test.combineOutputs(result1, result2)

        if ( combined is CustomResult.RSuccess){
            assertEquals(combined.product.id, product1.id)
            assertEquals(combined.product.amount, product1.amount + product2.amount)
            assertTrue(combined.product.providers.contains("A"))
            assertTrue(combined.product.providers.contains("B"))
        }

    }

    @Test
    fun `when both param are RSuccess and not the same id return first without combine Outputs`(){
        val product1 = ProductData(id = "1", amount = 2, providers = listOf("A"))
        val product2 = ProductData(id = "2", amount = 3, providers = listOf("B"))

        val result1 = CustomResult.RSuccess(product1)
        val result2 = CustomResult.RSuccess(product2)

        val combined = question1Test.combineOutputs(result1, result2)

        if (combined is CustomResult.RSuccess){
            assertEquals(combined.product.id, product1.id)
            assertEquals(combined.product.amount, product1.amount)
            assert(combined.product.amount != product1.amount + product2.amount)

            assertTrue(combined.product.providers.contains("A"))
            assertFalse(combined.product.providers.contains("B"))
        }
    }

    @Test
    fun `when a param is not RSuccess return critical error`() {
        val product1 = ProductData(id = "1", amount = 2, providers = listOf("A"))

        val result1 = CustomResult.RSuccess(product1)
        val result2 = CustomResult.RCriticalError

        val combined = question1Test.combineOutputs(result1, result2)

        assertTrue (combined is CustomResult.RCriticalError)

    }
	
}