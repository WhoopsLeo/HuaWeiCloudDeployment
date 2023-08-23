package com.colipu.huaweideployment;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.*;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import io.kubernetes.client.util.credentials.AccessTokenAuthentication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
public class HuaweiDeploymentApplicationTests {

    @Test
    public void testK8sClient() throws IOException, ApiException {
//      file path to your KubeConfig
        Resource resource = new ClassPathResource("kubeconfig.yaml");
        InputStream inputStream = resource.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

//      loading the out-of-cluster config, a kubeconfig from file-system
        ApiClient client = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(inputStreamReader)).build();

//      set the global default api-client to the in-cluster one from above
        Configuration.setDefaultApiClient(client);

//       the CoreV1Api loads default api-client from global configuration.
//       CoreV1Api api = new CoreV1Api();

        AppsV1Api api = new AppsV1Api();

        String nameSpace = "ops";



        V1DeploymentList deployment = api.listNamespacedDeployment(nameSpace, null, null, null, null, null, null, null, null, null, null);
        for (V1Deployment item : deployment.getItems()) {
            String deploymentName = item.getMetadata().getName();
            System.out.println("DeploymentName:" + deploymentName);
            V1Deployment v1Deployment = api.readNamespacedDeployment(deploymentName, nameSpace, null);
            List<V1Container> containers = v1Deployment.getSpec().getTemplate().getSpec().getContainers();
            for (V1Container container : containers) {
                String imageName = container.getImage();
                System.out.println("镜像名称：" + imageName);
            }
        }



    }

}
