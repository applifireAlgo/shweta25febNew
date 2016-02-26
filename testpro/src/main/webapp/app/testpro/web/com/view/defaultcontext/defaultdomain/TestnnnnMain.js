Ext.define('Testpro.testpro.web.com.view.defaultcontext.defaultdomain.TestnnnnMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestnnnnMainController",
     "restURL": "/Testnnnn",
     "defaults": {
          "split": true
     },
     "requires": ["Testpro.testpro.shared.com.model.defaultcontext.defaultdomain.TestnnnnModel", "Testpro.testpro.web.com.controller.defaultcontext.defaultdomain.TestnnnnMainController", "Testpro.testpro.shared.com.model.organizationboundedcontext.location.AddressModel", "Testpro.testpro.shared.com.viewmodel.defaultcontext.defaultdomain.TestnnnnViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "displayName": "Testnnnn",
               "name": "TestnnnnTreeContainer",
               "itemId": "TestnnnnTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "TestnnnnTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "xtype": "form",
                    "displayName": "Testnnnn",
                    "name": "Testnnnn",
                    "itemId": "TestnnnnForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "ds",
                                   "itemId": "ds",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "dad",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "dad<font color='red'> *<\/font>",
                                   "fieldId": "656543EF-CFFD-46D5-9C85-190C8D9CE790",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "ds",
                                   "bind": "{ds}"
                              }, {
                                   "name": "sfsf",
                                   "itemId": "sfsf",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "fsf",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "fsf<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "49369D75-2A9B-4F30-A1A6-FF6E30681BF4",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "regex": /^[a-zA-Z]+$/,
                                   "bindable": "sfsf",
                                   "columnWidth": 0.5,
                                   "bind": "{sfsf}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "148C3702-4F41-4838-B30B-0D23235683CD",
                                   "bindable": "versionId",
                                   "bind": "{versionId}",
                                   "hidden": true
                              }, {
                                   "xtype": "combo",
                                   "name": "Address",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "margin": 5,
                                   "bindable": "address.addressId",
                                   "typeAhead": true,
                                   "columnWidth": 0.5,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "Address<font color='red'> *<\/font>",
                                   "title": "Address",
                                   "itemId": "address",
                                   "store": {
                                        "data": [],
                                        "model": "Testpro.testpro.shared.com.model.organizationboundedcontext.location.AddressModel"
                                   }
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "viewModel": "TestnnnnViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Testnnnn",
                    "title": "Details Grid",
                    "name": "TestnnnnGrid",
                    "itemId": "TestnnnnGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "dad",
                         "dataIndex": "ds",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "fsf",
                         "dataIndex": "sfsf",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "xtype": "form",
               "displayName": "Testnnnn",
               "name": "Testnnnn",
               "itemId": "TestnnnnForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "ds",
                              "itemId": "ds",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "dad",
                              "margin": "5 5 5 5",
                              "fieldLabel": "dad<font color='red'> *<\/font>",
                              "fieldId": "656543EF-CFFD-46D5-9C85-190C8D9CE790",
                              "hidden": true,
                              "value": "",
                              "bindable": "ds",
                              "bind": "{ds}"
                         }, {
                              "name": "sfsf",
                              "itemId": "sfsf",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "fsf",
                              "margin": "5 5 5 5",
                              "fieldLabel": "fsf<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "49369D75-2A9B-4F30-A1A6-FF6E30681BF4",
                              "minLength": "0",
                              "maxLength": "256",
                              "regex": /^[a-zA-Z]+$/,
                              "bindable": "sfsf",
                              "columnWidth": 0.5,
                              "bind": "{sfsf}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "148C3702-4F41-4838-B30B-0D23235683CD",
                              "bindable": "versionId",
                              "bind": "{versionId}",
                              "hidden": true
                         }, {
                              "xtype": "combo",
                              "name": "Address",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "margin": 5,
                              "bindable": "address.addressId",
                              "typeAhead": true,
                              "columnWidth": 0.5,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "Address<font color='red'> *<\/font>",
                              "title": "Address",
                              "itemId": "address",
                              "store": {
                                   "data": [],
                                   "model": "Testpro.testpro.shared.com.model.organizationboundedcontext.location.AddressModel"
                              }
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "viewModel": "TestnnnnViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});