Ext
		.define(
				'Oct16last.view.mobileview.reportui.datachart.datagrid.DataGridView',
				{
					extend : 'Ext.grid.Panel',
					requires : [ 'Oct16last.view.mobileview.reportui.datachart.datagrid.DataGridController' ],
					xtype : 'data-grid-view',
					controller:'datagridController',
					autoscroll:true,
					itemId : 'data-grid-view',
					width : "100%",
					listeners : {
						scope:'controller',
						cellclick : 'dataGridCellClick',
						itemcontextmenu : 'dataGridRightClick',
					}
				// store:'',

				});
