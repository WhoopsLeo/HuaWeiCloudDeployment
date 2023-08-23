package com.colipu.huaweideployment.service;

import java.util.List;

public interface IRepositoryService {
    List<String> listRepository(String repoName,String instanceId, String repoNamespaceName,String repoStatus);
}
