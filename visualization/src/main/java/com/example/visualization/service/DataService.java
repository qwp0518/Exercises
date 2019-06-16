package com.example.visualization.service;
import cn.com.essence.proto.assetcenter.overview.UserStkAssetRequest;
import com.example.visualization.pojo.RequestLabels;

/**
 * @author William Tsien
 */
public interface DataService {
    UserStkAssetRequest showData(RequestLabels labels);
}
