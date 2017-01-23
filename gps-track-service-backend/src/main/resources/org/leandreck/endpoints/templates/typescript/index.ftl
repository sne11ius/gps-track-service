<#-- @ftlvariable name="" type="org.leandreck.endpoints.processor.printer.TypesPackage" -->
<#list types as type>
export { ${type.typeName} } from './${type.typeName?lower_case}.model.generated';
</#list>
<#list endpoints as service>
export { ${service.serviceName} } from './${service.serviceName?lower_case}.generated';
</#list>
// export { APIModule } from './api.module';
