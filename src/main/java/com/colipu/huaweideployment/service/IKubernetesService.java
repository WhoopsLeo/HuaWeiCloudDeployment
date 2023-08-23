package com.colipu.huaweideployment.service;

import com.colipu.huaweideployment.model.dto.DeploymentsAndImages.DeploymentsAndImagesDTO;

import java.util.List;

public interface IKubernetesService {

    List<DeploymentsAndImagesDTO> findDeploymentsAndImages();

}
