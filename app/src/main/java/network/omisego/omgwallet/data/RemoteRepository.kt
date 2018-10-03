package network.omisego.omgwallet.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.omisego.omisego.model.params.LoginParams
import co.omisego.omisego.model.params.SignUpParams
import network.omisego.omgwallet.data.contract.BalanceDataRepository
import network.omisego.omgwallet.extension.subscribe
import network.omisego.omgwallet.model.APIResult
import network.omisego.omgwallet.network.ClientProvider

/*
 * OmiseGO
 *
 * Created by Phuchit Sirimongkolsathien on 26/9/2018 AD.
 * Copyright © 2017-2018 OmiseGO. All rights reserved.
 */

class RemoteRepository : BalanceDataRepository {
    override fun loadWallet(liveAPIResult: MutableLiveData<APIResult>, networkOnly: Boolean) {
        ClientProvider.client.getWallets().subscribe(liveAPIResult)
    }

    fun signIn(params: LoginParams, liveAPIResult: MutableLiveData<APIResult>): LiveData<APIResult> {
        return ClientProvider.client.login(params).subscribe(liveAPIResult)
    }

    fun signup(params: SignUpParams, liveAPIResult: MutableLiveData<APIResult>) {
        ClientProvider.client.signup(params).subscribe(liveAPIResult)
    }
}
