package io.novafoundation.nova.feature_assets.presentation.balance.detail

import java.math.BigDecimal

class BalanceLocksModel(
    val locks: List<Lock>
) {
    class Lock(
        val id: String,
        val amount: BigDecimal,
        val reasons: String
    )
}
