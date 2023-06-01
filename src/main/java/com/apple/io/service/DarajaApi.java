package com.apple.io.service;

import com.apple.io.dto.mpesa.AccessTokenResponse;
import com.apple.io.dto.mpesa.InternalStkPushRequest;
import com.apple.io.dto.mpesa.StkPushSyncResponse;

public interface DarajaApi {

    AccessTokenResponse getAccessToken();
    StkPushSyncResponse performStkPushTransaction(InternalStkPushRequest internalStkPushRequest);



}
