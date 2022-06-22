package io.novafoundation.nova.feature_assets.domain

import io.novafoundation.nova.common.data.model.CursorPage
import io.novafoundation.nova.feature_account_api.domain.model.MetaAccount
import io.novafoundation.nova.feature_wallet_api.domain.interfaces.TransactionFilter
import io.novafoundation.nova.feature_wallet_api.domain.model.*
import io.novafoundation.nova.runtime.multiNetwork.chain.model.ChainId
import kotlinx.coroutines.flow.Flow

interface WalletInteractor {

    suspend fun getBalanceLocks(chainId: ChainId, chainAssetId: Int): BalanceLocks

    fun balancesFlow(): Flow<Balances>

    suspend fun syncAssetsRates()

    suspend fun syncNfts(metaAccount: MetaAccount)

    fun assetFlow(chainId: ChainId, chainAssetId: Int): Flow<Asset>

    fun commissionAssetFlow(chainId: ChainId): Flow<Asset>

    suspend fun getCurrentAsset(chainId: ChainId, chainAssetId: Int): Asset

    fun operationsFirstPageFlow(chainId: ChainId, chainAssetId: Int): Flow<OperationsPageChange>

    suspend fun syncOperationsFirstPage(
        chainId: ChainId,
        chainAssetId: Int,
        pageSize: Int,
        filters: Set<TransactionFilter>,
    ): Result<*>

    suspend fun getOperations(
        chainId: ChainId,
        chainAssetId: Int,
        pageSize: Int,
        cursor: String?,
        filters: Set<TransactionFilter>
    ): Result<CursorPage<Operation>>
}
