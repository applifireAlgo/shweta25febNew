Ext.define('Testproject1.testproject1.shared.com.model.sales.UserAccessModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "userid",
          "reference": "User",
          "defaultValue": ""
     }, {
          "name": "region",
          "reference": "SalesRegion",
          "defaultValue": ""
     }, {
          "name": "primaryKey",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "userAccessId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});