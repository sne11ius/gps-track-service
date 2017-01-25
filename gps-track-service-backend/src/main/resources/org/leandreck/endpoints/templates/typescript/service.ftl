<#-- @ftlvariable name="" type="org.leandreck.endpoints.processor.model.EndpointNode" -->
<#function buildUrl variables url>
  <#assign result = url>
  <#list variables as item>
    '/api/{value}/{some}'
    '/api/' + value + '/' + some + ''
    <#assign result = result?replace('{', '')>
  </#list>
  <#return result>
</#function>
<#list types as type>
import { ${type.typeName} } from './${type.typeName?lower_case}.model.generated';
</#list>

import axios from 'axios'

export class ${serviceName} {
  private serviceBaseURL = '${serviceURL}';

  constructor() {
  }

  /* GET */
<#list getGetMethods() as method>
  <#assign expandedURL = method.url?replace('{', '\' + ')>
  <#assign expandedURL = expandedURL?replace('}', ' + \'')>
  
  public ${method.name}Get(<#list method.pathVariableTypes as variable>${variable.fieldName}: ${variable.type}<#sep>, </#sep></#list>): Promise<${method.returnType.type}> {
    let url = this.serviceBaseURL + '${expandedURL}';

    return new Promise<${method.returnType.type}> (function (resolve, reject) {
      axios.get(url).then(function (response) {
        resolve(<${method.returnType.type}>response.data);
      })
      .catch(function (error) {
        reject(error);
      });
    });
  }

</#list>

  /* POST */
<#list getPostMethods() as method>
  <#assign expandedURL = method.url?replace('{', '\' + ')>
  <#assign expandedURL = expandedURL?replace('}', ' + \'')>
  public ${method.name}Post(<#list method.pathVariableTypes as variable>${variable.fieldName}: ${variable.type}<#sep>, </#sep></#list><#if method.pathVariableTypes?size gt 0>, </#if>${method.requestBodyType.fieldName}: ${method.requestBodyType.type}): Promise<${method.returnType.type}> {
    let url = this.serviceBaseURL + '${expandedURL}';
    return axios.post(url, ${method.requestBodyType.fieldName}).then(function (response) {
        resolve(<${method.returnType.type}>response.data);
      })
      .catch(function (error) {
        reject(error);
      });
  }

</#list>

  /* HEAD */
<#list getHeadMethods() as method>
  <#assign expandedURL = method.url?replace('{', '\' + ')>
  <#assign expandedURL = expandedURL?replace('}', ' + \'')>
  public ${method.name}Head(<#list method.pathVariableTypes as variable>${variable.fieldName}: ${variable.type}<#sep>, </#sep></#list>): Promise<Response> {
    let url = this.serviceBaseURL + '${expandedURL}';
    return axiosHead(url)
      .catch((error: Response) => this.handleError(error));
  }

</#list>

  /* PUT */
<#list getPutMethods() as method>
  <#assign expandedURL = method.url?replace('{', '\' + ')>
  <#assign expandedURL = expandedURL?replace('}', ' + \'')>
  public ${method.name}Put(<#list method.pathVariableTypes as variable>${variable.fieldName}: ${variable.type}<#sep>, </#sep></#list><#if method.pathVariableTypes?size gt 0>, </#if>${method.requestBodyType.fieldName}: ${method.requestBodyType.type}): Promise<${method.returnType.type}> {
    let url = this.serviceBaseURL + '${expandedURL}';
    return axiosPut(url, ${method.requestBodyType.fieldName})
      .map((response: Response) => <${method.returnType.type}>response.json())
      .catch((error: Response) => this.handleError(error));
  }

</#list>

  /* PATCH */
<#list getPatchMethods() as method>
  <#assign expandedURL = method.url?replace('{', '\' + ')>
  <#assign expandedURL = expandedURL?replace('}', ' + \'')>
  public ${method.name}Patch(<#list method.pathVariableTypes as variable>${variable.fieldName}: ${variable.type}<#sep>, </#sep></#list><#if method.pathVariableTypes?size gt 0>, </#if>${method.requestBodyType.fieldName}: ${method.requestBodyType.type}): Promise<${method.returnType.type}> {
    let url = this.serviceBaseURL + '${expandedURL}';
    return axiosPatch(url, ${method.requestBodyType.fieldName})
      .map((response: Response) => <${method.returnType.type}>response.json())
      .catch((error: Response) => this.handleError(error));
  }

</#list>

  /* DELETE */
<#list getDeleteMethods() as method>
  <#assign expandedURL = method.url?replace('{', '\' + ')>
  <#assign expandedURL = expandedURL?replace('}', ' + \'')>
  public ${method.name}Delete(<#list method.pathVariableTypes as variable>${variable.fieldName}: ${variable.type}<#sep>, </#sep></#list>): Promise<Response> {
    let url = this.serviceBaseURL + '${expandedURL}';
    return axiosDelete(url)
      .catch((error: Response) => this.handleError(error));
  }

</#list>

  /* OPTIONS */
<#list getOptionsMethods() as method>
  <#assign expandedURL = method.url?replace('{', '\' + ')>
  <#assign expandedURL = expandedURL?replace('}', ' + \'')>
  public ${method.name}Options(<#list method.pathVariableTypes as variable>${variable.fieldName}: ${variable.type}<#sep>, </#sep></#list><#if method.pathVariableTypes?size gt 0>, </#if>${method.requestBodyType.fieldName}: ${method.requestBodyType.type}): Promise<Response> {
    let url = this.serviceBaseURL + '${expandedURL}';
    return axiosOptions(url)
      .catch((error: Response) => this.handleError(error));
  }

</#list>

  /* TRACE */
<#list getTraceMethods() as method>
  <#assign expandedURL = method.url?replace('{', '\' + ')>
  <#assign expandedURL = expandedURL?replace('}', ' + \'')>
  public ${method.name}Trace(<#list method.pathVariableTypes as variable>${variable.fieldName}: ${variable.type}<#sep>, </#sep></#list><#if method.pathVariableTypes?size gt 0>, </#if>${method.requestBodyType.fieldName}: ${method.requestBodyType.type}): Promise<${method.requestBodyType.type}> {
    let url = this.serviceBaseURL + '${expandedURL}';
    return axiosTrace(url, ${method.requestBodyType.fieldName})
      .map((response: Response) => <${method.returnType.type}>response.json())
      .catch((error: Response) => this.handleError(error));
  }

</#list>

}
