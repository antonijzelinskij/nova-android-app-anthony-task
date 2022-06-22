package io.novafoundation.nova.feature_assets.presentation.balance.detail

import android.content.Context
import android.os.Bundle
import io.novafoundation.nova.feature_assets.R
import io.novafoundation.nova.common.view.bottomSheet.list.fixed.FixedListBottomSheet
import io.novafoundation.nova.feature_assets.presentation.common.currencyItem

class LockedTokensBottomSheet(
    context: Context,
    private val balanceLocks: BalanceLocksModel
) : FixedListBottomSheet(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = context.getString(R.string.wallet_balance_locked_template)
        setTitle(title)

        balanceLocks.locks.forEach {
            currencyItem(it.id, it.amount)
        }
    }
}
