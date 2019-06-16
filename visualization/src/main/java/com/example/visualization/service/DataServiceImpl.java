package com.example.visualization.service;

import cn.com.essence.proto.assetcenter.overview.CashResponse;
import cn.com.essence.proto.assetcenter.overview.UserStkAssetRequest;
import com.example.visualization.pojo.RequestLabels;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    @Override
    public CashResponse showData(RequestLabels labels) {
        UserStkAssetRequest userStkAssetRequest = new UserStkAssetRequest();

        userStkAssetRequest.setCustNo(labels.getCustNo());
        userStkAssetRequest.setStartDay(labels.getStartDay());
        userStkAssetRequest.setEndDay(labels.getEndDay());
        userStkAssetRequest.setPageSize(labels.getPageSize());
        userStkAssetRequest.setPageNum(labels.getPageNum());
        userStkAssetRequest.setAcctNo(labels.getAcctNo());


        return getCash(userStkAssetRequest);

    }
}
