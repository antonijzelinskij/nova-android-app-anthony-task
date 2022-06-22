package io.novafoundation.nova.feature_wallet_api.domain.model

import io.novafoundation.nova.common.list.GroupedList
import io.novafoundation.nova.runtime.multiNetwork.chain.model.Chain
import java.math.BigDecimal

class Balances(
    val assets: GroupedList<AssetGroup, Asset>,
    val totalBalanceFiat: BigDecimal,
    val lockedBalanceFiat: BigDecimal
)

class BalanceLocks(
    val locks: List<Lock>
) {
    class Lock(
        val id: String,
        val amount: BigDecimal,
        val reasons: String
    )
}

class AssetGroup(
    val chain: Chain,
    val groupBalanceFiat: BigDecimal,
    val zeroBalance: Boolean
)
