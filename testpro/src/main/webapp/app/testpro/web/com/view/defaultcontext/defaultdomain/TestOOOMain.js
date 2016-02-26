Ext.define('Testpro.testpro.web.com.view.defaultcontext.defaultdomain.TestOOOMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestOOOMainController",
     "restURL": "/TestOOO",
     "defaults": {
          "split": true
     },
     "requires": ["Testpro.testpro.shared.com.model.defaultcontext.defaultdomain.TestOOOModel", "Testpro.testpro.web.com.controller.defaultcontext.defaultdomain.TestOOOMainController", "Testpro.testpro.shared.com.model.organizationboundedcontext.location.AddressModel", "Testpro.testpro.shared.com.viewmodel.defaultcontext.defaultdomain.TestOOOViewModel"],
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
               "displayName": "TestOOO",
               "name": "TestOOOTreeContainer",
               "itemId": "TestOOOTreeContainer",
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
                    "itemId": "TestOOOTree",
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
                    "displayName": "TestOOO",
                    "name": "TestOOO",
                    "itemId": "TestOOOForm",
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
                                   "name": "ada",
                                   "itemId": "ada",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "ad",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "ad<font color='red'> *<\/font>",
                                   "fieldId": "FAD272A0-1970-49E0-BCE3-EAF7D52D773F",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "ada",
                                   "bind": "{ada}"
                              }, {
                                   "name": "dsds",
                                   "itemId": "dsds",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "dsd",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "dsd<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "DD794044-9A0A-42F9-B7F2-53835224BC3F",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "dsds",
                                   "columnWidth": 0.5,
                                   "bind": "{dsds}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "C4941C5C-C270-4823-9E78-0A4340E2B569",
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
                    "viewModel": "TestOOOViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "TestOOO",
                    "title": "Details Grid",
                    "name": "TestOOOGrid",
                    "itemId": "TestOOOGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "ad",
                         "dataIndex": "ada",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "dsd",
                         "dataIndex": "dsds",
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
               "displayName": "TestOOO",
               "name": "TestOOO",
               "itemId": "TestOOOForm",
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
                              "name": "ada",
                              "itemId": "ada",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "ad",
                              "margin": "5 5 5 5",
                              "fieldLabel": "ad<font color='red'> *<\/font>",
                              "fieldId": "FAD272A0-1970-49E0-BCE3-EAF7D52D773F",
                              "hidden": true,
                              "value": "",
                              "bindable": "ada",
                              "bind": "{ada}"
                         }, {
                              "name": "dsds",
                              "itemId": "dsds",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "dsd",
                              "margin": "5 5 5 5",
                              "fieldLabel": "dsd<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "DD794044-9A0A-42F9-B7F2-53835224BC3F",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "dsds",
                              "columnWidth": 0.5,
                              "bind": "{dsds}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "C4941C5C-C270-4823-9E78-0A4340E2B569",
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
               "viewModel": "TestOOOViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});