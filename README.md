# HuaWeiCloudDeployment
K8S应用从阿里云仓库下载，并发布到华为云


- **获取华为云Deployment及其对应的image**

    - 请求路径，如：http://deployment.colipu.com/Deployment/findDeploymentsAndImages
        - 请求参数：
          无
          
        - 响应参数：
        
          | 名称      | 类型    | 描述                                         | 示例                                 |
          | :-------- | :------ | :------------------------------------------- | :----------------------------------- |
          | success   | Boolean | 请求结果。true：请求成功 。false：请求失败。 | true                                 |
          | errorMsg  | String  | 错误信息。                                   |                                      |
          | data      |         |                                              |                                      |
          | - deploymentName   | String  | deployment名称。                             | erp-css                                   |
          | - imageName  | String  | 带tag的镜像名。                           | erp-css-api-java-colipu_css_api:xxxxx               |
          | - imageRepoName | String  | 不带tag的镜像名。               | erp-css-api-java-colipu_css_api |
          | total     | Long    | 匹配到的总数。                       | 1                                    |


- **根据imageName获取所有Tags**

    - 请求路径，如：http://deployment.colipu.com/Deployment/listImageTags?imageName=erp-css-api-java-colipu_css_api
        - 请求参数：

          | 名称            | 类型    | 描述                   | 必填 | 示例                                      |
          | :-------------- | :------ | :---------------------- | ---- | :---------------------------------------- |
          | imageName     | String  | 不带tag的镜像名称。     | 是   | erp-css-api-java-colipu_css_api                                       |
          | instanceId | String | 实例id。    | 否   | 默认值：cri-2xl36ikg0mg1eczp                                        |
          | repoNamespaceName         | String | 命名空间。 | 否   | 默认值：clp-uat                                 |
          | repoStatus        | String | 镜像仓库状态。  | 否   | 默认值：NORMAL                               |

        - 响应参数：
        
          | 名称      | 类型    | 描述                                         | 示例                                 |
          | :-------- | :------ | :------------------------------------------- | :----------------------------------- |
          | success   | Boolean | 请求结果。true：请求成功 。false：请求失败。 | true                                 |
          | errorMsg  | String  | 错误信息。                                   |                                      |
          | data      |         |                                              |                                      |
          | - imageTags   | String  | 镜像tag列表。                             | 235792034971                                   |
          | total     | Long    | 匹配到的tag总数。                       | 20                                    |




- **根据imageName(带tag)从阿里云pull镜像仓库并push到华为云镜像仓库**

    - 请求路径，如：http://deployment.colipu.com/Deployment/pullAndPushImage?imageName=erp-css-api-java-colipu_css_api:235792034971
        - 请求参数：

          | 名称            | 类型    | 描述                   | 必填 | 示例                                      |
          | :-------------- | :------ | :---------------------- | ---- | :---------------------------------------- |
          | imageName     | String  | 不带tag的镜像名称。     | 是   | erp-css-api-java-colipu_css_api:235792034971                                       |
          
        - 响应参数：
        
          | 名称      | 类型    | 描述                                         | 示例                                 |
          | :-------- | :------ | :------------------------------------------- | :----------------------------------- |
          | success   | Boolean | 请求结果。true：请求成功 。false：请求失败。 | true                                 |
          | errorMsg  | String  | 错误信息。                                   |                                      |
          | data      |         |                                              |无                                      |
      
